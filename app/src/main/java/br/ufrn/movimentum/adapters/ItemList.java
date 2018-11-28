package br.ufrn.movimentum.adapters;

/**
 * Created by Barreto on 22/11/2017.
 */

public class ItemList{

    private int id;
    private String nomeExercicio;
    private String quantidade_realizada;
    private String quantidade_total;
    private String pontuacao;

    public ItemList(int id, String nomeExercicio, String quantidade_realizada, String quantidade_total, String pontuacao){
        this.id = id;
        this.nomeExercicio = nomeExercicio;
        this.quantidade_realizada = quantidade_realizada;
        this.quantidade_total = quantidade_total;
        this.pontuacao = pontuacao;
    }

    public int getId() {
        return id;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public String getQuantidade_realizada() {
        return quantidade_realizada;
    }

    public void setQuantidade_realizada(String quantidade_realizada) {
        this.quantidade_realizada = quantidade_realizada;
    }

    public String getQuantidade_total() {
        return quantidade_total;
    }

    public void setQuantidade_total(String quantidade_total) {
        this.quantidade_total = quantidade_total;
    }

    public String getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }
}
