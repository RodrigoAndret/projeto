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
import javax.swing.JRadioButton;

public class Votar2 extends JFrame {



	String DB_URL = "jdbc:mysql://127.0.0.1:3306/vota";
	String USER = "root";
	String PASS = "root";
	int i = 0;
	List <String> opcoes = new ArrayList();
	int y  = 150;


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
	public Votar2() {

		JList list = new JList();

		String QUERY = "SELECT titulo FROM votacao";
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);
				) {		      
			while(rs.next()){

				//MOSTRAR INFOS DA VOTAÇÃO
				System.out.printf(rs.getString("titulo")+ "\n");
				opcoes.add(rs.getString("titulo"));
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

		JButton btnNewButton_1_1 = new JButton("< Voltar");
		btnNewButton_1_1.setBounds(29, 562, 108, 38);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votar1 v = new Votar1();
				v.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton_1_1);

		JLabel lblNewLabel_2 = new JLabel("_______________________________________________________________________________________________________________________");
		lblNewLabel_2.setBounds(29, 49, 839, 30);
		contentPane.add(lblNewLabel_2);

		JButton[] botoes = new JButton[opcoes.size()];

		JPanel p = new JPanel();
		p.setDoubleBuffered(false);
		p.setEnabled(false);
		p.setLayout(new GridLayout(0, 1));// tentando mudar o layout para ver se adiciona outras linhas

		for(String opcao:opcoes) {
			botoes[i] = new JButton(opcao);
			botoes[i].setBounds(240, y, 501, 58);
			botoes[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Votar2 v2 = new Votar2();
					v2.setVisible(true);
					dispose();
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
		scrollPane_1.setBounds(150, 150, 700, 400);
		contentPane.add(scrollPane_1);
		
		JButton btnNewButton_1_2 = new JButton("CONFIRMAR");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttonGroup.isSelected(null)) {
					JOptionPane.showMessageDialog(null, "Necessário escolher uma opção!" );
					
				}
				
				else {
				Menu menu = new Menu();
				JOptionPane.showMessageDialog(null, "Votação confirmada!");
				menu.setVisible(true);
				dispose();
				}
			
			}
		});
		btnNewButton_1_2.setOpaque(true);
		btnNewButton_1_2.setForeground(new Color(51, 51, 51));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.setBackground(new Color(102, 204, 102));
		btnNewButton_1_2.setBounds(785, 562, 184, 44);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblVotaesDisponveis_1 = new JLabel("Selecione a opção na qual deseja votar:");
		lblVotaesDisponveis_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotaesDisponveis_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVotaesDisponveis_1.setBounds(282, 92, 408, 36);
		contentPane.add(lblVotaesDisponveis_1);


	}
}
