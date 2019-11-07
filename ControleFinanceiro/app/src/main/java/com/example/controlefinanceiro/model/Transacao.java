package com.example.controlefinanceiro.model;

import android.widget.EditText;

public class Transacao {
    private String Descricao;
    private Double Valor;
    private String Data;
    private String Tipo;
    private String Conta;


    public Transacao(String descricao, Double valor, String data, String tipo, String conta) {
        Descricao = descricao;
        Valor = valor;
        Data = data;
        Tipo = tipo;
        Conta = conta;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        Valor = valor;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getConta() {
        return Conta;
    }

    public void setConta(String conta) {
        Conta = conta;
    }
}
