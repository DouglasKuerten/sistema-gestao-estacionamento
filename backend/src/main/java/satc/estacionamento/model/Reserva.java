package satc.estacionamento.model;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva extends MasterEntity {
    @ManyToOne
    @JoinColumn(name = "id_bloco")
    private Bloco bloco;
    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String status;
    @OneToOne
    private Pagamento pagamento;
}
