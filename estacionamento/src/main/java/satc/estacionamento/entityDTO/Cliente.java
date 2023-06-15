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
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends MasterEntity {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
}
