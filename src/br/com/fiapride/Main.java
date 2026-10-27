package br.com.fiapride;
import br.com.fiapride.model.*;
public class Main { public static void main(String[] args) {
    Passageiro p = new Passageiro(); p.setNome("Ana"); p.setSaldo(50);
    Viagem viagem = new Viagem(p, 15); System.out.println(viagem.resumo());
    System.out.println("Concluída: " + viagem.concluir());
    Veiculo[] frota = { new Carro("Sedan", "ABC1D23", 4), new Moto("City", "DEF2E34", 150) };
    for (Veiculo v : frota) System.out.println(v.getModelo() + ": " + v.calcularAutonomia() + " km");
} }
