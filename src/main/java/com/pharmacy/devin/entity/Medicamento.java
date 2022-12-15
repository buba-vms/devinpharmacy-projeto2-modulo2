package com.pharmacy.devin.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Entity(name = "medicamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String nome;


    @Column
    @NotNull
    private String laboratorio;

    @Column
    @NotNull
    private String dosagem;

    private String descricao;

    @Column
    @NotNull
    private Double precoUnitario;

    @Column
    @NotNull
    private String tipo;
}
