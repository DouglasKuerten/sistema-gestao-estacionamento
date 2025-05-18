package satc.estacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import satc.estacionamento.model.Bloco;
import satc.estacionamento.model.Estacionamento;
import satc.estacionamento.model.Reserva;
import satc.estacionamento.model.Tarifa;
import satc.estacionamento.repository.BlocoRepository;
import satc.estacionamento.repository.EstacionamentoRepository;
import satc.estacionamento.repository.ReservaRepository;
import satc.estacionamento.repository.TarifaRepository;

import javax.persistence.EntityNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private BlocoRepository blocoRepository;

    public List<Tarifa> listarTodos() {
        return tarifaRepository.findAll();
    }

    public Optional<Tarifa> buscarPorId(Long id) {
        return tarifaRepository.findById(id);
    }

    public long calcularValorCentavos(Long idReserva, Long idBloco) {
        Reserva reserva = reservaRepository.findById(idReserva)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada"));

        if (!reserva.getBloco().getId().equals(idBloco)) {
            throw new IllegalArgumentException("O bloco informado não corresponde ao bloco da reserva");
        }

        Optional<Bloco> optionalBloco = blocoRepository.findById(idBloco);
        if (optionalBloco.isEmpty()) {
            throw new EntityNotFoundException("Bloco não encontrado");
        }

        List<Tarifa> tarifas = tarifaRepository.findByBloco(optionalBloco.get());
        if (tarifas.isEmpty()) {
            throw new EntityNotFoundException("Tarifa não encontrada para o bloco informado");
        }

        Tarifa tarifa = tarifas.get(0);

        Duration duration = Duration.between(reserva.getDataInicio(), reserva.getDataFim());
        long minutos = duration.toMinutes();

        return tarifa.getPrecoHora() * minutos / 60;
    }


    public Tarifa salvar(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    public void excluir(Long id) {
        tarifaRepository.deleteById(id);
    }

    public List<Tarifa> listarTarifasPorBloco(Bloco bloco) {
        return tarifaRepository.findByBloco(bloco);
    }

}
