CREATE OR REPLACE FUNCTION delete_cliente(p_id_cliente IN NUMBER) RETURN VARCHAR2 IS
BEGIN
    DELETE FROM cliente WHERE id_cliente = p_id_cliente;
    
    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'No row was deleted.');
    ELSE
        RETURN 'Row deleted successfully.';
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20002, 'An error occurred: ' || SQLERRM);
END;