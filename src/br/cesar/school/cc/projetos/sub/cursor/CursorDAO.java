package br.cesar.school.cc.projetos.sub.cursor;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class CursorDAO {
    private CadastroObjetos cadastro = new CadastroObjetos(Cursor.class);
    public String gerarIdUnico(Cursor cursor){
        return cursor.getArquivo().gerarIdUnico() + "cursor";
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

