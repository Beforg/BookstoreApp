package br.com.alura.app.bookstore.utils;

import br.com.alura.app.bookstore.model.Autor;
import br.com.alura.app.bookstore.repository.LivroRepository;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ListenerBox {
    public static void listenerBusca(ChoiceBox<String> choiceBoxFiltro,
                                     TextField tf_buscaAutorLivro,
                                     Label label_selecionaCategoria,
                                     ChoiceBox<String> choiceBoxCategoria) {
        ChangeListener<String> avaliacaoListener = (observable1, oldValue1, newValue1) -> {
            if (!newValue1.matches("\\d*")) {
                Platform.runLater(() -> {
                    tf_buscaAutorLivro.setText(newValue1.replaceAll("[^\\d]", ""));
                });
            }
            if (!tf_buscaAutorLivro.getText().isEmpty()) {
                int value = Integer.parseInt(tf_buscaAutorLivro.getText());
                if (value < 0) {
                    Platform.runLater(() -> {
                        tf_buscaAutorLivro.setText("0");
                    });
                } else if (value > 10) {
                    Platform.runLater(() -> {
                        tf_buscaAutorLivro.setText("10");
                    });
                }
            }
        };

        choiceBoxFiltro.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("Autor") || newValue.equals("Nome")) {
                tf_buscaAutorLivro.setDisable(false);
                tf_buscaAutorLivro.setPromptText("Digite o " + newValue.toLowerCase() + " do livro");
                tf_buscaAutorLivro.textProperty().removeListener(avaliacaoListener);
            } else {
                tf_buscaAutorLivro.setText("");
                tf_buscaAutorLivro.setDisable(true);
                tf_buscaAutorLivro.setPromptText("Autor/Livro/Avaliação");
                tf_buscaAutorLivro.textProperty().removeListener(avaliacaoListener);
            } if (newValue.equals("Gênero")) {

                tf_buscaAutorLivro.setDisable(true);
                label_selecionaCategoria.setVisible(true);
                label_selecionaCategoria.setText("Selecione o gênero:");
                choiceBoxCategoria.setVisible(true);
                choiceBoxCategoria.getItems().clear();

//                for (Categorias s : Categorias.values()) {
//                    choiceBoxCategoria.getItems().add(s.getDescricao());
//                }
                Filter.filtrosCategorias(choiceBoxCategoria);

            } else {
                label_selecionaCategoria.setVisible(false);
                choiceBoxCategoria.setVisible(false);
                tf_buscaAutorLivro.setText("");

            } if (newValue.equals("Lido")) {
                label_selecionaCategoria.setText("Selecione a opção");
                label_selecionaCategoria.setVisible(true);
                choiceBoxCategoria.setVisible(true);
                choiceBoxCategoria.getItems().clear();
                choiceBoxCategoria.setItems(FXCollections.observableArrayList("Lidos", "Não lidos"));
            }  if (newValue.equals("Avaliação")) {
                label_selecionaCategoria.setVisible(true);
                label_selecionaCategoria.setText("Selecione a avaliação:");
                choiceBoxCategoria.setVisible(true);
                choiceBoxCategoria.setItems(FXCollections.observableArrayList("Maior que", "Menor que"));
                tf_buscaAutorLivro.setPromptText("Digite a avaliação");
                tf_buscaAutorLivro.setDisable(false);
                tf_buscaAutorLivro.textProperty().addListener(avaliacaoListener);

            } else {
                tf_buscaAutorLivro.textProperty().removeListener(avaliacaoListener);
            }

        });
    }
    public static void verificaCheckBoxMeusLivros(CheckBox sobre, CheckBox cb_ranking, CheckBox cb_editLivro, VBox box_ranking, VBox box_editLivro, Button salvar,Button botao_excluir, VBox vBox_sobre) {
        sobre.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(true)) {
                cb_ranking.setSelected(false);
                cb_editLivro.setSelected(false);
                box_ranking.setVisible(false);
                box_editLivro.setVisible(false);
                salvar.setVisible(false);
                vBox_sobre.setVisible(true);
                botao_excluir.setVisible(false);
            }
        });
        cb_ranking.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(true)) {
                cb_editLivro.setSelected(false);
                box_ranking.setVisible(true);
                box_editLivro.setVisible(false);
                vBox_sobre.setVisible(false);
                salvar.setVisible(false);
                sobre.setSelected(false);
                botao_excluir.setVisible(false);

            }
        });
        cb_editLivro.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(true)) {
                cb_ranking.setSelected(false);
                box_ranking.setVisible(false);
                box_editLivro.setVisible(true);
                vBox_sobre.setVisible(false);
                sobre.setSelected(false);
                salvar.setVisible(true);
                botao_excluir.setVisible(true);
            }
        });
    }
    public static void livroSelecionadoEdit(ChoiceBox<String> livroSelecionado, TextField titulo, ChoiceBox<Autor> autorChoiceBox, ChoiceBox<String> genero, CheckBox lido, TextField avaliacao, LivroRepository livroRepository) {
        livroSelecionado.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                titulo.setDisable(false);
                autorChoiceBox.setDisable(false);
                genero.setDisable(false);
                lido.setDisable(false);
                avaliacao.setDisable(false);

                titulo.setText(newValue);
                autorChoiceBox.setValue(livroRepository.findByTitulo(newValue).getAutor());
                genero.setValue(livroRepository.findByTitulo(newValue).getGenero());
                lido.setSelected(livroRepository.findByTitulo(newValue).isLido());
                avaliacao.setText(livroRepository.findByTitulo(newValue).getAvaliacao());

            } else {
                titulo.setDisable(true);
                autorChoiceBox.setDisable(true);
                genero.setDisable(true);
                lido.setDisable(true);
                avaliacao.setDisable(true);
            }
        });
    }
    public static void lidoSelected(CheckBox lido, TextField avaliacao) {
        lido.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(true)) {
                avaliacao.setDisable(false);
            } else {
                avaliacao.setDisable(true);
            }
        });
    }
}
