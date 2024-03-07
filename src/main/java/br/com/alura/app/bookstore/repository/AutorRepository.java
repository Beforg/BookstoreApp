package br.com.alura.app.bookstore.repository;

import br.com.alura.app.bookstore.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository  extends JpaRepository<Autor, Long> {
}
