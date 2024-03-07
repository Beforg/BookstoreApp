package br.com.alura.app.bookstore.utils;

import br.com.alura.app.bookstore.model.Categorias;
import br.com.alura.app.bookstore.model.Filtros;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.NumberStringConverter;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.function.UnaryOperator;

public class Filter {
    /*Iterando e colocando os itens do filtro para a busca.*/
    public static void filtrosBusca(ChoiceBox<String> cb_filtroBusca) {
        for (Filtros n : Filtros.values()) {
            cb_filtroBusca.getItems().add(n.getDescricao());
        }
    }
    public static void filtrosCategorias(ChoiceBox<String> choiceBoxCategoria) {
        for (Categorias s : Categorias.values()) {
            choiceBoxCategoria.getItems().add(s.getDescricao());
        }
    }
    public static void formatTextFieldAvaliacao(TextField textField) {
        DecimalFormat format = new DecimalFormat("#.0");
        NumberStringConverter converter = new NumberStringConverter(format);
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.isEmpty()) {
                return change;
            }

            ParsePosition parsePosition = new ParsePosition(0);
            Number number = format.parse(newText, parsePosition);

            if (number == null || newText.length() - parsePosition.getIndex() > 2 || number.doubleValue() < 0 || number.doubleValue() > 10) {
                return null;
            } else {
                return change;
            }
        };
        TextFormatter<Number> textFormatter = new TextFormatter<>(converter, null, filter);
        textField.setTextFormatter(textFormatter);
    }
}
