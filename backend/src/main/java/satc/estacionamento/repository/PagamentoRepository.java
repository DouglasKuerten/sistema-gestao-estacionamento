
package satc.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import satc.estacionamento.model.Pagamento;
import satc.estacionamento.model.Reserva;
import satc.estacionamento.model.Socio;
import java.util.List;

/**
 *
 * @author gusta
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    // Encontrar pagamentos por reserva
    Pagamento findByReserva(Reserva reserva);

    // Encontrar pagamentos por sócio
    List<Pagamento> findBySocio(Socio socio);
}
