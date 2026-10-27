package br.com.fiapride.model;
public class Veiculo {
    private final String modelo;
    private String placa;
    public Veiculo() { this("Modelo não informado", "ABC1D23"); }
    public Veiculo(String modelo, String placa) {
        if (modelo == null || modelo.isBlank()) throw new IllegalArgumentException("Modelo obrigatório");
        this.modelo = modelo.trim(); setPlaca(placa);
    }
    private void setPlaca(String placa) {
        if (placa == null || !placa.toUpperCase().matches("[A-Z]{3}[0-9][A-Z0-9][0-9]{2}")) throw new IllegalArgumentException("Placa inválida");
        this.placa = placa.toUpperCase();
    }
    public void atualizarPlaca(String placa) { setPlaca(placa); }
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
}
