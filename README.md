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
<code>[Criar Dicionário de dados](https://1drv.ms/x/s!AqDCvxmFwj5whfxT9cyz3GpUQ2C55Q?e=Qt8Jjc)</code>

### Criação do Banco:
<code>[Criar Banco de Dados](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/tree/main/estacionamento/docker)</code>

### Scripts DDL Criação das Tabelas:
<code>[Criar Tabelas](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/tree/main/estacionamento/src/main/resources/changelogs/tables)</code>

### Scripts Popula tabelas:
<code>[Popular Tabelas](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/blob/main/estacionamento/src/main/resources/changelogs/inserts.sql)</code>

### Objetos de BD (stored procedure, triggers e functions):

### Código do sistema:
##### &nbsp;&nbsp;[Banco](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/tree/main/estacionamento)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[![Foo](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/assets/101675688/6e67233a-e444-4188-9380-0e431d531db4)](https://www.oracle.com/)&nbsp;&nbsp;&nbsp;
[![Foo](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/assets/101675688/794ca41d-7d7f-4d08-9587-82848345802f)](https://www.docker.com/)

##### &nbsp;&nbsp;[Back-End](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/tree/main/estacionamento)
[![Foo](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/assets/101675688/62ddedea-f767-4de7-a7c3-35ac990582e2)](https://www.java.com/) &nbsp;&nbsp;&nbsp;
[![Foo](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/assets/101675688/30bb9c91-9b6a-4670-97cb-972a54f0f6ef)](https://www.liquibase.org/) &nbsp;&nbsp;&nbsp;
[![Foo](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/assets/101675688/74aba762-0d0c-465f-8d92-82e586bf6dff)](https://spring.io/) &nbsp;&nbsp;&nbsp;

##### &nbsp;&nbsp;[Front-End](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/tree/main/front-end)
[![Foo](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/assets/101675688/20ce5d60-cb92-407c-8351-0ede89d2e62e)](https://html.com) &nbsp;&nbsp;&nbsp;
[![Foo](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/assets/101675688/81897741-a7ba-4c41-b644-3580d57c3ec7)](https://css.com) &nbsp;&nbsp;&nbsp;
[![Foo](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/assets/101675688/5db80867-dc36-4bb0-a7f4-e6d4517ec830)](https://www.javascript.com/) &nbsp;&nbsp;&nbsp;
[![Foo](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/assets/101675688/3c4bfd6e-ef5f-42d0-959d-108a2f88e19a)](https://reactjs.org)

[![Foo](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/assets/101675688/cbbbe222-a9bf-46c1-98cc-0eeed19034a4)](https://vitejs.dev/) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
[![Foo](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/assets/101675688/4e9a5f9c-6580-41f8-9631-6d74e34b46eb)](https://tailwindcss.com/)

---

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
