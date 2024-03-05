package br.com.alura.musiscas.screensounds.controller;
import br.com.alura.musiscas.screensounds.model.Autor;
import br.com.alura.musiscas.screensounds.model.Livro;
import br.com.alura.musiscas.screensounds.repository.AutorRepository;
import br.com.alura.musiscas.screensounds.repository.LivroRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.ResourceBundle;
@Component
public class Controller implements Initializable {
    @FXML
    private CheckBox box_lido;

    @FXML
    private GridPane grid_addLivro;

    @FXML
    private FlowPane grid_busca;

    @FXML
    private ImageView img_addHome;

    @FXML
    private ImageView img_busca;

    @FXML
    private ImageView img_buscaHome;

    @FXML
    private ImageView img_meusLivros;

    @FXML
    private ImageView img_opMeusLivros;

    @FXML
    private ImageView img_rankHome;
    @FXML
    private ImageView img_addLivro;

    @FXML
    private Label label_addLivro;

    @FXML
    private Label label_meusLivros;

    @FXML
    private Label label_textoHome;

    @FXML
    private Label label_tituloBusca;

    @FXML
    private Label label_tituloHome;
    @FXML
    private ChoiceBox<Autor> cb_autorAddLivro;

    @FXML
    private TableView<?> table_busca;

    @FXML
    private TextField tf_autor;

    @FXML
    private TextField tf_avaliacao;

    @FXML
    private TextField tf_genero;

    @FXML
    private TextField tf_titulo;

    @FXML
    private VBox vBox_editMeusLivros;

    @FXML
    private VBox vBox_meusLivros;

    @FXML
    private VBox vBox_opMeusLivros;
    @FXML
    private Label label_addAutor;
    @FXML
    private Label label_novoAutor;
    @FXML
    private TextField tf_addAutor;
    @FXML
    private Button bt_addAutor;
    @FXML
    private ImageView img_addAutor;

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;


    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        List<Autor> autores = autorRepository.findAll();
        ObservableList<Autor> autorObservableList = FXCollections.observableArrayList(autores);
        cb_autorAddLivro.setItems(autorObservableList);
    }
    public void persist() {
        Livro livro = new Livro(tf_titulo.getText(),
                cb_autorAddLivro.getValue(),
                tf_avaliacao.getText(),
                tf_genero.getText(),
                box_lido.isSelected());

        livroRepository.save(livro);
    }

    public void showHome() {
        label_textoHome.setVisible(true);
        label_tituloHome.setVisible(true);
        img_addHome.setVisible(true);
        img_rankHome.setVisible(true);
        img_buscaHome.setVisible(true);
    }
    public void showAdd(){
        label_addLivro.setVisible(true);
        grid_addLivro.setVisible(true);
        img_addLivro.setVisible(true);
    }
    public void showBusca() {
        label_tituloBusca.setVisible(true);
        grid_busca.setVisible(true);
        img_busca.setVisible(true);
        table_busca.setVisible(true);
    }
    public void showMeusLivros() {
        img_meusLivros.setVisible(true);
        label_meusLivros.setVisible(true);
        vBox_meusLivros.setVisible(true);
        vBox_opMeusLivros.setVisible(true);
    }
    public void showNovoAutor() {
        label_addAutor.setVisible(true);
        label_novoAutor.setVisible(true);
        tf_addAutor.setVisible(true);
        bt_addAutor.setVisible(true);
        img_addAutor.setVisible(true);
    }
    public void hideInicio() {
        label_textoHome.setVisible(false);
        label_tituloHome.setVisible(false);
        img_addHome.setVisible(false);
        img_rankHome.setVisible(false);
        img_meusLivros.setVisible(false);
        img_buscaHome.setVisible(false);
    }
    public void hideBusca() {
        label_tituloBusca.setVisible(false);
        grid_busca.setVisible(false);
        table_busca.setVisible(false);
        img_busca.setVisible(false);
    }
    public void hideAddLivro() {
        label_addLivro.setVisible(false);
        grid_addLivro.setVisible(false);
        img_addLivro.setVisible(false);
    }
    public void hideAddAutor() {
        label_addAutor.setVisible(false);
        label_novoAutor.setVisible(false);
        tf_addAutor.setVisible(false);
        bt_addAutor.setVisible(false);
        img_addAutor.setVisible(false);
    }
    public void hideMeusLivros() {
        label_meusLivros.setVisible(false);
        vBox_meusLivros.setVisible(false);
        vBox_opMeusLivros.setVisible(false);
        vBox_editMeusLivros.setVisible(false);
        img_meusLivros.setVisible(false);
    }
    public void bt_inicio() {
        if (label_addLivro.isVisible()) {

            hideAddLivro();
            showHome();
        } else if (label_tituloBusca.isVisible()) {
            hideBusca();

            showHome();
        } else if (label_meusLivros.isVisible()) {
            hideMeusLivros();

            showHome();
        } else {
            hideAddAutor();
            showHome();
        }

    }
    public void bt_addLivro() {
        if (label_textoHome.isVisible()) {
            hideInicio();
            showAdd();
        } else if (label_meusLivros.isVisible()) {
            hideMeusLivros();

            showAdd();
        } else if (label_tituloBusca.isVisible()) {
            hideBusca();

            showAdd();
        } else {
            hideAddAutor();
            showAdd();
        }
    }

    public void bt_buscaLivro() {
        if (label_textoHome.isVisible()) {
            hideInicio();

            showBusca();
        } else if (label_addLivro.isVisible()) {
            hideAddLivro();

            showBusca();
        } else if (label_meusLivros.isVisible()) {
            hideMeusLivros();

            showBusca();
        } else {
            hideAddAutor();
            showBusca();
        }
    }
    public void bt_meusLivros() {
        if (label_tituloHome.isVisible()) {
            hideInicio();

            showMeusLivros();

        } else if (label_addLivro.isVisible()) {
            hideAddLivro();

            showMeusLivros();

        } else if (label_tituloBusca.isVisible()) {
            hideBusca();

            showMeusLivros();

        } else {
            hideAddAutor();
            showMeusLivros();
        }

    }
    public void novoAutor() {
        if (label_tituloHome.isVisible()) {
            hideInicio();

            showNovoAutor();
        } else if (label_addLivro.isVisible()) {
            hideAddLivro();


            showNovoAutor();
        } else if (label_tituloBusca.isVisible()) {
            hideBusca();

            showNovoAutor();
        } else if (label_meusLivros.isVisible()) {
            hideMeusLivros();
            showNovoAutor();
        }
    }
    public void addAutor() {
        Autor autor = new Autor(tf_addAutor.getText());
        autorRepository.save(autor);
    }
}
