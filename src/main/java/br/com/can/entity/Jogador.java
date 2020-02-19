package br.com.can.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String posicao;

    private Long totalGols;

    private Long peso;

    private Long altura;

    @OneToMany
    private Categoria categoria;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany
    private List<Pagamento> pagamentos;

    public Jogador(){

    }

    public Jogador(Long id, String nome, String posicao, Long totalGols, Long peso, Long altura, Categoria categoria, Usuario usuario, List<Pagamento> pagamentos) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.totalGols = totalGols;
        this.peso = peso;
        this.altura = altura;
        this.categoria = categoria;
        this.usuario = usuario;
        this.pagamentos = pagamentos;
    }
}
