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
@Table(name = "tipo_socio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoSocio{
    @Id
    private long idTipos;
    private String dsNome;
    private Long valor;
}
