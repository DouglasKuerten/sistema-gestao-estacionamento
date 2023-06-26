package satc.estacionamento;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gusta
 */
@RestController
@RequestMapping(value = "/cliente/{nome}", method = RequestMethod.POST)
public class SalvarClienteVeiculo {
    private final JdbcTemplate jdbcTemplate;
    
    public SalvarClienteVeiculo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping
    public ResponseEntity<String> salvarCliente(@PathVariable("nome") String nome) {
        String sql = "INSERT INTO CLIENTE (ID_CLIENTE, DS_NOME) VALUES (13, ?)";
        jdbcTemplate.update(sql, nome);
        
        return ResponseEntity.ok("Client saved successfully.");
    }
}
