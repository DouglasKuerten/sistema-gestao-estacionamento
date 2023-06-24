package satc.estacionamento.entityDTO;

import java.time.LocalDate;
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
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente{
    @Id
    private long idCliente;
    private String dsNome;
    private String dsTelefone;
    private String dsEmail;
    private String endereco;
    private LocalDate dtCadastro;
}
