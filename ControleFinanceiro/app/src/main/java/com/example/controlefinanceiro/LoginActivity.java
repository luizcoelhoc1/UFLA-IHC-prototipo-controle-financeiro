
package com.example.controlefinanceiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private String strEmail;
    private  String strSenha;
    private  String defaultEmail = "jose.silva@gmail.com";
    private  String defaultSenha = "123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button loginButton = findViewById(R.id.btn_login_id);
        final ImageButton loginFacebook = findViewById(R.id.btn_fb_login);
        final ImageButton loginGoogle = findViewById(R.id.btn_google_login);
        final EditText email = findViewById(R.id.editEmail);
        final EditText senha = findViewById(R.id.editSenha);

        strEmail = email.getText().toString();
        strSenha = senha.getText().toString();
        TextView t = findViewById(R.id.teste);




        loginButton.setOnClickListener(new View.OnClickListener() {
;
            @Override
            public void onClick(View v) {
                    if((defaultEmail.equals(strEmail)) && (defaultSenha.equals(strSenha))){
                        efetuarLogin();
                    }

            }
        });
        loginFacebook.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                efetuarLogin();

            }
        });

        loginGoogle.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
               efetuarLogin();
            }
        });
    }

    public void efetuarLogin(){

        Intent goMain = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(goMain);
    }
}
