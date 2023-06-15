package satc.estacionamento.entityDTO;

import javax.persistence.Entity;
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
public class Estacionamento extends MasterEntity{
    private String nome;
    private String endereco;
    private long vagasTotais;
    private long vagasDisponiveis;
}
