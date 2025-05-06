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
@Table(name = "veiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_veiculo")
    @SequenceGenerator(name = "seq_veiculo", sequenceName = "seq_veiculo", allocationSize = 1)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    private String dsPlaca;
    private String dsModelo;
    private String dsCor;
    private LocalDate dtCadastro;
}
