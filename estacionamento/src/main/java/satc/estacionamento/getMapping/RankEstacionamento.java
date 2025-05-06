package satc.estacionamento.getMapping;

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
@RequestMapping("rankEstacionamento")
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
            String sqlQuery = "SELECT"
                    + " (TO_DATE(A.DT_FIM, 'dd/mm/yyyy hh24:mi') - TO_DATE(A.DT_INICIO, 'dd/mm/yyyy hh24:mi')) * 24  AS TEMPO_DECORRIDO_TOTAL,"
                    + " D.DS_NOME,"
                    + " DS_MODELO,"
                    + " B.DS_PLACA,"
                    + " f_calcula_valor_estacionado(a.id_bloco, (TO_DATE(A.DT_FIM, 'dd/mm/yyyy hh24:mi') - TO_DATE(A.DT_INICIO, 'dd/mm/yyyy hh24:mi')) * 24 ) AS VALOR,"
                    + " RANK() OVER (ORDER BY (A.DT_FIM - A.DT_INICIO) DESC) AS RANK"
                    + " FROM"
                    + " RESERVA A"
                    + " INNER JOIN VEICULO B ON B.ID_VEICULO = A.ID_VEICULO"
                    + " INNER JOIN PAGAMENTO C ON C.ID_RESERVA = A.ID_RESERVA"
                    + " LEFT JOIN CLIENTE D ON D.ID_CLIENTE = B.ID_CLIENTE"
                    + " JOIN TARIFA T ON A.ID_BLOCO = T.ID_BLOCO"
                    + " WHERE"
                    + " A.DT_INICIO BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD')";
            return jdbcTemplate.queryForList(sqlQuery, startDate, endDate);

    }
}
