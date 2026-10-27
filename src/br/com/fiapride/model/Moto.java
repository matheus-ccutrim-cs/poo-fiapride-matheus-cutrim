package br.com.fiapride.model;
public class Moto extends Veiculo {
    private final int cilindradas;
    public Moto(String modelo, String placa, int cilindradas) {
        super(modelo, placa);
        if (cilindradas <= 0) throw new IllegalArgumentException("Valor inválido");
        this.cilindradas = cilindradas;
    }
    @Override public double calcularAutonomia() { return 350; }
    public int getCilindradas() { return cilindradas; }
}
