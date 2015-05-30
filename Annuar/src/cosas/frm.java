package cosas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class frm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5873654377244570265L;
	private JPanel contentPane;
	private static JTextField txtDato;
	private static JTextField txtIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					frm frame = new frm();
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
	public frm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					cosas.metodos.anuar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnValidar.setBounds(94, 122, 123, 27);
		contentPane.add(btnValidar);

		setTxtDato(new JTextField());
		getTxtDato().setBounds(6, 5, 163, 28);
		contentPane.add(getTxtDato());
		getTxtDato().setColumns(10);
		
		setTxtIngresar(new JTextField());
		getTxtIngresar().setBounds(6, 80, 292, 28);
		contentPane.add(getTxtIngresar());
		getTxtIngresar().setColumns(10);
	}

	public static JTextField getTxtDato() {
		return txtDato;
	}

	public void setTxtDato(JTextField txtDato) {
		frm.txtDato = txtDato;
	}

	public static JTextField getTxtIngresar() {
		return txtIngresar;
	}

	public void setTxtIngresar(JTextField txtIngresar) {
		this.txtIngresar = txtIngresar;
	}
}
