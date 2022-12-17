package com.pharmacy.devin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String cep;


    private String logradouro;


    private String numero;

    private String bairro;


    private String cidade;


    private String estado;

    private String complemento;

    private Double latitude;

    private Double longitude;
}
