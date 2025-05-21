package satc.estacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoEstacionadoDTO {
    private Long idVeiculo;
    private String placa;
    private String nomeCliente;
    private String statusReserva;
}
