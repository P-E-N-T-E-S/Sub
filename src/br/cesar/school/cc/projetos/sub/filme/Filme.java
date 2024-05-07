package br.cesar.school.cc.projetos.sub.filme;

import br.cesar.school.cc.projetos.sub.legenda.Legenda;
import br.cesar.school.cc.projetos.sub.utils.Registro;

import java.time.Duration;

public class Filme extends Registro {
    private String nome;
    private Duration duracao;
    private String autor;
    private String referencia; //lugar que ele ta guardado
    private Legenda[] legendas;

    public Filme(String nome, String autor, Duration duracao, String referencia) {
        this.nome = nome;
        this.autor = autor;
        this.duracao = duracao;
        this.referencia = referencia;
    }

    public String getNome() {
        return nome;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public String getAutor() {
        return autor;
    }
    public String getReferencia() {
        return referencia;
    }

    public Legenda[] getLegendas() {
        return this.legendas;
    }

    public void addLegendas(Legenda legenda) {
        if (this.legendas == null) {
            this.legendas = new Legenda[2];
        }else{
            Legenda[] legendaaux = this.legendas;
            this.legendas = new Legenda[this.legendas.length + 1];
            System.arraycopy(legendaaux, 0, this.legendas, 0, this.legendas.length);
        }
    }

    public String gerarID(){
        return this.nome + this.autor + this.referencia;
    }
}
