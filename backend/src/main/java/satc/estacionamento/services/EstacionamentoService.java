package satc.estacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import satc.estacionamento.model.Estacionamento;
import satc.estacionamento.repository.EstacionamentoRepository;

import java.util.List;
import java.util.Optional;

public class EstacionamentoService {
    @Autowired
    EstacionamentoRepository estacionamentoRepository;

    public List<Estacionamento> listarTodos() {
        return estacionamentoRepository.findAll();
    }

    public Optional<Estacionamento> buscarPorId(Long id) {
        return estacionamentoRepository.findById(id);
    }

    public Estacionamento salvar(Estacionamento estacionamento) {
        return estacionamentoRepository.save(estacionamento);
    }

    public void excluir(Long id) {
        estacionamentoRepository.deleteById(id);
    }
}
