# Projeto Sistema de Gestão de Estacionamento
## Projeto Final da Disciplina Banco Dados II - Grupo D

### Integrantes:
 - https://github.com/DouglasKuerten
 - https://github.com/BrunoDimon
 - https://github.com/thiagoDimon
 - https://github.com/GustavoTBett
 - https://github.com/vitorhenriquepereira
 - https://github.com/Freitas86
 - https://github.com/JorgeAntonioJr
 - https://github.com/Aleson00
 - https://github.com/Rocha101

### Modelo Físico:
<code>[Modelo Físico Banco](https://dbdiagram.io/d/647a7c0c722eb774944f750a)</code>

### Dicionário de Dados:
<code>[Criar Banco de Dados](https://1drv.ms/x/s!AqDCvxmFwj5whfxT9cyz3GpUQ2C55Q?e=Qt8Jjc)</code>

### Criação do Banco:
<code>[Criar Banco de Dados](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/blob/main/estacionamento/docker/run.bat)</code>

### Scripts DDL Criação das Tabelas:
<code>[Criar Tabelas](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/blob/main/estacionamento/src/main/resources/changelogs/tables.sql)</code>

### Scripts Popula tabelas:
<code>[Popular Tabelas](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/blob/main/estacionamento/src/main/resources/changelogs/inserts.sql)</code>

### Objetos de BD (stored procedure, triggers e functions):

### Código do sistema:

### Perguntas

* Qual é o número total de vagas disponíveis em um determinado estacionamento?

Solução em SQL:
<code>
SELECT vagas_disponiveis
FROM estacionamento
WHERE estacionamento_id = <id_do_estacionamento>;
</code>

* Pergunta: Quais são os funcionários que ocupam o cargo de "Gerente"?

Solução em SQL:
<code>
SELECT nome
FROM funcionarios
WHERE cargo = 'Gerente';
</code>

* Pergunta: Quais são os veículos registrados por um determinado cliente?

Solução em SQL:
<code>
SELECT v.modelo, v.placa
FROM veiculo v
INNER JOIN cliente c ON v.cliente_id = c.cliente_id
WHERE c.cliente_id = <id_do_cliente>
</code>

* Pergunta: Quais são os clientes que possuem reservas ativas no momento?

Solução em SQL:
<code>
SELECT c.nome
FROM cliente c
INNER JOIN reserva r ON c.cliente_id = r.cliente_id
WHERE r.data_hora_inicio <= CURRENT_TIMESTAMP
AND r.data_hora_fim >= CURRENT_TIMESTAMP;
</code>




