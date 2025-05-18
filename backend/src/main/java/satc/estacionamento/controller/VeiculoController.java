package satc.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import satc.estacionamento.dto.VeiculoEstacionadoDTO;
import satc.estacionamento.model.Veiculo;
import satc.estacionamento.services.VeiculoEstacionadoService;
import satc.estacionamento.services.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private VeiculoEstacionadoService veiculoEstacionadoService;

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodos() {
        List<Veiculo> veiculos = veiculoService.listarTodos();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        return veiculoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Veiculo> criar(@RequestBody Veiculo veiculo) {
        Veiculo veiculoNovo = veiculoService.salvar(veiculo);
        return ResponseEntity.ok(veiculoNovo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Veiculo> alterar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        if (veiculoService.buscarPorId(id).isPresent()) {
            Veiculo veiculoAtualizado = veiculoService.salvar(veiculo);
            return ResponseEntity.ok(veiculoAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (veiculoService.buscarPorId(id).isPresent()) {
            veiculoService.excluir(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("placa/{placa}")
    public ResponseEntity<Veiculo> buscarPorPlaca(@PathVariable String placa) {
        return veiculoService.buscarPorPlaca(placa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estacionados")
    public ResponseEntity<List<VeiculoEstacionadoDTO>> listarEstacionados() {
        return ResponseEntity.ok(veiculoEstacionadoService.listarVeiculosEstacionados());
    }
}
