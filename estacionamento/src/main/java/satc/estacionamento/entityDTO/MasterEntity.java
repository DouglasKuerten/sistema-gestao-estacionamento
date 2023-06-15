package satc.estacionamento.entityDTO;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 *
 * @author gusta
 */
@MappedSuperclass
@EqualsAndHashCode(of = {"id"})
public class MasterEntity {
    @Getter
    @Id
    private long id;
}
