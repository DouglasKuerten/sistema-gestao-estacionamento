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
@Table(name = "tarifa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa extends MasterEntity{
    @ManyToOne
    private Estacionamento estacionamento;
    private String descricao;
    private String precoHora;
}
