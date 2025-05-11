package satc.estacionamento.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bloco")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bloco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bloco")
    @SequenceGenerator(name = "seq_bloco", sequenceName = "seq_bloco", allocationSize = 1)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_estacionamento")
    private Estacionamento estacionamento;
    private String nome;
    private String sigla;
    private Long vagasTotais;
    private String descricao;
}