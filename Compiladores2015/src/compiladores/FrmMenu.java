package compiladores;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class FrmMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 421979183878054042L;
	private static JTextField txtPasos;
	private static JTextField txtResultado;
	private static JTextField txtValidar;
	/**
	 * @return the txtPasos
	 */
	public static JTextField getTxtPasos() {
		return txtPasos;
	}

	/**
	 * @return the txtResultado
	 */
	public static JTextField getTxtResultado() {
		return txtResultado;
	}

	/**
	 * @return the txtValidar
	 */
	public static JTextField getTxtValidar() {
		return txtValidar;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FrmMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMenu.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setTitle("Compiladores 2015");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("Daniel y Yuraniss");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTxtValidar(new JTextField());
		getTxtValidar().setToolTipText("Ejemplo: y=a+b¬");
		getTxtValidar().setText("¬");
		getTxtValidar().setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		getTxtValidar().setBounds(6, 86, 438, 28);
		contentPane.add(getTxtValidar());
		getTxtValidar().setColumns(10);
		
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
		lblNada.setForeground(new Color(0, 0, 255));
		lblNada.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNada.setBounds(6, 126, 90, 28);
		contentPane.add(lblNada);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 166, 438, 52);
		contentPane.add(panel);
		
		setTxtPasos(new JTextField());
		getTxtPasos().setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		getTxtPasos().setEnabled(false);
		getTxtPasos().setEditable(false);
		panel.add(getTxtPasos());
		getTxtPasos().setColumns(10);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					compiladores.Funcionalidad.analizador();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnValidar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnValidar.setBounds(6, 230, 266, 42);
		contentPane.add(btnValidar);
		
		setTxtResultado(new JTextField());
		getTxtResultado().setBackground(UIManager.getColor("Button.select"));
		getTxtResultado().setHorizontalAlignment(SwingConstants.CENTER);
		getTxtResultado().setEnabled(false);
		getTxtResultado().setEditable(false);
		getTxtResultado().setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		getTxtResultado().setBounds(108, 126, 336, 28);
		contentPane.add(getTxtResultado());
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnX.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnX.setBounds(386, 230, 58, 42);
		contentPane.add(btnX);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtValidar.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnLimpiar.setBounds(284, 230, 90, 42);
		contentPane.add(btnLimpiar);
		getTxtResultado().setColumns(10);
	}

	/**
	 * @param txtPasos the txtPasos to set
	 */
	public void setTxtPasos(JTextField txtPasos) {
		FrmMenu.txtPasos = txtPasos;
	}

	/**
	 * @param txtResultado the txtResultado to set
	 */
	public void setTxtResultado(JTextField txtResultado) {
		FrmMenu.txtResultado = txtResultado;
	}

	/**
	 * @param txtValidar the txtValidar to set
	 */
	public void setTxtValidar(JTextField txtValidar) {
		FrmMenu.txtValidar = txtValidar;
	}
}
