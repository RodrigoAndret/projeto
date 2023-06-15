package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;

public class MenuAdm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdm frame = new MenuAdm();
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
	public MenuAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton consultarVotacoes = new JButton("CONSULTAR VOTAÇÕES");
		consultarVotacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votacoes_Anteriores_1 v1 = new Votacoes_Anteriores_1();
				v1.setVisible(true);
				dispose();
			}
		});
		consultarVotacoes.setOpaque(true);
		consultarVotacoes.setForeground(Color.WHITE);
		consultarVotacoes.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 22));
		consultarVotacoes.setBackground(new Color(225, 81, 96));
		consultarVotacoes.setBounds(57, 284, 262, 300);
		contentPane.add(consultarVotacoes);
		
		JButton criarVotacao = new JButton("CRIAR VOTAÇÃO");
		criarVotacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Criar1 c1 = new Criar1();
				c1.setVisible(true);
				dispose();
			}
		});
		criarVotacao.setOpaque(true);
		criarVotacao.setForeground(Color.WHITE);
		criarVotacao.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 22));
		criarVotacao.setBackground(new Color(0, 128, 192));
		criarVotacao.setBounds(351, 284, 262, 300);
		contentPane.add(criarVotacao);
		
		JButton votar = new JButton("VOTAR");
		votar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votar1 votar1 = new Votar1();
				votar1.setVisible(true);
				dispose();
			}
		});
		votar.setOpaque(true);
		votar.setForeground(Color.WHITE);
		votar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 22));
		votar.setBackground(new Color(0, 128, 64));
		votar.setBounds(644, 284, 262, 300);
		contentPane.add(votar);
		
		JLabel lblNewLabel = new JLabel("Selecione uma opção:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 52));
		lblNewLabel.setBounds(214, 105, 536, 62);
		contentPane.add(lblNewLabel);
	}

}