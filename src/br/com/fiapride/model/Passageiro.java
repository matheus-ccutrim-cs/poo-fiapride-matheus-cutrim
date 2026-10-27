package br.com.fiapride.model;
public class Passageiro {
    public String nome;
    public double saldo;
    public void adicionarSaldo(double valor) {
        if (!Double.isFinite(valor) || valor <= 0) throw new IllegalArgumentException("Valor deve ser positivo e finito");
        saldo += valor;
    }
    public boolean pagar(double valor) {
        if (!Double.isFinite(valor) || valor <= 0) throw new IllegalArgumentException("Valor inválido");
        if (valor > saldo) return false;
        saldo -= valor; return true;
    }
}
