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
    
}
