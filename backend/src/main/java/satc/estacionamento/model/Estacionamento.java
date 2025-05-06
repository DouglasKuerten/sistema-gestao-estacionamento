package satc.estacionamento.model;

import javax.persistence.*;

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
public class Estacionamento{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estacionamento")
    @SequenceGenerator(name = "seq_estacionamento", sequenceName = "seq_estacionamento", allocationSize = 1)
    private long id;
    private String dsNome;
    private String dsSigla;
    private Long vagasTotais; 
}
