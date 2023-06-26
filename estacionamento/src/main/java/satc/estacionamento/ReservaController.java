/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package satc.estacionamento;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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
        int idBloco = (int) requestBody.get("ID_BLOCO");
        LocalDate dtInicio = LocalDate.parse((String) requestBody.get("DT_INICIO"));
        LocalDate dtFim = LocalDate.parse((String) requestBody.get("DT_FIM"));
        String status = (String) requestBody.get("STATUS");
        int idVeiculo = (int) requestBody.get("ID_VEICULO");

        String sql = "INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, idBloco, dtInicio, dtFim, status, idVeiculo);

        String selectSql = "SELECT * FROM RESERVA WHERE ID_RESERVA = ?";
        List<Map<String, Object>> insertedData = jdbcTemplate.queryForList(selectSql, idVeiculo);
        return insertedData;
    }

    @RequestMapping(value = "/reserva/{idReserva}", method = RequestMethod.PUT)
    public List<Map<String, Object>> updateReserva(@PathVariable("idReserva") int idReserva, @RequestBody Map<String, Object> requestBody) {
        int idBloco = (int) requestBody.get("ID_BLOCO");
        LocalDate dtInicio = LocalDate.parse((String) requestBody.get("DT_INICIO"));
        LocalDate dtFim = LocalDate.parse((String) requestBody.get("DT_FIM"));
        String status = (String) requestBody.get("STATUS");
        int idVeiculo = (int) requestBody.get("ID_VEICULO");

        String sql = "UPDATE RESERVA SET ID_BLOCO = ?, DT_INICIO = ?, DT_FIM = ?, STATUS = ?, ID_VEICULO = ? WHERE ID_RESERVA = ?";
        jdbcTemplate.update(sql, idBloco, dtInicio, dtFim, status, idVeiculo, idReserva);

        String selectSql = "SELECT * FROM RESERVA WHERE ID_RESERVA = ?";
        List<Map<String, Object>> updatedData = jdbcTemplate.queryForList(selectSql, idReserva);
        return updatedData;
    }
    
    @RequestMapping(value = "/reserva/{idReserva}", method = RequestMethod.DELETE)
    public void deleteReserva(@PathVariable("idReserva") int idReserva) {
        String sql = "DELETE FROM RESERVA WHERE ID_RESERVA = ?";
        jdbcTemplate.update(sql, idReserva);
    }
}
