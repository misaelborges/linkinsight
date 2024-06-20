create table cliente (
    id bigint not null auto_increment,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    email varchar(255) not null,
    celular varchar(255) not null,
    cpf varchar(255) not null,
    ativo bit,
    endereco_cidade_nome varchar(255) not null,
    endereco_logradouro varchar(255),
    endereco_bairro varchar(255),
    endereco_cep varchar(255),
    endereco_complemento varchar(255),
    endereco_numero varchar(255),
    senha varchar(255) not null,
    genero enum ('MASCULINO', 'FEMININO', 'OUTROS', 'PREFIRONAODIZER'),
    velocidade_internet enum ('CEM','DUZENTOS','TREZENTOS'),
    primary key (id)
) engine=InnoDB default charset=utf8;