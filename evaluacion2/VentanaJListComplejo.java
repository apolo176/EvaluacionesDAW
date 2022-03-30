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

public class VentanaJListComplejo extends JFrame implements ActionListener, FocusListener{

	private static final long serialVersionUID = 1531539371445418371L;
	private JPanel VentanaJListComplejo;
	private DefaultListModel<Complejos> dlm;
  private JList<Complejos> lstNumero;
  private JPanel panel_1;
  private JPanel panelbotones;
  private JLabel lblReal;
  private JTextField txtReal;
 
 private JButton btnInsertar;
  private JButton btnBorrar;
  private JButton btnLimpiar;
  private JLabel lblParteImaginaria;
  private JTextField txtImaginaria;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListComplejo frame = new VentanaJListComplejo();
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
	public VentanaJListComplejo() {
		setResizable(false);
		setTitle("VentanaJListComplejo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 557);
		VentanaJListComplejo = new JPanel();
		VentanaJListComplejo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(VentanaJListComplejo);
	
		
		// Modelo de datos
		
		VentanaJListComplejo.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		VentanaJListComplejo.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblReal = new JLabel("Parte Real");
		lblReal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblReal);
		
		txtReal = new JTextField();
	  txtReal.addFocusListener(this);

		txtReal.setToolTipText("");
		txtReal.addActionListener(this);
		txtReal.setText("");
		panel_1.add(txtReal);
		txtReal.setColumns(10);
	  
	  lblParteImaginaria = new JLabel("Parte Imaginaria");
	  lblParteImaginaria.setFont(new Font("Tahoma", Font.PLAIN, 16));
	  panel_1.add(lblParteImaginaria);
	  
	  txtImaginaria = new JTextField();
	  txtImaginaria.addFocusListener(this);
	  txtImaginaria.setToolTipText("");
	  txtImaginaria.setText("");
	  txtImaginaria.setColumns(10);
	  panel_1.add(txtImaginaria);
	
		
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
	
		
		dlm = new DefaultListModel<Complejos>();
		
		lstNumero = new JList<Complejos>();
		lstNumero.setModel(dlm);
		VentanaJListComplejo.add(lstNumero, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Object o = ae.getSource();
		if(o == this.btnInsertar || o==this.txtReal)
		{
			
			int real = Integer.parseInt(txtReal.getText());
			int imaginaria= Integer.parseInt(txtImaginaria.getText());
			Complejos C= new Complejos(real,imaginaria);
			Complejos C1=new Complejos(real,imaginaria);
			
			if (dlm.contains(C)) {
			JOptionPane.showMessageDialog(this, (String)"Error, ya existe", "Error", JOptionPane.ERROR_MESSAGE);
				}
			
			else {
			

			
				int posicion=0; 
				int numeroElementos=dlm.getSize();
				while(posicion<numeroElementos){
				C1=dlm.get(posicion);
					if(C.compareTo(C1)<0) {
					break;
				}
				posicion++;
				}
			
					dlm.add(posicion, C);

				
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
			String FinReal= txtReal.getText();
			txtReal.setSelectionStart(0);
			
			txtReal.setSelectionEnd(FinReal.length());
			String FinImaginaria= txtImaginaria.getText();
			txtImaginaria.setSelectionStart(0);
			
			txtImaginaria.setSelectionEnd(FinImaginaria.length());
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			txtReal.select(0,0);
			txtImaginaria.select(0,0);


		}


}