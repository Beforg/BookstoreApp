package br.com.alura.app.bookstore.repository;

import br.com.alura.app.bookstore.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query ("SELECT l FROM Livro l WHERE l.titulo ilike %:trecho% ORDER BY l.titulo ASC")
    List<Livro> buscaPorTitulo(String trecho);
    @Query ("SELECT l FROM Livro l WHERE l.autor.nome ilike %:trecho% ORDER BY l.titulo ASC")
    List<Livro> buscaPorAutor(String trecho);
    @Query("SELECT l FROM Livro l WHERE l.lido = true")
    List<Livro> buscaLidosTrue();
    @Query("SELECT l FROM Livro l WHERE CAST(l.avaliacao AS double) <= :avaliacao")
    List<Livro> buscaPorAvaliacaoMenorQue(String avaliacao);
    @Query("SELECT l FROM Livro l WHERE CAST(l.avaliacao AS double) >= :avaliacao")
    List<Livro> buscaPorAvaliacaoMaiorQue(String avaliacao);
    @Query("SELECT l FROM Livro l WHERE l.lido = false")
    List<Livro> buscaLidosFalse();
    @Query("SELECT l FROM Livro l WHERE l.genero = :genero")
    List<Livro> buscaPorGenero(String genero);
    @Query("SELECT l FROM Livro l ORDER BY l.avaliacao DESC LIMIT 10")
    List<Livro> buscaPorRanking();
    Livro findByTitulo(String newValue);
    @Modifying
    @Transactional
    @Query("DELETE FROM Livro l WHERE l.titulo = :titulo")
    void deleteByTitulo(String titulo);

    int countByLidoTrue();
}
