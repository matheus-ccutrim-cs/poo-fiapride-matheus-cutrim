package br.com.fiapride.biblioteca;
public class Usuario {
    private final String nome;
    public Usuario(String nome) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome obrigatório");
        this.nome = nome.trim();
    }
    public String getNome() { return nome; }
}
