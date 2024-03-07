package br.com.alura.app.bookstore.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Sobre {
    public static void sobre() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sobre");
        alert.setHeaderText("Sobre o aplicativo");
        alert.setContentText("@Beforg \n" +
                "Aplicativo para controle de livros | v1.0 \n"+ "github.com/Beforg");
        alert.setGraphic(new ImageView(new Image(Objects.requireNonNull(Sobre.class.getResourceAsStream("/img/information.png")))));

        alert.showAndWait();
        ButtonType okButtonType = alert.getButtonTypes().stream()
                .filter(buttonType -> buttonType.getButtonData() == ButtonBar.ButtonData.OK_DONE)
                .findFirst()
                .orElse(null);

        if (okButtonType != null) {
            Button okButton = (Button) alert.getDialogPane().lookupButton(okButtonType);
            okButton.setStyle("-fx-background-color: #6083DB; -fx-text-fill: white;");
        }

        alert.showAndWait();
    }

}
