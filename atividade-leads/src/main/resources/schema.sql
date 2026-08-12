CREATE TABLE "lead" (
  "id" VARCHAR(36) PRIMARY KEY,
  "nome" VARCHAR(255),
  "email" VARCHAR(255),
  "telefone" VARCHAR(100),
  "cpf" VARCHAR(20),
  "consumo_medio" DOUBLE,
  "faixa" VARCHAR(20),
  "prioridade" INTEGER,
  "sugestao" VARCHAR(255)
);
