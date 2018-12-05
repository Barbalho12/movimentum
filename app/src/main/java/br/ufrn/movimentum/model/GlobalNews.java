package br.ufrn.movimentum.model;

import java.io.Serializable;

public class GlobalNews extends News implements Serializable  {

    private String groupPicturePath;

    public GlobalNews(int id, String title, String date, String time, String groupPicturePath) {
        super(id, title, date, time);
        this.groupPicturePath = groupPicturePath;
    }

//    public GlobalNews(String id, String title, String description, String date, String time, ) {
//        super(id, title, description, date, time);
//    }

    public String getGroupPicturePath() {
        return groupPicturePath;
    }

    public void setGroupPicturePath(String groupPicturePath) {
        this.groupPicturePath = groupPicturePath;
    }

//    private String title;
//    private String description;
//    private String date;
//    private String time;

//    public GlobalNews(String title, String date, String time) {
//        this.title = title;
//        this.date = date;
//        this.time = time;
//    }
//
//    public GlobalNews(String title, String description, String date, String time) {
//        this.title = title;
//        this.description = description;
//        this.date = date;
//        this.time = time;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
}
