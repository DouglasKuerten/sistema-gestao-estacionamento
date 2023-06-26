package satc.estacionamento;

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
@RestController
@RequestMapping("valorTarifaPassandoReservaBloco/{reserva}-{bloco}")
public class ValorTarifaPassandoReservaBloco {
    private final JdbcTemplate jdbcTemplate;

    public ValorTarifaPassandoReservaBloco(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getPlacaRetornaVeiculoClienteReserva(@PathVariable("reserva") int reserva, @PathVariable("bloco") int bloco) {
        String sql = "SELECT fn_valor_tarifa(?, ?) AS valor FROM DUAL";
        return jdbcTemplate.queryForList(sql, reserva, bloco);
    }
}
