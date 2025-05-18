package satc.estacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import satc.estacionamento.model.Cliente;
import satc.estacionamento.model.Veiculo;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientesVeiculosDTO {
    private Cliente cliente;
    private List<Veiculo> veiculos;
}
