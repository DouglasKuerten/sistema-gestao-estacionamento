--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SOCIO
--------------------------------------------------------

  CREATE TABLE "SOCIO" 
   (	"ID_SOCIO" NUMBER(*,0), 
	"ID_CLIENTE" NUMBER(*,0), 
	"ID_TIPOS" NUMBER(*,0), 
	"STATUS" VARCHAR2(1) DEFAULT 'A', 
	"DT_INICIO" DATE, 
	"DT_FIM" DATE
   ) ;

   COMMENT ON COLUMN "SOCIO"."ID_SOCIO" IS 'PK Socio';
   COMMENT ON COLUMN "SOCIO"."ID_CLIENTE" IS 'FK Cliente';
   COMMENT ON COLUMN "SOCIO"."ID_TIPOS" IS 'FK Tipos';
   COMMENT ON COLUMN "SOCIO"."STATUS" IS '[A - Ativo/I - Invativo]';
   COMMENT ON TABLE "SOCIO"  IS 'Cadastro de Socios';
--------------------------------------------------------
--  DDL for Index SOCIO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SOCIO_PK" ON "SOCIO" ("ID_SOCIO") 
  ;
--------------------------------------------------------
--  Constraints for Table SOCIO
--------------------------------------------------------

  ALTER TABLE "SOCIO" MODIFY ("ID_SOCIO" NOT NULL ENABLE);
  ALTER TABLE "SOCIO" ADD CONSTRAINT "SOCIO_PK" PRIMARY KEY ("ID_SOCIO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SOCIO
--------------------------------------------------------

  ALTER TABLE "SOCIO" ADD CONSTRAINT "SOCIO_FK1" FOREIGN KEY ("ID_CLIENTE")
	  REFERENCES "CLIENTE" ("ID_CLIENTE") ENABLE;
  ALTER TABLE "SOCIO" ADD CONSTRAINT "SOCIO_FK2" FOREIGN KEY ("ID_TIPOS")
	  REFERENCES "TIPO_SOCIO" ("ID_TIPOS") ENABLE;
