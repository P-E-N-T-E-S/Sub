package br.cesar.school.cc.projetos.sub.tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin {
	private JFrame frame;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldSenha;

	public TelaLogin() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Login de Usuário");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblEmail = new JLabel("Email:");
		textFieldEmail = new JTextField(20);
		JLabel lblSenha = new JLabel("Senha:");
		passwordFieldSenha = new JPasswordField(20);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarLogin();
			}
		});

		GroupLayout layout = new GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(
				layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lblEmail)
								.addComponent(lblSenha))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(textFieldEmail)
								.addComponent(passwordFieldSenha)
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnLogin)))
		);

		layout.setVerticalGroup(
				layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblEmail)
								.addComponent(textFieldEmail))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblSenha)
								.addComponent(passwordFieldSenha))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnLogin))
		);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void realizarLogin() {
		String email = textFieldEmail.getText();
		String senha = new String(passwordFieldSenha.getPassword());

		boolean loginValido = "egcf@gmail.com".equals(email) && "caldinho".equals(senha);

		if (loginValido) {
			JOptionPane.showMessageDialog(frame, "Login realizado com sucesso!");
			abrirCatalogo();
		} else {
			JOptionPane.showMessageDialog(frame, "Email ou senha incorretos. Tente novamente.");
		}
	}

	private void abrirCatalogo() {
		frame.dispose();
		new TelaCatalogo();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TelaLogin();
			}
		});
	}
}
