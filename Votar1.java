package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;

public class Votar1 extends JFrame {
	
	
	
	String DB_URL = "jdbc:mysql://127.0.0.1:3306/vota";
	String USER = "root";
	String PASS = "root";
	int i = 0;
	List <String> votacoes = new ArrayList();
	int y  = 171;
	

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Votar1 frame = new Votar1();
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
	public Votar1() {
		
		JPanel panel = new JPanel();
		
		String QUERY = "SELECT titulo FROM votacao";
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);
		      ) {		      
		         while(rs.next()){
		        	 
		            //MOSTRAR INFOS DA VOTAÇÃO
		            System.out.printf(rs.getString("titulo")+ "\n");
		            votacoes.add(rs.getString("titulo"));
		         }
		      } catch (SQLException e1) {
		         e1.printStackTrace();
		      }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("VOTAR");
		lblNewLabel.setBounds(29, 13, 114, 36);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);

		JLabel lblVotaesDisponveis = new JLabel("VOTAÇÕES DISPONÍVEIS");
		lblVotaesDisponveis.setBounds(333, 90, 326, 36);
		lblVotaesDisponveis.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotaesDisponveis.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblVotaesDisponveis);

		JButton btnNewButton_1_1 = new JButton("<");
		btnNewButton_1_1.setBounds(29, 544, 67, 56);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(btnNewButton_1_1);

		JLabel lblNewLabel_2 = new JLabel("_______________________________________________________________________________________________________________________");
		lblNewLabel_2.setBounds(29, 49, 731, 30);
		contentPane.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 532, 656, -372);
		contentPane.add(scrollPane);
		
		JButton[] botoes = new JButton[votacoes.size()];
		
		//JPanel p = new JPanel();
		
		for(String votacao:votacoes) {
			botoes[i] = new JButton(votacao);
			botoes[i].setBounds(240, y, 501, 58);
			botoes[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Votar2 v2 = new Votar2();
					v2.setVisible(true);
					dispose();
				}
			});
			contentPane.add(botoes[i]);
			//p.add(botoes[i]);
			y+=100;
			i++;
		};
		
//		JScrollPane scrollPane_1 = new JScrollPane(p);
//		p.setLayout(null);
//		scrollPane_1.setBounds(250, 145, 600, 00);
//		contentPane.add(scrollPane_1);
		

	}
}


