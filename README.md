# URL Shortener

Este é um projeto de encurtador de URLs. Ele permite que você envie uma requisição com uma URL e receba, em resposta, o caminho encurtado correspondente. As URLs encurtadas têm um tempo de expiração de uma hora.

# Arquitetura

O projeto segue os princípios da Clean Architecture, garantindo a separação das camadas e a independência de frameworks. Isso assegura que o domínio e as regras de negócio permaneçam isolados da infraestrutura.

# Tecnologias do projeto

- **Docker**: Para containerização e fácil deploy da aplicação
- **Java 17**: Linguagem de programação utilizada no desenvolvimento
- **Spring**: Framework para criação da aplicação, utilizado principalmente para construção de APIs

# Executar o projeto

Para executar o projeto, voce precisa do docker instalado na sua maquina, se ja possuir ele basta rodar o comando abaixo.

```shell
docker-compose up -d
```

# Swagger

Esse projeto possui o Swagger para documentacao da API voce pode acessar executando o projeto acessando a URL abaixo:
```
http://localhost:8080/swagger-ui/index.html#/
```