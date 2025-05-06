create or replace TYPE type_relatorio_front as object (
tempo_decorrido_total      number(5),
ds_nome                    varchar2(50),
ds_modelo                  varchar2(50),
ds_placa                   varchar2(7),
valor                      number(5),
rank                       number(3));

create or replace function f_relatorio_front (vdata_ini date, vdata_fim date) return ctype_relatorio_front as
begin

    select type_relatorio_front((to_date(a.dt_fim, 'dd/mm/yyyy hh24:mi') - to_date(a.dt_inicio, 'dd/mm/yyyy hh24:mi')) * 24 as tempo_decorrido_total,
                                d.ds_nome,
                                ds_modelo,
                                b.ds_placa,
                                f_calcula_valor_estacionado(a.id_bloco, (to_date(a.dt_fim, 'dd/mm/yyyy hh24:mi') - to_date(a.dt_inicio, 'dd/mm/yyyy hh24:mi')) * 24 ) as valor,
                                rank() over (order by (a.dt_fim - a.dt_inicio) desc) as rank)
              bulk collect into ct_relatorio_front             
                           from reserva a
                                inner join veiculo b on b.id_veiculo = a.id_veiculo
                                inner join pagamento c on c.id_reserva = a.id_reserva
                                left join cliente d on d.id_cliente = b.id_cliente
                                join tarifa t on a.id_bloco = t.id_bloco
                          where a.dt_inicio between to_date(vdata_ini, 'DD-MM-YYYY') and to_date(vdata_fim, 'DD-MM-YYYY')
    
    return ct_relatorio_front;

end;
