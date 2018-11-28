package br.ufrn.movimentum;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import br.ufrn.movimentum.model.User;
import br.ufrn.movimentum.model.UserManager;

public class CadastrarActivity extends AppCompatActivity {

    UserManager userManager;

    TextView tv_cad_nome;
    TextView tv_cad_email;
    TextView tv_cad_password;
    TextView tv_cad_password_confirm;
    Button bt_cad_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);


        tv_cad_nome = (TextView) findViewById(R.id.tv_cad_nome);
        tv_cad_email = (TextView) findViewById(R.id.tv_cad_email);
        tv_cad_password = (TextView) findViewById(R.id.tv_cad_password);
        tv_cad_password_confirm = (TextView) findViewById(R.id.tv_cad_password_confirm);
        bt_cad_cadastrar = (Button) findViewById(R.id.bt_cad_cadastrar);

        userManager = new UserManager(getApplicationContext());

        bt_cad_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = tv_cad_nome.getText().toString();
                String email = tv_cad_email.getText().toString();
                String senha = tv_cad_password.getText().toString();
                String senha_rep = tv_cad_password_confirm.getText().toString();
                if(senha.equals(senha_rep)){
                    boolean sucess = userManager.addUser(new User(nome,email,senha), getApplicationContext());
                    if(sucess){
                        alert("Usuário cadastrado com sucesso!");
                        Intent intent = new Intent(CadastrarActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        alert("Usuário Já existe");
                    }
                }

            }
        });

    }


    void alert(String message){
        AlertDialog alertDialog = new AlertDialog.Builder(CadastrarActivity.this).create();
        alertDialog.setTitle("Alerta");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
