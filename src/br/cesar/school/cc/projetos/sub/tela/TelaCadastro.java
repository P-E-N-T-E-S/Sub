package br.cesar.school.cc.projetos.sub.tela;

import br.cesar.school.cc.projetos.sub.usuario.Usuario;
import br.cesar.school.cc.projetos.sub.usuario.UsuarioMediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro {
	private JFrame frame;
	private JTextField nomeField;
	private JTextField emailField;
	private JPasswordField senhaField;
	private UsuarioMediator usuarioMediator;

	public TelaCadastro() {
		usuarioMediator = UsuarioMediator.obterInstancia();

		frame = new JFrame("Cadastro de Usuário");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel nomeLabel = new JLabel("Nome:");
		nomeField = new JTextField();
		JLabel emailLabel = new JLabel("Email:");
		emailField = new JTextField();
		JLabel senhaLabel = new JLabel("Senha:");
		senhaField = new JPasswordField();

		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrarUsuario();
			}
		});

		JPanel panelBotoes = new JPanel();
		panelBotoes.add(cadastrarButton);

		GroupLayout layout = new GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(
				layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(nomeLabel)
								.addComponent(emailLabel)
								.addComponent(senhaLabel))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(nomeField)
								.addComponent(emailField)
								.addComponent(senhaField)
								.addComponent(panelBotoes))
		);

		layout.setVerticalGroup(
				layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(nomeLabel)
								.addComponent(nomeField))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(emailLabel)
								.addComponent(emailField))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(senhaLabel)
								.addComponent(senhaField))
						.addComponent(panelBotoes)
		);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void cadastrarUsuario() {
		String nome = nomeField.getText();
		String email = emailField.getText();
		String senha = new String(senhaField.getPassword());

		Usuario usuario = new Usuario(nome, email, senha, true);

		String msg = usuarioMediator.incluir(usuario);
		if (msg != null) {
			JOptionPane.showMessageDialog(frame, msg, "Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(frame, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
			new TelaCatalogo();
		}
	}

	private void abrirCatalogo() {
		new TelaCatalogo();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TelaCadastro();
			}
		});
	}
}
