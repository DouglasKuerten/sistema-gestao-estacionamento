CREATE OR REPLACE PROCEDURE excluir_cliente (
  p_id_cliente IN NUMBER
) AS
  v_error_message VARCHAR2(200);

BEGIN
  
  -- Excluir registros relacionados na tabela PAGAMENTO
  DELETE FROM PAGAMENTO
  WHERE ID_RESERVA IN (SELECT ID_RESERVA FROM RESERVA
                        WHERE ID_VEICULO IN (SELECT ID_VEICULO
                                               FROM VEICULO
                                              WHERE ID_CLIENTE = p_id_cliente
                                            )
  );
  
  DELETE FROM PAGAMENTO
  WHERE ID_SOCIO IN (
    SELECT ID_SOCIO FROM SOCIO WHERE ID_CLIENTE = p_id_cliente
  );
  
  -- Excluir registros relacionados na tabela RESERVA
  DELETE FROM RESERVA
  WHERE ID_VEICULO IN (
    SELECT ID_VEICULO FROM VEICULO WHERE ID_CLIENTE = p_id_cliente
  );

  -- Excluir registros relacionados na tabela SOCIO
  DELETE FROM SOCIO WHERE ID_CLIENTE = p_id_cliente;

  -- Excluir registros relacionados na tabela VEICULO
  DELETE FROM VEICULO WHERE ID_CLIENTE = p_id_cliente;

  -- Excluir o cliente
  DELETE FROM CLIENTE WHERE ID_CLIENTE = p_id_cliente;

  -- Exibir mensagem de sucesso
  DBMS_OUTPUT.PUT_LINE('Cliente excluído com sucesso.');
  COMMIT;

EXCEPTION
  -- Exibir mensagem de erro
  WHEN OTHERS THEN
    v_error_message := SQLERRM;
    DBMS_OUTPUT.PUT_LINE('Erro ao excluir o cliente: ' || v_error_message);
    ROLLBACK;
END;
