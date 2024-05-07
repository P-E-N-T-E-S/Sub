package br.cesar.school.cc.projetos.sub.usuario;

import br.cesar.school.cc.projetos.sub.legenda.Legenda;
import br.cesar.school.cc.projetos.sub.utils.Registro;

public class Usuario extends Registro {
    private String nome;
    private String email;
    private String senha;
    private boolean moderador;
    private Legenda[] legendas;

    public Usuario(String nome, String email, String senha, boolean moderador) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.moderador = moderador;
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

    public boolean isModerador() {
        return moderador;
    }

    public void setModerador(boolean moderador) {
        this.moderador = moderador;
    }

    public String getSenha() {
        return senha;
    }

    public Legenda[] getLegendas() {
        return legendas;
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

    public String gerarIdUnico(){
        return this.email;
    }
}
