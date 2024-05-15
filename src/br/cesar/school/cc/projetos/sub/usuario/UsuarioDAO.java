package br.cesar.school.cc.projetos.sub.usuario;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class UsuarioDAO {
    private CadastroObjetos cadastro = new CadastroObjetos(Usuario.class);

    public String gerarID(Usuario usuario){
        return usuario.getEmail();
    }
    public Usuario buscar(String idUsuario) {
        return (Usuario) cadastro.buscar(idUsuario);
    }
    public boolean incluir(Usuario usuario) {
        String idUnico = gerarID(usuario);
        Usuario cli = buscar(idUnico);
        if (cli == null) {
            cadastro.incluir(usuario, idUnico);
            return true;
        }
        return false;
    }

    public boolean alterar(Usuario usuario) {
        String idUnico = gerarID(usuario);
        Usuario cli = buscar(idUnico);
        if (cli != null) {
            cadastro.alterar(usuario, idUnico);
            return true;
        }
        return false;
    }

    public boolean excluir(Usuario usuario) {
        String idUnico = gerarID(usuario);
        Usuario cli = buscar(idUnico);
        if (cli != null) {
            cadastro.excluir(idUnico);
            return true;
        }
        return false;
    }
}
