--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table VEICULO
--------------------------------------------------------

  CREATE TABLE "VEICULO" 
   (	"ID_VEICULO" NUMBER(*,0), 
	"DS_PLACA" VARCHAR2(10), 
	"DS_MODELO" VARCHAR2(50), 
	"DS_COR" VARCHAR2(20), 
	"DT_CADASTRO" DATE, 
	"ID_CLIENTE" NUMBER(*,0)
   ) ;

   COMMENT ON COLUMN "VEICULO"."ID_VEICULO" IS 'PK Veiculo';
   COMMENT ON COLUMN "VEICULO"."ID_CLIENTE" IS 'FK Cliente';
   COMMENT ON TABLE "VEICULO"  IS 'Cadastro de Veiculo';
--------------------------------------------------------
--  DDL for Index VEICULO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "VEICULO_PK" ON "VEICULO" ("ID_VEICULO") 
  ;
--------------------------------------------------------
--  Constraints for Table VEICULO
--------------------------------------------------------

  ALTER TABLE "VEICULO" MODIFY ("ID_VEICULO" NOT NULL ENABLE);
  ALTER TABLE "VEICULO" ADD CONSTRAINT "VEICULO_PK" PRIMARY KEY ("ID_VEICULO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table VEICULO
--------------------------------------------------------

  ALTER TABLE "VEICULO" ADD CONSTRAINT "VEICULO_FK1" FOREIGN KEY ("ID_CLIENTE")
	  REFERENCES "CLIENTE" ("ID_CLIENTE") ENABLE;
