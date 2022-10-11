INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$Pjwaz69ahDucAHZ6B6ZZAOVx4K70DX6lO4Gdjre9IG2hXf/EQ0o0S');


INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');

INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Front-end');


INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor, curso) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 180000', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor, curso) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 190000', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor, curso) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 200000', 'NAO_RESPONDIDO', 1, 2);