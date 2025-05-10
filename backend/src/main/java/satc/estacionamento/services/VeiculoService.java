package satc.estacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import satc.estacionamento.model.Veiculo;
import satc.estacionamento.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

public class VeiculoService {
    @Autowired
    VeiculoRepository veiculoRepository;

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void excluir(Long id) {
        veiculoRepository.deleteById(id);
    }

    public List<Veiculo> buscarVeiculosCliente(Long idCliente) {
        return veiculoRepository.findByIdCliente(idCliente);
    }

    public Optional<Veiculo> buscarPorPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa);
    }

//    public List<Veiculo> listarVeiculosEstacionados() {
//        return veiculoRepository.findAllEstacionado();
//    }
}
