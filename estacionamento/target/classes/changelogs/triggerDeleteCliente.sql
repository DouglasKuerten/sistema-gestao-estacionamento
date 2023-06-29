create table log_exclusao_cliente (
id_cliente int,
ds_nome varchar2(100),
ds_telefone varchar2(20),
ds_email varchar2(254),
ds_endereco varchar(200),
dt_cadastro date,
data_exclusao date,
quem_excluiu varchar2(100)
);

create or replace trigger trg_log_exclusao_cliente
after delete on cliente
for each row
begin
  insert into log_exclusao_cliente (id_cliente, 
                                    ds_nome, 
                                    ds_telefone, 
                                    ds_email, 
                                    ds_endereco, 
                                    dt_cadastro,
                                    data_exclusao,
                                    quem_excluiu)values(:old.id_cliente, 
                                                        :old.ds_nome,
                                                        :old.ds_telefone,
                                                        :old.ds_email,
                                                        :old.endereco,
                                                        :old.dt_cadastro,
                                                        sysdate,
                                                        user);
exception
  when others then  
    raise_application_error(-20001,'Um erro foi encontrado - '||SQLCODE||' -erro- '||SQLERRM);
end;
