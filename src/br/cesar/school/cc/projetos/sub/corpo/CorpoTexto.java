package br.cesar.school.cc.projetos.sub.corpo;

import br.cesar.school.cc.projetos.sub.legenda.Legenda;
import br.cesar.school.cc.projetos.sub.utils.Registro;

public class CorpoTexto extends Registro {
    private String texto;
    private String fonte;
    private int tamanho;
    private Legenda arquivo;

    public CorpoTexto(String texto, String fonte, int tamanho, Legenda arquivo) {
        this.texto = texto;
        this.fonte = fonte;
        this.tamanho = tamanho;
        this.arquivo = arquivo;
    }

    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getFonte() {
        return fonte;
    }
    public void setFonte(String fonte) {
        this.fonte = fonte;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public String gerarIdUnico() {
        return arquivo.gerarIdUnico() + "corpo";
    }
}
