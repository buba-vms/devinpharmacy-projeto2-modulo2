package com.pharmacy.devin.service;

import com.pharmacy.devin.controller.dto.farmacia.EnderecoViaCep;
import com.pharmacy.devin.controller.dto.farmacia.FarmaciaRequest;
import com.pharmacy.devin.controller.dto.respostapadrao.DefaultResponse;
import com.pharmacy.devin.entity.Endereco;
import com.pharmacy.devin.entity.Farmacia;
import com.pharmacy.devin.entity.Medicamento;
import com.pharmacy.devin.feign.FeignCepClient;
import com.pharmacy.devin.repository.EnderecoRepository;
import com.pharmacy.devin.repository.FarmaciaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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



    public ResponseEntity<DefaultResponse<List<Farmacia>>> getAllFarmacia() {

        return new ResponseEntity<DefaultResponse<List<Farmacia>>>(
                new DefaultResponse<>(
                        200,
                        "Lista de Farmacias encontrada",
                        farmaciaRepository.findAll()),
                HttpStatus.OK);
    }

    public ResponseEntity<DefaultResponse<Farmacia>> getFarmaciaById(Long id) {
        //adicionar tratamento de error no get
        Farmacia farmacia= farmaciaRepository.findById(id).get();



        return new ResponseEntity<DefaultResponse<Farmacia>>(new DefaultResponse<>(
                200,
                "Farmácia de id " + farmacia.getId() + " encontrada com sucesso",
                farmacia
        ), HttpStatus.OK);
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

    public ResponseEntity<DefaultResponse<Farmacia>> updateById(Long id, FarmaciaRequest farmaciaRequest) {
        Farmacia farmacia = farmaciaRepository.findById(id).get();
        Endereco endereco = farmacia.getIdEnd();

        EnderecoViaCep enderecoViaCep = feignCepClient.buscaCep(farmaciaRequest.getCep());
        endereco = Endereco.builder()
                .cep(farmaciaRequest.getCep())
                .logradouro(enderecoViaCep.getLogradouro())
                .numero(farmaciaRequest.getNumero())
                .bairro(enderecoViaCep.getBairro())
                .cidade(enderecoViaCep.getLocalidade())
                .estado(enderecoViaCep.getUf())
                .complemento(farmaciaRequest.getComplemento())
                .latitude(farmaciaRequest.getLatitude())
                .longitude(farmaciaRequest.getLongitude())
                .id(farmacia.getIdEnd().getId())
                .build();


       farmacia = Farmacia.builder()
                .nomeFantasia(farmaciaRequest.getNomeFantasia())
                .cnpj(farmaciaRequest.getCnpj())
                .razaoSocial(farmaciaRequest.getRazaoSocial())
                .email(farmaciaRequest.getEmail())
                .celular(farmaciaRequest.getCelular())
                .telefone(farmaciaRequest.getTelefone())
                .idEnd(endereco)
               .id(farmacia.getId())
                .build();



        return new ResponseEntity<DefaultResponse<Farmacia>>(new DefaultResponse<Farmacia>(
                202,
                "Farmácia " + farmaciaRequest.getNomeFantasia() +" atualizada com Sucesso",
                farmacia), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<DefaultResponse<Void>> deleteById(Long id) {
        //adicionar tratamento de error no get
        Farmacia entity = farmaciaRepository.findById(id).get();

        farmaciaRepository.delete(entity);


        return new ResponseEntity<DefaultResponse<Void>>(new DefaultResponse<>(
                400, "Farmacia de id " + id + " deletada com sucesso"),
                HttpStatus.ACCEPTED);

    }



}
