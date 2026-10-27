package br.com.fiapride;
import br.com.fiapride.model.Passageiro;
public class Main { public static void main(String[] args) {
    Passageiro p = new Passageiro(); p.setNome("Ana"); p.setSaldo(50);
    p.adicionarSaldo(20); System.out.println(p.getNome() + " pagou: " + p.pagar(15));
} }
