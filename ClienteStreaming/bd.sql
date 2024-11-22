DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario (
    idUsuario INT NOT NULL AUTO_INCREMENT,
    usuario VARCHAR(100) NOT NULL,
    contrasenia VARCHAR(100) NOT NULL,
    PRIMARY KEY (idUsuario)
);

INSERT INTO usuario (idUsuario, usuario, contrasenia) VALUES
(1, 'Juan', 'Juan1'),
(2, 'Pedro', 'Pedro1'),
(3, 'Chano', 'Chano1');
