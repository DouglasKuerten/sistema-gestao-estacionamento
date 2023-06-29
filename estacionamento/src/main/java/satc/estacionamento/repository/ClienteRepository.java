package satc.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import satc.estacionamento.model.Cliente;

/**
 *
 * @author gusta
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
