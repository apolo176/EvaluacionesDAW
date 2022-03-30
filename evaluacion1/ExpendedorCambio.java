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

public class ExpendedorCambio extends JFrame {

	private static final long serialVersionUID = -7432671980495821429L;

	// defino los componentes
	private JLabel lblMensaje;
	private JButton btnAceptar;
	
	private JPanel contentPane;
	private JTextField txtDatos;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JTextField textMenu;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpendedorCambio frame = new ExpendedorCambio();
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
	public ExpendedorCambio() {
		setTitle("expendedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		lblMensaje = new JLabel("");
		lblMensaje.setForeground(new Color(0, 0, 128));
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMensaje, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("Introduzca un saldo");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		
		txtDatos = new JTextField();
		txtDatos.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(txtDatos);
		txtDatos.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		lblNewLabel_1 = new JLabel("introduce una opcion del menu");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNewLabel_1);
		
		textMenu = new JTextField();
		panel_1.add(textMenu);
		textMenu.setColumns(10);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor,valormenu;
				double euros;
				double importe, cambio;
				int menu;
				valor = txtDatos.getText();
				// convierto el valor a int
				euros= Integer.parseInt(valor);
				valormenu = textMenu.getText();
				menu=Integer.parseInt(valormenu);
				if(menu>=1 && menu<4) {
				switch (menu)
				{
				
				case 1:
					importe=0.43;
					if(euros>=importe)
					{
						cambio=euros-importe;
						lblMensaje.setText("Su producto, gracias. Cambio:"+cambio);
					}
					else
					{
						lblMensaje.setText("Saldo insuficiente! ");
					}
					
					break;
				case 2:
					importe=1.11;
					if(euros>=importe)
					{
						cambio=euros-importe;
						lblMensaje.setText("Su producto, gracias "+cambio);
					}
					else
					{
						lblMensaje.setText("Saldo insuficiente! ");
					}
				
					
					break;
				case 3:
					importe=0.36;
					if(euros>=importe)
					{
						cambio=euros-importe;
						lblMensaje.setText("Su producto, gracias "+cambio);
					}
					else
					{
						lblMensaje.setText("Saldo insuficiente! ");
					}
							break;
				}
				}
				else
				{
					lblMensaje.setText("Opcion Incorrecta ");
				}


			}
		});
	}

}

