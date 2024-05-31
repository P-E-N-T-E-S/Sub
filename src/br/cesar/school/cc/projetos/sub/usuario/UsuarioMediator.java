package br.cesar.school.cc.projetos.sub.usuario;

import br.cesar.school.cc.projetos.sub.utils.StringUtils;

public class UsuarioMediator {
    private static UsuarioMediator instance;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public static UsuarioMediator obterInstancia() {
        if (instance == null) {
            instance = new UsuarioMediator();
        }
        return instance;
    }

    public Usuario buscar(String idUnico){
        return usuarioDAO.buscar(idUnico);
    }

    public String validar(Usuario usuario){
        if(StringUtils.isVaziaOuNula(usuario.getNome())){
            return "Nome inválido";
        }
        boolean validacaoArroba = false;
        for(char caractere : usuario.getEmail().toCharArray()){
            if(caractere == '@'){
                validacaoArroba = true;
            }
        }
        if(!validacaoArroba){
           return "Email invalido";
        }
        if(StringUtils.isVaziaOuNula(usuario.getSenha())){
            return "Senha vazia";
        }
        return null;
    }

    public String incluir(Usuario usuario){
        String msg = validar(usuario);
        if(msg != null){
            if(!usuarioDAO.incluir(usuario)){
                msg = "Usuario ja existe";
            }
        }
        return msg;
    }

    public String alterar(Usuario usuario){
        String msg = validar(usuario);
        if(msg != null){
            if(!usuarioDAO.alterar(usuario)){
                msg = "Usuario nao encontrado";
            }
        }
        return msg;
    }

    public String excluir(Usuario usuario){
        String msg = validar(usuario);
        if(msg != null){
            if(!usuarioDAO.excluir(usuario)){
                msg = "Usuario nao encontrado";
            }
        }
        return msg;
    }
}
