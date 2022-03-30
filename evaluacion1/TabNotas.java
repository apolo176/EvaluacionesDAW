package evaluacion1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;

public class TabNotas extends JFrame {

	private static final long serialVersionUID = -7432671980495821429L;

	// defino los componentes
	private JLabel lblMensaje;
	private JButton btnAceptar;
	
	private JPanel contentPane;
	private JTextField txtDatos;
	private JLabel lblNewLabel;
	private JPanel panel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabNotas frame = new TabNotas();
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
	public TabNotas() {
		setTitle("ParImpar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblMensaje = new JLabel("");
		lblMensaje.setForeground(new Color(0, 0, 128));
		lblMensaje.setFont(new Font("Verdana", Font.ITALIC, 18));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMensaje);
		
		panel = new JPanel();
		contentPane.add(panel);
		
		lblNewLabel = new JLabel("Introduzca una nota");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		
		txtDatos = new JTextField();
		txtDatos.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDatos.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(lblNewLabel);
		panel.add(txtDatos);
		panel.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor;
				int n;
				
				valor = txtDatos.getText();
				// convierto el valor a int
				n= Integer.parseInt(valor);
				switch (n)
				{
				
				case 0:
					lblMensaje.setText("La calificacion es md ");
					break;
				case 1:
					lblMensaje.setText("La calificacion es md ");
					
					break;
				case 2:
					lblMensaje.setText("La calificacion es md ");
					break;
				case 3:
					lblMensaje.setText("La calificacion es md ");
					break;
				case 4:
					lblMensaje.setText("La calificacion es ins ");
					break;
				case 5:
					lblMensaje.setText("La calificacion es suf");
					break;
				case 6:
					lblMensaje.setText("La calificacion es bien");
					break;
				case 7:
					lblMensaje.setText("La calificacion es not ");
					break;
				case 8:
					lblMensaje.setText("La calificacion es not ");
					break;
				case 9:
					lblMensaje.setText("La calificacion es sobre ");
					break;
					case 10:
						lblMensaje.setText("La calificacion es sobre ");
					break;
				}
				
				
				
		
			}
		});
	}

}

