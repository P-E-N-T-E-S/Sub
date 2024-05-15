package br.cesar.school.cc.projetos.sub.corpo;

import br.cesar.school.cc.projetos.sub.legenda.LegendaDAO;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class CorpoTextoDAO {
    private CadastroObjetos cadastro = new CadastroObjetos(CorpoTexto.class);
    private LegendaDAO legendaDao = new LegendaDAO();
    public String gerarIdUnico(CorpoTexto corpoTexto) {
        String legendaId = legendaDao.gerarID(corpoTexto.getArquivo());
        return legendaId + "corpo";
    }
    public CorpoTexto buscar(String idCorpo) {
        return (CorpoTexto) cadastro.buscar(idCorpo);
    }
    public boolean incluir(CorpoTexto corpoTexto) {
        String idUnico = gerarIdUnico(corpoTexto);
        CorpoTexto cli = buscar(idUnico);
        if (cli == null) {
            cadastro.incluir(corpoTexto, idUnico);
            return true;
        }
        return false;
    }

    public boolean alterar(CorpoTexto corpoTexto) {
        String idUnico = gerarIdUnico(corpoTexto);
        CorpoTexto cli = buscar(idUnico);
        if (cli != null) {
            cadastro.alterar(corpoTexto, idUnico);
            return true;
        }
        return false;
    }

    public boolean excluir(CorpoTexto corpoTexto) {
        String idUnico = gerarIdUnico(corpoTexto);
        CorpoTexto cli = buscar(idUnico);
        if (cli != null) {
            cadastro.excluir(idUnico);
            return true;
        }
        return false;
    }
}


