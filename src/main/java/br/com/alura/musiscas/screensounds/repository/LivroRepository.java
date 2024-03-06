package br.com.alura.musiscas.screensounds.repository;

import br.com.alura.musiscas.screensounds.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query ("SELECT l FROM Livro l WHERE l.titulo ilike %:trecho% ORDER BY l.titulo ASC")
    List<Livro> buscaPorTitulo(String trecho);
    @Query ("SELECT l FROM Livro l WHERE l.autor.nome ilike %:trecho% ORDER BY l.titulo ASC")
    List<Livro> buscaPorAutor(String trecho);
    @Query("SELECT l FROM Livro l WHERE l.lido = true")
    List<Livro> buscaLidos();
    @Query("SELECT l FROM Livro l WHERE l.avaliacao >= :avaliacao")
    List<Livro> buscaPorAvaliacaoMaiorQue(String avaliacao);
    @Query("SELECT l FROM Livro l WHERE l.avaliacao <= :avaliacao")
    List<Livro> buscaPorAvaliacaoMenorQue(String avaliacao);
}
