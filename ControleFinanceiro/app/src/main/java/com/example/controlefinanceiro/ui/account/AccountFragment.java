package com.example.controlefinanceiro.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.controlefinanceiro.MainActivity;
import com.example.controlefinanceiro.R;
import com.example.controlefinanceiro.model.Conta;
import com.example.controlefinanceiro.ui.dashboard.DashboardFragment;
import com.example.controlefinanceiro.ui.home.HomeFragment;

public class AccountFragment extends Fragment {

    private AccountViewModel accountViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModel = ViewModelProviders.of(this).get(AccountViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_account, container, false);
        final TextView textView = root.findViewById(R.id.text_account);

        final Button save = root.findViewById(R.id.saveId);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment hf = new HomeFragment();
                EditText banco = root.findViewById(R.id.editBanco);
                EditText saldo = root.findViewById(R.id.editSaldo);

                String bancoString = banco.getText().toString();
                String saldoString = saldo.getText().toString();
                double saldoDouble = Double.parseDouble(saldoString);

                Conta conta = new Conta(bancoString, saldoDouble);
                hf.criarContas(conta);
                Intent i = new Intent(getContext(), MainActivity.class);
                startActivity(i);

            }
        });
        accountViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}