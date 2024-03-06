package br.com.alura.musiscas.screensounds.controller;
import br.com.alura.musiscas.screensounds.Table.ConsultaTabela;
import br.com.alura.musiscas.screensounds.model.Autor;
import br.com.alura.musiscas.screensounds.model.Categorias;
import br.com.alura.musiscas.screensounds.model.Livro;
import br.com.alura.musiscas.screensounds.repository.AutorRepository;
import br.com.alura.musiscas.screensounds.repository.LivroRepository;
import br.com.alura.musiscas.screensounds.service.Consultas;
import br.com.alura.musiscas.screensounds.utils.Filter;
import br.com.alura.musiscas.screensounds.utils.ListenerBox;
import br.com.alura.musiscas.screensounds.utils.TableSet;
import br.com.alura.musiscas.screensounds.utils.TransitionMenu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
@Component
public class Controller implements Initializable {
    @FXML
    private CheckBox box_lido;
    @FXML
    private GridPane grid_addLivro;
    @FXML
    private FlowPane grid_busca,flowPane_home;
    @FXML
    private ImageView img_busca,img_meusLivros,img_addLivro,img_addAutor;
    @FXML
    private Label label_meusLivros, label_addLivro,label_textoHome,label_tituloBusca,label_tituloHome,label_selecionaCategoria,label_addAutor;
    @FXML
    private ChoiceBox<Autor> cb_autorAddLivro;
    @FXML
    private TableView<ConsultaTabela> table_busca;
    @FXML
    private TextField tf_titulo,tf_buscadorAutorLivro, tf_avaliacao,tf_addAutor;
    @FXML
    private VBox vBox_opMeusLivros,vBox_addAutor,vBox_meusLivros;
    @FXML
    private ChoiceBox<String> cb_filtro_busca,cb_categoriaBusca,cb_categoriaAddLivros;
    @FXML
    private TableColumn<ConsultaTabela, String> nome, autor, genero, avaliacao;
    @FXML
    private Button botao_pesquisa;

    Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/pesquisar.png")));

    /*Consultas ao banco de dados*/
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    /*--------------------------------------*/
    ObservableList<Autor> autorObservableList;
    ObservableList<ConsultaTabela> tabelaObservable = FXCollections.observableArrayList();

    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        if (cb_filtro_busca.getItems().isEmpty()) {
            Filter.filtrosBusca(cb_filtro_busca);
        }
            List<Autor> autores = autorRepository.findAll();
            autorObservableList = FXCollections.observableArrayList(autores);
            cb_autorAddLivro.setItems(autorObservableList);

            for (Categorias s : Categorias.values()) {
                cb_categoriaAddLivros.getItems().add(s.getDescricao());
            }



        ListenerBox.listenerBusca(cb_filtro_busca, tf_buscadorAutorLivro, label_selecionaCategoria, cb_categoriaBusca);

        /*----------Tabelas-------*/
        TableSet.tabelaBusca(nome, autor, genero, avaliacao);
        table_busca.getItems().addAll(tabelaObservable);
        /*------------------------*/
        botao_pesquisa.setGraphic(new ImageView(image));


    }
    public void persist() {
        Livro livro = new Livro(tf_titulo.getText(),
                cb_autorAddLivro.getValue(),
                tf_avaliacao.getText(),
                cb_categoriaAddLivros.getValue(),
                box_lido.isSelected());

        livroRepository.save(livro);
    }
    public void consultar() {
        if (cb_filtro_busca.getValue().contains("Nome")) {
            System.out.println("Buscou por nome");
            tabelaObservable.clear();
            table_busca.getItems().clear();
            if (tf_buscadorAutorLivro.getText().isEmpty()) {
                System.out.println("Busca vazia");
            } else {
                Consultas.buscaPorTitulo(livroRepository, tf_buscadorAutorLivro.getText(), tabelaObservable);
                initialize(null,null);
            }
        } else if (cb_filtro_busca.getValue().equals("Autor")) {
            System.out.println("Buscou por autor");
            tabelaObservable.clear();
            table_busca.getItems().clear();
            if(tf_buscadorAutorLivro.getText().isEmpty()) {
                System.out.println("Busca vazia");
            } else {
                Consultas.buscaPorAutor(livroRepository, tf_buscadorAutorLivro.getText(), tabelaObservable);
                initialize(null,null);
            }
        }


    }
    public void bt_inicio() {
        TransitionMenu.verificaHome(label_addLivro, grid_addLivro, label_tituloBusca, grid_busca, img_busca, table_busca, label_meusLivros, img_meusLivros, vBox_meusLivros, vBox_opMeusLivros, label_addAutor, img_addAutor, vBox_addAutor, label_textoHome, label_tituloHome, flowPane_home, img_addLivro);
    }
    public void bt_addLivro() {
        TransitionMenu.verificaAddLivro(label_textoHome, label_tituloHome, flowPane_home, label_addLivro, grid_addLivro, img_addLivro, label_tituloBusca, grid_busca, img_busca, table_busca, label_meusLivros, img_meusLivros, vBox_meusLivros, vBox_opMeusLivros, label_addAutor, img_addAutor, vBox_addAutor);
    }

    public void bt_buscaLivro() {
        TransitionMenu.verificaBuscaLivro(label_textoHome, label_tituloHome, flowPane_home, label_addLivro, grid_addLivro, label_tituloBusca, grid_busca, img_busca, table_busca, label_meusLivros, img_meusLivros, vBox_meusLivros, vBox_opMeusLivros, label_addAutor, img_addAutor, vBox_addAutor, img_addLivro);
    }
    public void bt_meusLivros() {
        TransitionMenu.verificaMeusLivros(label_textoHome, label_tituloHome, flowPane_home, label_addLivro, grid_addLivro, label_tituloBusca, grid_busca, img_busca, table_busca, label_meusLivros, img_meusLivros, vBox_meusLivros, vBox_opMeusLivros, label_addAutor, img_addAutor, vBox_addAutor, img_addLivro);

    }
    public void novoAutor() {
    TransitionMenu.verificaAddAutor(label_textoHome, label_tituloHome, flowPane_home, label_addLivro, grid_addLivro, label_tituloBusca, grid_busca, img_busca, table_busca, label_meusLivros, img_meusLivros, vBox_meusLivros, vBox_opMeusLivros, label_addAutor, img_addAutor, vBox_addAutor, img_addLivro);
    }
    public void addAutor() {
        String nomeAutor = tf_addAutor.getText();
        if(nomeAutor.isEmpty()) {
            System.out.println("Campo vazio");
        } else {
            boolean autorExiste = autorObservableList.stream()
                    .anyMatch(autor -> autor.getNome().equals(nomeAutor));

            if (autorExiste) {
                System.out.println("Autor já existe na lista");
            } else {
                Autor autor = new Autor(nomeAutor);
                autorRepository.save(autor);
                autorObservableList.clear();
                autorObservableList.addAll(autorRepository.findAll());
            }
        }
    }
}
