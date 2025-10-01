# Plataforma Profissional Anônima - API REST com Oracle

### Visão Geral

Este é o serviço de back-end para a Plataforma Profissional Anônima. A API é responsável por fornecer dados estruturados para os clientes (aplicação mobile React Native e painel administrativo web Angular). A solução foi desenvolvida utilizando Java e o framework Spring Boot, seguindo uma arquitetura robusta e escalável, com a camada de persistência implementada em **Oracle Database**.

O projeto atende a valores da Sociedade 5.0, promovendo inclusão digital e bem-estar profissional. Adota um mecanismo de verificação facial off-chain para garantir a unicidade de usuários sem comprometer o anonimato visível.

### Tecnologias Utilizadas
* **Linguagem:** Java 17
* **Framework:** Spring Boot 3.x
* **Build Tool:** Maven
* **Banco de Dados:** **Oracle Database**
* **Linguagem de Banco de Dados:** **PL/SQL** para Procedures e Functions
* **ORM:** Spring Data JPA / Hibernate
* **Segurança:** Spring Security (com BCrypt para criptografia de senhas)
* **Utilidades:** Lombok
* **Documentação:** Springdoc OpenAPI (Swagger UI)
* **Validação:** Jakarta Bean Validation

### Como Executar o Projeto

#### Pré-requisitos
Certifique-se de que tem o **Java 17+**, o **Maven** e acesso a um **servidor Oracle Database** (como o Oracle XE) instalados e configurados.

#### 1. Configuração do Banco de Dados Oracle

Antes de executar a aplicação, é necessário criar a estrutura de tabelas e as rotinas em PL/SQL no seu banco de dados Oracle.

1.  Conecte-se ao seu schema no Oracle usando uma ferramenta como o **SQL Developer**.
2.  Execute o script completo `Script_SQL_PPA.sql` que se encontra na raiz do projeto. Este script é responsável por:
    * Criar todas as tabelas (`USUARIOS`, `VAGAS`, `FORUMS`, etc.).
    * Inserir dados simulados para teste.
    * Criar as `Functions` e `Procedures` em PL/SQL.

#### 2. Configuração da API

1.  **Clonar o repositório:**
    ```bash
    git clone [https://github.com/Lucas041123/API_PPA_SQL.git](https://github.com/Lucas041123/API_PPA_SQL.git)
    cd API_PPA_SQL
    ```
2.  **Configurar a Conexão:**
    Abra o ficheiro `src/main/resources/application.properties` e atualize as seguintes linhas com as credenciais do **seu** ambiente Oracle:
    ```properties
    spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
    spring.datasource.username=SEU_RM
    spring.datasource.password=SUA_SENHA
    ```
3.  **Construir o projeto:**
    ```bash
    mvn clean install
    ```
4.  **Executar a aplicação:**
    Pode executar o ficheiro `ApiApplication.java` diretamente da sua IDE ou via Maven.

### Endpoints da API

A documentação completa e interativa da API está disponível no Swagger UI, que pode ser acessado após a execução do projeto.

* **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* **OpenAPI JSON:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

A API fornece os seguintes endpoints:

* `GET /usuarios` - Lista todos os usuários.
* `POST /usuarios` - Cria um novo usuário.
* `GET /vagas` - Lista todas as vagas.
* `POST /vagas` - Cria uma nova vaga.
* `DELETE /vagas/{id}` - Exclui uma vaga.
* `GET /forums` - Lista todos os fóruns com os seus posts.
* `POST /forums` - Cria um novo fórum.
* `POST /posts` - Cria um novo post (chamando a procedure `registrar_novo_post` em PL/SQL).

### Estrutura do Projeto
O projeto está organizado nas seguintes camadas:

* `controller`: Responsável por expor os endpoints da API.
* `service`: Contém a lógica de negócio principal.
* `repository`: Interface para acesso aos dados, incluindo a chamada à procedure PL/SQL.
* `model`: Entidades JPA que representam as tabelas do banco de dados.
* `config`: Classes de configuração (Segurança, CORS).
* `handler`: Tratamento global de exceções.
* `dto`: Objetos para transferência de dados.
