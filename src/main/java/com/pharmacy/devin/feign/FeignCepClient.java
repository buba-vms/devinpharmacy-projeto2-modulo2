package com.pharmacy.devin.feign;


import com.pharmacy.devin.controller.dto.farmacia.EnderecoViaCep;
import com.pharmacy.devin.entity.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "https://viacep.com.br/ws/", name = "endereco")
public interface FeignCepClient {

    @GetMapping("{cep}/json")
    EnderecoViaCep buscaCep(@PathVariable("cep") String cep);

    @PostMapping("{cep}/json")
    EnderecoViaCep  buscaCep(@RequestBody Endereco endereco);


}
