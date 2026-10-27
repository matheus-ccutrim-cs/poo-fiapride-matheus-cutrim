package br.com.fiapride.biblioteca;
public class Livro {
    private final String titulo;
    private boolean disponivel = true;
    public Livro(String titulo) {
        if (titulo == null || titulo.isBlank()) throw new IllegalArgumentException("Título obrigatório");
        this.titulo = titulo.trim();
    }
    public String getTitulo() { return titulo; }
    public boolean isDisponivel() { return disponivel; }
    void emprestar() { if (!disponivel) throw new IllegalStateException("Livro indisponível"); disponivel = false; }
    void devolver() { disponivel = true; }
}
