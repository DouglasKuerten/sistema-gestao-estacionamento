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
