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
@RequestMapping("veiculosEstacionados")
public class VeiculosEstacionado {
    private final JdbcTemplate jdbcTemplate;

    public VeiculosEstacionado(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getPlacaRetornaVeiculoClienteReserva() {
        String sql = "SELECT *\n" +
"                 FROM  VEICULO v\n" +
"                 JOIN CLIENTE c ON v.ID_CLIENTE = c.ID_CLIENTE \n" +
"                 JOIN RESERVA r ON v.ID_VEICULO = r.ID_VEICULO \n" +
"                 AND r.STATUS = 'ATV'";
        return jdbcTemplate.queryForList(sql);
    }
}
