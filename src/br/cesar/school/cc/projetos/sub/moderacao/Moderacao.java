package br.cesar.school.cc.projetos.sub.moderacao;

import br.cesar.school.cc.projetos.sub.legenda.Legenda;
import br.cesar.school.cc.projetos.sub.usuario.Usuario;
import br.cesar.school.cc.projetos.sub.utils.Registro;

public class Moderacao extends Registro {
    private boolean aprovado;
    private String descricao;
    private Legenda legenda;
    private Usuario usuario;

    public Moderacao(Legenda legenda, String descricao, boolean aprovado, Usuario usuario) {
        this.legenda = legenda;
        this.descricao = descricao;
        this.aprovado = aprovado;
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public Legenda getLegenda() {
        return legenda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String gerarIdUnico(){
        return legenda.gerarIdUnico() + this.usuario.getEmail();
    }
}
