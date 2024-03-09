# BookstoreApp 📚

Projeto desenvolvido usando JavaFX, Spring Boot e PostgreSQL.

## Sobre:

Projeto de aplicativo para gerenciar livros do usuário, permitindo a adição, alteração e exclusão de livros no aplicativo. O projeto consiste em uma interação com o banco de dados, o qual possui duas tabelas `autores` e `livros`,
as classes dentro dos pacotes `Repository` e `Service` cuidam dessa parte. No pacote `Model` temos as entidades `Livro` e `Autor`, além de dois Enum que cuidam de gêneros e filtros de buscas. No pacote `utils` temos algumas classes para configurar 
os ouvintes dos elementos da interface, configuração de tabela e filtros.

### Interface:

A interface do projeto é básica e permite a interação com o usuário para adicionar livros, editar, excluir, e  fazer buscas de livros adicionados. a transição fica por conta da classe `TransitionMenu` que 
cuida da troca de tela dependendo do botão que é acionado. o controlador da tela é a classe `Controller` que cuida dos elementos da interface.

![](https://github.com/Beforg/assets/blob/main/bookstore/home.png)

### Adicionando Livros ➕:

Na aba de adicionar livros, podemos adicionar um livro, adicionamos um livro e vinculamos a um Autor (que já deve estar previamente cadastrado) para fazer uma relação entre **Autor** e **Livro**. a comunicação com o banco de dados fica sob responsabilidade
dos métodos da classe `PersistEConsulta`.

![](https://github.com/Beforg/assets/blob/main/bookstore/add_livro.png)

### Buscando Livros 🔍:

Na área de busca de livros, podemos buscar os livros a partir de filtros, incluindo: **Gênero, Avaliação, Nome, Autor e Lido (Lidos ou não lidos)** o campo avaliação só fica disponível caso a caixa de seleção "Lido" esteja marcada, caso contrário
o livro entra no banco de dados com avaliação `N/A`.

![](https://github.com/Beforg/assets/blob/main/bookstore/busca.png)


![](https://github.com/Beforg/assets/blob/main/bookstore/generos.png) 

### Meus livros 📚:

Na aba temos as opções de `Ranking`, `Editar Livro` e `Sobre` (ainda não disponível), o Ranking mostra os 10 livros melhores classificados, a tabela é configurada pela classe `RankingTabela` e recebe os dados do banco de dados assim que a aplicação é iniciada,
também é atualizada caso haja alguma alteração nos livros. em `Editar Livro` podemos selecionar os livros que foram adicionados para Editar qualquer detalhe sobre ele e, também, excluir o livro.

![](https://github.com/Beforg/assets/blob/main/bookstore/imagem_2024-03-09_164221248.png)

![](https://github.com/Beforg/assets/blob/main/bookstore/edit_rem.png)

### Novo autor 🧑:

Crucial para adicionar um novo livro, pois é preciso vincular o livro ao Autor, essa parte cuida exclusivamente de adicionar um novo autor, que será atualizado automaticamente na aplicação.

![](https://github.com/Beforg/assets/blob/main/bookstore/n_autor.png)

## Considerações Finais:

Projeto com intuito de aplicar os conhecimentos na área de Java e Spring Boot.

### Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- JavaFX
- PostgreSQL
