package br.com.alura.musiscas.screensounds.Table;

public class RankingTabela {
    private String nome_ranking;
    private String avaliacao_ranking;

    public RankingTabela(String nome_ranking, String avaliacao_ranking) {
        this.nome_ranking = nome_ranking;
        this.avaliacao_ranking = avaliacao_ranking;
    }

    public String getNome_ranking() {
        return nome_ranking;
    }

    public void setNome_ranking(String nome_ranking) {
        this.nome_ranking = nome_ranking;
    }

    public String getAvaliacao_ranking() {
        return avaliacao_ranking;
    }

    public void setAvaliacao_ranking(String avaliacao_ranking) {
        this.avaliacao_ranking = avaliacao_ranking;
    }
}
