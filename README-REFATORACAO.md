# Sistema de Gestão de Estacionamento - Entrega 1

## Integrantes do Grupo
- Gustavo Taufembach Bett
- Thiago Dimon

## Descrição do Software

O Sistema de Gestão de Estacionamento é uma aplicação web desenvolvida para gerenciar operações de estacionamentos comerciais. Esta solução permite o controle completo de reservas, veículos, clientes, pagamentos e outras funcionalidades essenciais para a administração eficiente de um ou mais estacionamentos.

O projeto foi desenvolvido utilizando as seguintes tecnologias:
- **Backend**: Java com Spring Boot, Liquibase(sql direto)
- **Frontend**: React com JavaScript
- **Banco de Dados**: Relacional com suporte a Oracle

## Principais Funcionalidades

1. **Gerenciamento de Estacionamentos**
    - Cadastro e manutenção de estacionamentos
    - Divisão por blocos e controle de capacidade

2. **Controle de Clientes**
    - Cadastro completo de clientes
    - Gerenciamento de sócios com diferentes tipos de planos

3. **Gestão de Veículos**
    - Registro de veículos associados aos clientes
    - Controle por placa, modelo e características

4. **Sistema de Reservas**
    - Agendamento de estacionamento por período
    - Controle de status das reservas

5. **Relatórios e Estatísticas**
    - Ranking de estacionamentos mais utilizados
    - Consulta de veículos por cliente

## Modelo de Domínio

O sistema é composto por diversas entidades interligadas:

- **Estacionamento**: Unidade principal com capacidade total de vagas
- **Bloco**: Subdivisão do estacionamento com características específicas
- **Cliente**: Pessoas ou empresas que utilizam o estacionamento
- **Veículo**: Carros registrados no sistema associados a clientes
- **Reserva**: Agendamento de vaga em determinado bloco e período
- **Socio**: Cliente com plano diferenciado de utilização
- **TipoSocio**: Categorias de planos para sócios
- **Pagamento**: Registro financeiro de reservas ou planos

## Código Original

O projeto original está disponível no repositório: [Sistema de Gestão de Estacionamento](https://github.com/DouglasKuerten/sistema-gestao-estacionamento) (branch: main)

Este sistema foi desenvolvido como parte de um projeto na disciplina de Banco de dados 2 e será o objeto de estudo e refatoração para aplicação dos conceitos de Clean Code.