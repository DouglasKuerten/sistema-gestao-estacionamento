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
public class TarifaReservaController {
    private final JdbcTemplate jdbcTemplate;

    public TarifaReservaController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value = "/valorTarifaPassandoReservaBloco/{reserva}-{bloco}", method = RequestMethod.GET)
    public List<Map<String, Object>> getPlacaRetornaVeiculoClienteReserva(@PathVariable("reserva") int reserva, @PathVariable("bloco") int bloco) {
        String sql = "SELECT fn_valor_tarifa(?, ?) AS valor FROM DUAL";
        return jdbcTemplate.queryForList(sql, reserva, bloco);
    }
}