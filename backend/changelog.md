## Commit 10/05 
> Foi finalizado o ajuste nos controllers:
- `ClienteController`
- `EstacionamentoController`
- `ReservaController`
- `TarifaController`
- `VeiculoController`

> Ainda está restando o ajuste nos controllers:
- `RankEstacionamentoController` (adicionar chamada dentro do arquivo `EstacionamentoController`)
- `TarifaReservaController` (adicionar chamada dentro do arquivo `TarifaController`)
- `VeiculosEstacionadosController` (adicionar chamada dentro do arquivo `VeiculosController`)
- Não foi realizado nada ainda na pasta getMapping, tudo o que possui lá deve ser migrado para dentro da pasta `controller`

> Foi realizado a criação dos services para separação de responsabilidade

> Foi alterado os respositorys conforme a necessidade da lógica implementada

## Commit 18/05
Alterado o `RankEstacionamentoController` para dentro do `EstacionamentoController`
Alterado o `TarifaReservaController` para dentro do `TarifaController`
Alterado o `VeiculosEstacionadosController` para dentro do `VeiculosController`

Removido a pasta getMapping e trazendo os metodos para dentro da pasta controller