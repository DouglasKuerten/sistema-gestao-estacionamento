package satc.estacionamento.entityDTO;

import java.time.LocalDate;
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
@Table(name = "reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva{
    @Id
    private long idReserva;
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
