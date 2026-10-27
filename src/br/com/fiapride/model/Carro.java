package br.com.fiapride.model;
public class Carro extends Veiculo {
    private final int portas;
    public Carro(String modelo, String placa, int portas) {
        super(modelo, placa);
        if (portas <= 0) throw new IllegalArgumentException("Valor inválido");
        this.portas = portas;
    }
    @Override public double calcularAutonomia() { return 600; }
    public int getPortas() { return portas; }
}
