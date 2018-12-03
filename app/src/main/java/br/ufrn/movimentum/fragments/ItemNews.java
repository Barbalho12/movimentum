package br.ufrn.movimentum.fragments;

public class ItemNews {
    private int id;
    private String title;
    private String data;
    private String hora;

    public ItemNews(int id, String title, String data, String hora) {
        this.id = id;
        this.title = title;
        this.data = data;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
