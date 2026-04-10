CREATE DATABASE ciccarelli_tp2;

USE ciccarelli_tp2;

CREATE TABLE inscripciones (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               fecha_hora TIMESTAMP NOT NULL,
                               id_participante VARCHAR(50) NOT NULL,
                               id_concurso VARCHAR(50) NOT NULL
);

CREATE TABLE consumos (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          fecha_hora TIMESTAMP NOT NULL,
                          monto_total DECIMAL(10,2) NOT NULL
);