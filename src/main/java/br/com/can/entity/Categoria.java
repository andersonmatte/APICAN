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
@Table(name = "CATEGORIA")
public class Categoria {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String tipoCategoria;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    private List<Jogador> jogadores;

}
