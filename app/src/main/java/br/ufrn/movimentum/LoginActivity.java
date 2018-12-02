package br.ufrn.movimentum;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import br.ufrn.movimentum.model.UserManager;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity /*implements LoaderCallbacks<Cursor>*/ {


    private EditText mEmailView;
    private EditText mPasswordView;

    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        userManager = new UserManager(getApplicationContext());


        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.email);
//        populateAutoComplete();

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
//                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
//                attemptLogin();
                String email = mEmailView.getText().toString();
                String senha = mPasswordView.getText().toString();
                boolean sucess = userManager.requestUser(getApplicationContext(), email,senha );
                if(sucess){
//                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(intent);
//                    finish();


                    Intent intent = new Intent(getApplicationContext(), InicialAllActivity.class);
                    startActivity(intent);
                    finish();

                }else{
                    alert("Email ou senha estão incorretos, tente novamente!");
                }
            }
        });

        TextView tv_log_esq_senha = findViewById(R.id.tv_log_esq_senha);
        tv_log_esq_senha.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Não implementado", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView bt_cadastrar = (TextView) findViewById(R.id.bt_cadastrar);
        bt_cadastrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastrarActivity.class);
                startActivity(intent);
//                finish();
            }
        });

    }

    void alert(String message){
        AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
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

    @Override
    public void onBackPressed() {
        finish();
    }
}

