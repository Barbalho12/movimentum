package br.ufrn.movimentum.model;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Barreto on 05/12/2017.
 */

public class UserManager implements Serializable {

    private List<User> users;
    private final String fileName = "UserManager_save.txt";


    private User activeUser;

    public UserManager(Context context){
        users = new ArrayList<>();
        try{
            load(context,fileName);
        }catch (Exception erro){

        }
    }


    public boolean addUser(User user, Context context){
        if(!users.contains(user)){
            users.add(user);
            activeUser = user;
            Log.v(TAG, user.getNome()+" Salvo ");
            boolean sucess = save(context, fileName, this);
            return sucess;
        }
        return false;
    }

    public UserManager load(Context context, String fileName) {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            ObjectInputStream is = new ObjectInputStream(fis);
            UserManager userManager = (UserManager) is.readObject();
            this.users = userManager.getUsers();
            this.activeUser = userManager.getActiveUser();
            is.close();
            fis.close();
            Log.v(TAG, "Lido ");
            return userManager;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        Log.v(TAG, "Error leitura");
        return null;
    }

    public void save(Context context) {
        save(context, fileName, this);
    }

    public boolean save(Context context, String fileName, UserManager userManager) {

        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(userManager);
            os.close();
            fos.close();
            Log.v(TAG, "Salvo");
            return true;
        } catch (FileNotFoundException e) {
            Log.v(TAG, "Error salvar");
            e.printStackTrace();
        } catch (IOException e) {
            Log.v(TAG, "Error salvar");
            e.printStackTrace();
        }
        return false;

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setInActiveUser(Context context) {
        this.activeUser = null;
        save(context, fileName, this);
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public boolean requestUser(Context context, String email, String senha) {
        for(User user : users){
            Log.v(TAG, email+"=="+user.getEmail()+", "+senha+"=="+user.getSenha());
            if(user.getEmail().equals(email) && user.getSenha().equals(senha)){
                activeUser = user;
                save(context, fileName, this);
                return true;
            }
        }
        return false;
    }
}
