# linkinsight

Projeto para o TCC do curso Tecnólogo em Analise e Desenvolviento de Sistemas - UNESC.
Projeot consiste em criar uma ferramenta para as empresas fornecedoras de Internet.

## Documentação da API

#### Retorna todos os itens

```http
  GET http://localhost:8080/clientes
```

#### Retorna um item

```http
  GET http://localhost:8080/clientes/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do item que você quer |

#### Salva um item

```http
  POST http://localhost:8080/clientes
```

##### Copo da requisição
```json
{
    "nome": "nome",
    "sobrenome": "sobrenome",
    "email": "email@email.com",
    "celular": "(xx) x xxxxxxxx",
    "cpf": "xxxxxxxxxxx",
    "endereco": {
        "cep": "cep",
        "logradouro": "logradouro",
        "numero": "numero da casa",
        "complemento": "complemento",
        "bairro": "bairro",
        "cidade": {
            "nome": "nome da cidade"
        }
    },
    "senha": "senha",
    "genero": "genero('MASCULINO', 'FEMININO', 'OUTROS', 'PREFIRONAODIZER')",
    "velocidadeInternet": "velocidade da internet ('CEM','DUZENTOS','TREZENTOS')",
    "ativo": booleano
}
```

#### Atualizar um item

```http
  PUT GET http://localhost:8080/clientes/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do item que você quer |

##### Copo da requisição
```json
{
    "nome": "nome",
    "sobrenome": "sobrenome",
    "email": "email@email.com",
    "celular": "(xx) x xxxxxxxx",
    "cpf": "xxxxxxxxxxx",
    "endereco": {
        "cep": "cep",
        "logradouro": "logradouro",
        "numero": "numero da casa",
        "complemento": "complemento",
        "bairro": "bairro",
        "cidade": {
            "nome": "nome da cidade"
        }
    },
    "senha": "senha",
    "genero": "genero('MASCULINO', 'FEMININO', 'OUTROS', 'PREFIRONAODIZER')",
    "velocidadeInternet": "velocidade da internet ('CEM','DUZENTOS','TREZENTOS')",
    "ativo": booleano
}
```

#### Deletar um item

```http
  DELETE http://localhost:8080/clientes/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do item que você quer |

## Tecnologias

* Java 17
* SpringBoot 3.3.0
* lombok
* flyway
* Model Mapper
* MySQL
