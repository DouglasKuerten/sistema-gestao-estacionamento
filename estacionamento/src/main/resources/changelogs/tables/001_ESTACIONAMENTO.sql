--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ESTACIONAMENTO
--------------------------------------------------------

  CREATE TABLE "ESTACIONAMENTO" 
   (	"ID_ESTACIONAMENTO" NUMBER GENERATED ALWAYS AS IDENTITY, 
	"DS_NOME" VARCHAR2(50), 
	"DS_SIGLA" VARCHAR2(10),
	"VAGAS_TOTAIS" NUMBER(*,0)
   ) ;

   COMMENT ON COLUMN "ESTACIONAMENTO"."ID_ESTACIONAMENTO" IS 'PK Estacionamento';
   COMMENT ON TABLE "ESTACIONAMENTO"  IS 'Cadastro de Estacionamento';
  ;
--------------------------------------------------------
--  Constraints for Table ESTACIONAMENTO
--------------------------------------------------------

  ALTER TABLE "ESTACIONAMENTO" ADD CONSTRAINT "ESTACIONAMENTO_PK" PRIMARY KEY ("ID_ESTACIONAMENTO")
  USING INDEX  ENABLE;