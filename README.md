## Sobre

O objetivo deste projeto no VS Code é mostrar uma forma de realizar conexão com banco de dados MySQL e realizar inserções e recuperações de dados.

## Estrutura dos Diretórios

O workspace contém cinco diretórios, sendo:

- `lib`: contém a biblioteca do conector java mysq
- `src/db`: conta com duas classes, a primeira responsável por realizar a conexão com o banco de dados MySQL e a segunda por realizar teste com a conexão
- `src/entity`: contém as classes usuario e produto, responsáveis por criar os objetos usuario e produto e seus respectivos métodos getters e setters
- `src/DAO`: contém as classes usuarioDAO e produtoDAO responsáveis por realizar as interações de cadastro e consulta dos dados dos objetos no banco de dados
- `src/main`: contém uma classe com o método main, responsável por instanciar os respectivos objetos, e realizar interações com as demais classes a partir das opções existentes.

Enquanto isso, os arquivos de saída compilados serão gerados por padrão no diretório `bin`.