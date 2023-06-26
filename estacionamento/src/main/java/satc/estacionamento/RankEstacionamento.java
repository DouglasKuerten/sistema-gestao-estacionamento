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
@RequestMapping("RankEstacionamento")
public class RankEstacionamento {
    private final JdbcTemplate jdbcTemplate;

    public RankEstacionamento(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/{startDate}/{endDate}")
    public List<Map<String, Object>> getPlacaRetornaVeiculoClienteReserva(
            @PathVariable("startDate") String startDate,
            @PathVariable("endDate") String endDate
    ) {
        String sql = "CALL get_parking_ranking(?, ?)";
        return jdbcTemplate.queryForList(sql, startDate, endDate);
    }
}
