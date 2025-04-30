# Food Flow Hex Service

## Visão Geral
O Food Flow Hex Service é uma aplicação baseada em Java projetada para gerenciar clientes e seus pedidos de forma dinâmica. A aplicação permite o cadastro de clientes, a criação de pedidos e a atualização do status dos pedidos à medida que eles progridem.

## Estrutura do Projeto

### Principais Componentes

- **Camada de Aplicação**
  - `FoodFlowHexServiceApplication.java`: O ponto de entrada principal da aplicação, onde a aplicação Spring Boot é inicializada.
  - **Casos de Uso**
    - `CreateClienteUseCase.java`: Interface que define os casos de uso para o gerenciamento de clientes, incluindo criação, recuperação, atualização e exclusão de clientes.

- **Camada de Domínio**
  - `Cliente.java`: Representa a entidade cliente com atributos como `id`, `nome` e `email`.

- **Camada de Infraestrutura**
  - **Banco de Dados**
    - `ClienteRepository.java`: Interface para operações CRUD na entidade [Cliente](cci:2://file:///home/gustavo-backes/food-flow-hex/food-flow-hex-service/src/main/java/com/github/gustavo/ordered/foodflowhexservice/domain/model/Cliente.java:9:0-28:1).
    - `ClienteRepositoryImpl.java`: Implementação da interface [ClienteRepository](cci:2://file:///home/gustavo-backes/food-flow-hex/food-flow-hex-service/src/main/java/com/github/gustavo/ordered/foodflowhexservice/infrastructure/database/ClienteRepositoryImpl.java:12:0-43:1), fornecendo métodos para salvar, encontrar, atualizar e excluir clientes no banco de dados.
  - **Controladores**
    - `ClienteController.java`: Controlador REST que manipula requisições HTTP relacionadas a clientes, incluindo endpoints para criar, recuperar, atualizar e excluir clientes.
  - **Tratamento de Exceções**
    - `GlobalExceptionHandler.java`: Manipulador de exceções centralizado para a aplicação, gerenciando exceções e retornando respostas HTTP apropriadas.

### Principais Funcionalidades
- **Gerenciamento de Clientes**: Criar, recuperar, atualizar e excluir clientes através de uma API RESTful.
- **Atualizações de Status Dinâmicas**: Atualizar os status dos pedidos de forma dinâmica à medida que progridem por várias etapas.

## Uso
Para executar a aplicação, use o seguinte comando:

```bash
mvn spring-boot:run

```

## docker-compose
Este projeto utiliza o Docker para rodar o pgAdmin e o PostgreSQL. Se você encontrar problemas de permissões, siga os passos abaixo para corrigir a configuração.

```shell
 sudo chown -R 5050:5050 food-flow-hex-service/docker-compose/data/pgadmin && 
 sudo chmod -R 770 food-flow-hex-service/docker-compose/data/pgadmin
 ```
