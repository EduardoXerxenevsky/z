# Z

Este é um projeto simples que lista perfis de usuários, mostrando seus nomes, descrições, número de posts e status de online/offline.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Thymeleaf
- Materialize CSS

## Configuração

1. **Clonando o repositório:**

git clone https://github.com/seu-usuario/nome-do-repositorio.git

2. **Configurando o banco de dados:**
- O projeto está configurado para usar o banco de dados H2 em memória por padrão. Se desejar usar outro banco de dados, você precisará modificar a configuração no arquivo `application.properties`.

3. **Executando o projeto:**
- Navegue até o diretório do projeto e execute:
  ```
  ./mvnw spring-boot:run
  ```
- O aplicativo estará disponível em [http://localhost:8080](http://localhost:8080).

4. **Visualizando os perfis:**
- Acesse a página de perfis em [http://localhost:8080/profiles](http://localhost:8080/profiles) para visualizar a lista de perfis.

## Funcionalidades

- Listagem de perfis com seus nomes, descrições, número de posts e status de online/offline.
- Utiliza Thymeleaf para renderização de templates HTML.
- Utiliza Materialize CSS para estilos básicos.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir um pull request para correção de bugs, adição de novas funcionalidades ou melhorias no código.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
