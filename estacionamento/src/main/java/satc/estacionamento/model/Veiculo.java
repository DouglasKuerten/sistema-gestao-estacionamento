package satc.estacionamento.model;

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
@Table(name = "veiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo{
    @Id
    private long idVeiculo;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    private String dsPlaca;
    private String dsModelo;
    private String dsCor;
    private LocalDate dtCadastro;
}
