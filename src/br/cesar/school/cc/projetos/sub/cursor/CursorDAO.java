package br.cesar.school.cc.projetos.sub.cursor;
import br.cesar.school.cc.projetos.sub.legenda.LegendaDAO;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class CursorDAO {
    private LegendaDAO legendaDao = new LegendaDAO();
    private CadastroObjetos cadastro = new CadastroObjetos(Cursor.class);
    public String gerarIdUnico(Cursor cursor){
        String legenda = legendaDao.gerarID(cursor.getArquivo());
        return legenda + "cursor";
    }
    public Cursor buscar(String idCursor) {
        return (Cursor) cadastro.buscar(idCursor);
    }
    public boolean incluir(Cursor cursor) {
        String idUnico = gerarIdUnico(cursor);
        Cursor cli = buscar(idUnico);
        if (cli == null) {
            cadastro.incluir(cursor, idUnico);
            return true;
        }
        return false;
    }

    public boolean alterar(Cursor cursor) {
        String idUnico = gerarIdUnico(cursor);
        Cursor cli = buscar(idUnico);
        if (cli != null) {
            cadastro.alterar(cursor, idUnico);
            return true;
        }
        return false;
    }

    public boolean excluir(Cursor cursor) {
        String idUnico = gerarIdUnico(cursor);
        Cursor cli = buscar(idUnico);
        if (cli != null) {
            cadastro.excluir(idUnico);
            return true;
        }
        return false;
    }
}

