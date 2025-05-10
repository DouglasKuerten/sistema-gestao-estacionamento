package satc.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import satc.estacionamento.model.Reserva;
import satc.estacionamento.services.ReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> listarTodos() {
        List<Reserva> reservas = reservaService.listarTodos();
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable Long id) {
        return reservaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> criar(@RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.salvar(reserva);
        return ResponseEntity.ok(novaReserva);
    }

    @PutMapping("{id}")
    public ResponseEntity<Reserva> alterar(@PathVariable Long id, @RequestBody Reserva reserva) {
        if (reservaService.buscarPorId(id).isPresent()) {
            Reserva reservaAtualizada = reservaService.salvar(reserva);
            return ResponseEntity.ok(reservaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (reservaService.buscarPorId(id).isPresent()) {
            reservaService.excluir(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("ativas/{placa}")
    public ResponseEntity<List<Reserva>> listarReservasAtivasPorPlaca(@PathVariable String placa) {
        List<Reserva> reservas = reservaService.listarReservasAtivaPorPlaca(placa);
        return ResponseEntity.ok(reservas);
    }
}
