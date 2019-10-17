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
public class Clube {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String descricao;

    @Column
    private String endereco;

    @Column
    private long telefone;

    @Column
    private long cnpj;

    @Column
    private String razaoSocial;

    @Column
    private String email;

    @Column
    private String linkFace;

    @Column
    private String linkInstagran;

    @Column
    private Date dataFundacao;

}
