package br.com.alura.musiscas.screensounds.utils;

import br.com.alura.musiscas.screensounds.Table.ConsultaTabela;
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
}
