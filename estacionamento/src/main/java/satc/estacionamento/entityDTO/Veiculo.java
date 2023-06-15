package satc.estacionamento.entityDTO;

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
@Table(name = "veiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo extends MasterEntity {
    @ManyToOne
    private Cliente cliente;
    private String placa;
    private String modelo;
    private String cor;
}
