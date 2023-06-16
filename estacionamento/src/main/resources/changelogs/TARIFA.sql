--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TARIFA
--------------------------------------------------------

  CREATE TABLE "TARIFA" 
   (	"ID_TARIFA" NUMBER(*,0), 
	"ID_BLOCO" NUMBER(*,0), 
	"DESCRICAO" VARCHAR2(100), 
	"PRECO_HORA" NUMBER(10,2)
   ) ;

   COMMENT ON COLUMN "TARIFA"."ID_TARIFA" IS 'PK Tarifa';
   COMMENT ON COLUMN "TARIFA"."ID_BLOCO" IS 'FK Bloco';
   COMMENT ON TABLE "TARIFA"  IS 'Cadastro de Tarifas';
--------------------------------------------------------
--  DDL for Index TARIFA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TARIFA_PK" ON "TARIFA" ("ID_TARIFA") 
  ;
--------------------------------------------------------
--  Constraints for Table TARIFA
--------------------------------------------------------

  ALTER TABLE "TARIFA" MODIFY ("ID_TARIFA" NOT NULL ENABLE);
  ALTER TABLE "TARIFA" ADD CONSTRAINT "TARIFA_PK" PRIMARY KEY ("ID_TARIFA")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TARIFA
--------------------------------------------------------

  ALTER TABLE "TARIFA" ADD CONSTRAINT "TARIFA_FK1" FOREIGN KEY ("ID_BLOCO")
	  REFERENCES "BLOCO" ("ID_BLOCO") ENABLE;
