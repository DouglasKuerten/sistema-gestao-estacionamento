package satc.estacionamento.controller;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gusta
 */
@RestController
public class VeiculosEstacionadosController {
    private final JdbcTemplate jdbcTemplate;

    public VeiculosEstacionadosController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value = "/veiculosEstacionados", method = RequestMethod.GET)
    public List<Map<String, Object>> getPlacaRetornaVeiculoClienteReserva() {
        String sql = "SELECT *\n" +
                 "FROM  VEICULO v\n" +
                 "LEFT JOIN CLIENTE c ON v.ID_CLIENTE = c.ID_CLIENTE \n" +
                 "JOIN RESERVA r ON v.ID_VEICULO = r.ID_VEICULO \n" +
                 "AND r.STATUS = 'ATV'";
        return jdbcTemplate.queryForList(sql);
    }
}