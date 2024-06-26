package br.cesar.school.cc.projetos.sub.tela;

import br.cesar.school.cc.projetos.sub.usuario.UsuarioMediator;

import javax.swing.*;
import java.awt.*;

public class TelaModel
{
	protected JFrame frame;
	static JMenuBar navbar;// menubar
	static JMenu arquivoBtn, editarBtn, ferramentasBtn, ajudaBtn;// JMenu
	static JMenuItem[] menuItemsArquivo = new JMenuItem[4], menuItemsEditar = new JMenuItem[3], menuItemsFerramentas = new JMenuItem[3], menuItemsAjuda = new JMenuItem[4];// Menu items

	public TelaModel(String name)
	{
		initializeMain(name);
	}
	private void initializeMain(String name)
	{
		java.net.URL imgURL = getClass().getResource("/br/cesar/school/cc/projetos/sub/tela/imgs/logo.png");
		if (imgURL == null) {
			System.err.println("Imagem não encontrada");
			return;
		}
		Image icon = new ImageIcon(imgURL).getImage();
		System.out.println("Imagem encontrada: " + imgURL);

		frame = new JFrame(name);
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.setIconImage(icon);

		navbar = new JMenuBar();
		arquivoBtn = new JMenu("Arquivo");
		editarBtn = new JMenu("Editar");
		ferramentasBtn = new JMenu("Ferramentas");
		ajudaBtn = new JMenu("Ajuda");

		menuItemsArquivo[0] = new JMenuItem("Nova Janela");
		menuItemsArquivo[1] = new JMenuItem("Novo Arquivo");
		menuItemsArquivo[2] = new JMenuItem("Abrir o Arquivo");
		menuItemsArquivo[3] = new JMenuItem("Abrir Pasta");

        for (JMenuItem jMenuItem : menuItemsArquivo) {
            arquivoBtn.add(jMenuItem);
        }

		menuItemsEditar[0] = new JMenuItem("Recortar");
		menuItemsEditar[1] = new JMenuItem("Copiar");
		menuItemsEditar[2] = new JMenuItem("Colar");

		for (JMenuItem jMenuItem : menuItemsEditar) {
			editarBtn.add(jMenuItem);
		}

		menuItemsFerramentas[0] = new JMenuItem("Sincronizador de texto");
		menuItemsFerramentas[1] = new JMenuItem("Corretor ortográfico");
		menuItemsFerramentas[2] = new JMenuItem("Localizar Palavra");

		for (JMenuItem jMenuItem : menuItemsFerramentas) {
			ferramentasBtn.add(jMenuItem);
		}

		menuItemsAjuda[0] = new JMenuItem("Tutoriais em vídeo");
		menuItemsAjuda[1] = new JMenuItem("Manual de uso");
		menuItemsAjuda[2] = new JMenuItem("Notas da versão");
		menuItemsAjuda[3] = new JMenuItem("Relatar Problema");

		for (JMenuItem jMenuItem : menuItemsAjuda) {
			ajudaBtn.add(jMenuItem);
		}

		navbar.add(arquivoBtn);
		navbar.add(editarBtn);
		navbar.add(ferramentasBtn);
		navbar.add(ajudaBtn);

		frame.setJMenuBar(navbar);

		frame.setVisible(true);
	}

}
