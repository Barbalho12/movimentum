package br.ufrn.movimentum.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String nome;
    private String email;
    private String role;
    private String senha;
    private List<Group> groups;


    public User(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.groups = new ArrayList<>();
    }

    public User(String nome, String email, String senha, String role) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.groups = new ArrayList<>();
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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }
}
