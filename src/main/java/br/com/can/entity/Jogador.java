package br.com.can.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "JOGADOR")
public class Jogador {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nome;

    @Column
    private String posicao;

    @Column
    private long totalGols;

    @Column
    private long peso;

    @Column
    private long altura;

//    @JoinColumn(name = "ID")
//    @OneToOne
//    private Categoria categoria;
//
//    @OneToOne
//    @JoinColumn(name = "ID")
//    private Usuario usuario;
//
//    @OneToMany
//    @JoinColumn(name = "ID")
//    private List<Pagamento> pagamentos;

}
