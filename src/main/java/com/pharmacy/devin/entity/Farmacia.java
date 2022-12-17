package com.pharmacy.devin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;


@Entity(name = "farmacia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    @JoinColumn(name = "id_end")
    private Endereco idEnd;



}
