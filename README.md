
# O Desafio da Produtividade na Era Digital - MINDLY



## Distrações Constantes
O ambiente moderno é repleto de interrupções que fragmentam a atenção e dificultam o foco profundo.
O ambiente moderno é repleto de interrupções que fragmentam a atenção e dificultam o foco profundo.

## Estresse Crescente
A pressão por desempenho e a falta de limites claros entre vida pessoal e profissional geram altos níveis de estresse.

## Dificuldade de Foco
Trabalhadores remotos e estudantes enfrentam obstáculos significativos para manter a concentração em suas tarefas diárias.



## Documentação da API

#### Retorna todos os itens

```http
  POST /api/auth/register
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `api_key` | `string` | **Obrigatório**. A chave da sua API |

#### Retorna um usuario criado

```http
  POST /api/auth/login
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. e-mail e senha |

#### retorna o token do login do usuario


```http
  POST /api/tasks/create
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. titulo, descricao, status, tempoEstimadoMin |

#### retorna um objeto com a tarefa criada


```http
  POST /api/tasks/update/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. qualquer uma das informações |

#### retorna o mesmo objeto com o id com as informações alteradas



