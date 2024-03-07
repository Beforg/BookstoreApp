package br.com.alura.app.bookstore.service;

import br.com.alura.app.bookstore.Table.ConsultaTabela;
import br.com.alura.app.bookstore.controller.InfoScreenController;
import br.com.alura.app.bookstore.model.Autor;
import br.com.alura.app.bookstore.model.Livro;
import br.com.alura.app.bookstore.repository.AutorRepository;
import br.com.alura.app.bookstore.repository.LivroRepository;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.transaction.annotation.Transactional;


public class PersistEConsulta {

    public static void salvarDados(TextField tf_titulo,
                                   TextField tf_avaliacao,
                                   ChoiceBox<Autor> cb_autorAddLivro,
                                   ChoiceBox<String> cb_categoriaAddLivros,
                                   CheckBox box_lido,
                                   LivroRepository livroRepository) {
        if (tf_titulo.getText().isEmpty() || cb_autorAddLivro.getValue() == null || cb_categoriaAddLivros.getValue() == null) {
            InfoScreenController infoScreenController = new InfoScreenController();
            infoScreenController.showInformationMessage("Preencha todos os campos", "Erro", 2,false);
        } else {
            Livro livro = new Livro(tf_titulo.getText(),
                    cb_autorAddLivro.getValue(),
                    tf_avaliacao.getText().replace("","N/A"),
                    cb_categoriaAddLivros.getValue(),
                    box_lido.isSelected());
            tf_titulo.setText("");
            tf_avaliacao.setText("");
            cb_autorAddLivro.setValue(null);
            cb_categoriaAddLivros.setValue(null);
            box_lido.setSelected(false);

            try {
                livroRepository.save(livro);
                InfoScreenController infoScreenController = new InfoScreenController();
                infoScreenController.showInformationMessage("Seu livro foi adicionado com sucesso.", "Livro adicionado", 1,false);

            } catch (Exception e) {
                InfoScreenController infoScreenController = new InfoScreenController();
                infoScreenController.showInformationMessage("Erro ao adicionar livro", "Erro", 2,false);
                throw new RuntimeException(e);
            }
        }


    }
    public static void consultas(ChoiceBox<String> cb_filtro_busca,
                                 ObservableList<ConsultaTabela> tabelaObservable,
                                 TableView<ConsultaTabela> table_busca,
                                 TextField tf_buscadorAutorLivro,
                                 LivroRepository livroRepository,
                                 ChoiceBox<String> cb_categoriaBusca) {
        if (cb_filtro_busca.getValue().contains("Nome")) {
            System.out.println("Buscou por nome");
            tabelaObservable.clear();
            table_busca.getItems().clear();
            if (tf_buscadorAutorLivro.getText().isEmpty()) {
                InfoScreenController infoScreenController = new InfoScreenController();
                infoScreenController.showInformationMessage("Campo de busca vazio", "Erro", 2,false);
            } else {
                ConsultasQuery.buscaPorTitulo(livroRepository, tf_buscadorAutorLivro.getText(), tabelaObservable);
            }
        } else if (cb_filtro_busca.getValue().equals("Autor")) {
            tabelaObservable.clear();
            table_busca.getItems().clear();
            if(tf_buscadorAutorLivro.getText().isEmpty()) {
                InfoScreenController infoScreenController = new InfoScreenController();
                infoScreenController.showInformationMessage("Campo de busca vazio", "Erro", 2,false);
            } else {
                ConsultasQuery.buscaPorAutor(livroRepository, tf_buscadorAutorLivro.getText(), tabelaObservable);

            }
        } else if (cb_filtro_busca.getValue().equals("Avaliação")) {
            tabelaObservable.clear();
            table_busca.getItems().clear();
            ConsultasQuery.buscarPorAvalicao(livroRepository, tabelaObservable, cb_categoriaBusca, tf_buscadorAutorLivro.getText());

        } else if (cb_filtro_busca.getValue().equals("Gênero")) {
            tabelaObservable.clear();
            table_busca.getItems().clear();
            ConsultasQuery.buscaPorGenero(livroRepository, cb_categoriaBusca.getValue(), tabelaObservable);
        } else if (cb_filtro_busca.getValue().equals("Lido")) {
            tabelaObservable.clear();
            table_busca.getItems().clear();
            ConsultasQuery.buscaPorLidos(livroRepository, tabelaObservable,cb_categoriaBusca);
        }
    }
    public static void editarLivro(ChoiceBox<String> cb_selecionaMeuLivro,
                                   TextField tf_titutloEdit,
                                   ChoiceBox<Autor> cb_autorEdit,
                                   ChoiceBox<String> cb_editGenero,
                                   CheckBox lido,
                                   TextField tf_avaliacaoEdit,
                                   LivroRepository livroRepository) {
        if (cb_selecionaMeuLivro.getValue() == null) {
            InfoScreenController infoScreenController = new InfoScreenController();
            infoScreenController.showInformationMessage("Selecione um livro para editar", "Erro", 2,false);
        } else if (tf_titutloEdit.getText().isEmpty() || cb_autorEdit.getValue() == null || cb_editGenero.getValue() == null || tf_avaliacaoEdit.getText().isEmpty()) {
            InfoScreenController infoScreenController = new InfoScreenController();
            infoScreenController.showInformationMessage("Preencha todos os campos", "Erro", 2,false);

        } else {
            Livro livro = livroRepository.findByTitulo(cb_selecionaMeuLivro.getValue());
            livro.setTitulo(tf_titutloEdit.getText());
            livro.setAutor(cb_autorEdit.getValue());
            livro.setGenero(cb_editGenero.getValue());
            livro.setLido(lido.isSelected());
            livro.setAvaliacao(tf_avaliacaoEdit.getText());
            try {
                livroRepository.save(livro);
                InfoScreenController infoScreenController = new InfoScreenController();
                infoScreenController.showInformationMessage("Seu livro foi editado com sucesso.", "Livro editado", 1,false);
            } catch (Exception e) {
                InfoScreenController infoScreenController = new InfoScreenController();
                infoScreenController.showInformationMessage("Erro ao editar livro", "Erro", 2,false);
                throw new RuntimeException(e);
            }


            tf_titutloEdit.setText("");
            cb_autorEdit.setValue(null);
            cb_editGenero.setValue(null);
            lido.setSelected(false);
            tf_avaliacaoEdit.setText("");
        }


    }
    public static void addAutor( ObservableList<Autor> autorObservableList, AutorRepository autorRepository, TextField tf_addAutor) {
        InfoScreenController infoScreenController = new InfoScreenController();
        if(tf_addAutor.getText().isEmpty()) {
            infoScreenController.showInformationMessage("Campo vazio", "Erro", 2,false);
        } else {
            String finalNomeAutor = tf_addAutor.getText();
            boolean autorExiste = autorObservableList.stream()
                    .anyMatch(autor -> autor.getNome().equals(finalNomeAutor));

            if (autorExiste) {
                System.out.println("Autor já existe na lista");
                infoScreenController.showInformationMessage("Autor já existe na lista", "Autor já existe", 2,false);
            } else {
                Autor autor = new Autor(tf_addAutor.getText());

                infoScreenController.showInformationMessage("Autor adicionado com sucesso", "Autor adicionado", 1,false);
                try {
                    autorRepository.save(autor);
                    autorObservableList.clear();
                    autorObservableList.addAll(autorRepository.findAll());
                    InfoScreenController infoScreenController1 = new InfoScreenController();
                    tf_addAutor.setText("");
                    infoScreenController1.showInformationMessage("Autor adicionado com sucesso", "Autor adicionado", 1,false);

                } catch (Exception e) {
                    InfoScreenController infoScreenController1 = new InfoScreenController();
                    infoScreenController1.showInformationMessage("Erro ao adicionar autor", "Erro", 2,false);
                    throw new RuntimeException(e);
                }

            }
        }
    }

    @Transactional
    public void excluirLivro(ChoiceBox<String> cb_selecionaMeuLivro,
                                    TextField tf_titutloEdit,
                                    ChoiceBox<Autor> cb_autorEdit,
                                    ChoiceBox<String> cb_editGenero,
                                    CheckBox lido,
                                    TextField tf_avaliacaoEdit,
                                    LivroRepository livroRepository) {

        if (cb_selecionaMeuLivro.getValue() == null) {
            InfoScreenController infoScreenController = new InfoScreenController();
            infoScreenController.showInformationMessage("Selecione um livro para excluir", "Erro", 2,false);
        } else {

            try {
                Livro livro = livroRepository.findByTitulo(cb_selecionaMeuLivro.getValue());
                if (livro!=null) {
                    livroRepository.deleteByTitulo(cb_selecionaMeuLivro.getValue());
                    InfoScreenController infoScreenController = new InfoScreenController();
                    infoScreenController.showInformationMessage("Seu livro foi excluído com sucesso.", "Livro excluído", 1,false);
                    tf_titutloEdit.setText("");
                    cb_autorEdit.getItems().removeAll();
                    cb_editGenero.setValue(null);
                    cb_selecionaMeuLivro.setValue(null);
                    cb_autorEdit.setValue(null);
                    lido.setSelected(false);
                    tf_avaliacaoEdit.setText("");
                }

            } catch (Exception e) {
                InfoScreenController infoScreenController = new InfoScreenController();
                infoScreenController.showInformationMessage("Erro ao excluir livro", "Erro", 2,false);
                throw new RuntimeException(e);
            }
        }

    }
}
