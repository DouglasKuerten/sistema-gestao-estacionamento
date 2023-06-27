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
@RequestMapping(value = "clienteVeiculos")
public class ClienteVeiculos {
    private final JdbcTemplate jdbcTemplate;

    public ClienteVeiculos(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> clienteVeiculos() {
        String sql = "SELECT c.id_Cliente, c.ds_nome, c.ds_telefone, c.ds_email, c.endereco, rtrim(xmlagg(xmlelement(x, v.DS_PLACA , ', ') ORDER BY v.DS_PLACA).extract('//text()').getstringval(), ',') AS PLACAS\n" +
"FROM cliente c inner join veiculo v ON c.id_cliente = v.id_cliente \n" +
"GROUP BY c.id_Cliente, c.ds_nome, c.ds_telefone, c.ds_email, c.endereco";
        return jdbcTemplate.queryForList(sql);
    }
}
