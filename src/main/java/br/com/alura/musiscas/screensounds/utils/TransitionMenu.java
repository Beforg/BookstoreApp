package br.com.alura.musiscas.screensounds.utils;
import br.com.alura.musiscas.screensounds.Table.ConsultaTabela;
import javafx.scene.control.Label;

import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class TransitionMenu {
    /*Visibilidade dos elementos do Inicio*/
    public static void transitionHome(Label label_textoHome, Label label_tituloHome, FlowPane flowPane_home, boolean b) {
        label_textoHome.setVisible(b);
        label_tituloHome.setVisible(b);
        flowPane_home.setVisible(b);
    }
    /*Visibilidade dos elementos do Adicionar Livros*/
    public static void transitionAddLivros(Label label_addLivro, GridPane grid_addLivro, boolean b, ImageView img_addLivro) {
        label_addLivro.setVisible(b);
        grid_addLivro.setVisible(b);
        img_addLivro.setVisible(b);
    }
    /*Visibilidade dos elementos da Busca*/
    public static void transitionBusca(Label label_tituloBusca, FlowPane grid_busca, ImageView img_busca, boolean b, TableView table_busca) {
        label_tituloBusca.setVisible(b);
        grid_busca.setVisible(b);
        img_busca.setVisible(b);
        table_busca.setVisible(b);
    }
    /*Visibilidade dos elementos dos Meus Livros*/
    public static void transitionMeusLivros(ImageView img_meusLivros, Label label_meusLivros, VBox vBox_meusLivros, VBox vBox_opMeusLivros, boolean b) {
        img_meusLivros.setVisible(b);
        label_meusLivros.setVisible(b);
        vBox_meusLivros.setVisible(b);
        vBox_opMeusLivros.setVisible(b);
    }
    /*Visibilidade dos elementos dos Autores*/
    public static void transitionAutores(Label label_addAutor, ImageView img_addAutor, VBox vBox_addAutor, boolean b) {
        label_addAutor.setVisible(b);
        img_addAutor.setVisible(b);
        vBox_addAutor.setVisible(b);
    }
    /*Verificação da aba aberta para Home*/
    public static void verificaHome(Label label_addLivro,
                                    GridPane grid_addLivro,
                                    Label label_tituloBusca,
                                    FlowPane grid_busca,
                                    ImageView img_busca,
                                    TableView<ConsultaTabela> table_busca,
                                    Label label_meusLivros,
                                    ImageView img_meusLivros,
                                    VBox vBox_meusLivros,
                                    VBox vBox_opMeusLivros,
                                    Label label_addAutor,
                                    ImageView img_addAutor,
                                    VBox vBox_addAutor,
                                    Label label_textoHome,
                                    Label label_tituloHome,
                                    FlowPane flowPane_home,
                                    ImageView img_addLivro) {
        if (label_addLivro.isVisible()) {
            TransitionMenu.transitionAddLivros(label_addLivro,grid_addLivro,false,img_addLivro);
            TransitionMenu.transitionHome(label_textoHome,label_tituloHome,flowPane_home,true);
        } else if (label_tituloBusca.isVisible()) {

            TransitionMenu.transitionBusca(label_tituloBusca,grid_busca,img_busca,false,table_busca);
            TransitionMenu.transitionHome(label_textoHome,label_tituloHome,flowPane_home,true);
        } else if (label_meusLivros.isVisible()) {

            TransitionMenu.transitionMeusLivros(img_meusLivros,label_meusLivros,vBox_meusLivros,vBox_opMeusLivros,false);
            TransitionMenu.transitionHome(label_textoHome,label_tituloHome,flowPane_home,true);

        } else {
            TransitionMenu.transitionAutores(label_addAutor,img_addAutor,vBox_addAutor,false);
            TransitionMenu.transitionHome(label_textoHome,label_tituloHome,flowPane_home,true);
        }
    }
    /*Verificação da aba aberta para Adicionar Livros*/
    public static void verificaAddLivro(Label label_textoHome,
                                        Label label_tituloHome,
                                        FlowPane flowPane_home,
                                        Label label_addLivro,
                                        GridPane grid_addLivro,
                                        ImageView img_addLivro,
                                        Label label_tituloBusca,
                                        FlowPane grid_busca,
                                        ImageView img_busca,
                                        TableView<ConsultaTabela> table_busca,
                                        Label label_meusLivros,
                                        ImageView img_meusLivros,
                                        VBox vBox_meusLivros,
                                        VBox vBox_opMeusLivros,
                                        Label label_addAutor,
                                        ImageView img_addAutor,
                                        VBox vBox_addAutor) {
        if (label_textoHome.isVisible()) {
            TransitionMenu.transitionHome(label_textoHome,label_tituloHome,flowPane_home,false);
            TransitionMenu.transitionAddLivros(label_addLivro,grid_addLivro,true,img_addLivro);
        } else if (label_meusLivros.isVisible()) {
            TransitionMenu.transitionMeusLivros(img_meusLivros,label_meusLivros,vBox_meusLivros,vBox_opMeusLivros,false);
            TransitionMenu.transitionAddLivros(label_addLivro,grid_addLivro,true,img_addLivro);
        } else if (label_tituloBusca.isVisible()) {
            TransitionMenu.transitionBusca(label_tituloBusca,grid_busca,img_busca,false,table_busca);
            TransitionMenu.transitionAddLivros(label_addLivro,grid_addLivro,true,img_addLivro);
        } else {
            TransitionMenu.transitionAutores(label_addAutor,img_addAutor,vBox_addAutor,false);
            TransitionMenu.transitionAddLivros(label_addLivro,grid_addLivro,true,img_addLivro);
        }
    }
    /*Verificação da aba aberta para Buscar livros*/
    public static void verificaBuscaLivro(Label label_textoHome,
                                          Label label_tituloHome,
                                          FlowPane flowPane_home,
                                          Label label_addLivro,
                                          GridPane grid_addLivro,
                                          Label label_tituloBusca,
                                          FlowPane grid_busca,
                                          ImageView img_busca,
                                          TableView<ConsultaTabela> table_busca,
                                          Label label_meusLivros,
                                          ImageView img_meusLivros,
                                          VBox vBox_meusLivros,
                                          VBox vBox_opMeusLivros,
                                          Label label_addAutor,
                                          ImageView img_addAutor,
                                          VBox vBox_addAutor,
                                          ImageView img_addLivro) {
        if (label_textoHome.isVisible()) {
            TransitionMenu.transitionHome(label_textoHome,label_tituloHome,flowPane_home,false);
            TransitionMenu.transitionBusca(label_tituloBusca,grid_busca,img_busca,true,table_busca);
        } else if (label_addLivro.isVisible()) {
            TransitionMenu.transitionAddLivros(label_addLivro,grid_addLivro,false,img_addLivro);
            TransitionMenu.transitionBusca(label_tituloBusca,grid_busca,img_busca,true,table_busca);
        } else if (label_meusLivros.isVisible()) {
            TransitionMenu.transitionMeusLivros(img_meusLivros,label_meusLivros,vBox_meusLivros,vBox_opMeusLivros,false);
            TransitionMenu.transitionBusca(label_tituloBusca,grid_busca,img_busca,true,table_busca);
        } else {
            TransitionMenu.transitionAutores(label_addAutor,img_addAutor,vBox_addAutor,false);
            TransitionMenu.transitionBusca(label_tituloBusca,grid_busca,img_busca,true,table_busca);
        }
    }
    /*Verificação da aba aberta para Meus livros*/
    public static void verificaMeusLivros(Label label_textoHome,
                                          Label label_tituloHome,
                                          FlowPane flowPane_home,
                                          Label label_addLivro,
                                          GridPane grid_addLivro,
                                          Label label_tituloBusca,
                                          FlowPane grid_busca,
                                          ImageView img_busca,
                                          TableView<ConsultaTabela> table_busca,
                                          Label label_meusLivros,
                                          ImageView img_meusLivros,
                                          VBox vBox_meusLivros,
                                          VBox vBox_opMeusLivros,
                                          Label label_addAutor,
                                          ImageView img_addAutor,
                                          VBox vBox_addAutor,
                                          ImageView img_addLivro) {
        if (label_tituloHome.isVisible()) {
            TransitionMenu.transitionHome(label_textoHome,label_tituloHome,flowPane_home,false);
            TransitionMenu.transitionMeusLivros(img_meusLivros,label_meusLivros,vBox_meusLivros,vBox_opMeusLivros,true);
        } else if (label_addLivro.isVisible()) {
            TransitionMenu.transitionAddLivros(label_addLivro,grid_addLivro,false,img_addLivro);
            TransitionMenu.transitionMeusLivros(img_meusLivros,label_meusLivros,vBox_meusLivros,vBox_opMeusLivros,true);
        } else if (label_tituloBusca.isVisible()) {
            TransitionMenu.transitionBusca(label_tituloBusca,grid_busca,img_busca,false,table_busca);
            TransitionMenu.transitionMeusLivros(img_meusLivros,label_meusLivros,vBox_meusLivros,vBox_opMeusLivros,true);
        } else {
            TransitionMenu.transitionAutores(label_addAutor,img_addAutor,vBox_addAutor,false);
            TransitionMenu.transitionMeusLivros(img_meusLivros,label_meusLivros,vBox_meusLivros,vBox_opMeusLivros,true);
        }
    }
    /*Verificação da aba aberta para Autores*/
    public static void verificaAddAutor(Label label_textoHome,
                                        Label label_tituloHome,
                                        FlowPane flowPane_home,
                                        Label label_addLivro,
                                        GridPane grid_addLivro,
                                        Label label_tituloBusca,
                                        FlowPane grid_busca,
                                        ImageView img_busca,
                                        TableView<ConsultaTabela> table_busca,
                                        Label label_meusLivros,
                                        ImageView img_meusLivros,
                                        VBox vBox_meusLivros,
                                        VBox vBox_opMeusLivros,
                                        Label label_addAutor,
                                        ImageView img_addAutor,
                                        VBox vBox_addAutor,
                                        ImageView img_addLivro) {
        if (label_tituloHome.isVisible()) {
            TransitionMenu.transitionHome(label_textoHome,label_tituloHome,flowPane_home,false);
            TransitionMenu.transitionAutores(label_addAutor,img_addAutor,vBox_addAutor,true);
        } else if (label_addLivro.isVisible()) {
            TransitionMenu.transitionAddLivros(label_addLivro,grid_addLivro,false,img_addLivro);
            TransitionMenu.transitionAutores(label_addAutor,img_addAutor,vBox_addAutor,true);
        } else if (label_tituloBusca.isVisible()) {
            TransitionMenu.transitionBusca(label_tituloBusca,grid_busca,img_busca,false,table_busca);
            TransitionMenu.transitionAutores(label_addAutor,img_addAutor,vBox_addAutor,true);
        } else if (label_meusLivros.isVisible()) {
            TransitionMenu.transitionMeusLivros(img_meusLivros,label_meusLivros,vBox_meusLivros,vBox_opMeusLivros,false);
            TransitionMenu.transitionAutores(label_addAutor,img_addAutor,vBox_addAutor,true);
        }
    }
}
