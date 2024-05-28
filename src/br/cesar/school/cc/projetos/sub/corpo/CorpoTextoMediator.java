package br.cesar.school.cc.projetos.sub.corpo;

import br.cesar.school.cc.projetos.sub.legenda.LegendaMediator;

public class CorpoTextoMediator {
    CorpoTextoDAO corpoTextoDAO = new CorpoTextoDAO();
    private static CorpoTextoMediator instancia;
    private LegendaMediator legendaMediator = LegendaMediator.obterInstancia();

    public static CorpoTextoMediator obterInstancia(){
        if(instancia == null){
            instancia = new CorpoTextoMediator();
        }
            return instancia;
    }
    public CorpoTexto buscar(String idUnico){
        return corpoTextoDAO.buscar(idUnico);
    }
    String validar(CorpoTexto corpoTexto){
        if(corpoTexto.getTexto() == null){
            return "Texto vazio";
        }
        if(corpoTexto.getFonte() == null){
            return "Fonte invalida";
        }
        if(corpoTexto.getTamanho() < 0){
            return "Tamanho invalido";
        }
        return null;
    }
    public String incluir(CorpoTexto texto){
        String msg = validar(texto);
        if(msg == null){
            if(!corpoTextoDAO.incluir(texto)){
                msg = "Corpo ja existente";
            }
        }
        return msg;
    }

    public String alterar(CorpoTexto texto){
        String msg = validar(texto);
        if(msg == null){
            if(!corpoTextoDAO.alterar(texto)){
                msg = "Corpo nao existente";
            }
        }
        return msg;
    }

    public String excluir(CorpoTexto texto){
        String msg = validar(texto);
        if(msg == null){
            if(!corpoTextoDAO.excluir(texto)){
                msg = "Corpo nao existente";
            }
        }
        return msg;
    }
}