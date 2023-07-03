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
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class Votar extends JFrame{


	JRadioButton nao;
	JRadioButton sim;
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
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Votar frame = new Votar();
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
	public Votar() {

		QUERY = "SELECT titulo FROM votacao";
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
		setBounds(450,250, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Votar");
		lblNewLabel.setForeground(new Color(0, 128, 64));
		lblNewLabel.setBounds(0, 11, 92, 36);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(lblNewLabel);

		JLabel lblVotaesDisponveis = new JLabel("Votações disponíveis:");
		lblVotaesDisponveis.setBounds(52, 103, 241, 36);
		lblVotaesDisponveis.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotaesDisponveis.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblVotaesDisponveis);

		JButton btnNewButton_1_1 = new JButton("< Voltar");
		btnNewButton_1_1.setBounds(29, 562, 108, 38);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton_1_1);

		JButton[] botoes = new JButton[votacoes.size()];

		JPanel p = new JPanel();
		p.setDoubleBuffered(false);
		p.setEnabled(false);
		p.setLayout(new GridLayout(0, 1));
		
		JLabel labelTitulo = new JLabel();
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		labelTitulo.setBounds(566, 150, 364, 96);
		contentPane.add(labelTitulo);

		
		
		
		for(String votacao:votacoes) {
			botoes[i] = new JButton(votacao);
			botoes[i].setBounds(240, y, 501, 58);
			botoes[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					votacao_selecionada = votacao;
					labelTitulo.setText(votacao_selecionada);
				}
			});
			botoes[i].setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			botoes[i].setFont(new Font("Verdana", Font.PLAIN, 21));
			contentPane.add(botoes[i]);
			p.add(botoes[i]);
			p.add(new JLabel(""));
			y+=75;
			i++;
		};

		JScrollPane scrollPane_1 = new JScrollPane(p);
		scrollPane_1.setBounds(75, 150, 450, 400);
		contentPane.add(scrollPane_1);

		sim = new JRadioButton("SIM");
		sim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sim.setBounds(615, 314, 109, 23);
		contentPane.add(sim);

		nao = new JRadioButton("NÃO");
		nao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nao.setBounds(758, 314, 109, 23);
		contentPane.add(nao);
		
		ButtonGroup group = new ButtonGroup();
		group.add(sim);
		group.add(nao);
		
				
		JLabel lblVotaesDisponveis_1 = new JLabel("Selecione a opção na qual deseja votar:");
		lblVotaesDisponveis_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotaesDisponveis_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVotaesDisponveis_1.setBounds(535, 271, 408, 36);
		contentPane.add(lblVotaesDisponveis_1);

		JButton confirmar = new JButton("CONFIRMAR");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QUERY = "SELECT id_votacao FROM votacao where titulo = '" + votacao_selecionada + "'";
				
				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         Statement stmt = conn.createStatement();
				         ResultSet rs = stmt.executeQuery(QUERY);
				      ) {		      
				         while(rs.next()){
				            //MOSTRAR INFOS DA VOTAÇÃO
				        	System.out.println(votacao_selecionada);
				            System.out.printf(rs.getInt("id_votacao")+ "\n");
				            id_votacao = (rs.getInt("id_votacao"));
				            
				         }
				      } catch (SQLException e1) {
				         e1.printStackTrace();
				      }
		
				
					if(sim.isSelected()==true) {
						try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
						         Statement stmt = conn.createStatement();
						      ) {		      
						         // Execute a query
						         System.out.println("Inserindo dados em tabela");
						         
						         
						         
						         String sql = "INSERT INTO voto (id_votacao,opcoes) VALUES ('"+id_votacao+"','sim')";
						         
						         stmt.executeUpdate(sql);  	  
						      } catch (SQLException e1) {
						         e1.printStackTrace();
						      } 
						JOptionPane.showMessageDialog(null, "Voto confirmado!");
						Menu menu = new Menu();
						menu.setVisible(true);
						dispose();
						
					}
					else if (nao.isSelected()==true) {
						try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
						         Statement stmt = conn.createStatement();
						      ) {		      
						         // Execute a query
						         System.out.println("Inserindo dados em tabela");
						         
						         QUERY = "INSERT INTO voto (id_votacao,opcoes) VALUES ("+id_votacao+",'nao')";
						         
						         stmt.executeUpdate(QUERY);  	  
						      } catch (SQLException e1) {
						         e1.printStackTrace();
						      } 
						JOptionPane.showMessageDialog(null, "Voto confirmado!");
						Menu menu = new Menu();
						menu.setVisible(true);
						dispose();

					}
					else {
						JOptionPane.showMessageDialog(null, "Selecione uma opção para votar!");
					}		
				}
				
		});
		confirmar.setOpaque(true);
		confirmar.setForeground(new Color(51, 51, 51));
		confirmar.setFont(new Font("Tahoma", Font.BOLD, 17));
		confirmar.setBorderPainted(false);
		confirmar.setBackground(new Color(102, 204, 102));
		confirmar.setBounds(758, 556, 184, 44);
		contentPane.add(confirmar);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("____________________________________________________________________________________________________________________________________________________________");
		textPane.setForeground(Color.BLACK);
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.menu);
		textPane.setBounds(10, 42, 964, 20);
		contentPane.add(textPane);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(626, 69, 50, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(626, 112, 62, 36);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(686, 69, 212, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(686, 115, 212, 23);
		contentPane.add(textField_1);
		
		


	}
}
