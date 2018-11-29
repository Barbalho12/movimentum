package br.ufrn.movimentum.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Barreto on 05/12/2017.
 */

public class User implements Serializable {
    private String nome;
    private String email;
    private String role;
    private String senha;
//    private float pontuacao;
    private String nivel;

//    private ArrayList<Integer> exercicios_realizados;
//    private ArrayList<Integer> exercicios_vizualizados;
    private int kanjis_vistos;


    public User(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        nivel = "Iniciante";

//        exercicios_realizados = new ArrayList<>();
//        exercicios_vizualizados = new ArrayList<>();
//        kanjis_vistos = 0;
    }

    public User(String nome, String email, String senha, String role) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        nivel = "Iniciante";
        this.role = role;
    }

    public void addKnjiVisto(){
        kanjis_vistos++;
    }

    public void addExercicios_realizados(Integer exerciceId){
//        if(!exercicios_realizados.contains(exerciceId))
//            exercicios_realizados.add(exerciceId);
    }

//    public void addExercicios_vizualizados(Integer exerciceId){
//        if(!exercicios_vizualizados.contains(exerciceId))
//            exercicios_vizualizados.add(exerciceId);
//    }

//    public int getNumberExercRealizados(){
//        return exercicios_realizados.size();
//    }
//
//    public int getNumberExercVistos(){
//        return exercicios_vizualizados.size();
//    }

//    public ArrayList<Integer> getExercicios_realizados() {
//        return exercicios_realizados;
//    }

//    public void setExercicios_realizados(ArrayList<Integer> exercicios_realizados) {
//        this.exercicios_realizados = exercicios_realizados;
//    }

//    public ArrayList<Integer> getExercicios_vizualizados() {
//        return exercicios_vizualizados;
//    }

//    public void setExercicios_vizualizados(ArrayList<Integer> exercicios_vizualizados) {
//        this.exercicios_vizualizados = exercicios_vizualizados;
//    }

    public int getKanjis_vistos() {
        return kanjis_vistos;
    }

    public void setKanjis_vistos(int kanjis_vistos) {
        this.kanjis_vistos = kanjis_vistos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//    public float getPontuacao() {
//        return pontuacao;
//    }
//
//    public void setPontuacao(float pontuacao) {
//        this.pontuacao = pontuacao;
//    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!nome.equals(user.nome)) return false;
        if (!email.equals(user.email)) return false;
        return senha.equals(user.senha);
    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + senha.hashCode();
        return result;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
