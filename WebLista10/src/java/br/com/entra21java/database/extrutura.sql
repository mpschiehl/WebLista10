DROP DATABASE IF EXISTS lista10;
CREATE DATABASE IF NOT EXISTS lista10;

USE lista10;

CREATE TABLE alunos(
        id              INT AUTO_INCREMENT PRIMARY KEY,
        nome            VARCHAR(100),
        codigo_de_matricula VARCHAR(100),
        nota_1          FLOAT UNSIGNED,
        nota_2          FLOAT UNSIGNED,
        nota_3          FLOAT UNSIGNED,
        frequencia      TINYINT UNSIGNED);
