package evaluacion2;

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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;

public class VentanaJListRacionales extends JFrame implements ActionListener, FocusListener{

	private static final long serialVersionUID = 1531539371445418371L;
	private JPanel VentanaJListRacional;
	private DefaultListModel<Racional> dlm;
  private JList<Racional> lstNumero;
  private JPanel panel_1;
  private JPanel panelbotones;
  private JLabel lblNumerador;
  private JTextField txtNumerador;
  private JTextField txtDenominador;

 
 private JButton btnInsertar;
  private JButton btnBorrar;
  private JButton btnLimpiar;
  private JLabel lblDenominador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListRacionales frame = new VentanaJListRacionales();
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
	public VentanaJListRacionales() {
		setResizable(false);
		setTitle("VentanaJListRacional");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 571);
		VentanaJListRacional = new JPanel();
		VentanaJListRacional.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(VentanaJListRacional);
	
		
		// Modelo de datos
		
		VentanaJListRacional.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		VentanaJListRacional.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNumerador = new JLabel("Numero");
		lblNumerador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblNumerador);
		
		txtNumerador = new JTextField();
	  txtNumerador.addFocusListener(this);

		txtNumerador.setToolTipText("");
		txtNumerador.addActionListener(this);
		txtNumerador.setText("");
		panel_1.add(txtNumerador);
		txtNumerador.setColumns(10);
	  
	  lblDenominador = new JLabel("denominador");
	  lblDenominador.setFont(new Font("Tahoma", Font.PLAIN, 16));
	  panel_1.add(lblDenominador);
	  
	  txtDenominador = new JTextField();
	  txtDenominador.addFocusListener(this);
	  txtDenominador.setToolTipText("");
	  txtDenominador.setText("");
	  txtDenominador.setColumns(10);
	  panel_1.add(txtDenominador);
	
		
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
	
		
		dlm = new DefaultListModel<Racional>();
	
		lstNumero = new JList<Racional>();
		lstNumero.setModel(dlm);
		VentanaJListRacional.add(lstNumero, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Object o = ae.getSource();
		if(o == this.btnInsertar || o==this.txtNumerador)
		{
			
			int numerador = Integer.parseInt(txtNumerador.getText());
			int denominador = Integer.parseInt(txtDenominador.getText());
			Racional r= new Racional(numerador,denominador);
			Racional r1=new Racional(numerador,denominador);
			
			if (dlm.contains(r)) {
			JOptionPane.showMessageDialog(this, (String)"Error", "Error", JOptionPane.ERROR_MESSAGE);
				}
			
			else {
			

			
				int posicion=0; 
				int numeroElementos=dlm.getSize();
				while(posicion<numeroElementos){
					r1=dlm.get(posicion);
					if(r.compareTo(r1)>0) {
					break;
				}
				posicion++;
				}
			
					dlm.add(posicion, r);

				
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

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		String FinNumerador= txtNumerador.getText();
		txtNumerador.setSelectionStart(0);
		
		txtNumerador.setSelectionEnd(FinNumerador.length());
		String FinDenominador= txtDenominador.getText();
		txtDenominador.setSelectionStart(0);
		
		txtDenominador.setSelectionEnd(FinDenominador.length());
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		txtNumerador.select(0,0);
		txtDenominador.select(0,0);


	}

	

}