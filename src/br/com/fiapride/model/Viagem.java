package br.com.fiapride.model;
public class Viagem {
    private final Passageiro solicitante;
    private final double valor;
    private boolean concluida;
    public Viagem(Passageiro solicitante, double valor) {
        if (solicitante == null || !Double.isFinite(valor) || valor <= 0) throw new IllegalArgumentException("Viagem inválida");
        this.solicitante = solicitante; this.valor = valor;
    }
    public boolean concluir() {
        if (concluida) throw new IllegalStateException("Viagem já concluída");
        if (!solicitante.pagar(valor)) return false;
        concluida = true; return true;
    }
    public String resumo() { return "Passageiro: " + solicitante.getNome() + ", valor: R$ " + valor; }
}
