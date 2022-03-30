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

public class VentanaJPasswordField extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1531539371445418371L;
	private JPanel Holamundo;
	private JPanel panel;
	private JLabel lblNewLabel_1;

	private JLabel lblNewLabel_2;

	private JButton btnNewButton;
	private JTextField txtUsuario;
	private JPasswordField txtcontrasena;
	private JLabel lblTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJPasswordField frame = new VentanaJPasswordField();
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
	public VentanaJPasswordField() {
		setResizable(false);
		setTitle("Hola ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Holamundo = new JPanel();
		Holamundo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Holamundo);
		Holamundo.setLayout(new BorderLayout(0, 0));
		
		lblTexto = new JLabel("Anonimo");
		lblTexto.setForeground(Color.BLUE);
		lblTexto.setBackground(Color.BLUE);
		lblTexto.setVerticalAlignment(SwingConstants.TOP);
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setFont(new Font("Vivaldi", Font.ITALIC, 53));
		Holamundo.add(lblTexto, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		Holamundo.add(panel, BorderLayout.SOUTH);
		
		lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.addActionListener(this);
		panel.add(txtUsuario);
		txtUsuario.setColumns(8);
		
		lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_2);
		
		txtcontrasena = new JPasswordField();
		txtcontrasena.addActionListener(this);
		txtcontrasena.setColumns(8);
		panel.add(txtcontrasena);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String usuariocorr="1dw3";
	  String contrasenacorr="1dw3";
	  String usuario;
	  String contrasena;
	  usuario = txtUsuario.getText();
	  contrasena = new String(txtcontrasena.getPassword());
	  if(contrasena.equals(contrasenacorr) && usuario.equals(usuariocorr)){
	  	lblTexto.setText("Bienvenido");
	  }
	  else {	
	  	lblTexto.setText("Se ha producido");
	  }
 }
}