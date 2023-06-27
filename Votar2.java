package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;

public class Votar2 extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Votar2 frame = new Votar2();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VOTAR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(22, 11, 114, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblVotaesDisponveis = new JLabel("OPÇÕES DE VOTAÇÃO");
		lblVotaesDisponveis.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotaesDisponveis.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVotaesDisponveis.setBounds(323, 90, 326, 36);
		contentPane.add(lblVotaesDisponveis);
		
		JButton btnNewButton_1_2 = new JButton("CONFIRMAR");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttonGroup.isSelected(null)) {
					JOptionPane.showMessageDialog(null, "Necessário escolher uma opção!" );
					
				}
				
				else {
					Votar1 anterior = new Votar1();
				JOptionPane.showMessageDialog(null, "Votação confirmada!");
				anterior.setVisible(true);
				dispose();
				}
			
			}
		});
		btnNewButton_1_2.setOpaque(true);
		btnNewButton_1_2.setForeground(new Color(51, 51, 51));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.setBackground(new Color(102, 204, 102));
		btnNewButton_1_2.setBounds(774, 556, 184, 44);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("__________________________________________________________________________________________________________________");
		lblNewLabel_2.setBounds(32, 35, 689, 30);
		contentPane.add(lblNewLabel_2);
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(740, 154, 17, 323);
		contentPane.add(scrollBar);
		
		JToggleButton tg1 = new JToggleButton("OPÇÃO 1");
		buttonGroup.add(tg1);
		tg1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		tg1.setBounds(220, 154, 501, 58);
		contentPane.add(tg1);
		
		JToggleButton tg2 = new JToggleButton("OPÇÃO 2 ");
		buttonGroup.add(tg2);
		tg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tg2.setBounds(220, 243, 501, 58);
		contentPane.add(tg2);

		JToggleButton tg3 = new JToggleButton("OPÇÃO 3");
		buttonGroup.add(tg3);
		tg3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tg3.setBounds(220, 334, 501, 58);
		contentPane.add(tg3);
		
		JToggleButton tg4 = new JToggleButton("OPÇÃO 4");
		buttonGroup.add(tg4);
		tg4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		tg4.setBounds(220, 419, 501, 58);
		contentPane.add(tg4);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
                Votar1 initialFrame = new Votar1();
                initialFrame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(22, 556, 55, 44);
		contentPane.add(btnNewButton);
		
		
	}
}