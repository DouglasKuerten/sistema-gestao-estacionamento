package satc.estacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import satc.estacionamento.model.Reserva;
import satc.estacionamento.model.Veiculo;
import satc.estacionamento.repository.ReservaRepository;
import satc.estacionamento.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

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
        Optional<Veiculo> veiculo = veiculoRepository.findByPlaca(placa);
        if (veiculo.isEmpty()){
            throw new IllegalArgumentException("Placa não encontrada");
        }
        return reservaRepository.findByStatusAndVeiculo("A", veiculo.get());
    }
}
