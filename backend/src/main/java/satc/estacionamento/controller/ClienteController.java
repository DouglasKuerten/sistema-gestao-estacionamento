package satc.estacionamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import satc.estacionamento.dto.ClientesVeiculosDTO;
import satc.estacionamento.model.Cliente;
import satc.estacionamento.model.Veiculo;
import satc.estacionamento.services.ClienteService;
import satc.estacionamento.services.VeiculoClienteService;
import satc.estacionamento.services.VeiculoService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private VeiculoClienteService veiculoClienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.salvar(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> alterar(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (clienteService.buscarPorId(id).isPresent()) {
            Cliente clienteAtualizado = clienteService.salvar(cliente);
            return ResponseEntity.ok(clienteAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (clienteService.buscarPorId(id).isPresent()) {
            clienteService.excluir(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}/veiculos")
    public ResponseEntity<List<Veiculo>> listarVeiculos(@PathVariable Long id) {
        Optional<Cliente> optionalCliente = clienteService.buscarPorId(id);
        if (optionalCliente.isPresent()) {
            List<Veiculo> veiculos = veiculoService.buscarVeiculosCliente(optionalCliente.get());
            return ResponseEntity.ok(veiculos);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("listaTodosClientesVeiculos")
    public ResponseEntity<List<ClientesVeiculosDTO>> listaTodosClientesVeiculos() {
        return ResponseEntity.ok(veiculoClienteService.listarVeiculosCliente());
    }
}
