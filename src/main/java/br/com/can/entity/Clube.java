package br.com.can.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String endereco;

    private Long telefone;

    private Long cnpj;

    private String razaoSocial;

    private String email;

    private String linkFace;

    private String linkInstagran;

    private Date dataFundacao;

    @OneToMany
    private List<Jogador> jogadores;

    public Clube() {
    }

}
