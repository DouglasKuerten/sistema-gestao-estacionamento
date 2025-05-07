package satc.estacionamento.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gusta
 */
@Entity
@Table(name = "tarifa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tarifa")
    @SequenceGenerator(name = "seq_tarifa", sequenceName = "seq_tarifa", allocationSize = 1)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_bloco")
    private Bloco bloco;
    private String descricao;
    private Long precoHora;
}
