package br.com.fiapride.biblioteca;
public class Emprestimo {
    private final Livro livro;
    private final Usuario usuario;
    private boolean ativo = true;
    public Emprestimo(Livro livro, Usuario usuario) {
        if (livro == null || usuario == null) throw new IllegalArgumentException("Livro e usuário são obrigatórios");
        livro.emprestar(); this.livro = livro; this.usuario = usuario;
    }
    public void devolver() {
        if (!ativo) throw new IllegalStateException("Empréstimo já encerrado");
        livro.devolver(); ativo = false;
    }
    public String resumo() { return usuario.getNome() + " - " + livro.getTitulo() + " - " + (ativo ? "ativo" : "devolvido"); }
}
