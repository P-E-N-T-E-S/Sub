package br.cesar.school.cc.projetos.sub.moderacao;
import br.cesar.school.cc.projetos.sub.legenda.LegendaDAO;
import br.cesar.school.cc.projetos.sub.usuario.UsuarioDAO;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class ModeracaoDAO {
    private CadastroObjetos cadastro = new CadastroObjetos(Moderacao.class);
    private LegendaDAO legendaDao = new LegendaDAO();
    private UsuarioDAO usuarioDao = new UsuarioDAO();
    public String gerarID(Moderacao moderacao){
        String legendaID = legendaDao.gerarID(moderacao.getLegenda());
        String usuarioID = usuarioDao.gerarID(moderacao.getUsuario());
        return legendaID + usuarioID;
    }
    public Moderacao buscar(String idModeracao) {
        return (Moderacao) cadastro.buscar(idModeracao);
    }
    public boolean incluir(Moderacao moderacao) {
        String idUnico = gerarID(moderacao);
        Moderacao cli = buscar(idUnico);
        if (cli == null) {
            cadastro.incluir(moderacao, idUnico);
            return true;
        }
        return false;
    }

    public boolean alterar(Moderacao moderacao) {
        String idUnico = gerarID(moderacao);
        Moderacao cli = buscar(idUnico);
        if (cli != null) {
            cadastro.alterar(moderacao, idUnico);
            return true;
        }
        return false;
    }

    public boolean excluir(Moderacao moderacao) {
        String idUnico = gerarID(moderacao);
        Moderacao cli = buscar(idUnico);
        if (cli != null) {
            cadastro.excluir(idUnico);
            return true;
        }
        return false;
    }
}
