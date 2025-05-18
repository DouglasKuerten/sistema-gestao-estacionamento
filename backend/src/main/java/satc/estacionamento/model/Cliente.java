package satc.estacionamento.model;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LocalDate dataCadastro;
}
