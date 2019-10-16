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
public class Jogo {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Date dataJogo;

    @Column
    private String local;

    @Column
    private String mandante;

    @Column
    private String visitante;

    @Column
    private long golsMandante;

    @Column
    private long golsVisitante;

}
