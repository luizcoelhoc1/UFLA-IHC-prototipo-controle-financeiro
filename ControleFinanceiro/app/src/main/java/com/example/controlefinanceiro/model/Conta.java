package com.example.controlefinanceiro.model;

public class Conta {
    private String Banco;
    private double Saldo;

    public Conta(String banco, double saldo) {
        Banco = banco;
        Saldo = saldo;
    }

    public String getBanco() {
        return Banco;
    }

    public void setBanco(String banco) {
        Banco = banco;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }
}
