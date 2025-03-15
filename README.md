# API de Usuários com Testes Automatizados

Este projeto é uma API simples desenvolvida com **Spring Boot**, focada em praticar **testes automatizados** utilizando **JUnit 5** e **Mockito**. O objetivo principal foi alcançar **100% de cobertura de código**, garantindo a confiabilidade das operações.

## 📌 Tecnologias utilizadas

- **Spring Boot** - Framework para desenvolvimento da API.
- **JUnit 5** - Framework para testes unitários.
- **Mockito** - Biblioteca para criação de mocks nos testes.
- **ModelMapper** - Facilita a conversão entre objetos de domínio e DTOs.


## 🚀 Funcionalidades da API

A API permite operações básicas para gerenciamento de usuários:

- **Buscar usuário por ID** (`GET /users/{id}`)
- **Listar todos os usuários** (`GET /users`)
- **Criar um novo usuário** (`POST /users`)
- **Atualizar usuário** (`PUT /users/{id}`)
- **Excluir usuário** (`DELETE /users/{id}`)

## 🛠️ Testes Automatizados

Os testes foram escritos para garantir que todas as funcionalidades funcionem corretamente.

### Exemplo de Teste com Mockito

```java
@Test
void whenFindByIdThenReturnSucess() {
    when(serviceImpl.findById(anyInt())).thenReturn(user);
    when(mapper.map(any(),any())).thenReturn(userDTO);

    ResponseEntity<UserDTO> response = resource.findById(ID);

    assertNotNull(response);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(UserDTO.class, response.getBody().getClass());
}
```

## :email: Contato
Linkedin: https://www.linkedin.com/in/dione-evangelista/

GitHub: https://github.com/DioneDw


