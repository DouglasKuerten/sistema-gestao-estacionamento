--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CLIENTE
--------------------------------------------------------

  CREATE TABLE "CLIENTE" 
   (	"ID_CLIENTE" NUMBER(*,0), 
	"DS_NOME" VARCHAR2(120), 
	"DS_TELEFONE" VARCHAR2(15), 
	"DS_EMAIL" VARCHAR2(50), 
	"ENDERECO" VARCHAR2(200), 
	"DT_CADASTRO" DATE
   ) ;

   COMMENT ON COLUMN "CLIENTE"."ID_CLIENTE" IS 'PK Veiculo';
   COMMENT ON TABLE "CLIENTE"  IS 'Cadastro de Clientes';
--------------------------------------------------------
--  DDL for Index CLIENTE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CLIENTE_PK" ON "CLIENTE" ("ID_CLIENTE") 
  ;
--------------------------------------------------------
--  Constraints for Table CLIENTE
--------------------------------------------------------

  ALTER TABLE "CLIENTE" MODIFY ("ID_CLIENTE" NOT NULL ENABLE);
  ALTER TABLE "CLIENTE" ADD CONSTRAINT "CLIENTE_PK" PRIMARY KEY ("ID_CLIENTE")
  USING INDEX  ENABLE;