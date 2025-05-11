
package satc.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import satc.estacionamento.model.Reserva;
import satc.estacionamento.model.Bloco;
import satc.estacionamento.model.Veiculo;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author gusta
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
    // Encontrar reservas por bloco
    List<Reserva> findByBloco(Bloco bloco);
    
    // Encontrar reservas por veículo
    List<Reserva> findByVeiculo(Veiculo veiculo);
    
    // Encontrar reservas por status
    List<Reserva> findByStatus(String status);
    
    // Encontrar reservas ativas (com status ATV)
    List<Reserva> findByStatusContaining(String status);
    
    // Encontrar reservas que começam após uma data
    List<Reserva> findByDataInicioGreaterThanEqual(LocalDate data);
    
    // Encontrar reservas que terminam antes de uma data
    List<Reserva> findByDataFimLessThanEqual(LocalDate data);
    
    // Encontrar reservas ativas em um período específico
    List<Reserva> findByStatusAndDataInicioLessThanEqualAndDataFimGreaterThanEqual(
            String status, LocalDate dataFim, LocalDate dataInicio);

    // Encontrar reservas por status e placa
    List<Reserva> findByStatusEqualAndPlacaEqual(String status, String placa);
}