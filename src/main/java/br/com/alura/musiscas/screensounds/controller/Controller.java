package br.com.alura.musiscas.screensounds.controller;
import br.com.alura.musiscas.screensounds.Table.ConsultaTabela;
import br.com.alura.musiscas.screensounds.Table.RankingTabela;
import br.com.alura.musiscas.screensounds.model.Autor;
import br.com.alura.musiscas.screensounds.model.Categorias;
import br.com.alura.musiscas.screensounds.repository.AutorRepository;
import br.com.alura.musiscas.screensounds.repository.LivroRepository;
import br.com.alura.musiscas.screensounds.service.ConsultasQuery;
import br.com.alura.musiscas.screensounds.service.PersistEConsulta;
import br.com.alura.musiscas.screensounds.utils.*;
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
    private CheckBox box_lido, cb_ranking, cb_editLivro;
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
    private VBox vBox_opMeusLivros,vBox_addAutor,vBox_meusLivros, vBox_editLivro;
    @FXML
    private ChoiceBox<String> cb_filtro_busca,cb_categoriaBusca,cb_categoriaAddLivros;
    @FXML
    private TableColumn<ConsultaTabela, String> nome, autor, genero, avaliacao;
    @FXML
    private Button botao_pesquisa;
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
        if (cb_filtro_busca.getItems().isEmpty()) {
            Filter.filtrosBusca(cb_filtro_busca);
        }
            List<Autor> autores = autorRepository.findAll();
            autorObservableList = FXCollections.observableArrayList(autores);
            cb_autorAddLivro.setItems(autorObservableList);

            for (Categorias s : Categorias.values()) {
                cb_categoriaAddLivros.getItems().add(s.getDescricao());
            }

        /*----------Listeners*-----*/
        ListenerBox.listenerBusca(cb_filtro_busca, tf_buscadorAutorLivro, label_selecionaCategoria, cb_categoriaBusca);
        ListenerBox.verificaCheckBoxMeusLivros(cb_ranking, cb_editLivro,vBox_editLivro, vBox_meusLivros );

        /*----------Tabelas-------*/
        TableSet.tabelaBusca(nome, autor, genero, avaliacao);
        table_busca.getItems().addAll(tabelaObservable);
        if (rankingObservable.isEmpty()) {
            TableSet.tabelaRanking(nome_ranking, avaliacao_ranking);
            ConsultasQuery.buscaPorRanking(livroRepository, rankingObservable);
            table_ranking.getItems().addAll(rankingObservable);
        }

        /*------------------------*/
        botao_pesquisa.setGraphic(new ImageView(image));


    }
    public void persist() {
        PersistEConsulta.salvarDados(tf_titulo, tf_avaliacao,cb_autorAddLivro,cb_categoriaAddLivros,box_lido,livroRepository);
    }
    public void consultar() {
        PersistEConsulta.consultas(cb_filtro_busca,tabelaObservable,table_busca,tf_buscadorAutorLivro,livroRepository,cb_categoriaBusca);
        initialize(null,null);
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
