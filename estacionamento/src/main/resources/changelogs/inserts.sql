-- INSERT CLIENTE
INSERT INTO CLIENTE (DS_NOME, DS_TELEFONE, DS_EMAIL, ENDERECO, DT_CADASTRO)VALUES ('João Silva', '(48) 9999-9999', 'joao.silva@example.com', 'Rua das Flores, 123 - Centro, Criciúma', TO_DATE('2023-01-07', 'YYYY-MM-DD'));
INSERT INTO CLIENTE (DS_NOME, DS_TELEFONE, DS_EMAIL, ENDERECO, DT_CADASTRO)VALUES ('Maria Santos', '(48) 8888-8888', 'maria.santos@example.com', 'Avenida Beira-Rio, 456 - Praia do Rincão, Içara', TO_DATE('2023-02-22', 'YYYY-MM-DD'));
INSERT INTO CLIENTE (DS_NOME, DS_TELEFONE, DS_EMAIL, ENDERECO, DT_CADASTRO)VALUES ('Pedro Souza', '(48) 7777-7777', 'pedro.souza@example.com', 'Travessa das Palmeiras, 789 - Vila Nova, Urussanga', TO_DATE('2023-03-15', 'YYYY-MM-DD'));
INSERT INTO CLIENTE (DS_NOME, DS_TELEFONE, DS_EMAIL, ENDERECO, DT_CADASTRO)VALUES ('Ana Oliveira', '(48) 6666-6666', 'ana.oliveira@example.com', 'Rua dos Pescadores, 234 - São Luiz, Criciúma', TO_DATE('2023-04-30', 'YYYY-MM-DD'));
INSERT INTO CLIENTE (DS_NOME, DS_TELEFONE, DS_EMAIL, ENDERECO, DT_CADASTRO)VALUES ('Carlos Rodrigues', '(48) 5555-5555', 'carlos.rodrigues@example.com', 'Avenida Atlântica, 567 - Cidade Mineira, Criciúma', TO_DATE('2023-05-11', 'YYYY-MM-DD'));
INSERT INTO CLIENTE (DS_NOME, DS_TELEFONE, DS_EMAIL, ENDERECO, DT_CADASTRO)VALUES ('Laura Costa', '(48) 4444-4444', 'laura.costa@example.com', 'Rua das Gaivotas, 890 - Jardim América, Içara', TO_DATE('2023-06-19', 'YYYY-MM-DD'));
INSERT INTO CLIENTE (DS_NOME, DS_TELEFONE, DS_EMAIL, ENDERECO, DT_CADASTRO)VALUES ('Roberto Almeida', '(48) 3333-3333', 'roberto.almeida@example.com', 'Avenida dos Coqueiros, 1234 - Morro da Fumaça, Criciúma', TO_DATE('2023-01-03', 'YYYY-MM-DD'));
INSERT INTO CLIENTE (DS_NOME, DS_TELEFONE, DS_EMAIL, ENDERECO, DT_CADASTRO) VALUES ('Fernanda Pereira', '(48) 2222-2222', 'fernanda.pereira@example.com', 'Rua das Dunas, 5678 - Rio Maina, Criciúma', TO_DATE('2023-02-14', 'YYYY-MM-DD'));
INSERT INTO CLIENTE (DS_NOME, DS_TELEFONE, DS_EMAIL, ENDERECO, DT_CADASTRO)VALUES ('Gustavo Lima', '(48) 1111-1111', 'gustavo.lima@example.com', 'Travessa das Conchas, 901 - Nova Itália, Urussanga', TO_DATE('2023-03-28', 'YYYY-MM-DD'));
INSERT INTO CLIENTE (DS_NOME, DS_TELEFONE, DS_EMAIL, ENDERECO, DT_CADASTRO)VALUES ('Aline Barbosa', '(48) 0000-0000', 'aline.barbosa@example.com', 'Avenida das Palmeiras, 2345 - Presidente Vargas, Criciúma', TO_DATE('2023-04-05', 'YYYY-MM-DD'));
INSERT INTO CLIENTE (DS_NOME, DS_TELEFONE, DS_EMAIL, ENDERECO, DT_CADASTRO) VALUES ('João Pedro Cesconetto', '(48) 123456789', 'joao.silva@example.com', 'Avenida Requinte, 564 - Cidade de Criciúma, Criciúma', TO_DATE('2023-01-15', 'YYYY-MM-DD'));
INSERT INTO CLIENTE (DS_NOME, DS_TELEFONE, DS_EMAIL, ENDERECO, DT_CADASTRO) VALUES ('Maria Oliveira', '(48) 987654321', 'maria.oliveira@example.com', 'Rua Santos Dumont, 741 - São Defende, Criciúma', TO_DATE('2023-02-28', 'YYYY-MM-DD'));

--INSERT ESTACIONAMENTO
INSERT INTO ESTACIONAMENTO (DS_NOME, DS_SIGLA, VAGAS_TOTAIS) VALUES ('Estacionamento A', 'EST_A', 150);
INSERT INTO ESTACIONAMENTO (DS_NOME, DS_SIGLA, VAGAS_TOTAIS) VALUES ('Estacionamento B', 'EST_B', 130);

--INSERT BLOCO
INSERT INTO BLOCO (ID_ESTACIONAMENTO, DS_NOME, DS_SIGLA, VAGAS_TOTAIS, DESCRICAO) VALUES (1, 'Bloco A', 'BLKA', 40, 'Descrição do Bloco A');
INSERT INTO BLOCO (ID_ESTACIONAMENTO, DS_NOME, DS_SIGLA, VAGAS_TOTAIS, DESCRICAO) VALUES (1, 'Bloco B', 'BLKB', 31, 'Descrição do Bloco B');
INSERT INTO BLOCO (ID_ESTACIONAMENTO, DS_NOME, DS_SIGLA, VAGAS_TOTAIS, DESCRICAO) VALUES (2, 'Bloco C', 'BLKC', 45, 'Descrição do Bloco C');
INSERT INTO BLOCO (ID_ESTACIONAMENTO, DS_NOME, DS_SIGLA, VAGAS_TOTAIS, DESCRICAO) VALUES (2, 'Bloco D', 'BLKD', 32, 'Descrição do Bloco D');
INSERT INTO BLOCO (ID_ESTACIONAMENTO, DS_NOME, DS_SIGLA, VAGAS_TOTAIS, DESCRICAO) VALUES (2, 'Bloco E', 'BLKE', 53, 'Descrição do Bloco E');
INSERT INTO BLOCO (ID_ESTACIONAMENTO, DS_NOME, DS_SIGLA, VAGAS_TOTAIS, DESCRICAO) VALUES (1, 'Bloco F', 'BLKF', 43, 'Descrição do Bloco F');
INSERT INTO BLOCO (ID_ESTACIONAMENTO, DS_NOME, DS_SIGLA, VAGAS_TOTAIS, DESCRICAO) VALUES (1, 'Bloco G', 'BLKG', 36, 'Descrição do Bloco G');

--INSERT VEICULO
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('ABC1234', 'Fiat Uno', 'Azul', TO_DATE('2023-01-15', 'YYYY-MM-DD'), 1);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('DEF5678', 'Volkswagen Gol', 'Prata', TO_DATE('2023-02-28', 'YYYY-MM-DD'), 2);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('GHI9012', 'Ford Fiesta', 'Vermelho', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 3);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('JKL3456', 'Chevrolet Onix', 'Branco', TO_DATE('2023-04-22', 'YYYY-MM-DD'), 4);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('MNO7890', 'Renault Sandero', 'Preto', TO_DATE('2023-05-05', 'YYYY-MM-DD'), 5);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('PQR2345', 'Fiat Palio', 'Cinza', TO_DATE('2023-06-18', 'YYYY-MM-DD'), 6);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('STU6789', 'Volkswagen Polo', 'Azul', TO_DATE('2023-01-02', 'YYYY-MM-DD'), 7);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('VWX0123', 'Ford Ka', 'Prata', TO_DATE('2023-02-14', 'YYYY-MM-DD'), 8);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('YZA4567', 'Chevrolet Prisma', 'Vermelho', TO_DATE('2023-03-28', 'YYYY-MM-DD'), 9);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('BCD8901', 'Renault Logan', 'Branco', TO_DATE('2023-04-10', 'YYYY-MM-DD'), 10);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('EFG2345', 'Fiat Siena', 'Preto', TO_DATE('2023-05-23', 'YYYY-MM-DD'), 11);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('HIJ6789', 'Volkswagen Virtus', 'Cinza', TO_DATE('2023-06-06', 'YYYY-MM-DD'), 12);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('KLM0123', 'Ford Focus', 'Azul', TO_DATE('2023-01-19', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('NOP4567', 'Chevrolet Cruze', 'Prata', TO_DATE('2023-02-01', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('QRS8901', 'Renault Duster', 'Vermelho', TO_DATE('2023-03-15', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('TUV2345', 'Fiat Toro', 'Branco', TO_DATE('2023-04-28', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('WXY6789', 'Volkswagen T-Cross', 'Preto', TO_DATE('2023-05-11', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('ZAB0123', 'Ford Ranger', 'Cinza', TO_DATE('2023-06-24', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('CDE4567', 'Chevrolet S10', 'Azul', TO_DATE('2023-01-07', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('FGH8901', 'Renault Captur', 'Prata', TO_DATE('2023-02-20', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('ABC2345', 'Fiat Mobi', 'Vermelho', TO_DATE('2023-03-05', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('DEF6789', 'Volkswagen Up!', 'Branco', TO_DATE('2023-04-18', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('GHI0123', 'Ford Fusion', 'Preto', TO_DATE('2023-05-01', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('JKL4567', 'Chevrolet Spin', 'Cinza', TO_DATE('2023-06-14', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('MNO8901', 'Renault Kwid', 'Azul', TO_DATE('2023-01-27', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('PQR2345', 'Fiat Argo', 'Prata', TO_DATE('2023-02-09', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('STU6789', 'Volkswagen Voyage', 'Vermelho', TO_DATE('2023-03-24', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('VWX0123', 'Ford Ecosport', 'Branco', TO_DATE('2023-04-06', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('YZA4567', 'Chevrolet Tracker', 'Preto', TO_DATE('2023-05-19', 'YYYY-MM-DD'), NULL);
INSERT INTO VEICULO (DS_PLACA, DS_MODELO, DS_COR, DT_CADASTRO, ID_CLIENTE) VALUES ('BCD8901', 'Renault Fluence', 'Cinza', TO_DATE('2023-06-02', 'YYYY-MM-DD'), NULL);

--INSERT TIPO SOCIO
INSERT INTO TIPO_SOCIO (DS_NOME, VALOR) VALUES ('Básico', 100.00);
INSERT INTO TIPO_SOCIO (DS_NOME, VALOR) VALUES ('Premium', 200.00);
INSERT INTO TIPO_SOCIO (DS_NOME, VALOR) VALUES ('VIP', 300.00);

--INSERT TARIFA
INSERT INTO TARIFA (ID_BLOCO, DESCRICAO, PRECO_HORA) VALUES (1, 'Tarifa A', 12.00);
INSERT INTO TARIFA (ID_BLOCO, DESCRICAO, PRECO_HORA) VALUES (3, 'Tarifa B', 8.50);
INSERT INTO TARIFA (ID_BLOCO, DESCRICAO, PRECO_HORA) VALUES (2, 'Tarifa C', 10.50);
INSERT INTO TARIFA (ID_BLOCO, DESCRICAO, PRECO_HORA) VALUES (5, 'Tarifa D', 15.00);
INSERT INTO TARIFA (ID_BLOCO, DESCRICAO, PRECO_HORA) VALUES (6, 'Tarifa E', 14.50);
INSERT INTO TARIFA (ID_BLOCO, DESCRICAO, PRECO_HORA) VALUES (7, 'Tarifa F', 12.00);
INSERT INTO TARIFA (ID_BLOCO, DESCRICAO, PRECO_HORA) VALUES (4, 'Tarifa G', 10.00);

--INSERT RESERVA
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (1, TO_DATE('2023-01-15 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-01-15 17:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 1);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (2, TO_DATE('2023-02-28 12:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-02-28 13:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 2);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (3, TO_DATE('2023-03-10 16:45:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-03-10 18:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 3);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (4, TO_DATE('2023-04-22 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-04-27 18:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 4);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (5, TO_DATE('2023-05-05 13:15:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-06-05 13:15:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 5);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (6, TO_DATE('2023-06-18 17:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-06-18 18:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 6);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (7, TO_DATE('2023-01-02 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-01-25 17:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 7);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (1, TO_DATE('2023-02-14 14:15:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-02-14 17:02:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 8);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (2, TO_DATE('2023-03-28 18:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-03-29 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 9);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (3, TO_DATE('2023-04-10 11:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-04-10 15:20:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 10);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (4, TO_DATE('2023-05-23 15:45:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-05-23 16:15:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 11);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (5, TO_DATE('2023-06-06 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-06-20 17:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 12);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (6, TO_DATE('2023-01-19 13:15:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-01-19 14:07:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 13);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (7, TO_DATE('2023-02-01 17:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-02-03 17:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 14);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (1, TO_DATE('2023-03-15 10:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-03-15 10:59:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 15);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (2, TO_DATE('2023-04-28 14:45:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-04-28 12:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 16);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (3, TO_DATE('2023-05-11 19:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-05-11 22:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 17);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (4, TO_DATE('2023-06-24 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-06-24 18:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 18);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (5, TO_DATE('2023-01-07 16:15:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-01-08 16:15:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 19);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (6, TO_DATE('2023-02-20 20:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-02-20 23:59:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 20);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (7, TO_DATE('2023-03-05 13:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-04-05 13:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 21);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (1, TO_DATE('2023-04-18 17:45:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-04-18 18:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 22);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (2, TO_DATE('2023-05-01 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-05-01 15:15:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 23);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (3, TO_DATE('2023-06-14 15:15:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-07-14 15:15:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 24);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (4, TO_DATE('2023-01-27 19:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-01-28 19:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 25);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (5, TO_DATE('2023-02-09 12:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-02-15 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'NTA', 26);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (6, TO_DATE('2023-06-28 07:45:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 27);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (7, TO_DATE('2023-06-28 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 28);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (1, TO_DATE('2023-06-28 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 29);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (2, TO_DATE('2023-06-28 14:15:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 30);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (3, TO_DATE('2023-06-28 15:15:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 21);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (4, TO_DATE('2023-06-28 16:30:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 17);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (5, TO_DATE('2023-06-28 17:45:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 9);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (6, TO_DATE('2023-06-28 18:45:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 1);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (7, TO_DATE('2023-06-29 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 22);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (1, TO_DATE('2023-06-29 10:15:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 2);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (2, TO_DATE('2023-06-29 12:15:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 11);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (3, TO_DATE('2023-06-29 16:30:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 7);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (4, TO_DATE('2023-06-29 16:45:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 8);
INSERT INTO RESERVA (ID_BLOCO, DT_INICIO, DT_FIM, STATUS, ID_VEICULO) VALUES (5, TO_DATE('2023-06-29 18:45:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 'ATV', 16);

--INSERT SOCIO
INSERT INTO SOCIO (ID_CLIENTE, ID_TIPOS, STATUS, DT_INICIO, DT_FIM) VALUES (1, 1, 'I', TO_DATE('2023-01-07', 'YYYY-MM-DD'), TO_DATE('2023-04-07', 'YYYY-MM-DD'));
INSERT INTO SOCIO (ID_CLIENTE, ID_TIPOS, STATUS, DT_INICIO, DT_FIM) VALUES (2, 2, 'A', TO_DATE('2023-04-30', 'YYYY-MM-DD'), TO_DATE('2023-10-09', 'YYYY-MM-DD'));
INSERT INTO SOCIO (ID_CLIENTE, ID_TIPOS, STATUS, DT_INICIO, DT_FIM) VALUES (3, 3, 'A', TO_DATE('2023-05-11', 'YYYY-MM-DD'), TO_DATE('2024-05-11', 'YYYY-MM-DD'));
INSERT INTO SOCIO (ID_CLIENTE, ID_TIPOS, STATUS, DT_INICIO, DT_FIM) VALUES (4, 1, 'A', TO_DATE('2023-03-28', 'YYYY-MM-DD'), TO_DATE('2024-03-28', 'YYYY-MM-DD'));
INSERT INTO SOCIO (ID_CLIENTE, ID_TIPOS, STATUS, DT_INICIO, DT_FIM) VALUES (5, 2, 'A', TO_DATE('2023-03-15', 'YYYY-MM-DD'), TO_DATE('2023-09-15', 'YYYY-MM-DD'));
INSERT INTO SOCIO (ID_CLIENTE, ID_TIPOS, STATUS, DT_INICIO, DT_FIM) VALUES (6, 1, 'I', TO_DATE('2023-01-03', 'YYYY-MM-DD'), TO_DATE('2023-04-03', 'YYYY-MM-DD'));
INSERT INTO SOCIO (ID_CLIENTE, ID_TIPOS, STATUS, DT_INICIO, DT_FIM) VALUES (7, 3, 'A', TO_DATE('2023-05-05', 'YYYY-MM-DD'), TO_DATE('2024-05-05', 'YYYY-MM-DD'));
INSERT INTO SOCIO (ID_CLIENTE, ID_TIPOS, STATUS, DT_INICIO, DT_FIM) VALUES (8, 2, 'A', TO_DATE('2023-04-10', 'YYYY-MM-DD'), TO_DATE('2023-10-10', 'YYYY-MM-DD'));
INSERT INTO SOCIO (ID_CLIENTE, ID_TIPOS, STATUS, DT_INICIO, DT_FIM) VALUES (9, 3, 'A', TO_DATE('2023-06-18', 'YYYY-MM-DD'), TO_DATE('2024-06-18', 'YYYY-MM-DD'));
INSERT INTO SOCIO (ID_CLIENTE, ID_TIPOS, STATUS, DT_INICIO, DT_FIM) VALUES (10, 1, 'I', TO_DATE('2023-01-15', 'YYYY-MM-DD'), TO_DATE('2023-04-15', 'YYYY-MM-DD'));
INSERT INTO SOCIO (ID_CLIENTE, ID_TIPOS, STATUS, DT_INICIO, DT_FIM) VALUES (11, 2, 'A', TO_DATE('2023-01-02', 'YYYY-MM-DD'), TO_DATE('2023-07-02', 'YYYY-MM-DD'));
INSERT INTO SOCIO (ID_CLIENTE, ID_TIPOS, STATUS, DT_INICIO, DT_FIM) VALUES (12, 3, 'A', TO_DATE('2023-03-28', 'YYYY-MM-DD'), TO_DATE('2024-03-28', 'YYYY-MM-DD'));


--INSERT PAGAMENTO
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (1, 1, 50.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (2, NULL, 75.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (3, NULL, 100.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (4, NULL, 80.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (5, NULL, 60.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (6, 6, 90.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (7, NULL, 70.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (8, NULL, 55.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (9, 9, 65.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (10, 10, 85.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (11, NULL, 95.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (12, 12, 45.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (13, NULL, 105.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (14, NULL, 115.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (15, NULL, 125.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (16, 5, 135.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (17, NULL, 145.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (18, NULL, 155.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (19, NULL, 165.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (20, NULL, 175.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (21, NULL, 185.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (22, NULL, 195.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (23, NULL, 205.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (24, 2, 215.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (25, NULL, 225.00);
INSERT INTO PAGAMENTO (ID_RESERVA, ID_SOCIO, VALOR) VALUES (26, NULL, 235.00);

