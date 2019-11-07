package com.example.controlefinanceiro.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.controlefinanceiro.adapter.AdapterContas;
import com.example.controlefinanceiro.model.Conta;

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

                textView.setText("R$ " + saldoT);

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

        return root;
    }

    public  void criarContas(Conta conta){

        this.listaConta.add(conta);


    }

    public static List<Conta> getListaContas (){
        return listaConta;
    }
}