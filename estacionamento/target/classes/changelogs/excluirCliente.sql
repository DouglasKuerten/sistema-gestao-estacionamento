CREATE OR REPLACE
PROCEDURE excluir_cliente (
  p_id_cliente IN NUMBER
) AS
  v_error_message VARCHAR2(4000);
BEGIN
  BEGIN
    DELETE FROM CLIENTE WHERE ID_CLIENTE = p_id_cliente;
  EXCEPTION
    WHEN OTHERS THEN
      IF SQLCODE = -2292 THEN
        v_error_message := 'Registro filho localizado.';
      ELSE
        v_error_message := SQLERRM;
      END IF;
  END;

  IF v_error_message IS NOT NULL THEN
    DBMS_OUTPUT.PUT_LINE('Erro ao excluir o cliente: ' || v_error_message);
  ELSE
    DBMS_OUTPUT.PUT_LINE('Cliente excluído com sucesso.');
  END IF;
END;
