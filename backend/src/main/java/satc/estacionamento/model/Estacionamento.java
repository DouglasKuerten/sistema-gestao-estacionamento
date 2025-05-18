package satc.estacionamento.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estacionamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estacionamento extends MasterEntity{
    private String nome;
    private String sigla;
    private Long vagasTotais; 
}
