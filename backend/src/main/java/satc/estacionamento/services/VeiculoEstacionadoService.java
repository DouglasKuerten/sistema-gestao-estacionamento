package satc.estacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import satc.estacionamento.dto.VeiculoEstacionadoDTO;
import satc.estacionamento.repository.ReservaRepository;

import java.util.List;

@Service
public class VeiculoEstacionadoService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<VeiculoEstacionadoDTO> listarVeiculosEstacionados() {
        return reservaRepository.buscarVeiculosEstacionadosAtivos();
    }
}
