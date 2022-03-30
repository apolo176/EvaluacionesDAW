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

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;

public class VentanaJListNumero extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1531539371445418371L;
	private JPanel JFrameListNumero;
	private DefaultListModel<Integer> dlm;
  private JList<Integer> lstNumero;
  private JPanel panel_1;
  private JPanel panelbotones;
  private JLabel lblNumero;
  private JTextField txtNumero;
 
  private JButton btnInsertar;
  private JButton btnBorrar;
  private JButton btnLimpiar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListNumero frame = new VentanaJListNumero();
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
	public VentanaJListNumero() {
		setResizable(false);
		setTitle("VentanaJListGroupos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JFrameListNumero = new JPanel();
		JFrameListNumero.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JFrameListNumero);
	
		
		// Modelo de datos
		
		JFrameListNumero.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		JFrameListNumero.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setToolTipText("");
		txtNumero.addActionListener(this);
		txtNumero.setText("");
		panel_1.add(txtNumero);
		txtNumero.setColumns(10);
	
		
	  panelbotones = new JPanel();
		panel_1.add(panelbotones);
		
		btnInsertar= new JButton("Insertar");
		panelbotones.add(btnInsertar);
		btnInsertar.addActionListener(this);
		
		btnLimpiar= new JButton("Limpiar");
		panelbotones.add(btnLimpiar);
		btnLimpiar.addActionListener(this);
		
		btnBorrar = new JButton("Borrar");
		panelbotones.add(btnBorrar);
		btnBorrar.addActionListener(this);
	
		
		dlm = new DefaultListModel<Integer>();
		lstNumero = new JList<Integer>();
		lstNumero.setModel(dlm);
		JFrameListNumero.add(lstNumero, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Object o = ae.getSource();
		if(o == this.btnInsertar || o==this.txtNumero)
		{
			
			int numero = Integer.parseInt(txtNumero.getText());
			
			if (dlm.contains(numero)) {
			JOptionPane.showMessageDialog(this, (String)"Error", "Error", JOptionPane.ERROR_MESSAGE);
				}
			else {
			dlm.addElement(numero);
		}
		}
		
		else if(o==this.btnBorrar)
		{
			
			
			int[]indices = this.lstNumero.getSelectedIndices();
			int numeroOpciones = indices.length;
			if(numeroOpciones==0) {
				JOptionPane.showMessageDialog(this, (String)"Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
			for(int posicion=numeroOpciones-1;posicion>=0;posicion--)
			{
			
				dlm.removeElementAt(indices[posicion]);
			}
		}
	
		else if(o==this.btnLimpiar)
		{
		
		
			if(dlm.isEmpty()) {
				JOptionPane.showMessageDialog(this, (String)"Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				dlm.clear();
			}

		}
	
	}

}