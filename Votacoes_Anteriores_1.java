package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

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
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.SoftBevelBorder;
import java.awt.ComponentOrientation;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Panel;

public class Votacoes_Anteriores_1 extends JFrame {
	
	
	
	String DB_URL = "jdbc:mysql://127.0.0.1:3306/vota";
	String USER = "root";
	String PASS = "root";
	int i = 0;
	List <String> votacoes = new ArrayList();
	int y  = 150;
	String votacao_selecionada = "";
	String QUERY = "";
	int id_votacao = 0;
	
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
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
		
		JList list = new JList();
		
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

		JLabel lblNewLabel = new JLabel("CONSULTAR");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(10, 22, 185, 36);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(lblNewLabel);

		JLabel lblVotaesDisponveis = new JLabel("VOTAÇÕES ANTERIORES");
		lblVotaesDisponveis.setBounds(10, 103, 326, 36);
		lblVotaesDisponveis.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotaesDisponveis.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblVotaesDisponveis);

		JButton btnNewButton_1_1 = new JButton("<");
		btnNewButton_1_1.setBounds(10, 555, 67, 56);
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
		lblNewLabel_2.setBounds(29, 49, 839, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel votacao_atual = new JLabel("");
		votacao_atual.setBounds(648, 170, 148, 30);
		contentPane.add(votacao_atual);

		JButton[] botoes = new JButton[votacoes.size()];
		
		JPanel p = new JPanel();
		p.setDoubleBuffered(false);
		p.setEnabled(false);
		p.setLayout(new GridLayout(0, 1));// tentano mudar o layout para ver se adiciona outras linhas
		
		for(String votacao:votacoes) {
			botoes[i] = new JButton(votacao);
			botoes[i].setBounds(240, y, 501, 58);
			botoes[i].setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			botoes[i].setFont(new Font("Verdana", Font.PLAIN, 21));
			botoes[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					votacao_selecionada = votacao;
					votacao_atual.setText(votacao_selecionada);
				
					String QUERY = "SELECT id_votacao FROM votacao where titulo = '" + votacao_selecionada + "'";
					
					try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					         Statement stmt = conn.createStatement();
					         ResultSet rs = stmt.executeQuery(QUERY);
					      ) {		      
					         while(rs.next()){
					            
					        	System.out.println(votacao_selecionada);
					            System.out.printf(rs.getInt("id_votacao")+ "\n");
					            id_votacao = (rs.getInt("id_votacao"));
					            
					            
					         }
					      } catch (SQLException e1) {
					         e1.printStackTrace();
					      }
					
				}
			});
			contentPane.add(botoes[i]);
			p.add(botoes[i]);
			p.add(new JLabel(""));
			y+=75;
			i++;
		};
		
		JScrollPane scrollPane_1 = new JScrollPane(p);
		scrollPane_1.setBounds(62, 150, 400, 400);
		contentPane.add(scrollPane_1);
		
		
		
	}
}
