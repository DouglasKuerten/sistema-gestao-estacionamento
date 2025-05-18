package satc.estacionamento.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import satc.estacionamento.dto.RelatorioReservaDTO;
import satc.estacionamento.model.Estacionamento;
import satc.estacionamento.services.EstacionamentoService;
import satc.estacionamento.services.RankEstacionamentoService;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {
    @Autowired
    private EstacionamentoService estacionamentoService;

    @Autowired
    private RankEstacionamentoService rankEstacionamentoService;

    @GetMapping
    public ResponseEntity<List<Estacionamento>> listarTodos() {
        List<Estacionamento> estacionamentos = estacionamentoService.listarTodos();
        return ResponseEntity.ok(estacionamentos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Estacionamento> buscarPorId(@PathVariable Long id) {
        return estacionamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/rank/{dataInicial}/{dataFinal}")
    public ResponseEntity<List<RelatorioReservaDTO>> getPlacaRetornaVeiculoClienteReserva(@PathVariable("dataInicial") LocalDate dataInicial, @PathVariable("dataFinal") LocalDate dataFinal) {
        return ResponseEntity.ok(rankEstacionamentoService.obterRankEstacionamento(dataInicial, dataFinal));
    }

    @PostMapping
    public ResponseEntity<Estacionamento> criar(@RequestBody Estacionamento estacionamento) {
        Estacionamento novoEstacionamento = estacionamentoService.salvar(estacionamento);
        return ResponseEntity.ok(novoEstacionamento);
    }

    @PutMapping("{id}")
    public ResponseEntity<Estacionamento> alterar(@PathVariable Long id, @RequestBody Estacionamento estacionamento) {
        if (estacionamentoService.buscarPorId(id).isPresent()) {
            Estacionamento estacionamentoAtualizado = estacionamentoService.salvar(estacionamento);
            return ResponseEntity.ok(estacionamentoAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (estacionamentoService.buscarPorId(id).isPresent()) {
            estacionamentoService.excluir(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
