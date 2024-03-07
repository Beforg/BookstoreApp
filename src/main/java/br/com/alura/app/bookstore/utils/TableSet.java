package br.com.alura.app.bookstore.utils;

import br.com.alura.app.bookstore.Table.ConsultaTabela;
import br.com.alura.app.bookstore.Table.RankingTabela;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableSet {
    public static void tabelaBusca(TableColumn<ConsultaTabela, String> nome,
                                   TableColumn<ConsultaTabela, String> autor,
                                   TableColumn<ConsultaTabela, String> genero,
                                   TableColumn<ConsultaTabela, String> avaliacao) {
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        avaliacao.setCellValueFactory(new PropertyValueFactory<>("avaliacao"));

    }

    public static void tabelaRanking(TableColumn<RankingTabela, String> nome_ranking,
                                     TableColumn<RankingTabela, String> avaliacao_ranking) {
        nome_ranking.setCellValueFactory(new PropertyValueFactory<>("nome_ranking"));
        avaliacao_ranking.setCellValueFactory(new PropertyValueFactory<>("avaliacao_ranking"));

    }
}
