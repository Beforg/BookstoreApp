package br.com.alura.musiscas.screensounds.repository;

import br.com.alura.musiscas.screensounds.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository  extends JpaRepository<Autor, Long> {
}
