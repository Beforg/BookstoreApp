package br.com.alura.musiscas.screensounds.utils;

import br.com.alura.musiscas.screensounds.model.Filtros;
import javafx.scene.control.ChoiceBox;

public class Filter {
    /*Iterando e colocando os itens do filtro para a busca.*/
    public static void filtrosBusca(ChoiceBox<String> cb_filtroBusca) {
        for (Filtros n : Filtros.values()) {
            cb_filtroBusca.getItems().add(n.getDescricao());
        }
    }
}
