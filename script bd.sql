create database vota;
use vota;

create table votante (
cpf_votante varchar(50),
nome_votante varchar(50));

alter table votante add primary key (cpf_votante);
alter table votante modify column cpf_votante varchar(50) not null;
alter table votante modify column nome_votante varchar(50) not null;

create table criador (
cpf_criador varchar(50),
nome_criador varchar(50));

desc criador;
alter table criador modify column nome_criador varchar(50) not null;

ALTER TABLE criador
ADD PRIMARY KEY (cpf_criador);

create table votacao (
id_votacao int auto_increment not null primary key,
titulo varchar(50),
descricao varchar(50),
cpf_criador varchar(50),
foreign key (cpf_criador) references criador(cpf_criador));

desc votacao;
alter table votacao modify column titulo varchar(50) not null;

create table voto (
id_voto int auto_increment not null primary key,
id_votacao int not null,
cpf_votante varchar(50),
data_voto date,
foreign key (cpf_votante) references votante(cpf_votante),
foreign key (id_votacao) references votacao(id_votacao));

