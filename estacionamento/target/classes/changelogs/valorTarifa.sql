CREATE OR REPLACE FUNCTION fn_valor_tarifa (v_reserva int, v_bloco int) RETURN NUMBER IS v_resultado NUMBER(10,2);
BEGIN
    select ((to_date(r.dt_fim, 'dd/mm/yyyy hh24:mi') - to_date(r.dt_inicio, 'dd/mm/yyyy hh24:mi')) * 24 * 60) * t.preco_hora
    into v_resultado
    from reserva r inner join bloco b 
    on r.id_bloco = b.id_bloco 
    inner join tarifa t on b.id_bloco = t.id_bloco
    where r.id_reserva = v_reserva and t.id_bloco = v_bloco;
    
    return v_resultado;
END;