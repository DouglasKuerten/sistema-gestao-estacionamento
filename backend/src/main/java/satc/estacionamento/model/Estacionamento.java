package satc.estacionamento.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "estacionamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estacionamento extends MasterEntity {
    private String nome;
    private String sigla;
    private Long vagasTotais;
}
