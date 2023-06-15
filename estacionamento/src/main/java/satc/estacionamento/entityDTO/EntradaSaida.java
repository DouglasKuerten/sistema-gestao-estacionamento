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
@Table(name = "entrada_saida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaSaida extends MasterEntity{
    @ManyToOne
    private Estacionamento estacionamento;
    @ManyToOne
    private Veiculo veiculo;
    private LocalDate dataHoraEntrada;
    private LocalDate dataHoraSaida;
}
