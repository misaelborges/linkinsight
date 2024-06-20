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

insert into cliente (id, nome, sobrenome, email, celular, cpf, endereco_cidade_nome, endereco_cep, endereco_logradouro, endereco_numero,
                     endereco_complemento, endereco_bairro, senha, genero, velocidade_internet)
values (1, 'João', 'Da Silva', 'joao.ger@algafood.com', '48 998881453', '08952137965', 'Florianópolis', '38400-999', 'Rua João Pinheiro', '1000',
        'Proximo a lagoa', 'Centro', 'mizinha1', 'MASCULINO', 'CEM');

insert into cliente (id, nome, sobrenome, email, celular, cpf, endereco_cidade_nome, endereco_cep, endereco_logradouro, endereco_numero,
                     endereco_complemento, endereco_bairro, senha, genero, velocidade_internet)
values (2, 'Maria', 'Joaquina', 'maria.vnd@algafood.com', '48 98215481', '08456315485', 'Criciúma', '88800-123', 'Rua Henriquel Lages', '154',
        'Proximo a Mercado do Zé', 'Zona Sul', 'danizinha1', 'FEMININO', 'DUZENTOS');

insert into cliente (id, nome, sobrenome, email, celular, cpf, endereco_cidade_nome, endereco_cep, endereco_logradouro, endereco_numero,
                     endereco_complemento, endereco_bairro, senha, genero, velocidade_internet)
values (3, 'José', 'Souza', 'jose.aux@algafood.com', '48 965151842124', '48965784612', 'Içara', '84628-321', 'Rua Bento Nordeste', '23154',
        'Janela Branca', 'Zona Norte', 'suzaninha1', 'FEMININO', 'TREZENTOS');

