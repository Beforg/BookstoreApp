package br.com.alura.musiscas.screensounds.model;
import jakarta.persistence.*;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String url;
    private String imagem;

    public Artista() {
    }

    public Artista(String nome, String url, String imagem) {
        this.nome = nome;
        this.url = url;
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUrl() {
        return url;
    }

    public String getImagem() {
        return imagem;
    }

}
