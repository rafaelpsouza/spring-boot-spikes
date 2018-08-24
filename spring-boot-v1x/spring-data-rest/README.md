# Exemplo de backend para app web usando Spring Data Rest

Como exemplo é utilizado um banco H2 em memória e é realizado a operação de CRUD para Movies. A ideia é esse backend servir de suporte a um frontend Single Page App.

### Estrutura

* /public -> Diretório que pode conter os arquivos da app de frontend. Esses arquivos serão providos pelo servidor como conteúdo estático.

* src/main/resources/import.sql -> Arquivo com imports iniciais para o banco de dados em memória.


### Links Importantes

* Spring Data Rest: http://docs.spring.io/spring-data/rest/docs/2.3.1.RELEASE/reference/html/
* Spring Data JPA: http://docs.spring.io/spring-data/jpa/docs/1.8.1.RELEASE/reference/html/
* HATEOAS: https://spring.io/understanding/HATEOAS
* Restangular (possível cliente HATEOAS): https://github.com/mgonto/restangular
* angular-hateoas (possível cliente HATEOAS): https://github.com/jmarquis/angular-hateoas 
