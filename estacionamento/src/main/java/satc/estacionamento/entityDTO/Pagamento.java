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
@Table(name = "pagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento extends MasterEntity {
    @ManyToOne
    private Reserva reserva;
    private long valor;
    private LocalDate dataHora;
}
