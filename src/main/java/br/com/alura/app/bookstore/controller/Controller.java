package br.com.alura.app.bookstore.controller;
import br.com.alura.app.bookstore.Table.ConsultaTabela;
import br.com.alura.app.bookstore.Table.RankingTabela;
import br.com.alura.app.bookstore.model.Autor;
import br.com.alura.app.bookstore.model.Categorias;
import br.com.alura.app.bookstore.repository.AutorRepository;
import br.com.alura.app.bookstore.repository.LivroRepository;
import br.com.alura.app.bookstore.service.PersistEConsulta;
import br.com.alura.app.bookstore.utils.*;
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
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
@Component
public class Controller implements Initializable {
    @FXML
    private CheckBox box_lido, cb_ranking, cb_editLivro,lidoEdit,sobre_livro;
    @FXML
    private GridPane grid_addLivro;
    @FXML
    private FlowPane grid_busca,flowPane_home;
    @FXML
    private ImageView img_busca,img_meusLivros,img_addLivro,img_addAutor;
    @FXML
    private Label label_meusLivros, label_addLivro,label_textoHome,label_tituloBusca,label_tituloHome,label_selecionaCategoria,label_addAutor;
    @FXML
    private ChoiceBox<Autor> cb_autorAddLivro,cb_autorEdit;
    @FXML
    private TableView<ConsultaTabela> table_busca;
    @FXML
    private TextField tf_titulo,tf_buscadorAutorLivro, tf_avaliacao,tf_addAutor,tf_tituloEdit,tf_editAvaliacao;
    @FXML
    private VBox vBox_opMeusLivros,vBox_addAutor,vBox_meusLivros, vBox_editLivro,vBox_pesquisa;
    @FXML
    private ChoiceBox<String> cb_filtro_busca,cb_categoriaBusca,cb_categoriaAddLivros,cb_selecionaMeuLivro,cb_generoEdit,cb_pesquisaEscolha;
    @FXML
    private TableColumn<ConsultaTabela, String> nome, autor, genero, avaliacao;
    @FXML
    private Button botao_pesquisa,bt_editSalvar,botao_excluir;
    @FXML
    private TableView<RankingTabela> table_ranking;
    @FXML
    private TableColumn<RankingTabela, String> nome_ranking, avaliacao_ranking;

    Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/pesquisar.png")));
    /*Consultas ao banco de dados*/
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    /*--------------------------------------*/
    ObservableList<Autor> autorObservableList;
    ObservableList<ConsultaTabela> tabelaObservable = FXCollections.observableArrayList();
    ObservableList<RankingTabela> rankingObservable = FXCollections.observableArrayList();

    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        /*----------------Filtro----------------*/
        if (cb_filtro_busca.getItems().isEmpty()) {
            Filter.filtrosBusca(cb_filtro_busca);
        }
            List<Autor> autores = autorRepository.findAll();
            autorObservableList = FXCollections.observableArrayList(autores);
            cb_autorAddLivro.setItems(autorObservableList);

            for (Categorias s : Categorias.values()) {
                cb_categoriaAddLivros.getItems().add(s.getDescricao());
            }
        Filter.formatTextFieldAvaliacao(tf_avaliacao);
        Filter.formatTextFieldAvaliacao(tf_editAvaliacao);

        Update.updateEditMeusLivros(cb_selecionaMeuLivro, livroRepository);
        Update.updateEditMeusLivros(cb_pesquisaEscolha, livroRepository);
        Update.updateRanking(table_ranking, rankingObservable, livroRepository);


        /*----------Listeners*-----*/
        ListenerBox.listenerBusca(cb_filtro_busca, tf_buscadorAutorLivro, label_selecionaCategoria, cb_categoriaBusca);
        ListenerBox.verificaCheckBoxMeusLivros(sobre_livro, cb_ranking,cb_editLivro,vBox_meusLivros,vBox_editLivro,bt_editSalvar,botao_excluir,vBox_pesquisa);
        ListenerBox.livroSelecionadoEdit(cb_selecionaMeuLivro, tf_tituloEdit, cb_autorEdit, cb_generoEdit, lidoEdit, tf_editAvaliacao, livroRepository);
        ListenerBox.lidoSelected(box_lido,tf_avaliacao);

        /*----------Tabelas-------*/
        TableSet.tabelaBusca(nome, autor, genero, avaliacao);
        TableSet.tabelaRanking(nome_ranking, avaliacao_ranking);
        table_busca.getItems().addAll(tabelaObservable);

        /*-----------Icone Pesquisa-------------*/
        botao_pesquisa.setGraphic(new ImageView(image));


    }
    public void persist() {
        PersistEConsulta.salvarDados(tf_titulo, tf_avaliacao,cb_autorAddLivro,cb_categoriaAddLivros,box_lido,livroRepository);
        initialize(null,null);
    }
    public void consultar() {
        PersistEConsulta.consultas(cb_filtro_busca,tabelaObservable,table_busca,tf_buscadorAutorLivro,livroRepository,cb_categoriaBusca);
        initialize(null,null);
    }
    public void bt_inicio() {
        TransitionMenu.verificaHome(label_addLivro, grid_addLivro, label_tituloBusca, grid_busca, img_busca, table_busca, label_meusLivros, img_meusLivros, vBox_meusLivros, vBox_opMeusLivros, label_addAutor, img_addAutor, vBox_addAutor, label_textoHome, label_tituloHome, flowPane_home, img_addLivro,vBox_editLivro,vBox_pesquisa);
    }
    public void bt_addLivro() {
        TransitionMenu.verificaAddLivro(label_textoHome, label_tituloHome, flowPane_home, label_addLivro, grid_addLivro, img_addLivro, label_tituloBusca, grid_busca, img_busca, table_busca, label_meusLivros, img_meusLivros, vBox_meusLivros, vBox_opMeusLivros, label_addAutor, img_addAutor, vBox_addAutor,vBox_editLivro,vBox_pesquisa);
    }

    public void bt_buscaLivro() {
        TransitionMenu.verificaBuscaLivro(label_textoHome, label_tituloHome, flowPane_home, label_addLivro, grid_addLivro, label_tituloBusca, grid_busca, img_busca, table_busca, label_meusLivros, img_meusLivros, vBox_meusLivros, vBox_opMeusLivros, label_addAutor, img_addAutor, vBox_addAutor, img_addLivro,vBox_editLivro,vBox_pesquisa);
    }
    public void bt_meusLivros() {
        TransitionMenu.verificaMeusLivros(label_textoHome, label_tituloHome, flowPane_home, label_addLivro, grid_addLivro, label_tituloBusca, grid_busca, img_busca, table_busca, label_meusLivros, img_meusLivros, vBox_meusLivros, vBox_opMeusLivros, label_addAutor, img_addAutor, vBox_addAutor, img_addLivro,vBox_editLivro,vBox_pesquisa);
        cb_ranking.setSelected(true);
    }
    public void novoAutor() {
    TransitionMenu.verificaAddAutor(label_textoHome, label_tituloHome, flowPane_home, label_addLivro, grid_addLivro, label_tituloBusca, grid_busca, img_busca, table_busca, label_meusLivros, img_meusLivros, vBox_meusLivros, vBox_opMeusLivros, label_addAutor, img_addAutor, vBox_addAutor, img_addLivro,vBox_editLivro,vBox_pesquisa);
    }
    public void addAutor() {
        PersistEConsulta.addAutor(autorObservableList,autorRepository,tf_addAutor);
    }
    public void editarLivro() {
        PersistEConsulta.editarLivro(cb_selecionaMeuLivro,tf_tituloEdit,cb_autorEdit, cb_generoEdit, lidoEdit, tf_editAvaliacao, livroRepository);
        initialize(null,null);
    }
    public void pesquisarSobre() {

    }

    public void sair() {
        Stage stage = (Stage) botao_excluir.getScene().getWindow();
        stage.close();
    }

    public void excluir() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Excluir Livro");
        alert.setHeaderText("Você tem certeza que deseja excluir o livro?");
        alert.setContentText("Esta ação não poderá ser desfeita");
        alert.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/information.png")))));
        alert.showAndWait();
        alert.getClass().getResource("/style/info_screen.css");
        if (alert.getResult().getButtonData().isDefaultButton()) {
            PersistEConsulta persistEConsulta = new PersistEConsulta();
            persistEConsulta.excluirLivro(cb_selecionaMeuLivro, tf_tituloEdit, cb_autorEdit, cb_generoEdit, lidoEdit, tf_editAvaliacao, livroRepository);
            initialize(null, null);
        }
    }
    public void sobre() {
        Sobre.sobre();
    }
}

