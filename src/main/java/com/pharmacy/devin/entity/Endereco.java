package com.pharmacy.devin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

@Entity(name = "endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    @NotNull
    private String cep;


    @Column
    @NotNull
    private String logradouro;

    @Column
    @NotNull
    private String numero;

    @Column
    @NotNull
    private String bairro;

    @Column
    @NotNull
    private String cidade;

    @Column
    @NotNull
    private String estado;

    @Column
    private String complemento;

    @Column
    @NotNull
    private Double latitude;

    @Column
    @NotNull
    private Double longitude;
}
