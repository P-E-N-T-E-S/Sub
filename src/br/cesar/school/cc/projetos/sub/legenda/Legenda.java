package br.cesar.school.cc.projetos.sub.legenda;

import br.cesar.school.cc.projetos.sub.corpo.CorpoTexto;
import br.cesar.school.cc.projetos.sub.filme.Filme;
import br.cesar.school.cc.projetos.sub.moderacao.Moderacao;
import br.cesar.school.cc.projetos.sub.utils.Registro;
import br.cesar.school.cc.projetos.sub.usuario.Usuario;
import br.cesar.school.cc.projetos.sub.cursor.Cursor;

import java.awt.*;
import java.time.LocalDateTime;

public class Legenda extends Registro {
    private String nomeArquivo;
    private String caminhoArquivo;
    private LocalDateTime ultimaEdicao;
    private Cursor ponteiro;
    private Filme filme;
    private CorpoTexto arquivo;
    private Moderacao[] moderacoes;
    private Usuario usuario;

    public Legenda(String nomeArquivo, String caminhoArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.caminhoArquivo = caminhoArquivo;
        this.ultimaEdicao = LocalDateTime.now();
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public LocalDateTime getUltimaEdicao() {
        return ultimaEdicao;
    }

    public void setUltimaEdicao(LocalDateTime ultimaEdicao) {
        this.ultimaEdicao = ultimaEdicao;
    }

    public Cursor getPonteiro() {
        return ponteiro;
    }

    public void setPonteiro(Cursor ponteiro) {
        this.ponteiro = ponteiro;
    }

    public Filme getFilme(){
        return filme;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Moderacao[] getModeracoes(){
        return moderacoes;
    }
}
