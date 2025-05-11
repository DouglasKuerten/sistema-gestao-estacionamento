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
@Table(name = "pagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pagamento")
    @SequenceGenerator(name = "seq_pagamento", sequenceName = "seq_pagamento", allocationSize = 1)
    private long id;
    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
    @ManyToOne
    @JoinColumn(name = "id_socio")
    private Socio socio;
    private Long valor;
}
