package satc.estacionamento.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import satc.estacionamento.model.Bloco;
import satc.estacionamento.model.Tarifa;
import satc.estacionamento.services.BlocoService;
import satc.estacionamento.services.TarifaService;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/tarifa")
public class TarifaController {
    @Autowired
    private TarifaService tarifaService;

    @Autowired
    private BlocoService blocoService;

    @GetMapping
    public ResponseEntity<List<Tarifa>> listarTodos() {
        List<Tarifa> tarifas = tarifaService.listarTodos();
        return ResponseEntity.ok(tarifas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Tarifa> buscarPorId(@PathVariable Long id) {
        return tarifaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tarifa> criar(@RequestBody Tarifa tarifa) {
        Tarifa tarifaNova = tarifaService.salvar(tarifa);
        return ResponseEntity.ok(tarifaNova);
    }

    @PutMapping("{id}")
    public ResponseEntity<Tarifa> alterar(@PathVariable Long id, @RequestBody Tarifa tarifa) {
        if (tarifaService.buscarPorId(id).isPresent()) {
            Tarifa tarifaAtualizada = tarifaService.salvar(tarifa);
            return ResponseEntity.ok(tarifaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (tarifaService.buscarPorId(id).isPresent()) {
            tarifaService.excluir(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("bloco/{id}")
    public ResponseEntity<List<Tarifa>> listarTarifasPorBloco(@PathVariable Long id) {
        Optional<Bloco> optionalBloco = blocoService.buscarPorId(id);
        if (optionalBloco.isPresent()) {
            List<Tarifa> tarifas = tarifaService.listarTarifasPorBloco(optionalBloco.get());
            return ResponseEntity.ok(tarifas);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/valorTarifaPassandoReservaBloco/{idReserva}/{idBloco}")
    public ResponseEntity<Long> calcularValorTarifa( @PathVariable Long idReserva, @PathVariable Long idBloco) {
        try {
            Long valor = tarifaService.calcularValorCentavos(idReserva, idBloco);
            return ResponseEntity.ok(valor);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}