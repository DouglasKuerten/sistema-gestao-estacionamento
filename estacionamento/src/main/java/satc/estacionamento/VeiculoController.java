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
public class VeiculoController {
    private final JdbcTemplate jdbcTemplate;

    public VeiculoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @RequestMapping(value = "/veiculo", method = RequestMethod.GET)
    public List<Map<String, Object>> getAllVeiculo(){
        String sql = "SELECT * FROM VEICULO";
        return jdbcTemplate.queryForList(sql);
    }
    
    @RequestMapping(value = "/veiculo/{idVeiculo}", method = RequestMethod.GET)
    public List<Map<String, Object>> getVeiculoById(@PathVariable(value = "idVeiculo") int idVeiculo) {
        String sql = "SELECT * FROM VEICULO WHERE ID_VEICULO = ?";
        return jdbcTemplate.queryForList(sql, idVeiculo);
    }

    @RequestMapping(value = "/veiculo", method = RequestMethod.POST)
    public List<Map<String, Object>> createVeiculo(@RequestBody Map<String, Object> requestBody) {
        String dsPlaca = (String) requestBody.get("DS_PLACA");
        String dsModelo = (String) requestBody.get("DS_MODELO");
        String dsCor = (String) requestBody.get("DS_COR");
        String dtCadastro = (String) requestBody.get("DT_CADASTRO");
        dtCadastro = "TO_DATE('" + dtCadastro + "', 'YYYY-MM-DD HH24:MI')";
        int idCliente = (int) requestBody.get("ID_CLIENTE");

        String sql = "INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.execute("INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('" + dsPlaca + "', '" + dsModelo + "', '" + dsCor + "', " + dtCadastro + ", " + idCliente + ")");

        String selectSql = "SELECT * FROM VEICULO WHERE ID_CLIENTE = ?";
        List<Map<String, Object>> insertedData = jdbcTemplate.queryForList(selectSql, idCliente);
        return insertedData;
    }

    @RequestMapping(value = "/veiculo/{idVeiculo}", method = RequestMethod.PUT)
    public List<Map<String, Object>> updateVeiculo(@PathVariable("idVeiculo") int idVeiculo, @RequestBody Map<String, Object> requestBody) {
        String dsPlaca = (String) requestBody.get("DS_PLACA");
        String dsModelo = (String) requestBody.get("DS_MODELO");
        String dsCor = (String) requestBody.get("DS_COR");
        LocalDate dtCadastro = LocalDate.now();  // Assuming current date as the registration date
        int idCliente = (int) requestBody.get("ID_CLIENTE");

        String sql = "UPDATE VEICULO SET DS_PLACA = ?, DS_MODELO = ?, DS_COR = ?, DT_CADASTRO = ?, ID_CLIENTE = ? WHERE ID_VEICULO = ?";
        jdbcTemplate.update(sql, dsPlaca, dsModelo, dsCor, dtCadastro, idCliente, idVeiculo);

        String selectSql = "SELECT * FROM VEICULO WHERE ID_VEICULO = ?";
        List<Map<String, Object>> updatedData = jdbcTemplate.queryForList(selectSql, idVeiculo);
        return updatedData;
    }

    @RequestMapping(value = "/veiculo/{idVeiculo}", method = RequestMethod.DELETE)
    public void deleteVeiculo(@PathVariable("idVeiculo") int idVeiculo) {
        String sql = "DELETE FROM VEICULO WHERE ID_VEICULO = ?";
        jdbcTemplate.update(sql, idVeiculo);
    }
}
