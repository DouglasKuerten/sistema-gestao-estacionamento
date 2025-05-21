package satc.estacionamento.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_socio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoSocio extends MasterEntity{
    private String nome;
    private Long valor;
}
