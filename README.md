# SpringBoot
# 🌱 Meu Primeiro Spring Boot

API REST desenvolvida com Spring Boot para gerenciamento de produtos, com autenticação via JWT e persistência em banco de dados PostgreSQL.

---

## 🚀 Tecnologias

- Java 21
- Spring Boot 3.3.5
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT (jjwt 0.11.5)
- Maven

---

## ⚙️ Como executar

### Pré-requisitos

- Java 21+
- Maven
- PostgreSQL rodando localmente

### Configuração do banco

Crie um banco de dados PostgreSQL e configure as credenciais no `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### Executando o projeto

```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

---

## 🔐 Autenticação

A API utiliza autenticação via JWT. Para acessar os endpoints protegidos, é necessário:

### 1. Criar um usuário

```http
POST /auth/register
Content-Type: application/json

{
  "username": "usuario",
  "password": "senha"
}
```

### 2. Fazer login

```http
POST /auth/login
Content-Type: application/json

{
  "username": "usuario",
  "password": "senha"
}
```

Resposta:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### 3. Usar o token nas requisições

Adicione o token no header de todas as requisições protegidas:

```
Authorization: Bearer {token}
```

> ⚠️ O token é gerado com uma chave aleatória a cada inicialização do servidor. Ao reiniciar, será necessário fazer login novamente para obter um novo token.

---

## 📦 Endpoints — Produtos

Todos os endpoints de produtos requerem autenticação JWT.

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/produtos` | Lista todos os produtos |
| GET | `/api/produtos/{id}` | Busca produto por ID |
| POST | `/api/produtos` | Cria um novo produto |
| DELETE | `/api/produtos/{id}` | Remove um produto |

### Exemplos

**Listar produtos**
```http
GET /api/produtos
Authorization: Bearer {token}
```

**Buscar produto por ID**
```http
GET /api/produtos/1
Authorization: Bearer {token}
```

**Criar produto**
```http
POST /api/produtos
Authorization: Bearer {token}
Content-Type: application/json

{
  "nome": "Notebook",
  "preco": 3500.00
}
```

**Deletar produto**
```http
DELETE /api/produtos/1
Authorization: Bearer {token}
```

---

## ⚠️ Tratamento de Erros

Quando um recurso não é encontrado, a API retorna:

```json
{
  "timestamp": "2026-04-24T10:00:00",
  "status": 404,
  "error": "Recurso não encontrado",
  "message": "Produto com ID 99 não encontrado!"
}
```

---

## 🗂️ Estrutura do Projeto

```
src/main/java/com/example/Meu_Primeiro_Spring_Boot/
├── Controller/
│   └── ProdutoController.java
├── Service/
│   ├── ProdutoService.java
│   └── UsuarioDetailsService.java
├── Security/
│   ├── SecurityConfig.java
│   ├── JwtAuthFilter.java
│   └── JwtUtil.java
├── Exceptions/
│   ├── RecursoNaoEncontradoException.java
│   └── GlobalExceptionHandler.java
├── model/
│   ├── Produto.java
│   └── Usuario.java
└── repository/
    ├── ProdutoRepository.java
    └── UsuarioRepository.java
```
