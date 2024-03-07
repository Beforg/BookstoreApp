package br.com.alura.musiscas.screensounds.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InfoScreenController {
    @FXML
    public Button bt_direita;

    @FXML
    public Button bt_esquerda;

    @FXML
    public ImageView error;

    @FXML
    public ImageView information;

    @FXML
    public Label label_texto;

    @FXML
    public Label label_titulo;

    @FXML
    public ImageView sucesso;

    public static boolean isOpen = false;

    public InfoScreenController() {

    }

    public void showInformationMessage(String message, String title, int tipo) {
        if (!isOpen) {
            isOpen = true;
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/info_screen.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(loader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            InfoScreenController controller = loader.getController();
            controller.label_titulo.setText(title);
            controller.label_texto.setText(message);

            if (tipo == 1) {
                controller.sucesso.setVisible(true);
            } else if (tipo == 2) {
                controller.error.setVisible(true);
            } else {
                controller.information.setVisible(true);
            }
            stage.setScene(scene);
            stage.setTitle("Atenção");
            stage.show();
        }
    }
}
