-- Como demonstrar plano de acesso de uma consulta
EXPLAIN PLAN FOR SELECT NVL(C.DS_NOME, 'NÃO CADASTRADO') AS NOME_CLIENTE, V.DS_PLACA, V.DS_MODELO, B.DS_NOME, E.DS_NOME
FROM CLIENTE C RIGHT JOIN VEICULO V
ON C.ID_CLIENTE = V.ID_VEICULO 
INNER JOIN RESERVA R 
ON R.ID_VEICULO = V.ID_VEICULO
INNER JOIN BLOCO B 
ON B.ID_BLOCO = R.ID_BLOCO
INNER JOIN ESTACIONAMENTO E
ON E.ID_ESTACIONAMENTO = B.ID_ESTACIONAMENTO
WHERE R.STATUS LIKE '%ATV%';

SELECT * FROM TABLE (DBMS_XPLAN.display);

-- Index para performar consulta
create index index_veiculo_id_cliente on veiculo (id_cliente)-- Criado devido ao fato de na tabela veiculo percorrer todo o campo id_cliente e ter que fazer a verificação se encontra um cliente correspondente
drop index index_veiculo_id_cliente