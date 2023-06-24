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
@Table(name = "socio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Socio{
    @Id
    private long idSocio;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoSocio tipo;
    private String status;
    private LocalDate dtInicio;
    private LocalDate dtFim;
}
