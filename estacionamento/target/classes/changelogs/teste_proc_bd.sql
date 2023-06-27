create or replace function f_calcula_valor_estacionado(p_bloco number, p_horas number) return number as
    v_preco_hora  number;
    v_preco_total  number;
    begin
        select preco_hora
            into v_preco_hora 
           from tarifa
         where id_bloco =  p_bloco;

      if v_preco_hora is null then
          v_preco_hora  := 10; -- valor preco hora padrao sem bloco
      end if;

    v_preco_total := v_preco_hora * p_horas;


    return v_preco_total;
end;

CREATE OR REPLACE PROCEDURE relatorio_front (vData_ini DATE, vData_fim DATE)
AS
  -- Declare variables to hold the result values
  vTempo_total NUMBER;
  vDS_NOME VARCHAR2(100);
  vDS_MODELO VARCHAR2(100);
  vDS_PLACA VARCHAR2(100);
  vVALOR NUMBER;
  vRANK NUMBER;
  
  -- Declare a cursor to retrieve the result set
  CURSOR c_reserva IS
    SELECT
      (TO_DATE(A.DT_FIM, 'dd/mm/yyyy hh24:mi') - TO_DATE(A.DT_INICIO, 'dd/mm/yyyy hh24:mi')) * 24  AS TEMPO_DECORRIDO_TOTAL,
      D.DS_NOME,
      DS_MODELO,
      B.DS_PLACA,
      f_calcula_valor_estacionado(a.id_bloco, (TO_DATE(A.DT_FIM, 'dd/mm/yyyy hh24:mi') - TO_DATE(A.DT_INICIO, 'dd/mm/yyyy hh24:mi')) * 24 ) AS VALOR,
      RANK() OVER (ORDER BY (A.DT_FIM - A.DT_INICIO) DESC) AS RANK
    FROM
      RESERVA A
      INNER JOIN VEICULO B ON B.ID_VEICULO = A.ID_VEICULO
      INNER JOIN PAGAMENTO C ON C.ID_RESERVA = A.ID_RESERVA
      LEFT JOIN CLIENTE D ON D.ID_CLIENTE = B.ID_CLIENTE
      JOIN TARIFA T ON A.ID_BLOCO = T.ID_BLOCO
    WHERE
      A.DT_INICIO BETWEEN TO_DATE(vData_ini, 'DD-MM-YYYY') AND TO_DATE(vData_fim, 'DD-MM-YYYY');
BEGIN
  -- Open the cursor
  OPEN c_reserva;

  -- Fetch the result into variables
  FETCH c_reserva INTO vTempo_total, vDS_NOME, vDS_MODELO, vDS_PLACA, vVALOR, vRANK;

  -- Perform further operations or return the values as needed
  
  -- Close the cursor
  CLOSE c_reserva;
END relatorio_front;
  
  BEGIN
  relatorio_front(TO_DATE('2023-06-01', 'YYYY-MM-DD'), TO_DATE('2023-06-30', 'YYYY-MM-DD'));
END;


-- 
-- 
-- SELECT * FROM CLIENTE
-- SELECT * FROM VEICULO
-- SELECT * FROM RESERVA
-- SELECT * FROM PAGAMENTO
-- 
-- 
-- SELECT A.ID_RESERVA, A.DT_INICIO, A.DT_FIM, D.DS_NOME, DS_MODELO, B.DS_PLACA, C.VALOR FROM RESERVA A
-- INNER JOIN VEICULO B ON B.ID_VEICULO = A.ID_VEICULO
-- INNER JOIN PAGAMENTO C ON C.ID_RESERVA = A.ID_RESERVA
-- LEFT JOIN CLIENTE D ON D.ID_CLIENTE = B.ID_CLIENTE
-- WHERE A.DT_INICIO BETWEEN '01/01/2023' AND '25/03/2023'
-- 
-- 
-- SELECT ID_RESERVA, DT_INICIO , DT_FIM FROM RESERVA
-- WHERE ID_RESERVA = 1
