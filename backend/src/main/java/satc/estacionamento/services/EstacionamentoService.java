package satc.estacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import satc.estacionamento.model.Estacionamento;
import satc.estacionamento.repository.EstacionamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

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
