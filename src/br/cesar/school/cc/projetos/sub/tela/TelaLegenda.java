package br.cesar.school.cc.projetos.sub.tela;

import br.cesar.school.cc.projetos.sub.legenda.Legenda;
import br.cesar.school.cc.projetos.sub.legenda.LegendaMediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TelaLegenda {
	private JFrame frame;
	private JTextArea textAreaLegenda;
	private JTextField nomeArquivoField;
	private LegendaMediator legendaMediator;
	private String caminhoArquivo;

	public TelaLegenda() {
		this("", "", "");
	}

	public TelaLegenda(String nomeArquivo, String caminhoArquivo, String conteudoLegenda) {
		this.caminhoArquivo = caminhoArquivo;
		legendaMediator = LegendaMediator.obterInstancia();

		frame = new JFrame("Editor de Legenda");
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		textAreaLegenda = new JTextArea(conteudoLegenda);
		textAreaLegenda.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textAreaLegenda);

		JPanel panelInputs = new JPanel(new GridLayout(1, 2));
		JLabel nomeArquivoLabel = new JLabel("Nome do Arquivo (.srt):");
		nomeArquivoField = new JTextField(nomeArquivo);

		panelInputs.add(nomeArquivoLabel);
		panelInputs.add(nomeArquivoField);

		JPanel panelBotoes = new JPanel();
		JButton salvarButton = new JButton("Salvar Legenda");
		JButton voltarButton = new JButton("Voltar");

		salvarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				salvarLegenda();
			}
		});

		voltarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				voltarParaCatalogo();
			}
		});

		panelBotoes.add(salvarButton);
		panelBotoes.add(voltarButton);

		frame.add(panelInputs, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(panelBotoes, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	public void salvarLegenda() {
		String nomeArquivo = nomeArquivoField.getText();
		if (!nomeArquivo.endsWith(".srt")) {
			nomeArquivo += ".srt";
		}

		String textoLegenda = textAreaLegenda.getText();
		if (nomeArquivo.isEmpty() || textoLegenda.isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		caminhoArquivo = "legendas/" + nomeArquivo;
		Legenda legenda = new Legenda(nomeArquivo, caminhoArquivo);

		File diretorio = new File("legendas");
		if (!diretorio.exists()) {
			diretorio.mkdir();
		}

		File arquivo = new File(caminhoArquivo);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
			writer.write(textoLegenda);
			JOptionPane.showMessageDialog(frame, "Legenda salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(frame, "Erro ao salvar a legenda.", "Erro", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	public void voltarParaCatalogo() {
		frame.dispose();
		new TelaCatalogo();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TelaLegenda();
			}
		});
	}
}
