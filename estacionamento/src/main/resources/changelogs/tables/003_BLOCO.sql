--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BLOCO
--------------------------------------------------------

  CREATE TABLE "BLOCO" 
   (	"ID_BLOCO" NUMBER GENERATED ALWAYS AS IDENTITY, 
	"ID_ESTACIONAMENTO" NUMBER(*,0), 
	"DS_NOME" VARCHAR2(50), 
	"DS_SIGLA" VARCHAR2(10), 
	"VAGAS_TOTAIS" NUMBER(*,0), 
	"DESCRICAO" VARCHAR2(500)
   ) ;

   COMMENT ON COLUMN "BLOCO"."ID_BLOCO" IS 'PK Bloco';
   COMMENT ON COLUMN "BLOCO"."ID_ESTACIONAMENTO" IS 'FK Estacionamento';
   COMMENT ON TABLE "BLOCO"  IS 'Cadastro de Bloco do Estacionamento';
--------------------------------------------------------
--  Constraints for Table BLOCO
--------------------------------------------------------
  ALTER TABLE "BLOCO" ADD CONSTRAINT "BLOCO_PK" PRIMARY KEY ("ID_BLOCO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BLOCO
--------------------------------------------------------

ALTER TABLE "BLOCO" ADD CONSTRAINT "BLOCO_FK1" 
    FOREIGN KEY ("ID_ESTACIONAMENTO")
    REFERENCES "ESTACIONAMENTO" ("ID_ESTACIONAMENTO")
    ENABLE;