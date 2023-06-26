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
public class ClienteController {
    private final JdbcTemplate jdbcTemplate;

    public ClienteController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public List<Map<String, Object>> getAllEstacionamento(){
        String sql = "SELECT * FROM cliente";
        return jdbcTemplate.queryForList(sql);
    }
    
    @RequestMapping(value = "/cliente/{idCliente}", method = RequestMethod.GET)
    public List<Map<String, Object>> GetById(@PathVariable(value = "idCliente") String id) throws Exception{
        String sql = "SELECT * FROM cliente where ID_CLIENTE = ?";
        return jdbcTemplate.queryForList(sql);
    }

    @RequestMapping(value = "/cliente", method =  RequestMethod.POST)
    public List<Map<String, Object>> Post(@RequestBody Map<String, Object> requestBody) throws Exception{
        String dsNome = (String) requestBody.get("DS_NOME");
        String dsTelefone = (String) requestBody.get("DS_TELEFONE");
        String dsEmail = (String) requestBody.get("DS_EMAIL");
        String endereco = (String) requestBody.get("ENDERECO");
        LocalDate dtCadastro = LocalDate.now();
        String sql = "INSERT INTO cliente (DS_NOME, DS_TELEFONE, DS_EMAIL, ENDERECO, DT_CADASTRO) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, dsNome, dsTelefone, dsEmail, dtCadastro, endereco);
        String selectSql = "SELECT * FROM estacionamento WHERE DS_NOME = ? AND dsTelefone = ?";
        List<Map<String, Object>> insertedData = jdbcTemplate.queryForList(selectSql, dsNome, dsTelefone);
        return insertedData;
    }

    @RequestMapping(value = "/cliente/{idCliente}", method =  RequestMethod.PUT)
    public List<Map<String, Object>> put(@PathVariable("idCliente") int idCliente, @RequestBody Map<String, Object> requestBody) throws Exception {
        String dsNome = (String) requestBody.get("DS_NOME");
        String dsTelefone = (String) requestBody.get("DS_TELEFONE");
        String dsEmail = (String) requestBody.get("DS_EMAIL");
        String endereco = (String) requestBody.get("ENDERECO");
        LocalDate dtCadastro = LocalDate.now();
        String sql = "UPDATE estacionamento SET DS_NOME = ?, DS_TELEFONE = ?, DS_EMAIL = ?, ENDERECO = ?, DT_CADASTRO = ? WHERE ID_CLIENTE = ?";
        jdbcTemplate.update(sql, dsNome, dsTelefone, dsEmail, endereco, dtCadastro, idCliente);

        String selectSql = "SELECT * FROM estacionamento WHERE ID_CLIENTE = ?";
        List<Map<String, Object>> updatedData = jdbcTemplate.queryForList(selectSql, idCliente);
        return updatedData;
    }

    @RequestMapping(value = "/cliente/{idCliente}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("idCliente") int idCliente) throws Exception {
        String sql = "DELETE FROM cliente WHERE ID_CLIENTE = ?";
        jdbcTemplate.update(sql, idCliente);
    }
}
