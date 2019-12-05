package com.example.controlefinanceiro.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controlefinanceiro.MainActivity;
import com.example.controlefinanceiro.R;
import com.example.controlefinanceiro.RecyclerItemClickListener;
import com.example.controlefinanceiro.adapter.AdapterContas;
import com.example.controlefinanceiro.model.Conta;
import com.example.controlefinanceiro.model.Transacao;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerContas;
    private static List<Conta> listaConta = new ArrayList<Conta>();
    private HomeViewModel homeViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        final TextView textView = root.findViewById(R.id.text_home);
        double saldoTotal = 0;

        for (Conta c: listaConta){
           saldoTotal = saldoTotal + c.getSaldo();
        }

        final double saldoT = saldoTotal;


        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                textView.setText("R$ " + saldoT+"0");

            }
        });

        recyclerContas = root.findViewById(R.id.recyclerContas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());


        //adapter
        AdapterContas adapter = new AdapterContas(listaConta);

        recyclerContas.setLayoutManager(layoutManager);
        recyclerContas.setHasFixedSize(true);
        recyclerContas.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerContas.setAdapter(adapter);
        recyclerContas.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getContext(),
                        recyclerContas,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                            }

                            @Override
                            public void onLongItemClick(View view, final int position) {

                                listaConta.remove(position);
                                //Intent i = new Intent(getContext(), MainActivity.class);
                                //startActivity(i);
                                Context contexto = getContext();
                                String texto = "Conta removida, atualize a página para ver";
                                int duracao = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(contexto, texto,duracao);
                                toast.show();


                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
        return root;
    }

    public void criarContas(Conta conta){

        this.listaConta.add(conta);


    }

    public static void decrementarSaldoConta(String conta, double valor){
        for (Conta c: listaConta){
            if(c.getBanco().equals(conta)) {
                double saldo = c.getSaldo();
                double novosaldo = saldo - valor;
                c.setSaldo(novosaldo);
            }
        }
    }

    public static void incrementaSaldoConta(String conta, double valor){
        for (Conta c: listaConta){
            if(c.getBanco().equals(conta)) {
                double saldo = c.getSaldo();
                double novosaldo = saldo + valor;
                c.setSaldo(novosaldo);
            }
        }
    }

    public static List<Conta> getListaContas (){
        return listaConta;
    }
}