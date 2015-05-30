import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Stack;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Pila extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2007595534557681922L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblEstado;
	private static Stack<String> pila=new Stack<String>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pila frame = new Pila();
					frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Pila() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntroduzcaCadena = new JLabel("Digite una expresion aritmetica:");
		lblIntroduzcaCadena.setForeground(Color.BLUE);
		lblIntroduzcaCadena.setBounds(10, 90, 240, 15);
		lblIntroduzcaCadena.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));
		contentPane.add(lblIntroduzcaCadena);
		
		textField = new JTextField();
		textField.setBounds(10, 116, 514, 30);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				int c=e.getKeyChar();
				if((c!=40)&&(c!=41)&&(c!=42)&&(c!=43)&&(c!=44)&&(c!=45)&&(c!=46)&&(c!=47)&&(c!=48)&&(c!=49)&&(c!=50)&&(c!=51)&&
				(c!=52)&&(c!=53)&&(c!=54)&&(c!=55)&&(c!=56)&&(c!=57)&&(c!=123)&&(c!=125)&&(c!=61)&&(c!=94)&&
				(c!=KeyEvent.VK_DELETE)&&(c!=KeyEvent.VK_BACK_SPACE)){
					e.consume();
			}
			}
				
		});
		textField.setFont(new Font("Arial", Font.BOLD, 20));
		textField.setColumns(10);
		contentPane.add(textField);
		
		JButton btnDeterminar = new JButton("Expresion Valida?");
		btnDeterminar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
		btnDeterminar.setBounds(10, 157, 212, 23);
		btnDeterminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
		    	while(Pila.pila.size()>0){
					Pila.pila.pop();
				}
				int llave=0;
				int parentesis=0;
				int estado=0;
				int i=0;
				String cadena=textField.getText();
				int tamano=cadena.length();
				while(i<tamano){
					switch(cadena.charAt(i)){
						case '{':
							if(llave==0 && parentesis==0){
								Pila.pila.push("{");
								llave=1;
							}else{
								i=tamano;
								estado=1;
							}
							break;
						case '}':
							if(llave==1 && parentesis==0){
								Pila.pila.pop();
								llave=0;
							}else{
								i=tamano;
								estado=1;
							}
							break;
						case '(':
							Pila.pila.push("(");
							parentesis++;
							break;
						case ')':
							if(parentesis==0||Pila.pila.size()==0){
								i=tamano;
								estado=1;
							}else{
								Pila.pila.pop();
								parentesis--;
							}
							break;
						default :
					}i++;
				}
				if(estado>0||Pila.pila.size()!=0){
					textField_1.setText("Rechazo");
				}else {
					textField_1.setText("Aceptacion");
				}
			}
		});
		contentPane.add(btnDeterminar);
		
		JLabel lblPila = new JLabel("Maquina de pila");
		lblPila.setForeground(Color.BLUE);
		lblPila.setBounds(190, 11, 171, 40);
		lblPila.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
		contentPane.add(lblPila);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
		textField_1.setForeground(Color.RED);
		textField_1.setBounds(399, 176, 125, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(Color.BLUE);
		lblEstado.setBounds(320, 175, 69, 25);
		lblEstado.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));
		contentPane.add(lblEstado);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
		btnSalir.setBounds(10, 191, 89, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
		});
		contentPane.add(btnSalir);
	}
}
