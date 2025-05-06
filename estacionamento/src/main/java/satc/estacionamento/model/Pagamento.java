package satc.estacionamento.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Pagamento{
    @Id
    private long idPagamento;
    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
    @ManyToOne
    @JoinColumn(name = "id_socio")
    private Socio socio;
    private Long valor;
}
