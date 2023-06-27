/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author gustavo
 */
@RestController
@RequestMapping("/placaRetornaVeiculoClienteReserva/{placa}")
public class PlacaRetornaVeiculoClienteReserva {
    private final JdbcTemplate jdbcTemplate;

    public PlacaRetornaVeiculoClienteReserva(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getPlacaRetornaVeiculoClienteReserva(@PathVariable("placa") String placa) {
        String sql = "SELECT c.*, r.*, v.* " +
                 "FROM CLIENTE c " +
                 "JOIN VEICULO v ON c.ID_CLIENTE = v.ID_CLIENTE " +
                 "JOIN RESERVA r ON v.ID_VEICULO = r.ID_VEICULO " +
                 "WHERE v.DS_PLACA = ? AND r.STATUS = 'ATV'";

        return jdbcTemplate.queryForList(sql, placa);
    }
}
