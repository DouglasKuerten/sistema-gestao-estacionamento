package satc.estacionamento;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gusta
 */
@RestController
@RequestMapping("/veiculos")
public class RetornaVeiculos {
    private final JdbcTemplate jdbcTemplate;
    
    public RetornaVeiculos(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getDadosVeiculoCliente() {
        String sql = "SELECT * FROM veiculo";
        return jdbcTemplate.queryForList(sql);
    }
}
