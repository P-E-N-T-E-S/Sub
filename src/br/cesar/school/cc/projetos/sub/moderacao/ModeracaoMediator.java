package br.cesar.school.cc.projetos.sub.moderacao;

import br.cesar.school.cc.projetos.sub.usuario.UsuarioMediator;
import br.cesar.school.cc.projetos.sub.utils.StringUtils;

public class ModeracaoMediator {
    private static ModeracaoMediator instance;
    private ModeracaoDAO moderacaoDAO;
    private UsuarioMediator usuarioMediator = UsuarioMediator.obterInstancia();

    public static ModeracaoMediator obterInstancia() {
        if (instance == null) {
            instance = new ModeracaoMediator();
        }
        return instance;
    }

    Moderacao buscar(String idunico){
        return moderacaoDAO.buscar(idunico);
    }

    String validar(Moderacao moderacao){
        if(StringUtils.isVaziaOuNula(moderacao.getDescricao())){
            return "Descricao nao informada";
        }
        String validacaoUsuario = usuarioMediator.validar(moderacao.getUsuario());
        if(!StringUtils.isVaziaOuNula(validacaoUsuario)){
            return validacaoUsuario;
        }
        return null;
    }
}
