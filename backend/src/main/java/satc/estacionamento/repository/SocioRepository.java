package satc.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import satc.estacionamento.model.Socio;
import satc.estacionamento.model.Cliente;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author gusta
 */
@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {

    // Encontrar sócios por cliente
    Socio findByCliente(Cliente cliente);

    // Encontrar sócios por status
    List<Socio> findByStatus(String status);
}
