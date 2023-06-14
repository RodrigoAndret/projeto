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
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Votacoes_Anteriores_2 extends JFrame {
	
	String url = "jdbc:mysql://localhost/escola";
	String username = "root";
	String password = "root";

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Votacoes_Anteriores_2 frame = new Votacoes_Anteriores_2();
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
	public Votacoes_Anteriores_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnVotos = new JTextPane();
		txtpnVotos.setText("11 Votos*");
		txtpnVotos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnVotos.setBackground(Color.WHITE);
		txtpnVotos.setBounds(790, 291, 153, 31);
		contentPane.add(txtpnVotos);
		
		JTextPane txtpnVotos_3 = new JTextPane();
		txtpnVotos_3.setText("6 Votos*");
		txtpnVotos_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnVotos_3.setBackground(Color.WHITE);
		txtpnVotos_3.setBounds(790, 383, 153, 31);
		contentPane.add(txtpnVotos_3);
		
		JTextPane txtpnVotos_1 = new JTextPane();
		txtpnVotos_1.setText("3 Votos*");
		txtpnVotos_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnVotos_1.setBackground(Color.WHITE);
		txtpnVotos_1.setBounds(790, 475, 153, 31);
		contentPane.add(txtpnVotos_1);
		
		JButton btnNewButton_1 = new JButton("1. Opção 1*requisição BD*");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(10, 278, 950, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("2. Opção 2*requisição BD*");
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1_1.setBounds(10, 371, 950, 57);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("3. Opção 3*requisição BD*");
		btnNewButton_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1_2.setBounds(10, 463, 950, 57);
		contentPane.add(btnNewButton_1_2);
		
		JButton voltar = new JButton("<- Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votacoes_Anteriores_1 v1 = new Votacoes_Anteriores_1();
				v1.setVisible(true);
				dispose();
			}
		});
		voltar.setHorizontalAlignment(SwingConstants.LEFT);
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		voltar.setBounds(10, 561, 162, 39);
		contentPane.add(voltar);
		
		JTextPane txtpnVotaesAnteriores = new JTextPane();
		txtpnVotaesAnteriores.setText("Votações Anteriores");
		txtpnVotaesAnteriores.setForeground(new Color(255, 0, 0));
		txtpnVotaesAnteriores.setFont(new Font("Swis721 Cn BT", Font.PLAIN, 52));
		txtpnVotaesAnteriores.setEditable(false);
		txtpnVotaesAnteriores.setBackground(Color.LIGHT_GRAY);
		txtpnVotaesAnteriores.setBounds(24, 55, 441, 75);
		contentPane.add(txtpnVotaesAnteriores);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(new Color(255, 0, 0));
		textPane.setBackground(new Color(192, 192, 192));
		textPane.setText("____________________________________________________________________________________________________________________________________________________________");
		textPane.setBounds(10, 124, 964, 20);
		contentPane.add(textPane);
		
		JTextPane txtpnVotaoX = new JTextPane();
		txtpnVotaoX.setText("Votação X*");
		txtpnVotaoX.setForeground(new Color(0, 0, 0));
		txtpnVotaoX.setFont(new Font("Swis721 Cn BT", Font.BOLD, 52));
		txtpnVotaoX.setEditable(false);
		txtpnVotaoX.setBackground(Color.LIGHT_GRAY);
		txtpnVotaoX.setBounds(24, 155, 441, 70);
		contentPane.add(txtpnVotaoX);
		
		JButton voltar_1 = new JButton("<- Voltar");
		voltar_1.setHorizontalAlignment(SwingConstants.LEFT);
		voltar_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		voltar_1.setBounds(24, 5, 162, 39);
		contentPane.add(voltar_1);
	}
}
