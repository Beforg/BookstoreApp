package br.com.alura.musiscas.screensounds.service;

import br.com.alura.musiscas.screensounds.Table.ConsultaTabela;
import br.com.alura.musiscas.screensounds.controller.InfoScreenController;
import br.com.alura.musiscas.screensounds.model.Autor;
import br.com.alura.musiscas.screensounds.model.Livro;
import br.com.alura.musiscas.screensounds.repository.LivroRepository;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PersistEConsulta {

    public static void salvarDados(TextField tf_titulo,
                                   TextField tf_avaliacao,
                                   ChoiceBox<Autor> cb_autorAddLivro,
                                   ChoiceBox<String> cb_categoriaAddLivros,
                                   CheckBox box_lido,
                                   LivroRepository livroRepository) {
        Livro livro = new Livro(tf_titulo.getText(),
                cb_autorAddLivro.getValue(),
                tf_avaliacao.getText(),
                cb_categoriaAddLivros.getValue(),
                box_lido.isSelected());
        tf_titulo.setText("");
        tf_avaliacao.setText("");
        cb_autorAddLivro.setValue(null);
        cb_categoriaAddLivros.setValue(null);
        box_lido.setSelected(false);

        try {
            livroRepository.save(livro);
            InfoScreenController infoScreenController = new InfoScreenController();
            infoScreenController.showInformationMessage("Seu livro foi adicionado com sucesso.", "Livro adicionado", 1);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void consultas(ChoiceBox<String> cb_filtro_busca,
                                 ObservableList<ConsultaTabela> tabelaObservable,
                                 TableView<ConsultaTabela> table_busca,
                                 TextField tf_buscadorAutorLivro,
                                 LivroRepository livroRepository,
                                 ChoiceBox<String> cb_categoriaBusca) {
        if (cb_filtro_busca.getValue().contains("Nome")) {
            System.out.println("Buscou por nome");
            tabelaObservable.clear();
            table_busca.getItems().clear();
            if (tf_buscadorAutorLivro.getText().isEmpty()) {
                System.out.println("Busca vazia");
            } else {
                ConsultasQuery.buscaPorTitulo(livroRepository, tf_buscadorAutorLivro.getText(), tabelaObservable);
            }
        } else if (cb_filtro_busca.getValue().equals("Autor")) {
            System.out.println("Buscou por autor");
            tabelaObservable.clear();
            table_busca.getItems().clear();
            if(tf_buscadorAutorLivro.getText().isEmpty()) {
                System.out.println("Busca vazia");
            } else {
                ConsultasQuery.buscaPorAutor(livroRepository, tf_buscadorAutorLivro.getText(), tabelaObservable);

            }
        } else if (cb_filtro_busca.getValue().equals("Avaliação")) {
            tabelaObservable.clear();
            table_busca.getItems().clear();
            ConsultasQuery.buscarPorAvalicao(livroRepository, tabelaObservable, cb_categoriaBusca, tf_buscadorAutorLivro.getText());

        } else if (cb_filtro_busca.getValue().equals("Gênero")) {
            tabelaObservable.clear();
            table_busca.getItems().clear();
            ConsultasQuery.buscaPorGenero(livroRepository, cb_categoriaBusca.getValue(), tabelaObservable);
        } else if (cb_filtro_busca.getValue().equals("Lido")) {
            tabelaObservable.clear();
            table_busca.getItems().clear();
            ConsultasQuery.buscaPorLidos(livroRepository, tabelaObservable,cb_categoriaBusca);
        }
    }
}
