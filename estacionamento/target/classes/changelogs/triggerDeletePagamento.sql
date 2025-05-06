create table pagamento_log_exclusao (
    id_pagamento integer, 
	id_reserva integer, 
	id_socio integer, 
	valor number(9,2),
    data_exclusao date,
    quem_excluiu varchar2(100)
);

create or replace trigger trg_log_exclusao_pagamento
after delete on pagamento
for each row
begin
  insert into pagamento_log_exclusao(id_pagamento, 
                                     id_reserva, 
                                     id_socio, 
                                     valor, 
                                     data_exclusao, 
                                     quem_excluiu)values(:old.id_pagamento, 
                                                         :old.id_reserva, 
                                                         :old.id_socio,
                                                         :old.valor, 
                                                         sysdate, 
                                                         user);
exception
  when others then  
    raise_application_error(-20001,'Um erro foi encontrado - '||SQLCODE||' -erro- '||SQLERRM);
end;