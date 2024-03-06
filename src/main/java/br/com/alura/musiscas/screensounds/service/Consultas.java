package br.com.alura.musiscas.screensounds.service;

import br.com.alura.musiscas.screensounds.Table.ConsultaTabela;
import br.com.alura.musiscas.screensounds.model.Livro;
import br.com.alura.musiscas.screensounds.repository.LivroRepository;
import javafx.collections.ObservableList;

import java.util.List;

public class Consultas {
    public static void buscaPorTitulo(LivroRepository livroRepository, String trecho, ObservableList<ConsultaTabela> livros) {
        List<Livro> resultado = livroRepository.buscaPorTitulo(trecho);
        verifica(livros, resultado);
    }
    public static void buscaPorAutor(LivroRepository livroRepository, String trecho, ObservableList<ConsultaTabela> livros) {
        List<Livro> resultado = livroRepository.buscaPorAutor(trecho);
        verifica(livros, resultado);
    }
    public static void buscaPorLidos(LivroRepository livroRepository, ObservableList<ConsultaTabela> livros) {
        List<Livro> resultado = livroRepository.buscaLidos();
        verifica(livros, resultado);
    }
    public static void buscarPorAvalicao(LivroRepository livroRepository, ObservableList<ConsultaTabela> livros, String avaliacao) {
        List<Livro> resultado = livroRepository.buscaPorAvaliacaoMaiorQue(avaliacao);
        verifica(livros, resultado);
    }
    public static void verifica(ObservableList<ConsultaTabela> livros, List<Livro> resultado) {
        for (Livro livro : resultado) {
            if (livro.isLido()) {
                livros.add(new ConsultaTabela("✔ "+livro.getTitulo(), livro.getAutor().toString(), livro.getGenero(), livro.getAvaliacao()));
            } else {
                livros.add(new ConsultaTabela(livro.getTitulo(), livro.getAutor().toString(), livro.getGenero(), livro.getAvaliacao()));
            }
        }
    }
}
