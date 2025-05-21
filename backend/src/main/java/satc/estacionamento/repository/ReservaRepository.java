
package satc.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import satc.estacionamento.dto.VeiculoEstacionadoDTO;
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

    // Encontrar reservas por status e placa
    List<Reserva> findByStatusAndVeiculo(String status, Veiculo veiculo);

    @Query("SELECT r FROM Reserva r " +
            "JOIN FETCH r.veiculo v " +
            "JOIN FETCH v.cliente c " +
            "JOIN FETCH r.pagamento p " +
            "WHERE r.dataInicio BETWEEN :inicio AND :fim")
    List<Reserva> findReservasComClienteEVeiculoComPagamento(LocalDate inicio, LocalDate fim);

    @Query("SELECT new satc.estacionamento.dto.VeiculoEstacionadoDTO(" +
            "v.id, v.placa, c.nome, r.status) " +
            "FROM Reserva r " +
            "JOIN r.veiculo v " +
            "LEFT JOIN v.cliente c " +
            "WHERE r.status = 'ATV'")
    List<VeiculoEstacionadoDTO> buscarVeiculosEstacionadosAtivos();

}
