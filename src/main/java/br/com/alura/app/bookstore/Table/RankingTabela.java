package br.com.alura.app.bookstore.Table;

public class RankingTabela {
    private String nome_ranking;
    private double avaliacao_ranking;

    public RankingTabela(String nome_ranking, double avaliacao_ranking) {
        this.nome_ranking = nome_ranking;
        this.avaliacao_ranking = avaliacao_ranking;
    }

    public String getNome_ranking() {
        return nome_ranking;
    }

    public void setNome_ranking(String nome_ranking) {
        this.nome_ranking = nome_ranking;
    }

    public double getAvaliacao_ranking() {
        return avaliacao_ranking;
    }

    public void setAvaliacao_ranking(double avaliacao_ranking) {
        this.avaliacao_ranking = avaliacao_ranking;
    }
}
