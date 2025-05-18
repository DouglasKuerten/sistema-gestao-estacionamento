package satc.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import satc.estacionamento.model.Bloco;
import satc.estacionamento.model.Estacionamento;
import java.util.List;

/**
 *
 * @author gusta
 */
@Repository
public interface BlocoRepository extends JpaRepository<Bloco, Long> {
    
    // Encontrar blocos por nome
    List<Bloco> findByNome(String nome);
    
    // Encontrar blocos por sigla
    List<Bloco> findBySigla(String sigla);
}