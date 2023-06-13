package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpf_1 = new JLabel("Digite seu CPF:");
		lblCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblCpf_1.setBounds(318, 146, 230, 48);
		contentPane.add(lblCpf_1);
		
		JLabel lblSenha_1 = new JLabel("Digite a senha desejada:");
		lblSenha_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblSenha_1.setBounds(244, 288, 383, 48);
		contentPane.add(lblSenha_1);
		
		JButton btnCadastrar = new JButton("Cadastrar >>");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado!");
								
				Login login = new Login();
				login.setVisible(true);
				dispose();
				
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCadastrar.setBounds(763, 539, 171, 32);
		contentPane.add(btnCadastrar);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordField_1.setBounds(237, 347, 390, 32);
		contentPane.add(passwordField_1);
		
		JLabel lblCriarVotao = new JLabel("Cadastro");
		lblCriarVotao.setForeground(new Color(0, 0, 0));
		lblCriarVotao.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCriarVotao.setBounds(21, 11, 155, 32);
		contentPane.add(lblCriarVotao);
		
		JLabel lblNewLabel_1 = new JLabel("_________________________________________________________________________________________");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(10, 47, 639, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("< Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(26, 539, 136, 32);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordField.setBounds(237, 205, 390, 32);
		contentPane.add(passwordField);
	}

}
