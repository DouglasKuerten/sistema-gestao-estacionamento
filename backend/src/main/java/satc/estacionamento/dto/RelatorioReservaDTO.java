package satc.estacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioReservaDTO {
    private Long tempoDecorridoTotal;
    private String nomeCliente;
    private String modelo;
    private String placa;
    private Long valor;
    private Long rank;
}