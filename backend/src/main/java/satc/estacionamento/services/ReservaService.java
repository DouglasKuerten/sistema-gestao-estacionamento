package satc.estacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import satc.estacionamento.model.Reserva;
import satc.estacionamento.model.Veiculo;
import satc.estacionamento.repository.ReservaRepository;

import java.util.List;
import java.util.Optional;

public class ReservaService {
    @Autowired
    ReservaRepository reservaRepository;

    public List<Reserva> listarTodos() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> buscarPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva salvar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void excluir(Long id) {
        reservaRepository.deleteById(id);
    }

    public List<Reserva> listarReservasAtivaPorPlaca(String placa) {
        return reservaRepository.findByStatusEqualAndPlacaEqual("A", placa);
    }
}
