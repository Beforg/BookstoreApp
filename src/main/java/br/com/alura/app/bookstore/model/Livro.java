package br.com.alura.app.bookstore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column
    private double avaliacao;
    private String genero;
    private boolean lido;
    @ManyToOne
    private Autor autor;

    public Livro() {
    }

    public Livro(String titulo, Autor autor, double avaliacao, String genero, boolean lido) {
        this.titulo = titulo;
        this.autor = autor;
        this.avaliacao = avaliacao;
        this.genero = genero;
        this.lido = lido;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getNome_autor() {
        return autor;
    }

    public void setNome_autor(Autor autor) {
        this.autor = autor;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

}
