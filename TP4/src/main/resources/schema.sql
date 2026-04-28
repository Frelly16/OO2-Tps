CREATE DATABASE IF NOT EXISTS concursos_db;

USE ciccarelli_concursos_db;

CREATE TABLE concursos (
                           id INT PRIMARY KEY,
                           nombre VARCHAR(150) NOT NULL,
                           fecha_inicio DATE NOT NULL,
                           fecha_fin DATE NOT NULL
);

CREATE TABLE inscriptos (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            apellido VARCHAR(100) NOT NULL,
                            nombre VARCHAR(100) NOT NULL,
                            telefono VARCHAR(50) NOT NULL,
                            email VARCHAR(150) NOT NULL,
                            id_concurso INT NOT NULL,
                            FOREIGN KEY (id_concurso) REFERENCES concursos(id)
);