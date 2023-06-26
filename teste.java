package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class teste extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teste frame = new teste();
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
	public teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(309, 120, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JButton[] botoes = new JButton[4];
		botoes[1] = new JButton("Botão 1");
		botoes[1].setBounds(159, 55, 89, 23);
		contentPane.add(botoes[1]);
		
		botoes[2] = new JButton("Botão 2");
		botoes[2].setBounds(159, 100, 89, 23);
		contentPane.add(botoes[2]);
		
		
	}
}
