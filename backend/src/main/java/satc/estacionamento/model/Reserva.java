package satc.estacionamento.model;

import java.time.LocalDate;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gusta
 */
@Entity
@Table(name = "reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reserva")
    @SequenceGenerator(name = "seq_reserva", sequenceName = "seq_reserva", allocationSize = 1)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_bloco")
    private Bloco bloco;
    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;
    private LocalDate dtInicio;
    private LocalDate dtFim;
    private String status;
}
