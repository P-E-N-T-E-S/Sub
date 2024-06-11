package br.cesar.school.cc.projetos.sub.tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class TelaCatalogo extends TelaModel{

	private JList<String> listLegendas;
	private DefaultListModel<String> listModel;

	public TelaCatalogo() {
		super("Catalogo");

		listModel = new DefaultListModel<>();
		listLegendas = new JList<>(listModel);
		listLegendas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					abrirLegendaParaEdicao(listLegendas.getSelectedValue());
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(listLegendas);

		JButton adicionarButton = new JButton("Adicionar Legenda");
		adicionarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new TelaLegenda();
			}
		});

		JPanel panelBotoes = new JPanel();
		panelBotoes.add(adicionarButton);

		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(panelBotoes, BorderLayout.SOUTH);

		carregarLegendas();

		frame.setVisible(true);
	}

	private void carregarLegendas() {
		File diretorio = new File("legendas");
		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
		File[] arquivos = diretorio.listFiles((dir, nome) -> nome.endsWith(".srt"));
		if (arquivos != null) {
			listModel.clear();
			Arrays.stream(arquivos).forEach(arquivo -> listModel.addElement(arquivo.getName()));
		}
	}

	private void abrirLegendaParaEdicao(String nomeArquivo) {
		String caminhoArquivo = "legendas/" + nomeArquivo;
		try {
			String conteudo = new String(Files.readAllBytes(new File(caminhoArquivo).toPath()));
			new TelaLegenda(nomeArquivo, caminhoArquivo, conteudo);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Erro ao carregar a legenda.", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TelaCatalogo();
			}
		});
	}
}
