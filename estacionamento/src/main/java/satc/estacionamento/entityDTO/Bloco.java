package satc.estacionamento.entityDTO;

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
@Table(name = "bloco")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bloco{
    @Id
    private long idBloco;
    @ManyToOne
    @JoinColumn(name = "id_estacionamento")
    private Estacionamento estacionamento;
    private String dsNome;
    private String dsSigla;
    private Long vagasTotais;
    private String descricao;
}
