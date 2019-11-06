package com.example.controlefinanceiro.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.controlefinanceiro.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView nubank = root.findViewById(R.id.nuId);
        final TextView bradesco = root.findViewById(R.id.brid);
        nubank.setText("500");
        bradesco.setText("484");

        final TextView textView = root.findViewById(R.id.text_home);


        final String saldoNubank = nubank.getText().toString();
        final String saldoBradesco = bradesco.getText().toString();

        final Double nSaldoNu = Double.parseDouble(saldoNubank);
        final Double nSaldoBra = Double.parseDouble(saldoBradesco);
        final Double saldototal = nSaldoNu + nSaldoBra;


        final String result = Double.toString(saldototal);

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                nubank.setText("R$ " + saldoNubank+".00");
                bradesco.setText("R$ " + saldoBradesco+".00");
                textView.setText("R$ " + result+"0");

            }
        });
        return root;
    }
}