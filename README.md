# Plataforma Profissional Anônima - API REST

### Visão Geral

Este é o serviço de back-end para a Plataforma Profissional Anônima. A API é responsável por fornecer dados estruturados para os clientes (aplicação mobile React Native e painel administrativo web Angular). A solução foi desenvolvida utilizando Java e o framework Spring Boot, seguindo uma arquitetura de microserviços.

O projeto atende a valores da Sociedade 5.0, promovendo inclusão digital e bem-estar profissional. Adota um mecanismo de verificação facial off-chain para garantir a unicidade de usuários sem comprometer o anonimato visível.

### Tecnologias Utilizadas
* **Linguagem:** Java 17
* **Framework:** Spring Boot 3.x
* **Build Tool:** Maven
* **Banco de Dados:** Oracle Database
* **ORM:** Spring Data JPA / Hibernate
* **Segurança:** Spring Security (com BCrypt para criptografia de senhas)
* **Utilidades:** Lombok (para reduzir o boilerplate code)
* **Documentação:** Springdoc OpenAPI (Swagger UI)
* **Validação:** Jakarta Bean Validation

### Como Executar o Projeto

#### Pré-requisitos
Certifique-se de que tem o **Java 17+** e o **Maven** instalados na sua máquina.

1.  **Clonar o repositório:**
    ```bash
    git clone [https://github.com/Lucas041123/API_PPA.git](https://github.com/Lucas041123/API_PPA.git)
    cd plataforma-profissional-api
    ```
2.  **Construir o projeto:**
    ```bash
    mvn clean install
    ```
3.  **Executar a aplicação:**
    Pode executar o ficheiro `ApiApplication.java` diretamente da sua IDE.

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
* `POST /posts` - Cria um novo post, associado a um fórum e a um autor.

**Console da Base de Dados H2**
Para inspecionar os dados diretamente no navegador, use:
* **URL:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
* **JDBC URL:** `jdbc:h2:mem:plataformadb`
* **User Name:** `sa`
* **Password:** `password`

### Estrutura do Projeto
O projeto está organizado nas seguintes camadas, seguindo as boas práticas do Spring:

* `controller`: Responsável por expor os endpoints da API.
* `service`: Contém a lógica de negócio principal.
* `repository`: Interface para acesso e persistência de dados.
* `model`: Entidades JPA que representam as tabelas da base de dados.
* `config`: Classes de configuração, como a de segurança.
* `handler`: Tratamento global de exceções.
* `dto`: Objetos para transferência de dados.
