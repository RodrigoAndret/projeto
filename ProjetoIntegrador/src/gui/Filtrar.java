package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Filtrar extends JFrame {
	
	String DB_URL = "jdbc:mysql://127.0.0.1:3306/vota";
	String USER = "root";
	String PASS = "root";

	private JPanel contentPane;
	private JTextField txtPalavraChave;
	private JTextPane txtpnNometema;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JTextPane txtpnDataDeIncio_1;
	private JTextField textDataInicio;
	private JTextPane txtpnDataFinal;
	private JTextField textDataFinal;
	private JTextPane txtpnResultado;
	private JButton btnBuscar;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filtrar frame = new Filtrar();
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
	public Filtrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnFiltros = new JTextPane();
		txtpnFiltros.setForeground(new Color(0, 0, 255));
		txtpnFiltros.setFont(new Font("Swis721 Cn BT", Font.PLAIN, 52));
		txtpnFiltros.setEditable(false);
		txtpnFiltros.setBackground(new Color(192, 192, 192));
		txtpnFiltros.setText("Consultar votações");
		txtpnFiltros.setBounds(36, 35, 441, 70);
		contentPane.add(txtpnFiltros);
		
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
		
		txtPalavraChave = new JTextField();
		txtPalavraChave.setToolTipText("Digite aqui");
		txtPalavraChave.setForeground(new Color(0, 0, 0));
		txtPalavraChave.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtPalavraChave.setBounds(215, 173, 198, 39);
		contentPane.add(txtPalavraChave);
		txtPalavraChave.setColumns(10);
		
		txtpnNometema = new JTextPane();
		txtpnNometema.setFont(new Font("Tahoma", Font.PLAIN, 27));
		txtpnNometema.setBackground(new Color(192, 192, 192));
		txtpnNometema.setText("Palavra chave:");
		txtpnNometema.setBounds(24, 173, 188, 39);
		contentPane.add(txtpnNometema);
		
		btnNewButton = new JButton("°Votação 1*requisição BD*");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votacoes_Anteriores_2 v2 = new Votacoes_Anteriores_2();
				v2.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(495, 170, 466, 57);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("°Votação 2*requisição BD*");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votacoes_Anteriores_2 v2 = new Votacoes_Anteriores_2();
				v2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(495, 249, 466, 57);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("°Votação 3*requisição BD*");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votacoes_Anteriores_2 v2 = new Votacoes_Anteriores_2();
				v2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_2.setBounds(495, 331, 466, 57);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("°Votação 4*requisição BD*");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votacoes_Anteriores_2 v2 = new Votacoes_Anteriores_2();
				v2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_3.setBounds(495, 409, 466, 57);
		contentPane.add(btnNewButton_3);
		
		txtpnDataDeIncio_1 = new JTextPane();
		txtpnDataDeIncio_1.setText("Data de início: ");
		txtpnDataDeIncio_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		txtpnDataDeIncio_1.setBackground(Color.LIGHT_GRAY);
		txtpnDataDeIncio_1.setBounds(24, 302, 188, 39);
		contentPane.add(txtpnDataDeIncio_1);
		
		textDataInicio = new JTextField();
		textDataInicio.setToolTipText("Digite aqui");
		textDataInicio.setForeground(Color.BLACK);
		textDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textDataInicio.setColumns(10);
		textDataInicio.setBounds(215, 302, 198, 39);
		contentPane.add(textDataInicio);
		
		txtpnDataFinal = new JTextPane();
		txtpnDataFinal.setText("Data final:");
		txtpnDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 27));
		txtpnDataFinal.setBackground(Color.LIGHT_GRAY);
		txtpnDataFinal.setBounds(24, 427, 181, 39);
		contentPane.add(txtpnDataFinal);
		
		textDataFinal = new JTextField();
		textDataFinal.setToolTipText("Digite aqui");
		textDataFinal.setForeground(Color.BLACK);
		textDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textDataFinal.setColumns(10);
		textDataFinal.setBounds(215, 427, 198, 39);
		contentPane.add(textDataFinal);
		
		txtpnResultado = new JTextPane();
		txtpnResultado.setText("Resultado:");
		txtpnResultado.setFont(new Font("Tahoma", Font.PLAIN, 27));
		txtpnResultado.setBackground(Color.LIGHT_GRAY);
		txtpnResultado.setBounds(495, 124, 188, 39);
		contentPane.add(txtpnResultado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PalavraChave = txtPalavraChave.getText();
					// POP UP OPCIONAL:  JOptionPane.showMessageDialog(null, "Busca realizada");
					// depois precisa adaptar para o real banco de dados
					String QUERY = "SELECT titulo FROM votacao WHERE titulo like '%" + PalavraChave + "%'";
					try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					         Statement stmt = conn.createStatement();
					         ResultSet rs = stmt.executeQuery(QUERY);
					      ) {		      
					         while(rs.next()){
					            //MOSTRAR INFOS DA VOTAÇÃO
					            System.out.printf(rs.getString("titulo")+ "\n");
					            
					         }
					      } catch (SQLException e1) {
					         e1.printStackTrace();
					      }
			}});
		btnBuscar.setBackground(new Color(148, 189, 235));
		btnBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnBuscar.setBounds(799, 561, 162, 39);
		contentPane.add(btnBuscar);
		
		textPane = new JTextPane();
		textPane.setText("____________________________________________________________________________________________________________________________________________________________");
		textPane.setForeground(new Color(0, 0, 255));
		textPane.setEditable(false);
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(10, 97, 964, 20);
		contentPane.add(textPane);
	}

}
