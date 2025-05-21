package satc.estacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import satc.estacionamento.dto.RelatorioReservaDTO;
import satc.estacionamento.model.Cliente;
import satc.estacionamento.model.Reserva;
import satc.estacionamento.model.Tarifa;
import satc.estacionamento.model.Veiculo;
import satc.estacionamento.repository.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class RankEstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private TarifaRepository tarifaRepository;

    public List<RelatorioReservaDTO> obterRankEstacionamento(LocalDate dataInicial, LocalDate dataFinal) {
        List<Reserva> reservas = reservaRepository.findReservasComClienteEVeiculoComPagamento(dataInicial, dataFinal);

        List<RelatorioReservaDTO> relatorio = reservas.stream().map(reserva -> {
            long tempoHoras = Duration.between(reserva.getDataInicio(), reserva.getDataFim()).toHours();

            List<Tarifa> tarifas = tarifaRepository.findByBloco(reserva.getBloco());

            Tarifa tarifa = tarifas.isEmpty()
                    ? new Tarifa()  // valor padrão
                    : tarifas.get(0);

            long valor = Math.round(tarifa.getPrecoHora() * tempoHoras);
            Veiculo veiculo = reserva.getVeiculo();
            Cliente cliente = veiculo.getCliente();


            return RelatorioReservaDTO.builder()
                    .tempoDecorridoTotal(tempoHoras)
                    .nomeCliente(cliente.getNome())
                    .modelo(veiculo.getModelo())
                    .placa(veiculo.getPlaca())
                    .valor(valor)
                    .build();
        }).sorted(Comparator.comparingLong(RelatorioReservaDTO::getTempoDecorridoTotal).reversed()).collect(Collectors.toList());

        AtomicLong counter = new AtomicLong(1);
        relatorio.forEach(dto -> dto.setRank(counter.getAndIncrement()));

        return relatorio;
    }

}
