package br.com.can.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date dataNascimento;

    private Long cpf;

    private String endereco;

    @Column(unique = true)
    private String email;

    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_role",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public Usuario() {
    }

    public Usuario(Long id, String nome, Date dataNascimento, Long cpf, String endereco, String email, String senha, List<Role> roles) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
        this.roles = roles;
    }

}
