--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PAGAMENTO
--------------------------------------------------------

  CREATE TABLE "PAGAMENTO" 
   (	"ID_PAGAMENTO" NUMBER GENERATED ALWAYS AS IDENTITY, 
	"ID_RESERVA" NUMBER(*,0), 
	"ID_SOCIO" NUMBER(*,0), 
	"VALOR" NUMBER(9,2)
   ) ;

   COMMENT ON COLUMN "PAGAMENTO"."ID_PAGAMENTO" IS 'PK Pagamento';
   COMMENT ON COLUMN "PAGAMENTO"."ID_RESERVA" IS 'FK Reserva';
   COMMENT ON COLUMN "PAGAMENTO"."ID_SOCIO" IS 'FK Socio';
--------------------------------------------------------
--  Constraints for Table PAGAMENTO
--------------------------------------------------------
  ALTER TABLE "PAGAMENTO" ADD CONSTRAINT "PAGAMENTO_PK" PRIMARY KEY ("ID_PAGAMENTO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PAGAMENTO
--------------------------------------------------------

  ALTER TABLE "PAGAMENTO" ADD CONSTRAINT "PAGAMENTO_FK1" FOREIGN KEY ("ID_RESERVA")
	  REFERENCES "RESERVA" ("ID_RESERVA") ENABLE;
  ALTER TABLE "PAGAMENTO" ADD CONSTRAINT "PAGAMENTO_FK2" FOREIGN KEY ("ID_SOCIO")
	  REFERENCES "SOCIO" ("ID_SOCIO") ENABLE;