
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
    List<Pagamento> findByReserva(Reserva reserva);
    
    // Encontrar pagamentos por sócio
    List<Pagamento> findBySocio(Socio socio);
    
    // Encontrar pagamentos com valor maior que
    List<Pagamento> findByValorGreaterThan(Long valor);
    
    // Encontrar pagamentos com valor entre dois valores
    List<Pagamento> findByValorBetween(Long valorMinimo, Long valorMaximo);
    
    // Encontrar os maiores pagamentos (ordenados por valor decrescente)
    List<Pagamento> findTop5ByOrderByValorDesc();
}