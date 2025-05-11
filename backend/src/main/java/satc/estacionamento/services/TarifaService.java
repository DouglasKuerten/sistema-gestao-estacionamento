package satc.estacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import satc.estacionamento.model.Estacionamento;
import satc.estacionamento.model.Tarifa;
import satc.estacionamento.repository.EstacionamentoRepository;
import satc.estacionamento.repository.TarifaRepository;

import java.util.List;
import java.util.Optional;

public class TarifaService {
    @Autowired
    TarifaRepository tarifaRepository;

    public List<Tarifa> listarTodos() {
        return tarifaRepository.findAll();
    }

    public Optional<Tarifa> buscarPorId(Long id) {
        return tarifaRepository.findById(id);
    }

    public Tarifa salvar(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    public void excluir(Long id) {
        tarifaRepository.deleteById(id);
    }

    public List<Tarifa> listarTarifasPorBloco(Long id) {
        return tarifaRepository.findByIdBloco(id);
    }

}
