package br.com.fiapride.model;
public class Passageiro {
    private String nome;
    private double saldo;
    public String getNome() { return nome; }
    public double getSaldo() { return saldo; }
    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome obrigatório");
        this.nome = nome.trim();
    }
    public void setSaldo(double saldo) {
        if (!Double.isFinite(saldo) || saldo < 0) throw new IllegalArgumentException("Saldo inválido");
        this.saldo = saldo;
    }
    public void adicionarSaldo(double valor) {
        if (!Double.isFinite(valor) || valor <= 0 || !Double.isFinite(saldo + valor)) throw new IllegalArgumentException("Valor inválido");
        saldo += valor;
    }
    public boolean pagar(double valor) {
        if (!Double.isFinite(valor) || valor <= 0) throw new IllegalArgumentException("Valor inválido");
        if (valor > saldo) return false;
        saldo -= valor; return true;
    }
}
