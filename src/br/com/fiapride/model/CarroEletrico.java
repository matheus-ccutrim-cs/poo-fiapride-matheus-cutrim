package br.com.fiapride.model;
public class CarroEletrico extends Veiculo implements Recarregavel {
    private int carga;
    public CarroEletrico(String modelo, String placa, int carga) {
        super(modelo, placa);
        if (carga < 0 || carga > CARGA_MAXIMA) throw new IllegalArgumentException("Carga inválida");
        this.carga = carga;
    }
    public int getCarga() { return carga; }
    @Override public void recarregar(int percentual) {
        if (percentual <= 0 || percentual > CARGA_MAXIMA - carga) throw new IllegalArgumentException("Carga fora do limite");
        carga += percentual;
    }
    @Override public double calcularAutonomia() { return carga * 4.0; }
}
