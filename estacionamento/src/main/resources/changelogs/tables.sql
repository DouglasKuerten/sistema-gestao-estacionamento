--------------------------------------------------------
--  Arquivo criado - sábado-junho-10-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BLOCO
--------------------------------------------------------

  CREATE TABLE "BLOCO" 
   (	"ID_BLOCO" NUMBER(*,0), 
	"ID_ESTACIONAMENTO" NUMBER(*,0), 
	"DS_NOME" VARCHAR2(50 BYTE), 
	"DS_SIGLA" VARCHAR2(10 BYTE), 
	"VAGAS_TOTAIS" NUMBER(*,0), 
	"DESCRICAO" VARCHAR2(500 BYTE)
   );

   COMMENT ON COLUMN "BLOCO"."ID_BLOCO" IS 'PK Bloco';
   COMMENT ON COLUMN "BLOCO"."ID_ESTACIONAMENTO" IS 'FK Estacionamento';
   COMMENT ON TABLE "BLOCO"  IS 'Cadastro de Bloco do Estacionamento';
--------------------------------------------------------
--  DDL for Table CLIENTE
--------------------------------------------------------

  CREATE TABLE "CLIENTE" 
   (	"ID_CLIENTE" NUMBER(*,0), 
	"DS_NOME" VARCHAR2(120 BYTE), 
	"DS_TELEFONE" VARCHAR2(15 BYTE), 
	"DS_EMAIL" VARCHAR2(50 BYTE), 
	"ID_ENDERECO" NUMBER(*,0), 
	"DT_CADASTRO" DATE
   );

   COMMENT ON COLUMN "CLIENTE"."ID_CLIENTE" IS 'PK Veiculo';
   COMMENT ON TABLE "CLIENTE"  IS 'Cadastro de Clientes';
--------------------------------------------------------
--  DDL for Table CLIENTE_VEICULO
--------------------------------------------------------

  CREATE TABLE "CLIENTE_VEICULO" 
   (	"ID_LIGACAO" NUMBER(*,0), 
	"ID_CLIENTE" NUMBER(*,0), 
	"ID_VEICULO" NUMBER(*,0)
   );

   COMMENT ON COLUMN "CLIENTE_VEICULO"."ID_LIGACAO" IS 'PK Ligação';
   COMMENT ON COLUMN "CLIENTE_VEICULO"."ID_CLIENTE" IS 'FK Cliente';
   COMMENT ON COLUMN "CLIENTE_VEICULO"."ID_VEICULO" IS 'FK Veiculo';
   COMMENT ON TABLE "CLIENTE_VEICULO"  IS 'Ligação entre cliente e veiculo';
--------------------------------------------------------
--  DDL for Table ESTACIONAMENTO
--------------------------------------------------------

  CREATE TABLE "ESTACIONAMENTO" 
   (	"ID_ESTACIONAMENTO" NUMBER(*,0), 
	"DS_NOME" VARCHAR2(50 BYTE), 
	"DS_SIGLA" VARCHAR2(10 BYTE), 
	"ID_ENDERECO" NUMBER(*,0), 
	"VAGAS_TOTAIS" NUMBER(*,0)
   ) ;

   COMMENT ON COLUMN "ESTACIONAMENTO"."ID_ESTACIONAMENTO" IS 'PK Estacionamento';
   COMMENT ON TABLE "ESTACIONAMENTO"  IS 'Cadastro de Estacionamento';
--------------------------------------------------------
--  DDL for Table PAGAMENTO
--------------------------------------------------------

  CREATE TABLE "PAGAMENTO" 
   (	"ID_PAGAMENTO" NUMBER(*,0), 
	"ID_RESERVA" NUMBER(*,0), 
	"ID_SOCIO" NUMBER(*,0), 
	"VALOR" NUMBER(9,2)
   );

   COMMENT ON COLUMN "PAGAMENTO"."ID_PAGAMENTO" IS 'PK Pagamento';
   COMMENT ON COLUMN "PAGAMENTO"."ID_RESERVA" IS 'FK Reserva';
   COMMENT ON COLUMN "PAGAMENTO"."ID_SOCIO" IS 'FK Socio';
   COMMENT ON TABLE "PAGAMENTO"  IS 'Pagamentos';
--------------------------------------------------------
--  DDL for Table RESERVA
--------------------------------------------------------

  CREATE TABLE "RESERVA" 
   (	"ID_RESERVA" NUMBER(*,0), 
	"ID_BLOCO" NUMBER(*,0), 
	"DT_INICIO" DATE, 
	"DT_FIM" DATE, 
	"STATUS" VARCHAR2(3 BYTE), 
	"ID_LIGACAO" NUMBER(*,0)
   );

   COMMENT ON COLUMN "RESERVA"."ID_RESERVA" IS 'PK Reserva';
   COMMENT ON COLUMN "RESERVA"."ID_BLOCO" IS 'FK Bloco';
   COMMENT ON COLUMN "RESERVA"."ID_LIGACAO" IS 'FK Ligação';
   COMMENT ON TABLE "PAGAMENTO"  IS 'Reservas de Estacionamento';
--------------------------------------------------------
--  DDL for Table SOCIO
--------------------------------------------------------

  CREATE TABLE "SOCIO" 
   (	"ID_SOCIO" NUMBER(*,0), 
	"ID_CLIENTE" NUMBER(*,0), 
	"ID_TIPOS" NUMBER(*,0), 
	"STATUS" VARCHAR2(1 BYTE) DEFAULT 'A', 
	"DT_INICIO" DATE, 
	"DT_FIM" DATE
   );

   COMMENT ON COLUMN "SOCIO"."ID_SOCIO" IS 'PK Socio';
   COMMENT ON COLUMN "SOCIO"."ID_CLIENTE" IS 'FK Cliente';
   COMMENT ON COLUMN "SOCIO"."ID_TIPOS" IS 'FK Tipos';
   COMMENT ON COLUMN "SOCIO"."STATUS" IS '[A - Ativo/I - Invativo]';
   COMMENT ON TABLE "SOCIO"  IS 'Cadastro de Socios';
--------------------------------------------------------
--  DDL for Table TARIFA
--------------------------------------------------------

  CREATE TABLE "TARIFA" 
   (	"ID_TARIFA" NUMBER(*,0), 
	"ID_BLOCO" NUMBER(*,0), 
	"DESCRICAO" VARCHAR2(100 BYTE), 
	"PRECO_HORA" NUMBER(10,2)
   );

   COMMENT ON COLUMN "TARIFA"."ID_TARIFA" IS 'PK Tarifa';
   COMMENT ON COLUMN "TARIFA"."ID_BLOCO" IS 'FK Bloco';
   COMMENT ON TABLE "TARIFA"  IS 'Cadastro de Tarifas';
--------------------------------------------------------
--  DDL for Table TIPO_SOCIO
--------------------------------------------------------

  CREATE TABLE "TIPO_SOCIO" 
   (	"ID_TIPOS" NUMBER(*,0), 
	"DS_NOME" VARCHAR2(50 BYTE), 
	"VALOR" NUMBER(9,2)
   );

   COMMENT ON COLUMN "TIPO_SOCIO"."ID_TIPOS" IS 'PK Tipo';
   COMMENT ON TABLE "TIPO_SOCIO"  IS 'Cadastros de Tipos de Socios';

--------------------------------------------------------
--  DDL for Table VEICULO
--------------------------------------------------------

  CREATE TABLE "VEICULO" 
   (	"ID_VEICULO" NUMBER(*,0), 
	"DS_PLACA" VARCHAR2(10 BYTE), 
	"DS_MODELO" VARCHAR2(50 BYTE), 
	"DS_COR" VARCHAR2(20 BYTE), 
	"DT_CADASTRO" DATE
   );

   COMMENT ON COLUMN "VEICULO"."ID_VEICULO" IS 'PK Veiculo';
   COMMENT ON TABLE "VEICULO"  IS 'Cadastro de Veiculo';
--------------------------------------------------------
--  DDL for Index BLOCO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BLOCO_PK" ON "BLOCO" ("ID_BLOCO") 
   
  ;
--------------------------------------------------------
--  DDL for Index CLIENTE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CLIENTE_PK" ON "CLIENTE" ("ID_CLIENTE") 
   
  ;
--------------------------------------------------------
--  DDL for Index CLIENTE_VEICULO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CLIENTE_VEICULO_PK" ON "CLIENTE_VEICULO" ("ID_LIGACAO") 
   
  ;
--------------------------------------------------------
--  DDL for Index ESTACIONAMENTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ESTACIONAMENTO_PK" ON "ESTACIONAMENTO" ("ID_ESTACIONAMENTO") 
   
  ;
--------------------------------------------------------
--  DDL for Index PAGAMENTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PAGAMENTO_PK" ON "PAGAMENTO" ("ID_PAGAMENTO") 
   
  ;
--------------------------------------------------------
--  DDL for Index RESERVA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RESERVA_PK" ON "RESERVA" ("ID_RESERVA") 
   
  ;
--------------------------------------------------------
--  DDL for Index SOCIO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SOCIO_PK" ON "SOCIO" ("ID_SOCIO") 
   
  ;
--------------------------------------------------------
--  DDL for Index TARIFA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TARIFA_PK" ON "TARIFA" ("ID_TARIFA") 
   
  ;
--------------------------------------------------------
--  DDL for Index TIPO_SOCIO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TIPO_SOCIO_PK" ON "TIPO_SOCIO" ("ID_TIPOS") 
   
  ;
--------------------------------------------------------
--  DDL for Index VEICULO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "VEICULO_PK" ON "VEICULO" ("ID_VEICULO") 
   
  ;
--------------------------------------------------------
--  Constraints for Table BLOCO
--------------------------------------------------------

  ALTER TABLE "BLOCO" MODIFY ("ID_BLOCO" NOT NULL ENABLE);
  ALTER TABLE "BLOCO" ADD CONSTRAINT "BLOCO_PK" PRIMARY KEY ("ID_BLOCO")
  USING INDEX  
   ENABLE;
--------------------------------------------------------
--  Constraints for Table CLIENTE
--------------------------------------------------------

  ALTER TABLE "CLIENTE" MODIFY ("ID_CLIENTE" NOT NULL ENABLE);
  ALTER TABLE "CLIENTE" ADD CONSTRAINT "CLIENTE_PK" PRIMARY KEY ("ID_CLIENTE")
  USING INDEX  
   ENABLE;
--------------------------------------------------------
--  Constraints for Table CLIENTE_VEICULO
--------------------------------------------------------

  ALTER TABLE "CLIENTE_VEICULO" MODIFY ("ID_LIGACAO" NOT NULL ENABLE);
  ALTER TABLE "CLIENTE_VEICULO" MODIFY ("ID_CLIENTE" NOT NULL ENABLE);
  ALTER TABLE "CLIENTE_VEICULO" MODIFY ("ID_VEICULO" NOT NULL ENABLE);
  ALTER TABLE "CLIENTE_VEICULO" ADD CONSTRAINT "CLIENTE_VEICULO_PK" PRIMARY KEY ("ID_LIGACAO")
  USING INDEX  
   ENABLE;
--------------------------------------------------------
--  Constraints for Table ESTACIONAMENTO
--------------------------------------------------------

  ALTER TABLE "ESTACIONAMENTO" MODIFY ("ID_ESTACIONAMENTO" NOT NULL ENABLE);
  ALTER TABLE "ESTACIONAMENTO" ADD CONSTRAINT "ESTACIONAMENTO_PK" PRIMARY KEY ("ID_ESTACIONAMENTO")
  USING INDEX  
   ENABLE;
--------------------------------------------------------
--  Constraints for Table PAGAMENTO
--------------------------------------------------------

  ALTER TABLE "PAGAMENTO" MODIFY ("ID_PAGAMENTO" NOT NULL ENABLE);
  ALTER TABLE "PAGAMENTO" ADD CONSTRAINT "PAGAMENTO_PK" PRIMARY KEY ("ID_PAGAMENTO")
  USING INDEX  
   ENABLE;
--------------------------------------------------------
--  Constraints for Table RESERVA
--------------------------------------------------------

  ALTER TABLE "RESERVA" MODIFY ("ID_RESERVA" NOT NULL ENABLE);
  ALTER TABLE "RESERVA" ADD CONSTRAINT "RESERVA_PK" PRIMARY KEY ("ID_RESERVA")
  USING INDEX  
   ENABLE;
--------------------------------------------------------
--  Constraints for Table SOCIO
--------------------------------------------------------

  ALTER TABLE "SOCIO" MODIFY ("ID_SOCIO" NOT NULL ENABLE);
  ALTER TABLE "SOCIO" ADD CONSTRAINT "SOCIO_PK" PRIMARY KEY ("ID_SOCIO")
  USING INDEX  
   ENABLE;
--------------------------------------------------------
--  Constraints for Table TARIFA
--------------------------------------------------------

  ALTER TABLE "TARIFA" MODIFY ("ID_TARIFA" NOT NULL ENABLE);
  ALTER TABLE "TARIFA" ADD CONSTRAINT "TARIFA_PK" PRIMARY KEY ("ID_TARIFA")
  USING INDEX  
   ENABLE;
--------------------------------------------------------
--  Constraints for Table TIPO_SOCIO
--------------------------------------------------------

  ALTER TABLE "TIPO_SOCIO" MODIFY ("ID_TIPOS" NOT NULL ENABLE);
  ALTER TABLE "TIPO_SOCIO" ADD CONSTRAINT "TIPO_SOCIO_PK" PRIMARY KEY ("ID_TIPOS")
  USING INDEX  
   ENABLE;
--------------------------------------------------------
--  Constraints for Table VEICULO
--------------------------------------------------------

  ALTER TABLE "VEICULO" MODIFY ("ID_VEICULO" NOT NULL ENABLE);
  ALTER TABLE "VEICULO" ADD CONSTRAINT "VEICULO_PK" PRIMARY KEY ("ID_VEICULO")
  USING INDEX  
   ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BLOCO
--------------------------------------------------------

  ALTER TABLE "BLOCO" ADD CONSTRAINT "BLOCO_FK1" FOREIGN KEY ("ID_ESTACIONAMENTO")
	  REFERENCES "ESTACIONAMENTO" ("ID_ESTACIONAMENTO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CLIENTE_VEICULO
--------------------------------------------------------

  ALTER TABLE "CLIENTE_VEICULO" ADD CONSTRAINT "CLIENTE_VEICULO_FK1" FOREIGN KEY ("ID_CLIENTE")
	  REFERENCES "CLIENTE" ("ID_CLIENTE") ENABLE;
  ALTER TABLE "CLIENTE_VEICULO" ADD CONSTRAINT "CLIENTE_VEICULO_FK2" FOREIGN KEY ("ID_VEICULO")
	  REFERENCES "VEICULO" ("ID_VEICULO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PAGAMENTO
--------------------------------------------------------

  ALTER TABLE "PAGAMENTO" ADD CONSTRAINT "PAGAMENTO_FK1" FOREIGN KEY ("ID_RESERVA")
	  REFERENCES "RESERVA" ("ID_RESERVA") ENABLE;
  ALTER TABLE "PAGAMENTO" ADD CONSTRAINT "PAGAMENTO_FK2" FOREIGN KEY ("ID_SOCIO")
	  REFERENCES "SOCIO" ("ID_SOCIO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RESERVA
--------------------------------------------------------

  ALTER TABLE "RESERVA" ADD CONSTRAINT "RESERVA_FK1" FOREIGN KEY ("ID_BLOCO")
	  REFERENCES "BLOCO" ("ID_BLOCO") ENABLE;
  ALTER TABLE "RESERVA" ADD CONSTRAINT "RESERVA_FK2" FOREIGN KEY ("ID_LIGACAO")
	  REFERENCES "CLIENTE_VEICULO" ("ID_LIGACAO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SOCIO
--------------------------------------------------------

  ALTER TABLE "SOCIO" ADD CONSTRAINT "SOCIO_FK1" FOREIGN KEY ("ID_CLIENTE")
	  REFERENCES "CLIENTE" ("ID_CLIENTE") ENABLE;
  ALTER TABLE "SOCIO" ADD CONSTRAINT "SOCIO_FK2" FOREIGN KEY ("ID_TIPOS")
	  REFERENCES "TIPO_SOCIO" ("ID_TIPOS") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TARIFA
--------------------------------------------------------

  ALTER TABLE "TARIFA" ADD CONSTRAINT "TARIFA_FK1" FOREIGN KEY ("ID_BLOCO")
	  REFERENCES "BLOCO" ("ID_BLOCO") ENABLE;
