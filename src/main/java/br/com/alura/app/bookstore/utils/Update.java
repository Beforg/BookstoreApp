package br.com.alura.app.bookstore.utils;

import br.com.alura.app.bookstore.Table.RankingTabela;
import br.com.alura.app.bookstore.repository.LivroRepository;
import br.com.alura.app.bookstore.service.ConsultasQuery;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;

public class Update {
    public static void updateEditMeusLivros(ChoiceBox<String> livros, LivroRepository livroRepository) {
        livros.getItems().clear();
        livroRepository.findAll().forEach(livro -> {
            livros.getItems().add(livro.getTitulo());
        });
    }
    public static void updateRanking(TableView<RankingTabela> table_ranking, ObservableList<RankingTabela> rankingObservable, LivroRepository livroRepository) {
            table_ranking.getItems().clear();
            rankingObservable.clear();
            ConsultasQuery.buscaPorRanking(livroRepository, rankingObservable);
            table_ranking.getItems().addAll(rankingObservable);



    }
}
