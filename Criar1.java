package design;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class Criar1 extends JFrame {

	String DB_URL = "jdbc:mysql://127.0.0.1:3306/vota";
	String USER = "root";
	String PASS = "root";

	private JPanel contentPane;
	private JTextField tema;
	private JTextField opcao1;
	private JTextField opcao2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Criar1 frame = new Criar1();
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
	public Criar1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Criar Votação");
		lblNewLabel.setBounds(21, 11, 155, 32);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Insira o tema da sua votação:");
		lblNewLabel_2.setBounds(68, 109, 424, 39);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(lblNewLabel_2);

		tema = new JTextField();
		tema.setBounds(68, 171, 473, 38);
		tema.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tema.setColumns(10);
		contentPane.add(tema);

		JButton Voltar = new JButton("< Voltar");
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// add if pra ver se é adm
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		Voltar.setBounds(10, 547, 125, 33);
		Voltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(Voltar);

		JButton Criar = new JButton("Criar >>");
		Criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tema_votacao = tema.getText();
				String opcao_1 = opcao1.getText();
				String opcao_2 = opcao2.getText();

				if (tema.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira um tema!");
				}
				else {
					try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					         Statement stmt = conn.createStatement();
					      ) {		      
					         // Execute a query
					         System.out.println("Inserindo dados em tabela");

					         String sql = "INSERT INTO votacao (id_votacao,titulo,data_votacao,opcao1,opcao2) VALUES (default,'"+tema_votacao+"',now(),'"+opcao_1+"','"+opcao_2+"')";

					         stmt.executeUpdate(sql);  	  
					      } catch (SQLException e1) {
					         e1.printStackTrace();
					      } 
					JOptionPane.showMessageDialog(null, "Votação criada com sucesso!");
					Menu menu = new Menu();
					menu.setVisible(true);
					dispose();
				}
			}
		});
		Criar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Criar.setBounds(819, 547, 131, 32);
		contentPane.add(Criar);

		JLabel insiraOpcoes = new JLabel("Insira as opções da sua votação:");
		insiraOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 32));
		insiraOpcoes.setBounds(68, 251, 489, 39);
		contentPane.add(insiraOpcoes);

		opcao1 = new JTextField();
		opcao1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		opcao1.setColumns(10);
		opcao1.setBounds(69, 311, 473, 38);
		contentPane.add(opcao1);

		opcao2 = new JTextField();
		opcao2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		opcao2.setColumns(10);
		opcao2.setBounds(69, 377, 473, 38);
		contentPane.add(opcao2);

		JLabel numeroOpcao1 = new JLabel("1.");
		numeroOpcao1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		numeroOpcao1.setBounds(29, 317, 30, 26);
		contentPane.add(numeroOpcao1);

		JLabel numeroOpcao2 = new JLabel("2.");
		numeroOpcao2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		numeroOpcao2.setBounds(29, 383, 30, 26);
		contentPane.add(numeroOpcao2);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("____________________________________________________________________________________________________________________________________________________________");
		textPane.setForeground(Color.BLACK);
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.menu);
		textPane.setBounds(21, 39, 964, 20);
		contentPane.add(textPane);
	}

}