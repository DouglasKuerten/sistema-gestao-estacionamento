package satc.estacionamento.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import satc.estacionamento.model.Cliente;
import satc.estacionamento.repository.ClienteRepository;

/**
 *
 * @author gustavo
 */
@RestController
public class ClienteController {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public List<Map<String, Object>> getAllEstacionamento() {
        // exemplo pelo jpa:
        List<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(cliente -> {
            System.out.println(cliente);
        });
        
        String sql = "SELECT * FROM cliente";
        return jdbcTemplate.queryForList(sql);
    }

    @RequestMapping(value = "/cliente/{idCliente}", method = RequestMethod.GET)
    public List<Map<String, Object>> GetById(@PathVariable(value = "idCliente") String id) throws Exception {
        String sql = "SELECT * FROM cliente where ID_CLIENTE = ?";
        return jdbcTemplate.queryForList(sql, id);
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public List<Map<String, Object>> Post(@RequestBody Map<String, Object> requestBody) throws Exception {
        String dsNome = (String) requestBody.get("DS_NOME");
        jdbcTemplate.execute("INSERT INTO cliente (DS_NOME) VALUES ('" + dsNome + "')");
        String selectSql = "SELECT * FROM cliente WHERE DS_NOME = ?";
        List<Map<String, Object>> insertedData = jdbcTemplate.queryForList(selectSql, dsNome);
        return insertedData;
    }

    @RequestMapping(value = "/cliente/{idCliente}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("idCliente") int idCliente) {
        try {
            String sql = "DELETE FROM cliente WHERE ID_CLIENTE = ?";
            jdbcTemplate.queryForList(sql, idCliente);

            return ResponseEntity.ok("Cliente deletado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Problema para deletar o cliente: " + e.getMessage());
        }
    }  
}
