package com.example.controlefinanceiro.model;

import android.widget.EditText;

public class Transacao {
    private String Descricao;
    private Double Valor;
    private String Data;
    private String Tipo;


    public Transacao(String descricao, Double valor, String data, String tipo) {
        Descricao = descricao;
        Valor = valor;
        Data = data;
        Tipo = tipo;
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
}
