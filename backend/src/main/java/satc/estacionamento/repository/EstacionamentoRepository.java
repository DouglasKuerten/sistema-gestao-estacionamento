package satc.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import satc.estacionamento.model.Estacionamento;
import java.util.List;

/**
 *
 * @author gusta
 */
@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long> {
    
    // Encontrar estacionamentos por nome
    List<Estacionamento> findByDsNomeContaining(String nome);
    
    // Encontrar estacionamentos por sigla
    List<Estacionamento> findByDsSigla(String sigla);
}