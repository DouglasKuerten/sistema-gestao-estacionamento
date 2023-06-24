--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TIPO_SOCIO
--------------------------------------------------------

  CREATE TABLE "TIPO_SOCIO" 
   (	"ID_TIPOS" NUMBER(*,0), 
	"DS_NOME" VARCHAR2(50), 
	"VALOR" NUMBER(9,2)
   ) ;

   COMMENT ON COLUMN "TIPO_SOCIO"."ID_TIPOS" IS 'PK Tipo';
   COMMENT ON TABLE "TIPO_SOCIO"  IS 'Cadastros de Tipos de Socios';
--------------------------------------------------------
--  DDL for Index TIPO_SOCIO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TIPO_SOCIO_PK" ON "TIPO_SOCIO" ("ID_TIPOS") 
  ;
--------------------------------------------------------
--  Constraints for Table TIPO_SOCIO
--------------------------------------------------------

  ALTER TABLE "TIPO_SOCIO" MODIFY ("ID_TIPOS" NOT NULL ENABLE);
  ALTER TABLE "TIPO_SOCIO" ADD CONSTRAINT "TIPO_SOCIO_PK" PRIMARY KEY ("ID_TIPOS")
  USING INDEX  ENABLE;