package br.cesar.school.cc.projetos.sub.tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TelaLegenda {
	private JFrame frame;
	private JTextArea textAreaLegenda;

	public TelaLegenda() {
		frame = new JFrame("Editor de Legenda");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		textAreaLegenda = new JTextArea();
		textAreaLegenda.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textAreaLegenda);

		JPanel panelBotoes = new JPanel();
		JButton salvarButton = new JButton("Salvar Legenda");

		salvarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				salvarLegenda();
			}
		});

		panelBotoes.add(salvarButton);

		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(panelBotoes, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	public void salvarLegenda() {
		String textoLegenda = textAreaLegenda.getText();
		if (!textoLegenda.isEmpty()) {
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
			String nomeArquivo = "legenda_" + agora.format(formatter) + ".txt";
			File diretorio = new File("legendas");
			if (!diretorio.exists()) {
				diretorio.mkdir();
			}
			File arquivo = new File(diretorio, nomeArquivo);
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
				writer.write(textoLegenda);
				JOptionPane.showMessageDialog(frame, "Legenda salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(frame, "Erro ao salvar a legenda.", "Erro", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Nada para salvar. Legenda vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
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
