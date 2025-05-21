package satc.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import satc.estacionamento.model.Veiculo;
import satc.estacionamento.model.Cliente;
import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    // Encontrar veículos por cliente
    List<Veiculo> findByCliente(Cliente cliente);

    // Encontrar veículo por placa
    Optional<Veiculo> findByPlaca(String placa);

    // Encontrar veículos que não estão associados a um cliente
    List<Veiculo> findByClienteIsNull();
}
