package satc.estacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import satc.estacionamento.model.Cliente;
import satc.estacionamento.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
