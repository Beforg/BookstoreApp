package br.com.alura.musiscas.screensounds.service;

import br.com.alura.musiscas.screensounds.Table.ConsultaTabela;
import br.com.alura.musiscas.screensounds.Table.RankingTabela;
import br.com.alura.musiscas.screensounds.model.Livro;
import br.com.alura.musiscas.screensounds.repository.LivroRepository;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

import java.util.List;

public class ConsultasQuery {
    public static void buscaPorTitulo(LivroRepository livroRepository, String trecho, ObservableList<ConsultaTabela> livros) {
        List<Livro> resultado = livroRepository.buscaPorTitulo(trecho);
        verifica(livros, resultado);
    }
    public static void buscaPorAutor(LivroRepository livroRepository, String trecho, ObservableList<ConsultaTabela> livros) {
        List<Livro> resultado = livroRepository.buscaPorAutor(trecho);
        verifica(livros, resultado);
    }
    public static void buscaPorLidos(LivroRepository livroRepository, ObservableList<ConsultaTabela> livros, ChoiceBox<String> tipoLido) {
        if (tipoLido.getValue().equals("Lidos")) {
            List<Livro> resultado = livroRepository.buscaLidosTrue();
            verifica(livros, resultado);

        } else {
            List<Livro> resultado = livroRepository.buscaLidosFalse();
            verifica(livros, resultado);
        }
    }
    public static void buscarPorAvalicao(LivroRepository livroRepository, ObservableList<ConsultaTabela> livros, ChoiceBox<String> tipoAvaliacao, String avaliacao) {
        if (tipoAvaliacao.getValue().equals("Menor que")) {
            List<Livro> resultado = livroRepository.buscaPorAvaliacaoMenorQue(avaliacao);
            verifica(livros, resultado);
        } else {
            List<Livro> resultado = livroRepository.buscaPorAvaliacaoMaiorQue(avaliacao);
            verifica(livros, resultado);
        }

    }
    public static void buscaPorGenero(LivroRepository livroRepository, String genero, ObservableList<ConsultaTabela> livros) {
        List<Livro> resultado = livroRepository.buscaPorGenero(genero);
        verifica(livros, resultado);
    }
    public static void buscaPorRanking(LivroRepository livroRepository, ObservableList<RankingTabela> ranking) {
        List<Livro> resultado = livroRepository.buscaPorRanking();
        for (Livro livro : resultado) {
            ranking.add(new RankingTabela(livro.getTitulo(), livro.getAvaliacao()));
        }
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
