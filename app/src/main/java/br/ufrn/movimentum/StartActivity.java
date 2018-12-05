package br.ufrn.movimentum;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.movimentum.model.Group;
import br.ufrn.movimentum.model.GroupLocal;
import br.ufrn.movimentum.model.User;
import br.ufrn.movimentum.model.UserManager;
import br.ufrn.movimentum.utils.ImageFIle;

public class StartActivity extends AppCompatActivity {


    UserManager userManager;

    private String saveAndGetPath(String name, int ir) {
        String path = ImageFIle.trySaveImage(name + userManager.getUsers().size(), getDrawable(ir));
        return path;
    }

    void verifySession() {

        if (userManager.getActiveUser() != null) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        } else if (!userManager.isStart()) {


            User user1 = new User("Felipe", "felipe@mail.com", "123", "Estudante", saveAndGetPath("Felipe", R.drawable.boy1));
            User user2 = new User("José", "j@mail.com", "123", "Professor", saveAndGetPath("jose", R.drawable.boy2));
            User user3 = new User("Luis", "l@mail.com", "123", "Estudante", saveAndGetPath("luis", R.drawable.boy3));
            User user4 = new User("Marcos", "m@mail.com", "123", "Estudante", saveAndGetPath("marcos", R.drawable.boy4));

            List<Group> list_itens = new ArrayList<>();

            String pathName = "android.resource://" + getPackageName() + "/";
            list_itens.add(new Group(1, "Corrida Livre", "Grupo para praticar corrida para melhorar o condicionamento físico.", new GroupLocal("Em torno da UFRN"), 20, "qui,sex", "18h00-19h00", pathName + R.drawable.running_group));
            list_itens.add(new Group(2, "Natação 2", "Grupo para praticar diferente estilos de nado com orientaçã.o", new GroupLocal("UFRN - Piscina 2"), 20, "seg,qua", "08h00-09h00", pathName + R.drawable.swimming_group));
            list_itens.add(new Group(3, "Time de Atletismo", "Grupo formado pelo Time de atletismo da UFRN.", new GroupLocal("UFRN - Pista de Atletismo"), 20, "seg,qua,sex", "17h00-18h30", pathName + R.drawable.atletism_group));
            list_itens.add(new Group(6, "Futsal C&T", "Grupo de futsal descontraído de alunos da ECT.", new GroupLocal("UFRN - Ginásio 2"), 20, "ter", "08h00-10h00", pathName + R.drawable.group_futsal_cet));
            list_itens.add(new Group(4, "Hidroginástica 3° Idade", "Prática de hidroginástica para manutenção da saúde de idosos.", new GroupLocal("UFRN - Piscina 2"), 20, "seg,qua", "16h00-17h00", pathName + R.drawable.group_hidro));
            list_itens.add(new Group(5, "Time Futsal UFRN", "Grupo formado por atletas do time de futsal da UFRN", new GroupLocal("UFRN - Ginásio 1"), 20, "seg,qua,sex", "18h00-19h30", pathName + R.drawable.group_futsal));
            list_itens.add(new Group(7, "Treino Karate", "Clube para prática de karate.", new GroupLocal("UFRN - Ginásio 1"), 20, "qua,sex", "20h00-21h00", pathName + R.drawable.group_karate));
            list_itens.add(new Group(8, "Preparatório Maratona", "Clube de alunos e servidores para preparação para maratonas ao longo do ano.", new GroupLocal("Em torno da UFRN"), 20, "seg,qua,sex", "07h00-08h30", pathName + R.drawable.group_maratona));

            user1.addGroup(list_itens.get(0));
            user1.addGroup(list_itens.get(1));
            user1.addGroup(list_itens.get(2));
            user1.addGroup(list_itens.get(3));

            user2.addGroup(list_itens.get(0));
            user3.addGroup(list_itens.get(0));
            user4.addGroup(list_itens.get(0));

            userManager.setGroups(list_itens);
            userManager.addUser(user1, getApplicationContext());
            userManager.addUser(user2, getApplicationContext());
            userManager.addUser(user3, getApplicationContext());
            userManager.addUser(user4, getApplicationContext());
            userManager.persiste(getApplicationContext());


            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        } else {
            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }


    public void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    ImageFIle.PERMISSIONS_STORAGE,
                    ImageFIle.REQUEST_EXTERNAL_STORAGE
            );
        } else {

            if (userManager.getActiveUser() != null) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
            verifySession();

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

        userManager = new UserManager(getApplicationContext());
        verifyStoragePermissions(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



    }


}
