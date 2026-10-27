package br.com.fiapride;
import br.com.fiapride.model.Passageiro;
public class Main { public static void main(String[] args) {
    Passageiro p = new Passageiro(); p.nome = "Ana"; p.saldo = 50;
    System.out.println(p.nome + ": " + p.saldo);
} }
