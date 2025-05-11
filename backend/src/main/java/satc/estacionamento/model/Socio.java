package satc.estacionamento.model;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "socio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_socio")
    @SequenceGenerator(name = "seq_socio", sequenceName = "seq_socio", allocationSize = 1)
    private long id;
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoSocio tipo;
    private String status;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
