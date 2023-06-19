package projetoIntegrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

public class Votar1 extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("VOTAR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(29, 13, 114, 36);
		contentPane.add(lblNewLabel);

		JLabel lblVotaesDisponveis = new JLabel("VOTAÇÕES DISPONÍVEIS");
		lblVotaesDisponveis.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotaesDisponveis.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVotaesDisponveis.setBounds(333, 90, 326, 36);
		contentPane.add(lblVotaesDisponveis);



		JButton btnNewButton_1_1 = new JButton("<");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnNewButton_1_1.setBounds(29, 544, 67, 56);
		contentPane.add(btnNewButton_1_1);

		JLabel lblNewLabel_2 = new JLabel("_______________________________________________________________________________________________________________________");
		lblNewLabel_2.setBounds(29, 49, 731, 30);
		contentPane.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 532, 656, -372);
		contentPane.add(scrollPane);


			
		
		JToggleButton bt1 = new JToggleButton("OPÇÃO 1");
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votar2 next = new Votar2();
				next.setVisible(true);
				dispose();
			}
		});
		buttonGroup.add(bt1);
		bt1.setBounds(243, 171, 501, 58);
		contentPane.add(bt1);

		JToggleButton bt2 = new JToggleButton("OPÇÃO 2");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votar2 next = new Votar2();
				next.setVisible(true);
				dispose();
			}
		});
		buttonGroup.add(bt2);
		bt2.setBounds(243, 261, 501, 58);
		contentPane.add(bt2);

		JToggleButton bt3 = new JToggleButton("OPÇÃO 3");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votar2 next = new Votar2();
			next.setVisible(true);
			dispose();
			}
		});
		buttonGroup.add(bt3);
		bt3.setBounds(243, 348, 501, 58);
		contentPane.add(bt3);

		JToggleButton bt4 = new JToggleButton("OPÇÃO 4");
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votar2 next = new Votar2();
				next.setVisible(true);
				dispose();
				
			}
		});
		buttonGroup.add(bt4);
		bt4.setBounds(243, 436, 501, 58);
		contentPane.add(bt4);



	}
}


