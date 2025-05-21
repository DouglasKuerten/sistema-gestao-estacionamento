package satc.estacionamento.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarifa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa extends MasterEntity{
    @ManyToOne
    @JoinColumn(name = "id_bloco")
    private Bloco bloco;
    private String descricao;
    private Long precoHora;
}
