package com.pharmacy.devin.controller.dto.farmacia;

import com.pharmacy.devin.entity.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FarmaciaRequest {


    private String razaoSocial;

    private String cnpj;

    private String nomeFantasia;

    private String email;

    private String telefone;

    private String celular;

    private String cep;

    private String complemento;

    private String numero;

    private Double latitude;

    private Double longitude;
}
