package satc.estacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import satc.estacionamento.model.Bloco;
import satc.estacionamento.model.Tarifa;
import satc.estacionamento.repository.BlocoRepository;
import satc.estacionamento.repository.TarifaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlocoService {

    @Autowired
    private BlocoRepository blocoRepository;

    public List<Bloco> listarTodos() {
        return blocoRepository.findAll();
    }

    public Optional<Bloco> buscarPorId(Long id) {
        return blocoRepository.findById(id);
    }

    public Bloco salvar(Bloco bloco) {
        return blocoRepository.save(bloco);
    }

    public void excluir(Long id) {
        blocoRepository.deleteById(id);
    }

//    public List<Bloco> listar
}
