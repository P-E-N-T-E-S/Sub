package br.cesar.school.cc.projetos.sub.cursor;

public class CursorMediator {
    private static CursorMediator instancia;
    private CursorDAO cursorDAO = new CursorDAO();

    public static CursorMediator obterInstancia() {
        if (instancia == null) {
            instancia = new CursorMediator();
        }
        return instancia;
    }

    public Cursor buscar(String idUnico) {
        return cursorDAO.buscar(idUnico);
    }

    public String validar(Cursor cursor) {
        if(cursor.getPosicao() < 0) {
            return "Posicao invalida";
        }
        return null;
    }

    public String inserir(Cursor cursor) {
        String msg = validar(cursor);
        if(msg != null) {
            if(!cursorDAO.incluir(cursor)){
                msg = "Cursor ja existe";
            }
        }
        return msg;
    }

    public String alterar(Cursor cursor) {
        String msg = validar(cursor);
        if(msg != null) {
            if(!cursorDAO.alterar(cursor)){
                msg = "Cursor nao encontrado";
            }
        }
        return msg;
    }

    public String excluir(Cursor cursor) {
        String msg = validar(cursor);
        if(msg != null) {
            if(!cursorDAO.excluir(cursor)){
                msg = "Cursor nao encontrado";
            }
        }
        return msg;
    }
}
