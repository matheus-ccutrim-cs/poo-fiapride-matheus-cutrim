package br.com.fiapride;
import br.com.fiapride.model.Passageiro;
public class Main { public static void main(String[] args) {
    Passageiro p = new Passageiro(); p.nome = "Ana"; p.saldo = 50;
    p.adicionarSaldo(20); System.out.println("Pagamento: " + p.pagar(15));
} }
