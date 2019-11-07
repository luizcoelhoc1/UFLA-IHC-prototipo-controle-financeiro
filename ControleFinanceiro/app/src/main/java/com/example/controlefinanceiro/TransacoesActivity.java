package com.example.controlefinanceiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.controlefinanceiro.model.Conta;
import com.example.controlefinanceiro.model.Transacao;
import com.example.controlefinanceiro.ui.dashboard.DashboardFragment;
import com.example.controlefinanceiro.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class TransacoesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private static final String[] CONTAS = new String[]{"Nubank", "Bradesco"};
    public String tipo;
    private String contaEscolhida;
    private String tipoDespesa = "Despesa";
    private String tipoReceita = "Receita";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transacoes);
        Button save = findViewById(R.id.saveId);

        final Spinner spinner = findViewById(R.id.spinner);
        List<Conta> contas =  HomeFragment.getListaContas();
        List<String> contasNome = new ArrayList<String>();

        for (Conta c: contas){
            contasNome.add(c.getBanco());
        }
        final ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, contasNome);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardFragment df = new DashboardFragment();
                EditText descricao = findViewById(R.id.editTextDescricao);
                String descricaoString = descricao.getText().toString();

                EditText data = findViewById(R.id.editTextData);
                String dataString = data.getText().toString();

                EditText valor = findViewById(R.id.editTextValor);
                String valorString = valor.getText().toString();
                double valorDouble = Double.parseDouble(valorString);

                RadioGroup radioGroup = findViewById(R.id.radioGroup);

                int selectedItemID = radioGroup.getCheckedRadioButtonId();

                if(selectedItemID>0){

                    RadioButton tipoRadio = (RadioButton) findViewById(selectedItemID);
                    tipo = tipoRadio.getText().toString();
                    if(tipo.equals(tipoDespesa)){
                        HomeFragment.decrementarSaldoConta(contaEscolhida, valorDouble);
                    }
                    if(tipo.equals(tipoReceita)){
                        HomeFragment.incrementaSaldoConta(contaEscolhida, valorDouble);
                    }
                }

                Transacao transacao = new Transacao(descricaoString, valorDouble, dataString, tipo, contaEscolhida);
                df.criarTransacoes(transacao);

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        contaEscolhida = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}