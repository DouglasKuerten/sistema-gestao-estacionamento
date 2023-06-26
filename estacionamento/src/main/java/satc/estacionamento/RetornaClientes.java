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
@RequestMapping("/clientes")
public class RetornaClientes {
    private final JdbcTemplate jdbcTemplate;
    
    public RetornaClientes(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getDadosVeiculoCliente() {
        String sql = "SELECT * FROM CLIENTE";
        return jdbcTemplate.queryForList(sql);
    }
}
