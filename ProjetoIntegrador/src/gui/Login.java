package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("V.O.T.A.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblNewLabel.setBounds(368, 11, 212, 84);
		contentPane.add(lblNewLabel);
		
		JButton btnFazerLogin = new JButton("Fazer Login");
		btnFazerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cpf não está cadastrado ou digitado incorretamente ou senha incorreta) {
					JOptionPane.showMessageDialog(null, "Credenciais incorretas!");
				}
				else {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
				}
			}
			
		});
		btnFazerLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFazerLogin.setBounds(193, 410, 167, 32);
		contentPane.add(btnFazerLogin);
		
		JLabel lblvotaoOfflineTransparente = new JLabel("(Votação Offline Transparente e Acessível)");
		lblvotaoOfflineTransparente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblvotaoOfflineTransparente.setBounds(271, 92, 393, 25);
		contentPane.add(lblvotaoOfflineTransparente);
		
		JLabel lblCpf_1 = new JLabel("Digite seu CPF:");
		lblCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblCpf_1.setBounds(167, 166, 230, 48);
		contentPane.add(lblCpf_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordField.setBounds(86, 225, 390, 32);
		contentPane.add(passwordField);
		
		JLabel lblSenha_1 = new JLabel("Digite a senha desejada:");
		lblSenha_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblSenha_1.setBounds(93, 308, 383, 48);
		contentPane.add(lblSenha_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordField_1.setBounds(86, 367, 390, 32);
		contentPane.add(passwordField_1);
		
		JButton btnCadastrarse = new JButton("Cadastrar-se");
		btnCadastrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro cadastro = new Cadastro();
				cadastro.setVisible(true);
				dispose();
			}
			
		});
		btnCadastrarse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCadastrarse.setBounds(644, 321, 178, 32);
		contentPane.add(btnCadastrarse);
		
		JLabel lblCpf_1_1 = new JLabel("Não possui cadastro?");
		lblCpf_1_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblCpf_1_1.setBounds(599, 254, 317, 48);
		contentPane.add(lblCpf_1_1);
	}
}
