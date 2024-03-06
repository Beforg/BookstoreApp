package br.com.alura.musiscas.screensounds.utils;

import br.com.alura.musiscas.screensounds.model.Categorias;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

                for (Categorias s : Categorias.values()) {
                    choiceBoxCategoria.getItems().add(s.getDescricao());
                }

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
}
