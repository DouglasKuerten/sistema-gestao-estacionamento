package satc.estacionamento.entityDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gusta
 */
@Entity
@Table(name = "estacionamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estacionamento{
    @Id
    private long idEstacionamento;
    private String dsNome;
    private String dsSigla;
    private Long vagasTotais; 
}
