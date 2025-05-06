package satc.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import satc.estacionamento.model.Tarifa;
import satc.estacionamento.model.Bloco;
import java.util.List;

/**
 *
 * @author gusta
 */
@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
    
    // Encontrar tarifas por bloco
    List<Tarifa> findByBloco(Bloco bloco);
    
    // Encontrar tarifas por descrição contendo um texto
    List<Tarifa> findByDescricaoContaining(String descricao);
    
    // Encontrar tarifas por preço por hora menor que um valor
    List<Tarifa> findByPrecoHoraLessThan(Long preco);
}