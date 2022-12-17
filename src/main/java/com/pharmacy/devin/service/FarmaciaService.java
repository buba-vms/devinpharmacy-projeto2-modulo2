package com.pharmacy.devin.service;

import com.pharmacy.devin.controller.dto.farmacia.EnderecoViaCep;
import com.pharmacy.devin.controller.dto.farmacia.FarmaciaRequest;
import com.pharmacy.devin.controller.dto.respostapadrao.DefaultResponse;
import com.pharmacy.devin.entity.Endereco;
import com.pharmacy.devin.entity.Farmacia;
import com.pharmacy.devin.feign.FeignCepClient;
import com.pharmacy.devin.repository.EnderecoRepository;
import com.pharmacy.devin.repository.FarmaciaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FarmaciaService {


    private final FeignCepClient feignCepClient;

    private final FarmaciaRepository farmaciaRepository;

    private final EnderecoRepository enderecoRepository;

    public FarmaciaService(FeignCepClient feignCepClient, FarmaciaRepository farmaciaRepository, EnderecoRepository enderecoRepository) {
        this.feignCepClient = feignCepClient;
        this.farmaciaRepository = farmaciaRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public ResponseEntity<DefaultResponse<Farmacia>> save(FarmaciaRequest farmaciaRequest){


        EnderecoViaCep enderecoViaCep = feignCepClient.buscaCep(farmaciaRequest.getCep());
        Endereco endereco = Endereco.builder()
                .cep(farmaciaRequest.getCep())
                .logradouro(enderecoViaCep.getLogradouro())
                .numero(farmaciaRequest.getNumero())
                .bairro(enderecoViaCep.getBairro())
                .cidade(enderecoViaCep.getLocalidade())
                .estado(enderecoViaCep.getUf())
                .complemento(farmaciaRequest.getComplemento())
                .latitude(farmaciaRequest.getLatitude())
                .longitude(farmaciaRequest.getLongitude())
                .build();

        enderecoRepository.save(endereco);

        Farmacia farmacia = Farmacia.builder()
                .nomeFantasia(farmaciaRequest.getNomeFantasia())
                .cnpj(farmaciaRequest.getCnpj())
                .razaoSocial(farmaciaRequest.getRazaoSocial())
                .email(farmaciaRequest.getEmail())
                .celular(farmaciaRequest.getCelular())
                .telefone(farmaciaRequest.getTelefone())
                .idEnd(endereco)
                .build();

        farmaciaRepository.save(farmacia);

        return new ResponseEntity<DefaultResponse<Farmacia>>(new DefaultResponse<Farmacia>(
                201,
                "Farmácia Criada " + farmaciaRequest.getNomeFantasia() +" com Sucesso",
                farmacia), HttpStatus.CREATED);
    }
}
