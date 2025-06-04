package com.api.apidocker.table;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "usuario")
@Data // gera getters, setters, toString, equals, hashCode
@NoArgsConstructor // gera construtor vazio
@AllArgsConstructor // gera construtor com todos os campos
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

}
