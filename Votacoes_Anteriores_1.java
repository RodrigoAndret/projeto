package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Votacoes_Anteriores_1 extends JFrame {
	
	String DB_URL = "jdbc:mysql://127.0.0.1:3306/escola";
	String USER = "root";
	String PASS = "root";

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Votacoes_Anteriores_1 frame = new Votacoes_Anteriores_1();
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
	public Votacoes_Anteriores_1() {
		
		// pegando o nome das votações
		String QUERY = "SELECT nome FROM votacoes";
		ArrayList<String> nomes = new ArrayList<String>();
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);
		      ) {	
			
				
		         while(rs.next()){
		            //PEGAR INFOS DA VOTAÇÃO E BOTAR EM UMA LISTA, QUE DEPOIS SERA LIDA		            
		            nomes.add(rs.getString("nome"));
		            
		         }
		      } catch (SQLException e1) {
		         e1.printStackTrace();
		      }
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filtrar filtrar = new Filtrar();
				filtrar.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(822, 70, 133, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("°Votação 1*requisição BD*");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votacoes_Anteriores_2 v2 = new Votacoes_Anteriores_2();
				v2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(10, 179, 950, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("°Votação 2*requisição BD*");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votacoes_Anteriores_2 v2 = new Votacoes_Anteriores_2();
				v2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_2.setBounds(10, 258, 950, 57);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("°Votação 3*requisição BD*");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votacoes_Anteriores_2 v2 = new Votacoes_Anteriores_2();
				v2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_3.setBounds(10, 340, 950, 57);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("°Votação 4*requisição BD*");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votacoes_Anteriores_2 v2 = new Votacoes_Anteriores_2();
				v2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_4.setBounds(10, 418, 950, 57);
		contentPane.add(btnNewButton_4);
		
		JButton voltar = new JButton("<- Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
				
			}
		});
		voltar.setHorizontalAlignment(SwingConstants.LEFT);
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		voltar.setBounds(10, 561, 162, 39);
		contentPane.add(voltar);
		
		JTextPane txtpnVotaesAnteriores = new JTextPane();
		txtpnVotaesAnteriores.setText("Votações Anteriores");
		txtpnVotaesAnteriores.setForeground(Color.RED);
		txtpnVotaesAnteriores.setFont(new Font("Swis721 Cn BT", Font.PLAIN, 52));
		txtpnVotaesAnteriores.setEditable(false);
		txtpnVotaesAnteriores.setBackground(Color.LIGHT_GRAY);
		txtpnVotaesAnteriores.setBounds(25, 63, 441, 70);
		contentPane.add(txtpnVotaesAnteriores);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("____________________________________________________________________________________________________________________________________________________________");
		textPane.setForeground(Color.RED);
		textPane.setEditable(false);
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(10, 126, 964, 20);
		contentPane.add(textPane);
	}
}
