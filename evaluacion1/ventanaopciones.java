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
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ventanaopciones extends JFrame {

	private static final long serialVersionUID = -7432671980495821429L;
	private JButton btnAceptar;
	
	private JPanel contentPane;
	private JTextField txtDatos;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaopciones frame = new ventanaopciones();
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
	public ventanaopciones() {
		setTitle("VentanaLeernum1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{19, 317, 10, 45, 0};
		gbl_contentPane.rowHeights = new int[]{37, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		lblNewLabel = new JLabel("Introduzca un n\u00FAmero entero");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		
		txtDatos = new JTextField();
		txtDatos.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(txtDatos);
		txtDatos.setText("0");
		txtDatos.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		  int ractual=0,ranterior,n;
			double error=0;
			String num;
				
			num=txtDatos.getText();
			n=Integer.parseInt(num);
			
			ranterior=n/2;
			
				while(error<0.0000001) 
				{
					ractual=((n/ranterior)+ranterior)/2;
					error=ranterior-ractual;
					if(error<0) 
					{
						error=-error;
					}
				ranterior=ractual;
				}
				lblNewLabel_1.setText("La raiz de tu numero es: "+ractual);	
			}
			
			
			
		});
		
		lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
	}

}

