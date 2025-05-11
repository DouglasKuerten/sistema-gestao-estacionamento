package satc.estacionamento.getMapping;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gustavo
 */
@RestController
@RequestMapping("/tarifaPeloBloco/{bloco}")
// TODO: Remover arquivo, método não é necessário
// Método já disponível em TarifaController @GetMapping("bloco/{id}")
public class TarifaPeloBloco {
    private final JdbcTemplate jdbcTemplate;

    public TarifaPeloBloco(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getPlacaRetornaVeiculoClienteReserva(@PathVariable("bloco") String bloco) {
        String sql = "SELECT * FROM TARIFA WHERE ID_BLOCO = ?";

        return jdbcTemplate.queryForList(sql, bloco);
    }
}
