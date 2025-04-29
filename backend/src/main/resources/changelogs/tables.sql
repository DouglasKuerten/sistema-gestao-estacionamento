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
--------------------------------------------------------
--  Constraints for Table ESTACIONAMENTO
--------------------------------------------------------

  ALTER TABLE "ESTACIONAMENTO" ADD CONSTRAINT "ESTACIONAMENTO_PK" PRIMARY KEY ("ID_ESTACIONAMENTO")
  USING INDEX  ENABLE;

--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CLIENTE
--------------------------------------------------------

  CREATE TABLE "CLIENTE" 
   (	"ID_CLIENTE" NUMBER GENERATED ALWAYS AS IDENTITY, 
	"DS_NOME" VARCHAR2(120), 
	"DS_TELEFONE" VARCHAR2(15), 
	"DS_EMAIL" VARCHAR2(50), 
	"ENDERECO" VARCHAR2(200), 
	"DT_CADASTRO" DATE
   ) ;

   COMMENT ON COLUMN "CLIENTE"."ID_CLIENTE" IS 'PK Veiculo';
   COMMENT ON TABLE "CLIENTE"  IS 'Cadastro de Clientes';
--------------------------------------------------------
--  Constraints for Table CLIENTE
--------------------------------------------------------
  ALTER TABLE "CLIENTE" ADD CONSTRAINT "CLIENTE_PK" PRIMARY KEY ("ID_CLIENTE")
  USING INDEX  ENABLE;

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

--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table VEICULO
--------------------------------------------------------

  CREATE TABLE "VEICULO" 
   (	"ID_VEICULO" NUMBER GENERATED ALWAYS AS IDENTITY, 
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
--  Constraints for Table VEICULO
--------------------------------------------------------
  ALTER TABLE "VEICULO" ADD CONSTRAINT "VEICULO_PK" PRIMARY KEY ("ID_VEICULO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table VEICULO
--------------------------------------------------------

  ALTER TABLE "VEICULO" ADD CONSTRAINT "VEICULO_FK1" FOREIGN KEY ("ID_CLIENTE")
	  REFERENCES "CLIENTE" ("ID_CLIENTE") ENABLE;

--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TIPO_SOCIO
--------------------------------------------------------

  CREATE TABLE "TIPO_SOCIO" 
   (	"ID_TIPOS" NUMBER GENERATED ALWAYS AS IDENTITY, 
	"DS_NOME" VARCHAR2(50), 
	"VALOR" NUMBER(9,2)
   ) ;

   COMMENT ON COLUMN "TIPO_SOCIO"."ID_TIPOS" IS 'PK Tipo';
   COMMENT ON TABLE "TIPO_SOCIO"  IS 'Cadastros de Tipos de Socios';
--------------------------------------------------------
--  Constraints for Table TIPO_SOCIO
--------------------------------------------------------
  ALTER TABLE "TIPO_SOCIO" ADD CONSTRAINT "TIPO_SOCIO_PK" PRIMARY KEY ("ID_TIPOS")
  USING INDEX  ENABLE;


--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TARIFA
--------------------------------------------------------

  CREATE TABLE "TARIFA" 
   (	"ID_TARIFA" NUMBER GENERATED ALWAYS AS IDENTITY, 
	"ID_BLOCO" NUMBER(*,0), 
	"DESCRICAO" VARCHAR2(100), 
	"PRECO_HORA" NUMBER(10,2)
   ) ;

   COMMENT ON COLUMN "TARIFA"."ID_TARIFA" IS 'PK Tarifa';
   COMMENT ON COLUMN "TARIFA"."ID_BLOCO" IS 'FK Bloco';
   COMMENT ON TABLE "TARIFA"  IS 'Cadastro de Tarifas';
--------------------------------------------------------
--  Constraints for Table TARIFA
--------------------------------------------------------
  ALTER TABLE "TARIFA" ADD CONSTRAINT "TARIFA_PK" PRIMARY KEY ("ID_TARIFA")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TARIFA
--------------------------------------------------------

  ALTER TABLE "TARIFA" ADD CONSTRAINT "TARIFA_FK1" FOREIGN KEY ("ID_BLOCO")
	  REFERENCES "BLOCO" ("ID_BLOCO") ENABLE;

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

--------------------------------------------------------
--  Arquivo criado - quinta-feira-junho-15-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SOCIO
--------------------------------------------------------

  CREATE TABLE "SOCIO" 
   (	"ID_SOCIO" NUMBER GENERATED ALWAYS AS IDENTITY, 
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
--  Constraints for Table SOCIO
--------------------------------------------------------
  ALTER TABLE "SOCIO" ADD CONSTRAINT "SOCIO_PK" PRIMARY KEY ("ID_SOCIO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SOCIO
--------------------------------------------------------

  ALTER TABLE "SOCIO" ADD CONSTRAINT "SOCIO_FK1" FOREIGN KEY ("ID_CLIENTE")
	  REFERENCES "CLIENTE" ("ID_CLIENTE") ENABLE;
  ALTER TABLE "SOCIO" ADD CONSTRAINT "SOCIO_FK2" FOREIGN KEY ("ID_TIPOS")
	  REFERENCES "TIPO_SOCIO" ("ID_TIPOS") ENABLE;

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


