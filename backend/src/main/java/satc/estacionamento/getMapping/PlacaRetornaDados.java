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
 * @author gusta
 */
// TODO: Remover esse arquivo, método não é necessário
// Método já existe em VeiculoController @GetMapping("placa/{placa}")
@RestController
@RequestMapping("/placaRetornaDados/{placa}")
public class PlacaRetornaDados {
    private final JdbcTemplate jdbcTemplate;

    public PlacaRetornaDados(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getDadosVeiculoCliente(@PathVariable("placa") String placa) {
        String sql = "SELECT * FROM veiculo v JOIN cliente c ON v.ID_CLIENTE = c.ID_CLIENTE WHERE v.DS_PLACA = ?";
        return jdbcTemplate.queryForList(sql, placa);
    }
}
