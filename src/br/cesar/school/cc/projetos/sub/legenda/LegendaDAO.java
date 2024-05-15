package br.cesar.school.cc.projetos.sub.legenda;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class LegendaDAO {
    private CadastroObjetos cadastro = new CadastroObjetos(Legenda.class);
    public String gerarID(Legenda legenda){
        return legenda.getNomeArquivo() + legenda.getUsuario().getEmail() + legenda.getFilme().getNome();
    }
    public Legenda buscar(String idLegenda) {
        return (Legenda) cadastro.buscar(idLegenda);
    }
    public boolean incluir(Legenda legenda) {
        String idUnico = gerarID(legenda);
        Legenda cli = buscar(idUnico);
        if (cli == null) {
            cadastro.incluir(legenda, idUnico);
            return true;
        }
        return false;
    }

    public boolean alterar(Legenda legenda) {
        String idUnico = gerarID(legenda);
        Legenda cli = buscar(idUnico);
        if (cli != null) {
            cadastro.alterar(legenda, idUnico);
            return true;
        }
        return false;
    }

    public boolean excluir(Legenda legenda) {
        String idUnico = gerarID(legenda);
        Legenda cli = buscar(idUnico);
        if (cli != null) {
            cadastro.excluir(idUnico);
            return true;
        }
        return false;
    }
}
