package com.example.controlefinanceiro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controlefinanceiro.R;
import com.example.controlefinanceiro.model.Conta;

import java.util.List;

public class AdapterContas extends RecyclerView.Adapter<AdapterContas.MyViewHolder> {
    private List<Conta> listaConta;
    public AdapterContas(List<Conta> lista) {
        this.listaConta = lista;
    }

    @NonNull
    public AdapterContas.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista_contas, parent, false );

        return new AdapterContas.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterContas.MyViewHolder holder, int position) {
        Conta conta = listaConta.get(position);
        holder.Banco.setText(conta.getBanco());
        String saldo = Double.toString(conta.getSaldo());
        holder.Saldo.setText("R$ " + saldo + "0" );
    }


    public int getItemCount() {
        return listaConta.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Saldo;
        TextView Banco;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Banco = itemView.findViewById(R.id.textBanco);
            Saldo = itemView.findViewById(R.id.textSaldo);

        }
    }
}

