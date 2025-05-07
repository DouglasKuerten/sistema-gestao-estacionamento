package satc.estacionamento.controller;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gusta
 */
@RestController
public class PlacaController {
    private final JdbcTemplate jdbcTemplate;

    public PlacaController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value = "/placaRetornaDados/{placa}", method = RequestMethod.GET)
    public List<Map<String, Object>> getDadosVeiculoCliente(@PathVariable("placa") String placa) {
        String sql = "SELECT * FROM veiculo v JOIN cliente c ON v.ID_CLIENTE = c.ID_CLIENTE WHERE v.DS_PLACA = ?";
        return jdbcTemplate.queryForList(sql, placa);
    }
}