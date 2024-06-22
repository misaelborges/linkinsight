set foreign_key_checks = 0;

delete from cidade;
delete from cliente;

set foreign_key_checks = 1;

alter table cidade auto_increment = 1;
alter table cliente auto_increment = 1;

insert into cidade (id, nome) values (1, 'Florianópolis');
insert into cidade (id, nome) values (2, 'Criciúma');
insert into cidade (id, nome) values (3, 'Içara');
insert into cidade (id, nome) values (4, 'Balneário Rincão');

insert into cliente (id, nome, sobrenome, email, celular, cpf, endereco_cidade_nome, endereco_logradouro, senha, genero)
values (1, 'João', 'Da Silva', 'joao.ger@algafood.com', '48 998881453', '08952137965', 'Florianópolis', 'Rua João Pinheiro',
        'mizinha1', 'MASCULINO');

insert into cliente (id, nome, sobrenome, email, celular, cpf, endereco_cidade_nome, endereco_logradouro, senha, genero)
values (2, 'Maria', 'Joaquina', 'maria.vnd@algafood.com', '48 98215481', '08456315485', 'Criciúma', 'Rua Henriquel Lages',
        'danizinha1', 'FEMININO');

insert into cliente (id, nome, sobrenome, email, celular, cpf, endereco_cidade_nome, endereco_logradouro, senha, genero)
values (3, 'José', 'Souza', 'jose.aux@algafood.com', '48 965151842124', '48965784612', 'Içara', 'Rua Bento Nordeste',
        'suzaninha1', 'FEMININO');

