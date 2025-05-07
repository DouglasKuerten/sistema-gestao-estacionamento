package satc.estacionamento.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gusta
 */
@Entity
@Table(name = "bloco")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bloco{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bloco")
    @SequenceGenerator(name = "seq_bloco", sequenceName = "seq_bloco", allocationSize = 1)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_estacionamento")
    private Estacionamento estacionamento;
    private String dsNome;
    private String dsSigla;
    private Long vagasTotais;
    private String descricao;
}