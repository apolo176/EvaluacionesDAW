package evaluacion1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JOptionPaneShowOptionDialog extends JFrame implements ActionListener{

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
					JOptionPaneShowOptionDialog frame = new JOptionPaneShowOptionDialog();
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
	public JOptionPaneShowOptionDialog() {
		setResizable(false);
		setTitle("Foco");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Holamundo = new JPanel();
		Holamundo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Holamundo);
		Holamundo.setLayout(new BorderLayout(0, 0));
		
		lblTexto = new JLabel("No se ha pulsado un boton");
		lblTexto.setForeground(Color.BLUE);
		lblTexto.setBackground(Color.BLUE);
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setFont(new Font("Vivaldi", Font.ITALIC, 22));
		Holamundo.add(lblTexto, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		Holamundo.add(panel, BorderLayout.SOUTH);
		
	
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] opciones = {"1AS3", "2AS3", "1DW3", "2DW3", "1SM2", "2SM2"};
		int opcion = JOptionPane.showOptionDialog(this,"Prueba de Cuadros de Diálogo","Cuadro de Diálogo con OpcionesPersonalizadas",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[2]); // pone como opcion por defecto "1DW3"
	 /*
		if(opcion==0)
	  {
	  	lblTexto.setText("Ha pulsado"+opciones[0]);
	  }
	  else if(opcion==1)
	  {
	  	lblTexto.setText("Ha pulsado"+opciones[1]);
	  	
	  }
	  else if(opcion==2)
	  {
	  	lblTexto.setText("Ha pulsado "+opciones[2]);
	  }
	  else if(opcion==3)
	  {
	  	lblTexto.setText("Ha pulsado"+opciones[3]);
	  }
	  else if(opcion==4)
	  {
	  	lblTexto.setText("Ha pulsado"+opciones[4]);
	  }
	  else if(opcion==5)
	  {
	  	lblTexto.setText("Ha pulsado"+opciones[5]);
	  }
	  else
	  {
	  	lblTexto.setText("Errror!");
	  }
	  	
	  	*/
		if(opcion==JOptionPane.CLOSED_OPTION)
		{
	  	lblTexto.setText("Errror!");
}
		else
		{
	  	lblTexto.setText("Ha pulsado"+opciones[opcion]);
		}
	  
 }
}