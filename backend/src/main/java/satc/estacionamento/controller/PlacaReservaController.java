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
public class PlacaReservaController {

    private final JdbcTemplate jdbcTemplate;

    public PlacaReservaController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value = "/placaRetornaVeiculoClienteReserva/{placa}", method = RequestMethod.GET)
    public List<Map<String, Object>> getPlacaRetornaVeiculoClienteReserva(@PathVariable("placa") String placa) {
        String sql = "SELECT c.*, r.*, v.* "
                + "FROM CLIENTE c "
                + "RIGHT JOIN VEICULO v ON c.ID_CLIENTE = v.ID_CLIENTE "
                + "JOIN RESERVA r ON v.ID_VEICULO = r.ID_VEICULO "
                + "WHERE v.DS_PLACA = ? AND r.STATUS = 'ATV'";

        return jdbcTemplate.queryForList(sql, placa);
    }
}