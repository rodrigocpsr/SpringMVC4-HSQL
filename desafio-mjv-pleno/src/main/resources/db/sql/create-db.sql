CREATE TABLE colaborador 
(
  idcolaborador INT PRIMARY KEY,
  nome VARCHAR(30),
  sobrenome VARCHAR(30),
  email  VARCHAR(50),
  projeto VARCHAR(30),
  gestor VARCHAR(30),
  departamento VARCHAR(30)
);

CREATE TABLE projeto 
(
  idprojeto INT PRIMARY KEY,
  nome VARCHAR(30)
);

CREATE TABLE gestor 
(
  idgestor INT PRIMARY KEY,
  nome VARCHAR(30)
);

CREATE TABLE departamento 
(
  iddepartamento INT PRIMARY KEY,
  nome VARCHAR(30)
);