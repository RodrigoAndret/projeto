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
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Criar1 extends JFrame {

	private JPanel contentPane;
	private JTextField tema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Criar1 frame = new Criar1();
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
	public Criar1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Criar Votação");
		lblNewLabel.setBounds(10, 11, 155, 32);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Insira o tema da sua votação:");
		lblNewLabel_2.setBounds(241, 230, 424, 39);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(lblNewLabel_2);
		
		tema = new JTextField();
		tema.setBounds(231, 304, 473, 38);
		tema.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tema.setColumns(10);
		contentPane.add(tema);
		
		JButton Voltar = new JButton("< Voltar");
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		Voltar.setBounds(10, 547, 125, 33);
		Voltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(Voltar);
		
		JButton Avancar = new JButton("Avançar >");
		Avancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tema.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira um tema!");
				}
					
				else {
				Criar2 criar2 = new Criar2();
				criar2.setVisible(true);
				dispose();
				}
			}
		});
		Avancar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Avancar.setBounds(805, 547, 145, 32);
		contentPane.add(Avancar);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("____________________________________________________________________________________________________________________________________________________________");
		textPane.setForeground(new Color(0, 0, 255));
		textPane.setEditable(false);
		textPane.setBackground(new Color(240, 240, 240));
		textPane.setBounds(10, 39, 964, 20);
		contentPane.add(textPane);
	}
}