package br.ufrn.movimentum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.ufrn.movimentum.model.UserManager;

public class StartActivity extends AppCompatActivity {

    void verifySession(){
        UserManager userManager = new UserManager(getApplicationContext());
        if(userManager.getActiveUser() != null){
            Intent intent = new Intent(getApplicationContext(), InicialAllActivity.class);
            startActivity(intent);
            finish();
        }else{
            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

//    void verifySession(){
//        UserManager userManager = new UserManager(getApplicationContext());
//        if(userManager.getActiveUser() != null){
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//            finish();
//        }else{
//            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
//            startActivity(intent);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        verifySession();
        super.onCreate(savedInstanceState);
    }
}
