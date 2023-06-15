package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Cursor;

public class Criar2 extends JFrame {

	private JScrollPane contentPane;
	private JTextField opcao1;
	private JTextField opcao2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Criar2 frame = new Criar2();
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
	public Criar2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JScrollPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel linhaSecao = new JLabel("_________________________________________________________________________________________");
		linhaSecao.setForeground(Color.BLUE);
		linhaSecao.setBounds(10, 47, 534, 14);
		contentPane.add(linhaSecao);
		
		JLabel secaoCriar = new JLabel("Criar Votação");
		secaoCriar.setForeground(Color.BLUE);
		secaoCriar.setFont(new Font("Tahoma", Font.PLAIN, 26));
		secaoCriar.setBounds(21, 11, 155, 32);
		contentPane.add(secaoCriar);
		
		JLabel insiraOpcoes = new JLabel("Insira as opções da sua votação:");
		insiraOpcoes.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		insiraOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 32));
		insiraOpcoes.setBounds(44, 117, 489, 39);
		contentPane.add(insiraOpcoes);
		
		opcao1 = new JTextField();
		opcao1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		opcao1.setColumns(10);
		opcao1.setBounds(71, 190, 473, 38);
		contentPane.add(opcao1);
		
		JLabel numeroOpcao1 = new JLabel("1.");
		numeroOpcao1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		numeroOpcao1.setBounds(31, 196, 30, 26);
		contentPane.add(numeroOpcao1);
		
		JLabel numeroOpcao2 = new JLabel("2.");
		numeroOpcao2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		numeroOpcao2.setBounds(31, 262, 30, 26);
		contentPane.add(numeroOpcao2);
		
		opcao2 = new JTextField();
		opcao2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		opcao2.setColumns(10);
		opcao2.setBounds(71, 256, 473, 38);
		contentPane.add(opcao2);
		
		JButton voltar = new JButton("< Voltar");
		voltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Criar1 criar1 = new Criar1();
				criar1.setVisible(true);
				dispose();
			}
		});
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		voltar.setBounds(21, 553, 125, 33);
		contentPane.add(voltar);
		
		JButton criar = new JButton("Criar >>");
		criar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (opcao1.getText().equals("") || opcao2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todas as opções!");
				}
				
				else {
				JOptionPane.showMessageDialog(null, "Votação criada com sucesso!");
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
				}
				
			}
		});
		criar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		criar.setBounds(836, 553, 125, 32);
		contentPane.add(criar);
	}
}
