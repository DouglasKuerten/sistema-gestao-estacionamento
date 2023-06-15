CREATE TABLE cliente (
  cliente_id NUMBER PRIMARY KEY,
  nome VARCHAR2(50),
  telefone VARCHAR2(15),
  email VARCHAR2(50),
  endereco VARCHAR2(100)
);

CREATE TABLE veiculo (
  veiculo_id NUMBER PRIMARY KEY,
  cliente_id NUMBER,
  placa VARCHAR2(10),
  modelo VARCHAR2(50),
  cor VARCHAR2(20),
  FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id)
);

CREATE TABLE estacionamento (
  estacionamento_id NUMBER PRIMARY KEY,
  nome VARCHAR2(10),
  endereco VARCHAR2(100),
  vagas_totais NUMBER,
  vagas_disponiveis NUMBER
);

CREATE TABLE reserva (
  reserva_id NUMBER PRIMARY KEY,
  cliente_id NUMBER,
  veiculo_id NUMBER,
  estacionamento_id NUMBER,
  data_hora_inicio TIMESTAMP,
  data_hora_fim TIMESTAMP,
  FOREIGN KEY (cliente_id) REFERENCES CLIENTE(cliente_id),
  FOREIGN KEY (veiculo_id) REFERENCES VEICULO(veiculo_id),
  FOREIGN KEY (estacionamento_id) REFERENCES estacionamento(estacionamento_id)
);

CREATE TABLE pagamento (
  pagamento_id NUMBER PRIMARY KEY,
  reserva_id NUMBER,
  valor NUMBER(10, 2),
  data_hora TIMESTAMP,
  FOREIGN KEY (reserva_id) REFERENCES reserva(reserva_id)
);

CREATE TABLE funcionarios (
  funcionario_id NUMBER PRIMARY KEY,
  nome VARCHAR2(50),
  telefone VARCHAR2(15),
  email VARCHAR2(50),
  cargo VARCHAR2(50)
);

CREATE TABLE entrada_saida (
  entrada_saida_id NUMBER PRIMARY KEY,
  estacionamento_id NUMBER,
  veiculo_id NUMBER,
  data_hora_entrada TIMESTAMP,
  data_hora_saida TIMESTAMP,
  FOREIGN KEY (estacionamento_id) REFERENCES estacionamento(estacionamento_id),
  FOREIGN KEY (veiculo_id) REFERENCES veiculo(veiculo_id)
);

CREATE TABLE tarifa (
  tarifa_id NUMBER PRIMARY KEY,
  estacionamento_id NUMBER,
  descricao VARCHAR2(100),
  preco_hora NUMBER(10, 2),
  FOREIGN KEY (estacionamento_id) REFERENCES estacionamento(estacionamento_id)
);