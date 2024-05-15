package br.cesar.school.cc.projetos.sub.corpo;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class CorpoTextoDAO {
    private CadastroObjetos cadastro = new CadastroObjetos(CorpoTexto.class);
    public String gerarIdUnico(CorpoTexto corpoTexto) {
        return corpoTexto.getArquivo().gerarIdUnico() + "corpo";
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
}


