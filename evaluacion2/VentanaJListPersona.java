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

public class VentanaJListPersona extends JFrame implements ActionListener, FocusListener{

	private static final long serialVersionUID = 1531539371445418371L;
	private JPanel VentanaJListComplejo;
	private DefaultListModel<Persona> dlm;
  private JList<Persona> lstPersona;
  private JPanel panel_1;
  private JPanel panelbotones;
  private JLabel lblDNI;
  private JTextField txtDNI;
 
 private JButton btnInsertar;
  private JButton btnBorrar;
  private JButton btnLimpiar;
  private JLabel lblApellido;
  private JTextField txtApellido;
  private JLabel lblNombre;
  private JTextField txtNombre;
  private JTextField txtDia;
  private JTextField txtMes;
  private JTextField txtAño;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListPersona frame = new VentanaJListPersona();
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
	public VentanaJListPersona() {
		setResizable(false);
		setTitle("VentanaJListComplejo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 557);
		VentanaJListComplejo = new JPanel();
		VentanaJListComplejo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(VentanaJListComplejo);
		VentanaJListComplejo.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(5, 5, 690, 85);
		VentanaJListComplejo.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblDNI = new JLabel("DNI: ");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblDNI);
		
		txtDNI = new JTextField();
	  txtDNI.addFocusListener(this);

		txtDNI.setToolTipText("");
		txtDNI.addActionListener(this);
		txtDNI.setText("");
		panel_1.add(txtDNI);
		txtDNI.setColumns(10);
	  
	  lblApellido = new JLabel("Apellido");
	  lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
	  panel_1.add(lblApellido);
	  
	  txtApellido = new JTextField();
	  txtApellido.addFocusListener(this);
	  txtApellido.setToolTipText("");
	  txtApellido.setText("");
	  txtApellido.setColumns(10);
	  panel_1.add(txtApellido);
	  
	  lblNombre = new JLabel("Nombre");
	  panel_1.add(lblNombre);
	  
	  txtNombre = new JTextField();
	  panel_1.add(txtNombre);
	  txtNombre.setColumns(10);
	  
	  JLabel lblNewLabel = new JLabel("dia");
	  panel_1.add(lblNewLabel);
	  
	  txtDia = new JTextField();
	  panel_1.add(txtDia);
	  txtDia.setColumns(10);
	  
	  JLabel lblNewLabel_1 = new JLabel("mes");
	  panel_1.add(lblNewLabel_1);
	  
	  txtMes = new JTextField();
	  panel_1.add(txtMes);
	  txtMes.setColumns(10);
	  
	  JLabel lblNewLabel_2 = new JLabel("a\u00F1o");
	  panel_1.add(lblNewLabel_2);
	  
	  txtAño = new JTextField();
	  panel_1.add(txtAño);
	  txtAño.setColumns(10);
	
		
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
	
		
		dlm = new DefaultListModel<Persona>();
		
		lstPersona = new JList<Persona>();
		lstPersona.setBounds(5, 103, 690, 412);

		lstPersona.setModel(dlm);
		VentanaJListComplejo.add(lstPersona);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Object o = ae.getSource();
		if(o == this.btnInsertar)
		{
			
			String DNI=(txtDNI.getText());
			String nombre= txtNombre.getText();
			String apellido=txtApellido.getText();
			int dia= Integer.parseInt(txtDia.getText());
			int mes= Integer.parseInt(txtMes.getText());
			int ano= Integer.parseInt(txtAño.getText());
			Fecha f=new Fecha( dia, mes, ano);
		
			Persona P= new Persona(DNI, nombre,apellido,f);
			Persona P1=new Persona(P);
			
			if (dlm.contains(P)) {
			JOptionPane.showMessageDialog(this, (String)"Error, ya existe", "Error", JOptionPane.ERROR_MESSAGE);
				}
			
			else {
			

			
				int posicion=0; 
				int numeroElementos=dlm.getSize();
				while(posicion<numeroElementos){
				P1=dlm.get(posicion);
					if(P.compareTo(P1)<0) {
					break;
				}
				posicion++;
				}
			
					dlm.add(posicion, P);

				
			}
				
		}
				
		
		
		
		else if(o==this.btnBorrar)
		{
			
			
			int[]indices = this.lstPersona.getSelectedIndices();
			int numeroOpciones = indices.length;
			if(numeroOpciones==0) {
				JOptionPane.showMessageDialog(this, (String)"Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
			Persona opcion= new Persona();
			
			for(int posicion=numeroOpciones-1;posicion>=0;posicion--)
			{
			
				opcion=dlm.getElementAt(indices[posicion]);
				dlm.removeElement(opcion);
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
			String FinReal= txtDNI.getText();
			txtDNI.setSelectionStart(0);
			
			txtDNI.setSelectionEnd(FinReal.length());
			String FinImaginaria= txtApellido.getText();
			txtApellido.setSelectionStart(0);
			
			txtApellido.setSelectionEnd(FinImaginaria.length());
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			txtDNI.select(0,0);
			txtApellido.select(0,0);


		}
}