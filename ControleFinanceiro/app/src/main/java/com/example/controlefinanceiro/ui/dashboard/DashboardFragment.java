package com.example.controlefinanceiro.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controlefinanceiro.R;
import com.example.controlefinanceiro.TransacoesActivity;
import com.example.controlefinanceiro.adapter.AdapterTransacoes;
import com.example.controlefinanceiro.model.Transacao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {
    private RecyclerView recyclerTransacoes;
    private DashboardViewModel dashboardViewModel;
    private List<Transacao> listaTransacao = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        final TextView textView = root.findViewById(R.id.text_dashboard);
        final FloatingActionButton add = root.findViewById(R.id.float_button);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        recyclerTransacoes = root.findViewById(R.id.recyclerTransacoes);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        //criar transacoes

        this.criarTransacoes();
        //adapter
        AdapterTransacoes adapter = new AdapterTransacoes(listaTransacao);

        recyclerTransacoes.setLayoutManager(layoutManager);
        recyclerTransacoes.setHasFixedSize(true);
        recyclerTransacoes.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerTransacoes.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TransacoesActivity.class);
                startActivity(i);
            }
        });


        return root;
    }

    public  void criarTransacoes(){
        Transacao transacao = new Transacao("Almoço", 15.00, "15/10/2019", "Despesa" );
        this.listaTransacao.add(transacao);
        transacao = new Transacao("Almoço", 15.00, "15/10/2019", "Despesa" );
        this.listaTransacao.add(transacao);
        transacao = new Transacao("Almoço", 15.00, "15/10/2019", "Despesa" );
        this.listaTransacao.add(transacao);
        transacao = new Transacao("Almoço", 15.00, "15/10/2019", "Despesa" );
        this.listaTransacao.add(transacao);
        transacao = new Transacao("Almoço", 15.00, "15/10/2019", "Despesa" );
        this.listaTransacao.add(transacao);
        transacao = new Transacao("Almoço", 15.00, "15/10/2019", "Despesa" );
        this.listaTransacao.add(transacao);
        transacao = new Transacao("Almoço", 15.00, "15/10/2019", "Despesa" );
        this.listaTransacao.add(transacao);
        transacao = new Transacao("Almoço", 15.00, "15/10/2019", "Despesa" );
        this.listaTransacao.add(transacao);
        transacao = new Transacao("Almoço", 15.00, "15/10/2019", "Despesa" );
        this.listaTransacao.add(transacao);transacao = new Transacao("Almoço", 15.00, "15/10/2019", "Despesa" );
        this.listaTransacao.add(transacao);transacao = new Transacao("Almoço", 15.00, "15/10/2019", "Despesa" );
        this.listaTransacao.add(transacao);transacao = new Transacao("Almoço", 15.00, "15/10/2019", "Despesa" );
        this.listaTransacao.add(transacao);
        transacao = new Transacao("Almoço", 15.00, "15/10/2019", "Despesa" );
        this.listaTransacao.add(transacao);




    }
}