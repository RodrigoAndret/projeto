package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.cj.xdevapi.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Cadastro extends JFrame {
	
	String DB_URL = "jdbc:mysql://127.0.0.1:3306/vota";
	String USER = "root";
	String PASS = "root";

	private JPanel contentPane;
	private JPasswordField senha;
	private JPasswordField cpf;

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
		
				String cadastro_cpf = cpf.getText();
				String cadastro_senha = senha.getText();
				
				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         Statement stmt = conn.createStatement();
				      ) {		      
				         // Execute a query
				         System.out.println("Inserindo dados em tabela");
				         
				         String sql = "INSERT INTO usuarios VALUES ('"+cadastro_cpf+"','"+cadastro_senha+"')";
				         
				         stmt.executeUpdate(sql);  	  
				      } catch (SQLException e1) {
				         e1.printStackTrace();
				      } 
				
				JOptionPane.showMessageDialog(null, "Cadastro realizado!");
								
				Login login = new Login();
				login.setVisible(true);
				dispose();
				
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCadastrar.setBounds(763, 539, 171, 32);
		contentPane.add(btnCadastrar);
		
		senha = new JPasswordField();
		senha.setFont(new Font("Tahoma", Font.PLAIN, 22));
		senha.setBounds(237, 347, 390, 32);
		contentPane.add(senha);
		
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
		
		cpf = new JPasswordField();
		cpf.setFont(new Font("Tahoma", Font.PLAIN, 22));
		cpf.setBounds(237, 205, 390, 32);
		contentPane.add(cpf);
	}

}