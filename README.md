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
<code>[Objetos de BD](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/tree/main/estacionamento/src/main/resources/changelogs)</code>

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

## Como criar a aplicação:

  * Fazer um clone do projeto
  ### Banco - Oracle - Docker
  Requisitos: Ter o docker instalado;

  <code>[Abrir esse arquivo pelo navegador do windows/linux/mac(Verificar a pasta no arquivo run.bat, tem que ser o mesmo lugar que ele estiver instalado)](https://github.com/DouglasKuerten/sistema-gestao-estacionamento/blob/main/estacionamento/docker/run.bat)</code>

  Irá criar um container no docker para ser usado como banco na aplicação;

  ### Backend - Java - SpringBoot
  Requisitos: Ter o java 17 instalado na máquina;

  caso não tenha: <code>[Vídeo explicando a instalar](https://www.youtube.com/watch?v=QekeJBShCy4)</code>

  Para rodar o projeto pelo visual studio code, precisa baixar a extensão do springBoot dashboard;
  
  Com ela instalada, vai ser localizado o app java no projeto para ser inicializado, podendo já ser usada as apis do sistema;

  ### Frontend - React
  Requisitos: Ter o node instalado;

  Abrir a pasta /front-end/ pelo vscode para primeiro fazer as instalações das dependências para depois fazer o npm run dev;

---

### Perguntas

* Qual é o número total de vagas disponíveis em um determinado estacionamento?

Solução em SQL:
<code>
SELECT
    ESTACIONAMENTO.DS_SIGLA AS "ESTACIONAMENTO",
    CONCAT(
        CONCAT(BLOCO.ID_BLOCO,BLOCO.DS_SIGLA),
        CONCAT(' - ', BLOCO.DESCRICAO)
    ) AS "DESCRIÇÃO DO BLOCO",
    BLOCO.VAGAS_TOTAIS - (
    SELECT COUNT(1)
      FROM RESERVA
     WHERE BLOCO.ID_BLOCO = RESERVA.ID_BLOCO
       AND STATUS = 'ATV'
    ) AS "VAGAS DISPONIVEIS",
    BLOCO.VAGAS_TOTAIS AS "VAGAS TOTAIS"
  FROM BLOCO INNER JOIN ESTACIONAMENTO
    ON (BLOCO.ID_ESTACIONAMENTO = ESTACIONAMENTO.ID_ESTACIONAMENTO)
 ORDER BY
    ESTACIONAMENTO.ID_ESTACIONAMENTO,
    BLOCO.ID_BLOCO;
</code>

* Pergunta: Quais são o top 5 pagamentos de clientes cadastrados?
  
Solução em SQL:
<code>
SELECT 
    D.DS_NOME, 
    A.VALOR 
  FROM pagamento A
 INNER JOIN reserva B 
    ON B.ID_RESERVA = A.ID_RESERVA
 INNER JOIN veiculo C 
    ON C.ID_VEICULO = B.ID_VEICULO
 LEFT JOIN cliente D 
    ON D.ID_CLIENTE = C.ID_CLIENTE
 WHERE ROWNUM <= 5
 ORDER BY VALOR DESC
</code>

* Pergunta: Quais são os veículos registrados por um determinado cliente?

Solução em SQL:
<code>
SELECT 
    RETORNA_CLIENTE(ID_CLIENTE) AS "CÓDIGO E NOME DO CLIENTE",
    DS_MODELO AS "MODELO",
    DS_PLACA AS "PLACA"
  FROM VEICULO
 WHERE ID_CLIENTE IS NOT NULL
 ORDER BY ID_CLIENTE;
</code>

* Pergunta: Quais são os clientes que possuem reservas ativas no momento?

Solução em SQL:
<code>
SELECT
    RETORNA_CLIENTE(ID_CLIENTE) AS "SOCIO",
    TIPO_SOCIO.DS_NOME AS "TIPO DE SOCIO",
    SOCIO.DT_INICIO AS "INICIO DA ASSOCIAÇÃO",
    SOCIO.DT_FIM AS "FIM DA ASSOCIAÇÃO"
  FROM SOCIO
 INNER JOIN TIPO_SOCIO
    ON (SOCIO.ID_TIPOS = TIPO_SOCIO.ID_TIPOS)
 WHERE SOCIO.DT_FIM >= SYSDATE
 ORDER BY DT_INICIO;
</code>

* Pergunta: Em que estacionamento e bloco os carros dos cliente com reserva ativa estão estacionados?

Solução em SQL: 
<code>
SELECT 
    NVL(C.DS_NOME, 'NÃO CADASTRADO') AS NOME_CLIENTE, 
    V.DS_PLACA, 
    V.DS_MODELO, 
    B.DS_NOME, 
    E.DS_NOME
  FROM CLIENTE C 
 RIGHT JOIN VEICULO V
    ON C.ID_CLIENTE = V.ID_VEICULO 
 INNER JOIN RESERVA R 
    ON R.ID_VEICULO = V.ID_VEICULO
 INNER JOIN BLOCO B 
    ON B.ID_BLOCO = R.ID_BLOCO
 INNER JOIN ESTACIONAMENTO E
    ON E.ID_ESTACIONAMENTO = B.ID_ESTACIONAMENTO
 WHERE R.STATUS LIKE '%ATV%'
</code>

* Pergunta: Quais os blocos que mais receberam cliente?

Solução em SQL:
<code>
SELECT DISTINCT 
     B.ID_BLOCO, 
     B.DS_NOME, COUNT(R.ID_BLOCO) OVER(PARTITION BY R.ID_BLOCO) AS TOTAL_RECEBIDO
   FROM BLOCO B 
  INNER JOIN RESERVA R
      ON B.ID_BLOCO = R.ID_BLOCO
  ORDER BY B.ID_BLOCO, B.DS_NOME, TOTAL_RECEBIDO 
</code>
