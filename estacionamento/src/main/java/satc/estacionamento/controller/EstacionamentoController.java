package satc.estacionamento.controller;

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
 * @author gusta
 */
@RestController
public class EstacionamentoController {
    private final JdbcTemplate jdbcTemplate;

    public EstacionamentoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @RequestMapping(value = "/estacionamento", method = RequestMethod.GET)
    public List<Map<String, Object>> getAllEstacionamento(){
        String sql = "SELECT * FROM estacionamento";
        return jdbcTemplate.queryForList(sql);
    }
    
    @RequestMapping(value = "/estacionamento/{idEstaciomento}", method = RequestMethod.GET)
    public List<Map<String, Object>> GetById(@PathVariable(value = "idEstaciomento") String id) throws Exception{
        String sql = "SELECT * FROM estacionamento where ID_ESTACIONAMENTO = ?";
        return jdbcTemplate.queryForList(sql, id);
    }

    @RequestMapping(value = "/estacionamento", method =  RequestMethod.POST)
    public List<Map<String, Object>> Post(@RequestBody Map<String, Object> requestBody) throws Exception{
        String dsNome = (String) requestBody.get("DS_NOME");
        String dsSigla = (String) requestBody.get("DS_SIGLA");
        Integer vagasTotais = (Integer) requestBody.get("VAGAS_TOTAIS");
        String sql = "INSERT INTO estacionamento (DS_NOME, DS_SIGLA, VAGAS_TOTAIS) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, dsNome, dsSigla, vagasTotais);
        String selectSql = "SELECT * FROM estacionamento WHERE DS_NOME = ? AND DS_SIGLA = ?";
        List<Map<String, Object>> insertedData = jdbcTemplate.queryForList(selectSql, dsNome, dsSigla);
        return insertedData;
    }

    @RequestMapping(value = "/estacionamento/{idEstaciomento}", method =  RequestMethod.PUT)
    public List<Map<String, Object>> put(@PathVariable("idEstaciomento") int idEstaciomento, @RequestBody Map<String, Object> requestBody) throws Exception {
        String dsNome = (String) requestBody.get("DS_NOME");
        String dsSigla = (String) requestBody.get("DS_SIGLA");
        Integer vagasTotais = (Integer) requestBody.get("VAGAS_TOTAIS");

        String sql = "UPDATE estacionamento SET DS_NOME = ?, DS_SIGLA = ?, VAGAS_TOTAIS = ? WHERE ID_ESTACIONAMENTO = ?";
        jdbcTemplate.update(sql, dsNome, dsSigla, vagasTotais, idEstaciomento);

        String selectSql = "SELECT * FROM estacionamento WHERE ID_ESTACIONAMENTO = ?";
        List<Map<String, Object>> updatedData = jdbcTemplate.queryForList(selectSql, idEstaciomento);
        return updatedData;
    }

    @RequestMapping(value = "/estacionamento/{idEstaciomento}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("idEstaciomento") int idEstaciomento) throws Exception {
        String sql = "DELETE FROM estacionamento WHERE ID_ESTACIONAMENTO = ?";
        jdbcTemplate.update(sql, idEstaciomento);
    }
}
