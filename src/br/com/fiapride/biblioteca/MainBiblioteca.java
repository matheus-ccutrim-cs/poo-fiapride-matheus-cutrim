package br.com.fiapride.biblioteca;
public class MainBiblioteca {
    public static void main(String[] args) {
        Livro livro = new Livro("Odisseia"); Usuario usuario = new Usuario("Maria");
        Emprestimo emprestimo = new Emprestimo(livro, usuario);
        System.out.println(emprestimo.resumo()); emprestimo.devolver();
        System.out.println(emprestimo.resumo());
    }
}
