package com.example.crud.models.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cliente {

    /*Atributos */
    private int idcliente;
    private String nombre;
    private String apellidos;
    private String correo;

}
