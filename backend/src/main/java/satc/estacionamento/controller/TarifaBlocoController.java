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
 * @author gustavo
 */
@RestController
public class TarifaBlocoController {
    private final JdbcTemplate jdbcTemplate;

    public TarifaBlocoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value = "/tarifaPeloBloco/{bloco}", method = RequestMethod.GET)
    public List<Map<String, Object>> getPlacaRetornaVeiculoClienteReserva(@PathVariable("bloco") String bloco) {
        String sql = "SELECT * FROM TARIFA WHERE ID_BLOCO = ?";

        return jdbcTemplate.queryForList(sql, bloco);
    }
}