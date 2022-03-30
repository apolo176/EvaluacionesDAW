package evaluacion1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Panel;

public class VentanaActionListenerDiferentesComponentes extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1531539371445418371L;
	private JPanel Holamundo;
	private JLabel lblTexto;
	private Panel panel;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaActionListenerDiferentesComponentes frame = new VentanaActionListenerDiferentesComponentes();
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
	public VentanaActionListenerDiferentesComponentes() {
		setResizable(false);
		setTitle("Hola ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Holamundo = new JPanel();
		Holamundo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Holamundo);
		Holamundo.setLayout(new BorderLayout(0, 0));
		
		lblTexto = new JLabel("Ningun boton pulsado");
		lblTexto.setForeground(Color.BLUE);
		lblTexto.setBackground(Color.BLUE);
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setFont(new Font("Verdana", Font.ITALIC, 14));
		Holamundo.add(lblTexto, BorderLayout.CENTER);
		
		panel = new Panel();
		Holamundo.add(panel, BorderLayout.NORTH);
		
		btn1 = new JButton("boton 1");
		btn1.addActionListener(this);
		panel.add(btn1);
		
		btn2 = new JButton("boton 2");
		btn2.addActionListener(this);
		panel.add(btn2);
		
		btn3 = new JButton("boton3");
		btn3.addActionListener(this);
		panel.add(btn3);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
	// obtengo sobre que componente se ha realizado la accion
	Object o = ae.getSource();
	if (o == btn1){
	// si se ha pulsado btnAceptar
		lblTexto.setText("Ha pulsado el boton 1");
	}
	else if (o == btn2){
	// si se ha pulsado enter dentro de txtNombre
		lblTexto.setText("Ha pulsado el boton 2");
	}
	else if (o == btn3){
	// si se ha pulsado enter dentro de pwfContrasena
		lblTexto.setText("Ha pulsado el boton 3");
	}
	}
}