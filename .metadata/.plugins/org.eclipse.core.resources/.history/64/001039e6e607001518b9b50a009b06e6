package compiladores;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class FrmMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 421979183878054042L;
	private JPanel contentPane;
	private JTextField txtValidar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenu frame = new FrmMenu();
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
	public FrmMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtValidar = new JTextField();
		txtValidar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtValidar.setBounds(6, 86, 438, 28);
		contentPane.add(txtValidar);
		txtValidar.setColumns(10);
		
		JLabel lblGramatica = new JLabel("Bienvenido, AppCompiler");
		lblGramatica.setHorizontalAlignment(SwingConstants.CENTER);
		lblGramatica.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblGramatica.setBounds(6, 6, 438, 40);
		contentPane.add(lblGramatica);
		
		JLabel lblIngreseLaGramatica = new JLabel("Ingrese la gramatica:");
		lblIngreseLaGramatica.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblIngreseLaGramatica.setBounds(6, 58, 438, 16);
		contentPane.add(lblIngreseLaGramatica);
		
		JLabel lblNada = new JLabel("Resultado:");
		lblNada.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNada.setBounds(6, 126, 90, 28);
		contentPane.add(lblNada);
		
		JLabel lblResultado = new JLabel("Mensaje");
		lblResultado.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblResultado.setBounds(108, 126, 336, 28);
		contentPane.add(lblResultado);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 166, 438, 52);
		contentPane.add(panel);
		
		JLabel lblPasos = new JLabel("-");
		lblPasos.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		panel.add(lblPasos);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					compiladores.Funcionalidad.analizador();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnValidar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnValidar.setBounds(6, 230, 438, 29);
		contentPane.add(btnValidar);
	}
}
