package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CriarConfirmar extends JFrame {
	
	String DB_URL = "jdbc:mysql://127.0.0.1:3306/vota";
	String USER = "root";
	String PASS = "root";

	private JPanel contentPane;
	private JTextField cpf;
	private JTextField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarConfirmar frame = new CriarConfirmar();
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
	public CriarConfirmar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 400, 390, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cpf = new JTextField();
		cpf.setBounds(88, 54, 195, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Confirme as credenciais de administrador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(45, 11, 327, 14);
		contentPane.add(lblNewLabel);
		
		senha = new JTextField();
		senha.setColumns(10);
		senha.setBounds(88, 95, 195, 20);
		contentPane.add(senha);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCpf.setBounds(51, 55, 58, 14);
		contentPane.add(lblCpf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(33, 96, 58, 14);
		contentPane.add(lblSenha);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf_adms = "123";
				String senha_adms = "adms";
				String cpf_usuario = cpf.getText();
				String senha_testando = senha.getText();
				boolean valido = false;

				String QUERY = "SELECT cpf_usuario, senha FROM usuarios";

				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(QUERY);
						) {		      
					while(rs.next()){

						if((rs.getString("cpf_usuario").equals(cpf_usuario)) && (rs.getString("senha").equals(senha_testando))) {
							valido = true;
						};

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				if (valido == true) {

					Criar1 c = new Criar1();
					c.setVisible(true);
					dispose();						

				}

				else {
					JOptionPane.showMessageDialog(null, "Credenciais incorretas!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(256, 126, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(20, 126, 89, 23);
		contentPane.add(btnCancelar);
	}
}
