package br.cesar.school.cc.projetos.sub.cursor;

import br.cesar.school.cc.projetos.sub.legenda.Legenda;
import br.cesar.school.cc.projetos.sub.utils.Registro;

public class Cursor extends Registro {
    private int posicao;
    private Legenda arquivo;
    public Cursor(int posicao, Legenda arquivo) {
        this.posicao = posicao;
        this.arquivo = arquivo;
    }
    public int getPosicao() {
        return posicao;
    }
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    public String gerarIdUnico(){
        return this.arquivo.gerarIdUnico() + "cursor";
    }
}
