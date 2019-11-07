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
import android.widget.Toast;

import com.example.controlefinanceiro.model.Transacao;
import com.example.controlefinanceiro.ui.dashboard.DashboardFragment;

public class TransacoesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private static final String[] CONTAS = new String[]{"Nubank", "Bradesco"};
    public String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transacoes);
        Button save = findViewById(R.id.saveId);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista_contas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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
                }

                Transacao transacao = new Transacao(descricaoString, valorDouble, dataString, tipo);

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}