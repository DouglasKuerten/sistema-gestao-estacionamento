CREATE OR REPLACE
PROCEDURE relatorio_front (vData_ini DATE, vData_fim DATE) AS
BEGIN
    FOR rec IN (
        SELECT 
             diminui_data(TO_CHAR(a.dt_fim,'dd/mm/yyyy hh24:mi'),TO_CHAR(a.dt_inicio,'dd/mm/yyyy hh24:mi')) as Horas,
             d.ds_nome,
             ds_modelo,
             b.ds_placa,
             f_calcula_valor_estacionado(a.id_bloco, (TO_DATE(a.dt_fim, 'dd/mm/yyyy hh24:mi:ss') - TO_DATE(a.dt_inicio, 'dd/mm/yyyy hh24:mi:ss')) * 24) AS valor,
             RANK() OVER (ORDER BY (a.dt_fim - a.dt_inicio) DESC) AS rank
        FROM reserva a
        INNER JOIN veiculo b ON b.id_veiculo = a.id_veiculo
        INNER JOIN pagamento c ON c.id_reserva = a.id_reserva
        LEFT JOIN cliente d ON d.id_cliente = b.id_cliente
        JOIN tarifa t ON a.id_bloco = t.id_bloco
        WHERE a.dt_inicio BETWEEN vdata_ini AND vdata_fim
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Placa: ' || rec.rank);
        DBMS_OUTPUT.PUT_LINE('Horas estacionadas: ' || rec.Horas);
        DBMS_OUTPUT.PUT_LINE('Nome Cliente: ' || rec.ds_nome);
        DBMS_OUTPUT.PUT_LINE('Modelo do carro: ' || rec.ds_modelo);
        DBMS_OUTPUT.PUT_LINE('Placa: ' || rec.ds_placa);
        DBMS_OUTPUT.PUT_LINE('Placa: ' || rec.valor);
        DBMS_OUTPUT.PUT_LINE('-------------------------');
    END LOOP;
END relatorio_front;
