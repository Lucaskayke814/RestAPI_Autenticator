---

# Projeto de Autenticação com Spring Boot 

## Descrição

Este projeto é um sistema de autenticação básico que utiliza Spring Boot para a construção da aplicação web, Spring Security para a segurança, e MongoDB como banco de dados. Ele permite o registro de usuários, autenticação via JWT, e a realização de operações CRUD (Create, Read, Update, Delete) em usuários.

## Funcionalidades

- **Registro de Usuários**: Permite o cadastro de novos usuários com nome de usuário, senha e e-mail. Cada usuário pode ser identificado como administrador, moderador ou usuário comum.
- **Autenticação Segura**: Usuários podem se autenticar utilizando suas credenciais (nome de usuário e senha). A autenticação é realizada através de JSON Web Tokens (JWT).
- **Operações CRUD**: Permite criar, ler, atualizar e deletar usuários.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para criação de aplicações Java.
- **Spring Security**: Framework para prover autenticação e autorização.
- **JWT (JSON Web Token)**: Para autenticação baseada em tokens.
- **MongoDB**: Banco de dados NoSQL utilizado para armazenar informações dos usuários.
- **Maven**: Gerenciamento de dependências e construção do projeto.

## Estrutura do Projeto

- `src/main/java/com/example/Autenticacao`: Contém a classe principal que inicia a aplicação Spring Boot.
- `src/main/java/com/example/config`: Contém configurações relacionadas à segurança.
- `src/main/java/com/example/controller`: Contém os controladores REST que expõem os endpoints da API.
- `src/main/java/com/example/entity`: Contém as classes de entidade que representam os dados no MongoDB.
- `src/main/java/com/example/enums`: Contém as enums utilizadas no projeto.
- `src/main/java/com/example/repository`: Contém os repositórios que realizam operações no banco de dados.
- `src/main/java/com/example/security`: Contém classes relacionadas à autenticação JWT.
- `src/main/java/com/example/service`: Contém as classes de serviço que implementam a lógica de negócios.

## Configuração do Ambiente

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6.3 ou superior
- MongoDB

### Configuração do MongoDB

1. Certifique-se de que o MongoDB está instalado e em execução.
2. A configuração padrão espera que o MongoDB esteja rodando em `localhost` na porta `27017`.

### Configuração da Aplicação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/autenticacao-springboot.git
   cd autenticacao-springboot
   ```

2. Configure o arquivo `application.properties` em `src/main/resources`:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/autenticacao
   spring.security.user.name=admin
   spring.security.user.password=admin
   ```

3. Compile e execute a aplicação:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Endpoints da API

### Registro de Usuário

- **URL**: `/usuario/salvar`
- **Método**: `POST`
- **Descrição**: Registra um novo usuário.
- **Corpo da Requisição**:
  ```json
  {
      "id": "1",
      "nomeUsuario": "testUser",
      "senha": "testPass",
      "email": "testEmail@example.com",
      "tipoConta": "ADMIN"
  }
  ```

### Login de Usuário

- **URL**: `/auth/login`
- **Método**: `POST`
- **Descrição**: Autentica um usuário e retorna um token JWT.
- **Corpo da Requisição**:
  ```json
  {
      "userName": "testUser",
      "password": "testPass"
  }
  ```

### Obter Todos os Usuários

- **URL**: `/usuario/obtemTodos`
- **Método**: `GET`
- **Descrição**: Retorna uma lista de todos os usuários.

### Obter Usuário por ID

- **URL**: `/usuario/obtemUsuarioPorId`
- **Método**: `GET`
- **Descrição**: Retorna um usuário baseado no seu ID.
- **Parâmetros**:
  - `idUsuario`: ID do usuário a ser buscado.

### Deletar Usuário

- **URL**: `/usuario/deletar`
- **Método**: `DELETE`
- **Descrição**: Deleta um usuário baseado no seu ID.
- **Parâmetros**:
  - `idUsuario`: ID do usuário a ser deletado.

## Testando a Aplicação com Insomnia

### 1. Registro de Usuário

- **URL**: `http://localhost:8080/usuario/salvar`
- **Método**: `POST`
- **Corpo da Requisição**:
  ```json
  {
      "id": "1",
      "nomeUsuario": "testUser",
      "senha": "testPass",
      "email": "testEmail@example.com",
      "tipoConta": "ADMIN"
  }
  ```

### 2. Login de Usuário

- **URL**: `http://localhost:8080/auth/login`
- **Método**: `POST`
- **Corpo da Requisição**:
  ```json
  {
      "userName": "testUser",
      "password": "testPass"
  }
  ```

### 3. Obter Todos os Usuários

- **URL**: `http://localhost:8080/usuario/obtemTodos`
- **Método**: `GET`

### 4. Obter Usuário por ID

- **URL**: `http://localhost:8080/usuario/obtemUsuarioPorId?idUsuario=1`
- **Método**: `GET`

### 5. Deletar Usuário

- **URL**: `http://localhost:8080/usuario/deletar?idUsuario=1`
- **Método**: `DELETE`

![Captura de tela 2024-06-20 193312](https://github.com/Lucaskayke814/RestAPI_Autenticator/assets/125411283/17ad7020-79a0-4b53-9393-4c79e4678a8e)

![image](https://github.com/Lucaskayke814/RestAPI_Autenticator/assets/125411283/f0d920ff-9798-48ad-a9c2-d7e8ab331bbd)

## Contato

Para mais informações, entre em contato através de [lucaskayke13@gmail.com]


Com este README, você deve ter uma documentação completa para ajudar os desenvolvedores a configurar, usar e contribuir para o projeto.
