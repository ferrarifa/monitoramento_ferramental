CREATE DATABASE monitoramento;
USE monitoramento;

CREATE TABLE ferramental (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    horasUso INT DEFAULT 0,
    vidaUtilMaxima INT NOT NULL
);

insert into ferramental(nome, horasUso, vidaUtilMaxima) values
("Trator", 0, 3000),
("Empilhadeira", 0, 5000);