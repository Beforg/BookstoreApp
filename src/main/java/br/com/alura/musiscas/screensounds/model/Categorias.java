package br.com.alura.musiscas.screensounds.model;

public enum Categorias {
    FANTASIA("Fantasia"),
    TERROR("Terror"),
    ROMANCE("Romance"),
    FICCAO("Ficção"),
    AVENTURA("Aventura"),
    DRAMA("Drama"),
    SUSPENSE("Suspense"),
    AUTOAJUDA("Autoajuda"),
    BIOGRAFIA("Biografia"),
    INFANTIL("Infantil"),
    HISTORIA("História"),
    RELIGIAO("Religião"),
    POLITICA("Política"),
    POLICIAL("Policial"),
    MISTERIO("Mistério"),
    MITOLOGIA("Mitologia"),;

    private final String descricao;

    Categorias(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
