--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table RESERVA
--------------------------------------------------------

  CREATE TABLE "RESERVA" 
   (	"ID_RESERVA" NUMBER GENERATED ALWAYS AS IDENTITY, 
	"ID_BLOCO" NUMBER(*,0), 
	"DT_INICIO" DATE, 
	"DT_FIM" DATE, 
	"STATUS" VARCHAR2(3), 
	"ID_VEICULO" NUMBER(*,0)
   ) ;

   COMMENT ON COLUMN "RESERVA"."ID_RESERVA" IS 'PK Reserva';
   COMMENT ON COLUMN "RESERVA"."ID_BLOCO" IS 'FK Bloco';
   COMMENT ON COLUMN "RESERVA"."ID_VEICULO" IS 'FK Veiculo';
--------------------------------------------------------
--  Constraints for Table RESERVA
--------------------------------------------------------
  ALTER TABLE "RESERVA" ADD CONSTRAINT "RESERVA_PK" PRIMARY KEY ("ID_RESERVA")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RESERVA
--------------------------------------------------------

  ALTER TABLE "RESERVA" ADD CONSTRAINT "RESERVA_FK2" FOREIGN KEY ("ID_VEICULO")
	  REFERENCES "VEICULO" ("ID_VEICULO") ENABLE;
  ALTER TABLE "RESERVA" ADD CONSTRAINT "RESERVA_FK1" FOREIGN KEY ("ID_BLOCO")
	  REFERENCES "BLOCO" ("ID_BLOCO") ENABLE;