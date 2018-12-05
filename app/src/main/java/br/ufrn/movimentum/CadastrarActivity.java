package br.ufrn.movimentum;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.movimentum.model.User;
import br.ufrn.movimentum.model.UserManager;
import br.ufrn.movimentum.utils.ImageFIle;

public class CadastrarActivity extends AppCompatActivity {

    UserManager userManager;

    TextView tv_cad_nome;
    TextView tv_cad_email;
    TextView tv_cad_password;
    TextView tv_cad_password_confirm;
    Button bt_cad_cadastrar;
    TextView bt_back_cad;

    // Spinner element
    Spinner sp_cad_role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        ImageFIle.verifyStoragePermissions(this);

        tv_cad_nome = (TextView) findViewById(R.id.tv_cad_nome);
        tv_cad_email = (TextView) findViewById(R.id.tv_cad_email);
        tv_cad_password = (TextView) findViewById(R.id.tv_cad_password);
        tv_cad_password_confirm = (TextView) findViewById(R.id.tv_cad_password_confirm);
        bt_cad_cadastrar = (Button) findViewById(R.id.bt_cad_cadastrar);
        bt_back_cad = findViewById(R.id.bt_back_cad);
        sp_cad_role = (Spinner) findViewById(R.id.sp_cad_role);

        userManager = new UserManager(getApplicationContext());

        bt_cad_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = tv_cad_nome.getText().toString();
                String email = tv_cad_email.getText().toString();
                String senha = tv_cad_password.getText().toString();
                String senha_rep = tv_cad_password_confirm.getText().toString();
                String role = sp_cad_role.getSelectedItem().toString();
                if(senha.equals(senha_rep)){

                    boolean sucess = userManager.addUser(new User(nome,email,senha,role), getApplicationContext());
                    if(sucess){
                        sucess = userManager.requestUser(getApplicationContext(), email,senha );
                        if(sucess) {
                            String path = ImageFIle.trySaveImage(nome + userManager.getUsers().size(), getDrawable(R.drawable.boy));
                            Log.i("Details", path);
                            userManager.getActiveUser().setGroupPicturePath(path);
                            userManager.persiste(getApplicationContext());
                            alert("Usuário cadastrado com sucesso!");
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }else{
                        alert("Usuário Já existe");
                    }
                }
            }
        });

        bt_back_cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Estudante");
        categories.add("Professor");
        categories.add("Servidor");
        categories.add("Visitante");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down activity_search_news style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        sp_cad_role.setAdapter(dataAdapter);
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
