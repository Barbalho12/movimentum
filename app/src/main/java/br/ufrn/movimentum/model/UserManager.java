package br.ufrn.movimentum.model;

import android.content.Context;
import android.util.Log;

import java.io.File;
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
    private List<Group> groups;
    private List<GlobalNews> globalNews;
    private final String fileName = "UserManager_save.txt";

    private User activeUser;
    private Group activeGroup;

    public UserManager(Context context){
        users = new ArrayList<>();
        groups = new ArrayList<>();
        globalNews = new ArrayList<>();
        try{
            load(context,fileName);
        }catch (Exception erro){

        }
    }

    public boolean addGroup(Group group, Context context){
        if(!groups.contains(group)){
            groups.add(group);
            activeUser.addGroup(group);

//            activeUser = user;
            Log.v(TAG, group.getGroupName()+" Salvo ");
            boolean sucess = save(context, fileName, this);
            return sucess;
        }
        return false;
    }


    public boolean addUser(User user, Context context){
        if(!users.contains(user)){

            users.add(user);
//            activeUser = user;
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
            this.groups = userManager.getGroups();
            this.activeUser = userManager.getActiveUser();
            this.globalNews = userManager.getGlobalNews();
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

    public boolean persiste(Context context) {
        try {
            boolean sucess = save(context, fileName, this);
            return sucess;
       } catch (Exception e) {
            Log.v(TAG, "Error salvar");
            e.printStackTrace();
        }
        return false;

    }

    public boolean isStart(){
        File file = new File(fileName);
        return file.exists();
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

    public void setInActiveUser(Context context) {
        this.activeUser = null;
        save(context, fileName, this);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getActiveUser() {
        return activeUser;
    }



    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public List<User> userInGroup(Group group){
        List<User> usGrs = new ArrayList<>();
        for(User u: users){
            if(u.getGroups().contains(group)){
                usGrs.add(u);
            }
        }
        return usGrs;
    }


    public List<GlobalNews> getGlobalNews() {
        return globalNews;
    }

    public void setGlobalNews(List<GlobalNews> globalNews) {
        this.globalNews = globalNews;
    }

    public Group getActiveGroup() {
        return activeGroup;
    }

    public void setActiveGroup(Group activeGroup) {
        this.activeGroup = activeGroup;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
