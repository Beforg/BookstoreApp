package br.com.alura.app.bookstore.Table;

public class ConsultaTabela {
    private final String nome;
    private final String autor;
    private final String genero;
    private final double avaliacao;

    public ConsultaTabela(String nome, String autor, String genero, double avaliacao) {
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.avaliacao = avaliacao;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

}
