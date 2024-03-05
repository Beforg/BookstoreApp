package br.com.alura.musiscas.screensounds.repository;

import br.com.alura.musiscas.screensounds.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
