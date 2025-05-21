package satc.estacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import satc.estacionamento.dto.ClientesVeiculosDTO;
import satc.estacionamento.model.Cliente;
import satc.estacionamento.model.Veiculo;
import satc.estacionamento.repository.ClienteRepository;
import satc.estacionamento.repository.VeiculoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoClienteService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClientesVeiculosDTO> listarVeiculosCliente() {
        List<Cliente> clientes = clienteRepository.findAll();

        List<ClientesVeiculosDTO> clientesVeiculosDTO = new ArrayList<>();

        clientes.forEach(cliente -> {
            List<Veiculo> clientesVeiculos = veiculoRepository.findByCliente(cliente);
            clientesVeiculosDTO.add(ClientesVeiculosDTO.builder().cliente(cliente).veiculos(clientesVeiculos).build());
        });


        return clientesVeiculosDTO;
    }
}
