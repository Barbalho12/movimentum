package br.ufrn.movimentum.adapters;

import android.media.Image;

/**
 * Created by Barreto on 22/11/2017.
 */

public class ItemList{

    private int id;
    private String groupName;
    private String groupLocal;
    private String groupSchedule;
    private String groupTime;
    private String groupPicturePath;

    public ItemList(int id, String groupName, String groupLocal, String groupSchedule, String groupTime, String groupPicturePath){
        this.id = id;
        this.groupName = groupName;
        this.groupLocal = groupLocal;
        this.groupSchedule = groupSchedule;
        this.groupTime = groupTime;
        this.groupPicturePath = groupPicturePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupLocal() {
        return groupLocal;
    }

    public void setGroupLocal(String groupLocal) {
        this.groupLocal = groupLocal;
    }

    public String getGroupSchedule() {
        return groupSchedule;
    }

    public void setGroupSchedule(String groupSchedule) {
        this.groupSchedule = groupSchedule;
    }

    public String getGroupTime() {
        return groupTime;
    }

    public void setGroupTime(String groupTime) {
        this.groupTime = groupTime;
    }

    public String getGroupPicturePath() {
        return groupPicturePath;
    }

    public void setGroupPicture(String groupPicturePath) {
        this.groupPicturePath = groupPicturePath;
    }
}
