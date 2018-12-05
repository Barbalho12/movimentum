package br.ufrn.movimentum.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Barreto on 22/11/2017.
 */

public class Group implements Serializable {

    private int id;
    private String groupName;
    private GroupLocal groupLocal;
    private List<News> listNews;
    private String groupSchedule;
    private String groupTime;
    private String groupPicturePath;
    private String groupDescription;
    private int capacity;

    public Group(int id, String groupName, String groupDescription, GroupLocal groupLocal, int capacity, String groupSchedule, String groupTime, String groupPicturePath){
        this.id = id;
        this.groupName = groupName;
        this.groupLocal = groupLocal;
        this.groupSchedule = groupSchedule;
        this.groupTime = groupTime;
        this.groupPicturePath = groupPicturePath;
        listNews = new ArrayList<>();
        this.capacity = capacity;
        this.groupDescription = groupDescription;
    }


    public void addNews(News news){
        listNews.add(news);

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

    public GroupLocal getGroupLocal() {
        return groupLocal;
    }

    public void setGroupLocal(GroupLocal groupLocal) {
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

    public List<News> getListNews() {
        return listNews;
    }

    public void setListNews(List<News> listNews) {
        this.listNews = listNews;
    }

    public void setGroupPicturePath(String groupPicturePath) {
        this.groupPicturePath = groupPicturePath;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id &&
                Objects.equals(groupName, group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName);
    }
}
