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
    
    // Encontrar blocos por estacionamento
    List<Bloco> findByIdEstacionamento(Long id);
    
    // Encontrar blocos por nome
    List<Bloco> findByNomeContaining(String nome);
    
    // Encontrar blocos por sigla
    List<Bloco> findBySigla(String sigla);
    
    // Encontrar blocos com número de vagas maior que um valor
    List<Bloco> findByVagasTotaisGreaterThan(Long vagas);
}