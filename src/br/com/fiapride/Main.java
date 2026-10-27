package br.com.fiapride;
import br.com.fiapride.model.*;
public class Main { public static void main(String[] args) {
    Passageiro p = new Passageiro(); p.setNome("Ana"); p.setSaldo(50);
    Viagem viagem = new Viagem(p, 15); System.out.println(viagem.resumo());
    System.out.println("Concluída: " + viagem.concluir());
} }
