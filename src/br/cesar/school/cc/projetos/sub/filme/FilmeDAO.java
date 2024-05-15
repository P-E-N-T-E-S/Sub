package br.cesar.school.cc.projetos.sub.filme;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class FilmeDAO {
    private CadastroObjetos cadastro = new CadastroObjetos(Filme.class);
    public String gerarID(Filme filme){
        return filme.getNome() + filme.getAutor() + filme.getReferencia();
    }
    public Filme buscar(String idFilme) {
        return (Filme) cadastro.buscar(idFilme);
    }
    public boolean incluir(Filme filme) {
        String idUnico = gerarID(filme);
        Filme cli = buscar(idUnico);
        if (cli == null) {
            cadastro.incluir(filme, idUnico);
            return true;
        }
        return false;
    }

    public boolean alterar(Filme filme) {
        String idUnico = gerarID(filme);
        Filme cli = buscar(idUnico);
        if (cli != null) {
            cadastro.alterar(filme, idUnico);
            return true;
        }
        return false;
    }

    public boolean excluir(Filme filme) {
        String idUnico = gerarID(filme);
        Filme cli = buscar(idUnico);
        if (cli != null) {
            cadastro.excluir(idUnico);
            return true;
        }
        return false;
    }
}
