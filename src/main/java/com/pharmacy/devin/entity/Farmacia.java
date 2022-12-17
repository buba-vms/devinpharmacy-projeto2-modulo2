package com.pharmacy.devin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;


@Entity(name = "farmacia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Farmacia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String razaoSocial;

    @Column
    @NotNull
    private String cnpj;

    @Column
    @NotNull
    private String nomeFantasia;

    @Column
    @NotNull
    private String email;

    private String telefone;

    @Column
    @NotNull
    private String celular;


    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @PrimaryKeyJoinColumn
    private Endereco id_end;



}
