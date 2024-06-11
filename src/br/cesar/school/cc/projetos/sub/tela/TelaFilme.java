package br.cesar.school.cc.projetos.sub.tela;

import javax.swing.*;
import java.awt.*;

public class TelaFilme extends JFrame {

	public TelaFilme() {
		setTitle("Modern Times - Sub!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLayout(new BorderLayout());

		JLabel logoLabel = new JLabel("Sub!", SwingConstants.CENTER);
		logoLabel.setFont(new Font("Arial", Font.BOLD, 36));
		logoLabel.setBackground(Color.YELLOW);
		logoLabel.setOpaque(true);
		add(logoLabel, BorderLayout.NORTH);

		JPanel mainPanel = new JPanel(new BorderLayout());

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

		JLabel titleLabel = new JLabel("Modern Times");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		infoPanel.add(titleLabel);

		JLabel directorLabel = new JLabel("Directed by Charlie Chaplin");
		infoPanel.add(directorLabel);

		JLabel descriptionLabel = new JLabel("<html>'Tempos Modernos' é um filme de 1936, dirigido e estrelado por Charlie Chaplin..."
				+ "O filme mistura comédia e crítica social...</html>");
		infoPanel.add(descriptionLabel);

		JPanel buttonPanel = new JPanel();
		JButton editButton = new JButton("Editar Legenda");
		JButton downloadButton = new JButton("Baixar Legenda");
		buttonPanel.add(editButton);
		buttonPanel.add(downloadButton);
		infoPanel.add(buttonPanel);

		mainPanel.add(infoPanel, BorderLayout.CENTER);

		JTextArea commentsArea = new JTextArea(10, 50);
		commentsArea.setText("286 Comments\n\nJames Gouse: A legenda tem alguns erros de tradução, mas nada que tira o sentido da obra\n"
				+ "Alan Cooper: A legenda tem alguns erros de tradução, mas nada que tira o sentido da obra\n");
		commentsArea.setEditable(false);
		JScrollPane commentsScrollPane = new JScrollPane(commentsArea);

		mainPanel.add(commentsScrollPane, BorderLayout.SOUTH);

		add(mainPanel, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {
		new TelaFilme();
	}
}
