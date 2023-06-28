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
import javax.swing.JScrollBar;

public class ConceitoCriar extends JFrame {
		
	String DB_URL = "jdbc:mysql://127.0.0.1:3306/vota";
	String USER = "root";
	String PASS = "root";

	private JPanel contentPane;
	private JTextField tema;
	private JTextField opcao1;
	private JTextField opcao2;
	private JTextField data_fim_votacao;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Criar frame = new Criar();
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
	public ConceitoCriar() {
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
		
		JLabel lblNewLabel_1 = new JLabel("_________________________________________________________________________________________");
		lblNewLabel_1.setBounds(10, 47, 534, 14);
		lblNewLabel_1.setForeground(Color.BLUE);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Insira o tema da sua votação:");
		lblNewLabel_2.setBounds(68, 72, 424, 39);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(lblNewLabel_2);
		
		tema = new JTextField();
		tema.setBounds(68, 122, 473, 38);
		tema.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tema.setColumns(10);
		contentPane.add(tema);
		
		JButton Voltar = new JButton("< Voltar");
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAdm menu = new MenuAdm();
				menu.setVisible(true);
				dispose();
			}
		});
		Voltar.setBounds(10, 547, 125, 33);
		Voltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(Voltar);
		
		JButton Criar = new JButton("FINALIZAR");
		Criar.setForeground(new Color(255, 255, 255));
		Criar.setBackground(new Color(0, 0, 255));
		Criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tema_votacao = tema.getText();
				String opcao_1 = opcao1.getText();
				String opcao_2 = opcao2.getText();
				String data_final = data_fim_votacao.getText();
				
				if (tema.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira um tema!");
				}
				else {
					try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					         Statement stmt = conn.createStatement();
					      ) {		      
					         // Execute a query
					         System.out.println("Inserindo dados em tabela");
					         
					         String sql = "INSERT INTO votacao (id_votacao,titulo,data_votacao,opcao1,opcao2,data_final) VALUES (default,'"+tema_votacao+"',now(),'"+opcao_1+"','"+opcao_2+"', '"+data_final+"')";
					         
					         stmt.executeUpdate(sql);  	  
					      } catch (SQLException e1) {
					         e1.printStackTrace();
					      } 
					JOptionPane.showMessageDialog(null, "Votação criada com sucesso!");
					MenuAdm menu = new MenuAdm();
					menu.setVisible(true);
					dispose();
				}
			}
		});
		Criar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Criar.setBounds(703, 499, 247, 80);
		contentPane.add(Criar);
		
		JLabel insiraOpcoes = new JLabel("Insira as opções da sua votação:");
		insiraOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 32));
		insiraOpcoes.setBounds(68, 181, 489, 39);
		contentPane.add(insiraOpcoes);
		
		opcao1 = new JTextField();
		opcao1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		opcao1.setColumns(10);
		opcao1.setBounds(68, 231, 473, 38);
		contentPane.add(opcao1);
		
		opcao2 = new JTextField();
		opcao2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		opcao2.setColumns(10);
		opcao2.setBounds(68, 280, 473, 38);
		contentPane.add(opcao2);
		
		JLabel numeroOpcao1 = new JLabel("1.");
		numeroOpcao1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		numeroOpcao1.setBounds(28, 237, 30, 26);
		contentPane.add(numeroOpcao1);
		
		JLabel numeroOpcao2 = new JLabel("2.");
		numeroOpcao2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		numeroOpcao2.setBounds(28, 286, 30, 26);
		contentPane.add(numeroOpcao2);
		
		data_fim_votacao = new JTextField();
		data_fim_votacao.setFont(new Font("Tahoma", Font.PLAIN, 26));
		data_fim_votacao.setColumns(10);
		data_fim_votacao.setBounds(68, 473, 473, 38);
		contentPane.add(data_fim_votacao);
		
		JLabel lblVotaoDisponvelAt = new JLabel("Votação disponível até:");
		lblVotaoDisponvelAt.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblVotaoDisponvelAt.setBounds(68, 423, 489, 39);
		contentPane.add(lblVotaoDisponvelAt);
		
		JLabel lblAnomsdiaExemploAaaammaa = new JLabel("Ano-mês-dia. Exemplo: aaaa-mm-aa");
		lblAnomsdiaExemploAaaammaa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnomsdiaExemploAaaammaa.setBounds(68, 512, 252, 24);
		contentPane.add(lblAnomsdiaExemploAaaammaa);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(626, 231, 23, 141);
		contentPane.add(scrollBar);
		
		JLabel lblNewLabel_3 = new JLabel("Adicionar opção");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_3.setBounds(674, 309, 219, 39);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnNewButton.setBounds(703, 231, 89, 81);
		contentPane.add(btnNewButton);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(546, 238, 74, 33);
		contentPane.add(btnExcluir);
		
		JButton btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir_1.setBounds(546, 287, 74, 33);
		contentPane.add(btnExcluir_1);
		
		JLabel numeroOpcao2_1 = new JLabel("3.");
		numeroOpcao2_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		numeroOpcao2_1.setBounds(28, 340, 30, 26);
		contentPane.add(numeroOpcao2_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField.setColumns(10);
		textField.setBounds(68, 334, 473, 38);
		contentPane.add(textField);
		
		JButton btnExcluir_1_1 = new JButton("Excluir");
		btnExcluir_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir_1_1.setBounds(546, 339, 74, 33);
		contentPane.add(btnExcluir_1_1);
	}
}