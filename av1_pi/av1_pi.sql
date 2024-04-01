create database av1_pi;

use av1_pi;

create table usuario(
	id_use int primary key auto_increment,
    login varchar (50) not null,
	senha varchar (50) not null,
    nome varchar (50) not null,
    ativo varchar (3) not null,
	dataNascimento varchar (10) not null,
    dataCadastro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

show tables;
describe usuario;
select * from usuario where id_use = 2;
select * from usuario order by nome;
select * from usuario where id_use = 11;
select * from usuario order by nome;
delete from usuario where id_use=18;
select id_use, nome, senha, email from usuario where id_use = 1;
update usuario set dataNascimento='1995-11-28' where id_use = 1;
select * from usuario where login = 'lucas1049' and dataNascimento = ?


