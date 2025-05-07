package satc.estacionamento.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import satc.estacionamento.model.Cliente;
import satc.estacionamento.model.Veiculo;
import satc.estacionamento.repository.ClienteRepository;
import satc.estacionamento.repository.VeiculoRepository;

/**
 *
 * @author gusta
 */
@RestController
public class ClienteVeiculosController {

    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;

    public ClienteVeiculosController(ClienteRepository clienteRepository, VeiculoRepository veiculoRepository) {
        this.clienteRepository = clienteRepository;
        this.veiculoRepository = veiculoRepository;
    }

    @RequestMapping(value = "/clienteVeiculos", method = RequestMethod.GET)
    public List<Map<String, Object>> clienteVeiculos() {
        List<Map<String, Object>> result = new ArrayList<>();

        // Get all clients
        List<Cliente> clientes = clienteRepository.findAll();

        for (Cliente cliente : clientes) {
            // Get vehicles for each client
            List<Veiculo> veiculos = veiculoRepository.findByCliente(cliente);

            // Skip clients with no vehicles
            if (veiculos.isEmpty()) {
                continue;
            }

            // Create a map for each client with their vehicles
            Map<String, Object> clienteMap = new HashMap<>();
            clienteMap.put("id_Cliente", cliente.getId());
            clienteMap.put("ds_nome", cliente.getDsNome());
            clienteMap.put("ds_telefone", cliente.getDsTelefone());
            clienteMap.put("ds_email", cliente.getDsEmail());
            clienteMap.put("endereco", cliente.getEndereco());

            // Join vehicle plates with comma
            String placas = veiculos.stream()
                    .map(Veiculo::getDsPlaca)
                    .sorted()
                    .collect(Collectors.joining(", "));

            clienteMap.put("PLACAS", placas);

            result.add(clienteMap);
        }

        return result;
    }
}
