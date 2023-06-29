package satc.estacionamento.controller;

import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gustavo
 */
@RestController
public class ReservaController {
    private final JdbcTemplate jdbcTemplate;

    public ReservaController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @RequestMapping(value = "/reserva", method = RequestMethod.GET)
    public List<Map<String, Object>> getAllReserva() {
        String sql = "SELECT * FROM RESERVA";
        return jdbcTemplate.queryForList(sql);
    }
    
    @RequestMapping(value = "/reserva/{idReserva}", method = RequestMethod.GET)
    public List<Map<String, Object>> getReservaById(@PathVariable(value = "idReserva") int idReserva) {
        String sql = "SELECT * FROM RESERVA WHERE ID_RESERVA = ?";
        return jdbcTemplate.queryForList(sql, idReserva);
    }

    @RequestMapping(value = "/reserva", method = RequestMethod.POST)
    public List<Map<String, Object>> createReserva(@RequestBody Map<String, Object> requestBody) {
        Integer idBloco;
        if (requestBody.get("ID_BLOCO") != null) {
            idBloco = (int) requestBody.get("ID_BLOCO");
        } else {
            idBloco = null;
        }
        String dtInicio;
        if (requestBody.get("DT_INICIO") != null) {
            dtInicio = (String) requestBody.get("DT_INICIO");
        } else {
            dtInicio = null;
        }
        String dtFim;
        if (requestBody.get("DT_FIM") != null) {
            dtFim = (String) requestBody.get("DT_FIM");
        } else {
            dtFim = null;
        }
        String status;
        if (requestBody.get("STATUS") != null) {
            status = (String) requestBody.get("STATUS");
            status = "'" + status +"'";
        } else {
            status = (String) requestBody.get("STATUS");
        }
        Integer idVeiculo;
        if (requestBody.get("ID_VEICULO") != null) {
            idVeiculo = (int) requestBody.get("ID_VEICULO");
        } else {
            idVeiculo = (int) requestBody.get("ID_VEICULO");
        }
        
        if (dtInicio != null) {
            dtInicio = "TO_DATE('" + dtInicio + "', 'YYYY-MM-DD HH24:MI')";
        }
        if (dtFim != null) {
            dtFim = "TO_DATE('" + dtFim + "', 'YYYY-MM-DD HH24:MI')";
        }

        String sql = "INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.execute("INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES ("+ idBloco+ " , "+ dtInicio+ ", "+ dtFim+ ", "+ status+ ", "+ idVeiculo+ ")");

        String selectSql = "SELECT * FROM RESERVA WHERE ID_VEICULO = ? and STATUS = 'ATV'";
        List<Map<String, Object>> insertedData = jdbcTemplate.queryForList(selectSql, idVeiculo);
        return insertedData;
    }

    @RequestMapping(value = "/reserva/{idReserva}", method = RequestMethod.PUT)
    public List<Map<String, Object>> updateReserva(@PathVariable("idReserva") int idReserva, @RequestBody Map<String, Object> requestBody) {
        String dtFim = (String) requestBody.get("DT_FIM");
        String status = (String) requestBody.get("STATUS");
        if (requestBody.get("ID_BLOCO") == null) {
            String sql = "UPDATE RESERVA SET DT_FIM = TO_DATE('"+ dtFim +"','YYYY-MM-DD HH24:MI:SS'), STATUS = '"+ status +"' WHERE ID_RESERVA = " + idReserva;
            jdbcTemplate.execute(sql);
        } else {
            int idBloco = (int) requestBody.get("ID_BLOCO");
            String dtInicio = (String) requestBody.get("DT_INICIO");
            int idVeiculo = (int) requestBody.get("ID_VEICULO");

            String sql = "UPDATE RESERVA SET ID_BLOCO = " + idBloco + ", DT_INICIO = TO_DATE('"+  dtInicio + "' ,'YYYY-MM-DD HH24:MI:SS'), DT_FIM = TO_DATE('"+ dtFim +"','YYYY-MM-DD HH24:MI:SS'), STATUS = '"+ status +"', ID_VEICULO = "+idVeiculo+" WHERE ID_RESERVA = " + idReserva;
            jdbcTemplate.execute(sql);
        }
        

        String selectSql = "SELECT * FROM RESERVA WHERE ID_RESERVA = ?";
        List<Map<String, Object>> updatedData = jdbcTemplate.queryForList(selectSql, idReserva);
        return updatedData;
    }
    
    @RequestMapping(value = "/reserva/{idReserva}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteReserva(@PathVariable("idReserva") int idReserva) {
        try {
            String sql = "DELETE FROM RESERVA WHERE ID_RESERVA = ?";
            jdbcTemplate.queryForList(sql, idReserva);

            return ResponseEntity.ok("Reserva deletado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Problema para deletar o reserva: " + e.getMessage());
        }
    }
}
