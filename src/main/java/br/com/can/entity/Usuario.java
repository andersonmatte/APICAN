package br.com.can.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nome;

    @Column
    private Date dataNascimento;

    @Column
    private long cpf;

    @Column
    private String endereco;

    @Column
    private String email;

    @Column
    private String tipoUsuario;

    @Column
    private String usuario;

    @Column
    private String senha;

}
