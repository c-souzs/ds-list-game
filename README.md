<div align="center">
  <h1>💻 Ds List Game 💳</h1>
  <p align="center"> API para genrenciar e ordernar jogos por coleções.</p>
 
  [Sobre](#sobre) • 
  [Aprendizados](#aprendizados) • 
  [Tecnologias](#tecnologias) • 
  [Como rodar](#run) • 
  [Autor](#autor)  
</div>

📎 Sobre.
=========

Projeto desenvolvido durante o intensivão JAVA Spring administrado pelo [Dev Superior](https://devsuperior.com.br/).

O Projeto consiste em uma API para gerenciar Jogos atráves de Listas, permitindo que o usuário ordene, por posição, os Jogos de cada Lista. A cada ordenação a posição do novo jogo é salva no banco.

Como diferencial, optei por implementar os end points para:

*   Cadastrar e/ou inserir um jogo em uma lista.
*   Remover um jogo de uma lista.
*   Deletar um jogo do sistema.

Nestes últimos casos, foi necessário implementar regras para atualizar as posições dos jogos em cada lista no banco de dados.

A relação de jogo, lista e posição é baseado conforme o diagrama UML abaixo:

![Diagrama UML Ds list games](https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/dslist-model.png)

### 🌐 API Endpoints.

Host: **http://localhost:8080**

##### Game

\`\`\`markdown - Cadastra jogo: - POST /games - Lista todas as informações de todos os jogos: - GET /games - Lista todas as informações de jogo, por ID: - GET /games/{id} - Atualiza as informações de um jogo, por ID: - PUT /games/{id} - Remove um jogo, por ID: - DELETE /games/{id} \`\`\`

##### Game List

\`\`\`markdown - Adiciona um jogo a uma lista: - POST /lists/{id} - Atualiza a posição de um jogo ordenado na lista: - POST /lists/{id} - Lista todos os jogos da lista, ordenado por posição: - GET /lists/{id}/games - Lista todas as listas de jogos: - GET /lists - Remove um jogo de uma lista, por ID: - DELETE /lists/{id}/{idGame} \`\`\`

📚 Aprendizados.
================

*   Padrões de camadas e sua relação com injeção de dependência.
*   Representação de relacionamentos no ORM.
*   Classes de associação.
*   Configuração de ambiente para testes, desenvolvimento e produção.
*   Processo de deploy com CI/CD na Railway.

🛠 Tecnologias.
===============

[![JAVA](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/pt-BR/) [![Spring boot](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot) [![PostgreSQL](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)

🛠 Como rodar.
==============

Requisitos iniciais:

*   Versão do Java 21+
*   Instale o PostgreSQL
*   Instale o pgAdmin
*   Crie um banco de dados com o nome: ds-list-game

Executando o projeto:

*   Acesse uma pasta e clone o repositório: \`\`\` git clone https://github.com/c-souzs/ds-list-game.git \`\`\`
*   Abra o projeto em sua IDE e execute
*   A princípio vamos usar o banco de teste H2, as informações para acessar a tela do mesmo está no arquivo: \`\`\` ...\\ds-list-game\\src\\main\\resources\\application-test.properties \`\`\` No navegador, acesse: \`\`\` http://localhost:8080/h2-console/login.jsp \`\`\`
Pronto! Caso deseje alterar entre os ambientes de teste, desenvolvimento e produção altere o perfile ativo no arquivo \`\`\` ...\\ds-list-game\\src\\main\\resources\\application.properties spring.profiles.active=${APP\_PROFILE:test} spring.profiles.active=${APP\_PROFILE:dev} spring.profiles.active=${APP\_PROFILE:prod} \`\`\`

**Obs:** Ao alterar para o ambiente de desenvolvimento, descomente as 4 primeiras linha do arquivo: \`\`\` ...\\ds-list-game\\src\\main\\resources\\application-dev.properties \`\`\` Execute uma vez o projeto, comente novamente as linhas, execute novamente.

✏️ Autor.
=========

Desenvolvimento por [Caio Souza](https://github.com/souzzs).

 [![](https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/souzzs/)
 [![](https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white) ](mailto:souzsdev@gmail.com)
 [![](https://img.shields.io/badge/Discord-7289DA?style=for-the-badge&logo=discord&logoColor=white)](https://discord.gg/BsnqGK6e)
