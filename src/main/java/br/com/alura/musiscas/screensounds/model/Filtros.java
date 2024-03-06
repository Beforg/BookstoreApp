package br.com.alura.musiscas.screensounds.model;

public enum Filtros {
    GENERO("Gênero"),
    AVALIACAO("Avaliação"),
    LIDO("Lido"),
    NOME("Nome"),
    AUTOR("Autor");

    private final String descricao;

    Filtros(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
