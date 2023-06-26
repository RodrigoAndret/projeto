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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.util.Date;

public class Votacoes_Anteriores_1 extends JFrame {
	
	String DB_URL = "jdbc:mysql://127.0.0.1:3306/vota";
	String USER = "root";
	String PASS = "root";
	int i = 0;
	List <String> votacoes = new ArrayList();
	List <String> datas = new ArrayList();
	int y  = 150;
	//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	//String dataAtual = dtf.format(LocalDateTime.now());

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
		
		String QUERY = "SELECT titulo,data_final,data_votacao FROM votacao";
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);
		      ) {		      
		         while(rs.next()){
		        	
		        	//String data_final = rs.getString("data_final");
		        	//int ret = dataAtual.compareTo(data_final);
		        	//if(ret < 0) {
		            System.out.printf(rs.getString("titulo")+ "\n");
		            votacoes.add(rs.getString("titulo"));
		            datas.add(rs.getString("data_votacao"));
		        	//}
		         }
		      } catch (SQLException e1) {
		         e1.printStackTrace();
		      }
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Filtrar pesquisa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filtrar filtrar = new Filtrar();
				filtrar.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(779, 68, 171, 39);
		contentPane.add(btnNewButton);
		
		JButton[] botoes = new JButton[votacoes.size()];
		int x = 15;
		for(String votacao:votacoes) {
			
			botoes[i] = new JButton(votacao);
			botoes[i].setBounds(x, y, 450, 57);
			botoes[i].setHorizontalAlignment(SwingConstants.LEFT);
			botoes[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
			contentPane.add(botoes[i]);
			if (y== 450 ) {
				x=500;
				y = 75;
			}
			//p.add(botoes[i]);
			y+=75;
			i++;
		};
		
		JButton voltar = new JButton("< Voltar");
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
		
		JTextPane textPane = new JTextPane();
		textPane.setText("____________________________________________________________________________________________________________________________________________________________");
		textPane.setForeground(new Color(255, 0, 0));
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.menu);
		textPane.setBounds(10, 44, 964, 20);
		contentPane.add(textPane);
		
		JLabel lblNewLabel = new JLabel("Consultar votações");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 11, 262, 31);
		contentPane.add(lblNewLabel);
	}
}
