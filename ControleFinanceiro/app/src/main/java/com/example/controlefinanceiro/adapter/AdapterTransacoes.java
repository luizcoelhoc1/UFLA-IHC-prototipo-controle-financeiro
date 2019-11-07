package com.example.controlefinanceiro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controlefinanceiro.R;
import com.example.controlefinanceiro.model.Transacao;

import java.util.List;

public class AdapterTransacoes extends RecyclerView.Adapter<AdapterTransacoes.MyViewHolder> {
    private  List<Transacao> listaTransacao;

    public AdapterTransacoes(List<Transacao> lista) {
        this.listaTransacao = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista_transacoes, parent, false );

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Transacao transacao = listaTransacao.get(position);
        holder.Tipo.setText(transacao.getTipo());
        String valor = Double.toString(transacao.getValor());
        holder.Valor.setText("R$ " + valor + "0");
        holder.Descricao.setText(transacao.getDescricao());
        holder.Data.setText(transacao.getData());
        holder.Conta.setText(transacao.getConta());
    }

    @Override
    public int getItemCount() {
        return listaTransacao.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Descricao;
        TextView Valor;
        TextView Data;
        TextView Tipo;
        TextView Conta;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Descricao = itemView.findViewById(R.id.textDescricao);
            Valor = itemView.findViewById(R.id.textValor);
            Data = itemView.findViewById(R.id.textData);
            Tipo = itemView.findViewById(R.id.textTipo);
            Conta = itemView.findViewById(R.id.textConta);
        }
    }
}
