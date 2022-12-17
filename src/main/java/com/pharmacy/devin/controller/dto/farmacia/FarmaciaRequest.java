package com.pharmacy.devin.controller.dto.farmacia;

import com.pharmacy.devin.entity.Endereco;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

public class FarmaciaRequest {


    private String razaoSocial;

    private String cnpj;

    private String nomeFantasia;

    private String email;

    private String telefone;

    private String celular;

    private String cep;

    private String complemento;

    private Long numero;
}
