package br.cesar.school.cc.projetos.sub.filme;

import br.cesar.school.cc.projetos.sub.utils.StringUtils;

public class FilmeMediator {
    private FilmeDAO filmeDAO = new FilmeDAO();
    private static FilmeMediator instancia;

    public static FilmeMediator obterInstancia() {
        if (instancia == null) {
            instancia = new FilmeMediator();
        }
        return instancia;
    }

    public Filme buscar(String idUnico){
        return filmeDAO.buscar(idUnico);
    }

    public String validar(Filme filme){
        if(StringUtils.isVaziaOuNula(filme.getNome())){
            return "Nome do filme Vazio";
        }
        if(filme.getDuracao().isZero() || filme.getDuracao().isNegative()){
            return "Duracao de filme invalida";
        }
        if (StringUtils.isVaziaOuNula(filme.getAutor())){
            return "Autor vazio";
        }
        if (StringUtils.isVaziaOuNula(filme.getReferencia())){
            return "Referencia vazia";
        }
        return null;
    }

    public String incluir(Filme filme){
        String msg = validar(filme);
        if(msg != null){
            if(!filmeDAO.incluir(filme)){
                msg = "Filme ja existe";
            }
        }
        return msg;
    }

    public String alterar(Filme filme){
        String msg = validar(filme);
        if(msg != null){
            if(!filmeDAO.alterar(filme)){
                msg = "Filme não encontrado existe";
            }
        }
        return msg;
    }

    public String excluir(Filme filme){
        String msg = validar(filme);
        if(msg != null){
            if(!filmeDAO.excluir(filme)){
                msg = "Filme nao encontrado";
            }
        }
        return msg;
    }
}
