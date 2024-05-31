package br.cesar.school.cc.projetos.sub.legenda;

import br.cesar.school.cc.projetos.sub.utils.StringUtils;
import br.cesar.school.cc.projetos.sub.filme.FilmeMediator;
import br.cesar.school.cc.projetos.sub.usuario.UsuarioMediator;
import br.cesar.school.cc.projetos.sub.cursor.CursorMediator;
import br.cesar.school.cc.projetos.sub.moderacao.ModeracaoMediator;

import java.time.LocalDateTime;

public class LegendaMediator {
    private LegendaDAO legendaDAO = new LegendaDAO();
    private static LegendaMediator instance;
    private FilmeMediator filmeMediator = FilmeMediator.obterInstancia();
    private CursorMediator cursorMediator = CursorMediator.obterInstancia();
    private UsuarioMediator usuarioMediator = UsuarioMediator.obterInstancia();
    private ModeracaoMediator moderacaoMediator = ModeracaoMediator.obterInstancia();

    public static LegendaMediator obterInstancia() {
        if (instance == null) {
            instance = new LegendaMediator();
        }
        return instance;
    }

    public Legenda buscar(String idUnico){
        return legendaDAO.buscar(idUnico);
    }

    public String validar(Legenda legenda){
        String nomeArquivo = legenda.getNomeArquivo();
        if(nomeArquivo.isEmpty()){
            return "Nome de Arquivo Vazio";
        }
        String extensao = StringUtils.getUltimosCaracteres(nomeArquivo, 3);
        if(!extensao.equals(".srt")){
            return "Extensão de Arquivo Invalida";
        }
        if(legenda.getCaminhoArquivo().isEmpty()){
            return "Caminho Arquivo Vazio";
        }
        LocalDateTime hoje = LocalDateTime.now();
        if(hoje.isBefore(legenda.getUltimaEdicao())){
            return "Horario de ultima edicao Invalida";
        }
        String validarFilme = filmeMediator.validar(legenda.getFilme());
        String validarCursor = cursorMediator.validar(legenda.getPonteiro());
        String validarUsuario = usuarioMediator.validar(legenda.getUsuario());
        if(validarFilme != null){
            return validarFilme;
        }
        if(validarCursor != null){
            return validarCursor;
        }
        if(validarUsuario != null){
            return validarUsuario;
        }
        return null;
    }
    public String incluir(Legenda legenda){
        String msg = validar(legenda);
        if(msg != null){
            if(!legendaDAO.incluir(legenda)){
                msg = "Legenda ja existente";
            }
        }
        return msg;
    }

    public String alterar(Legenda legenda){
        String msg = validar(legenda);
        if(msg != null){
            if(!legendaDAO.alterar(legenda)){
                msg = "Legenda nao encontrada";
            }
        }
        return msg;
    }

    public String excluir(Legenda legenda){
        String msg = validar(legenda);
        if(msg != null){
            if(!legendaDAO.excluir(legenda)){
                msg = "Legenda nao encontrada";
            }
        }
        return msg;
    }

}
