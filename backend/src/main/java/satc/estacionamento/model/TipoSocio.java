package satc.estacionamento.model;

import javax.persistence.*;

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
public class TipoSocio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_socio")
    @SequenceGenerator(name = "seq_tipo_socio", sequenceName = "seq_tipo_socio", allocationSize = 1)
    private long id;
    private String dsNome;
    private Long valor;
}
