package satc.estacionamento.model;

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
@Table(name = "tarifa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa{
    @Id
    private long idTarifa;
    @ManyToOne
    @JoinColumn(name = "id_bloco")
    private Bloco bloco;
    private String descricao;
    private Long precoHora;
}
