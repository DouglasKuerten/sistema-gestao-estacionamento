package satc.estacionamento.entityDTO;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
public class Reserva extends MasterEntity {
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Veiculo veiculo;
    @ManyToOne
    private Estacionamento estacionamento;
    private LocalDate dataHoraInicio;
    private LocalDate dataHoraFim;
}
