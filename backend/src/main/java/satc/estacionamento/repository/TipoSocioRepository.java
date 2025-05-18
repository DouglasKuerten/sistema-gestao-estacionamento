package satc.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import satc.estacionamento.model.TipoSocio;
import java.util.List;

@Repository
public interface TipoSocioRepository extends JpaRepository<TipoSocio, Long> {
    
    // Encontrar tipos de sócio por nome
    List<TipoSocio> findByNome(String nome);
}