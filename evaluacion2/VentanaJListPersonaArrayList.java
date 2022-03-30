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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.util.Collections;
import javax.swing.JRadioButton;

public class VentanaJListPersonaArrayList extends JFrame implements ActionListener, FocusListener,WindowListener{

	private static final long serialVersionUID = 1531539371445418371L;
	private JPanel VentanaJListPersona;
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
  private JButton  btnOrdenar;
  private JComboBox comboBox;
  private final JRadioButton rdbtAscendente = new JRadioButton("Ascendente");
  private JRadioButton rdbtDescendente = new JRadioButton("Descendente");
   
  private boolean modificar = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListPersonaArrayList frame = new VentanaJListPersonaArrayList();
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
	public VentanaJListPersonaArrayList() {
		setResizable(false);
		setTitle("VentanaJListPersona");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(this);
		setBounds(100, 100, 714, 557);
		VentanaJListPersona = new JPanel();
		VentanaJListPersona.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(VentanaJListPersona);
		VentanaJListPersona.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(5, 5, 690, 85);
		VentanaJListPersona.add(panel_1);
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
		
	 btnOrdenar = new JButton("Ordenar");
		panelbotones.add(btnOrdenar);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"DNI", "Nombre", "Apellido", "Fecha"}));
		comboBox.addActionListener(this);
		panel_1.add(comboBox);
		panel_1.add(rdbtAscendente);
		
		rdbtDescendente = new JRadioButton("Ascendente");
		
		panel_1.add(rdbtDescendente);
		btnBorrar.addActionListener(this);
		btnOrdenar.addActionListener(this);
		
		dlm = new DefaultListModel<Persona>();
		
		lstPersona = new JList<Persona>();
		lstPersona.setBounds(5, 103, 690, 412);

		lstPersona.setModel(dlm);
		VentanaJListPersona.add(lstPersona);
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
					dlm.addElement(P);
					modificar=true;
				
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
				modificar=true;
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
				modificar=true;
			}
		
		}
		else if(o==this.btnOrdenar)
		{
		
		
			if(dlm.isEmpty()) {
				JOptionPane.showMessageDialog(this, (String)"Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if(comboBox.getSelectedIndex()==0)
				{
					ArrayList<Persona> ArrayPersonas= new ArrayList<Persona>();
					int posicion=0; 
					Persona P=new Persona();
					for(posicion=0;posicion<dlm.getSize();posicion++)
						{
						ArrayPersonas.add(dlm.get(posicion));
			
						}
					Collections.sort(ArrayPersonas);
					for(posicion=0;posicion<ArrayPersonas.size();posicion++)
					{
						P=(ArrayPersonas.get(posicion));
						dlm.set(posicion, P);
					}
				}
				if(comboBox.getSelectedIndex()==1)
				{
					ArrayList<Persona> ArrayPersonas= new ArrayList<Persona>();
					int posicion=0; 
					Persona P=new Persona();
					for(posicion=0;posicion<dlm.getSize();posicion++)
						{
						ArrayPersonas.add(dlm.get(posicion));
			
						}
					Comparator<Persona> comparador = Collections.reverseOrder();
					Collections.sort(ArrayPersonas, comparador);
					
					for(posicion=0;posicion<ArrayPersonas.size();posicion++)
					{
						P=(ArrayPersonas.get(posicion));
						dlm.set(posicion, P);
					}
				}
				if(comboBox.getSelectedIndex()==2)
				{
					ArrayList<Persona> ArrayPersonas= new ArrayList<Persona>();
					int posicion=0; 
					Persona P=new Persona();
					for(posicion=0;posicion<dlm.getSize();posicion++)
						{
						ArrayPersonas.add(dlm.get(posicion));
			
						}
					Collections.sort(ArrayPersonas, new Comparator<Persona>() {
						@Override
						public int compare(Persona c1, Persona c2) {
						return ((c1.getNombre()).compareTo(c2.getNombre()));
						}
						});
					for(posicion=0;posicion<ArrayPersonas.size();posicion++)
					{
						P=(ArrayPersonas.get(posicion));
						dlm.set(posicion, P);
					}
				}
				if(comboBox.getSelectedIndex()==3)
				{
					ArrayList<Persona> ArrayPersonas= new ArrayList<Persona>();
					int posicion=0; 
					Persona P=new Persona();
					for(posicion=0;posicion<dlm.getSize();posicion++)
						{
						ArrayPersonas.add(dlm.get(posicion));
			
						}
					Collections.sort(ArrayPersonas, new Comparator<Persona>() {
						@Override
						public int compare(Persona c1, Persona c2) {
						return new Integer((c1.getApellido()).compareTo(c2.getApellido()));
						}
						});
					for(posicion=0;posicion<ArrayPersonas.size();posicion++)
					{
						P=(ArrayPersonas.get(posicion));
						dlm.set(posicion, P);
					}
				}
				if(comboBox.getSelectedIndex()==4)
				{
					ArrayList<Persona> ArrayPersonas= new ArrayList<Persona>();
					int posicion=0; 
					Persona P=new Persona();
					for(posicion=0;posicion<dlm.getSize();posicion++)
						{
						ArrayPersonas.add(dlm.get(posicion));
			
						}
					Collections.sort(ArrayPersonas, new Comparator<Persona>() {
						@Override
						public int compare(Persona c1, Persona c2) {
						return new Integer((c1.getFechanaci()).compareTo(c2.getFechanaci()));
						}
						});
					for(posicion=0;posicion<ArrayPersonas.size();posicion++)
					{
						P=(ArrayPersonas.get(posicion));
						dlm.set(posicion, P);
					}
				}
			}
			modificar=true;
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

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
			FileInputStream fis;
			ObjectInputStream ois;
			Persona p= new Persona();
			try {
				fis=new FileInputStream("Persona.dat");
				ois= new ObjectInputStream(fis);
		
				while(fis.available() > 0){
					p=(Persona) ois.readObject();
					dlm.addElement(p);
				
				}
			 // convierte los bytes leídos en un objeto de la clase Persona
		 
				ois.close();
				fis.close();
			} catch (FileNotFoundException ae) {
				// TODO Auto-generated catch block
				ae.printStackTrace();
			}catch (IOException ae) {
				// TODO Auto-generated catch block
				ae.printStackTrace();
			} catch (ClassNotFoundException ae) {
				// TODO Auto-generated catch block
				ae.printStackTrace();
			} 
		}
		

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub

			
			if(modificar==false) {
				System.exit(0);
				}else 
					{
					int opcion = JOptionPane.showConfirmDialog(VentanaJListPersona, "Guardar?");
					if(opcion== JOptionPane.YES_OPTION)
					{
						FileOutputStream fos;
						ObjectOutputStream oos;
						try {
							fos = new FileOutputStream("Persona.dat");
							 oos = new ObjectOutputStream (fos);
							// lo grabo
							for(int i=0; i<dlm.size();i++)
							{
							oos.writeObject(dlm.elementAt(i));
		
							}
							// cierro el fichero
							oos.close();
							fos.close();
						} catch (FileNotFoundException ae) {
							// TODO Auto-generated catch block
							ae.printStackTrace();
						}catch (IOException ae) {
							// TODO Auto-generated catch block
							ae.printStackTrace();
						}
						FileInputStream fis;
						ObjectInputStream ois;
						Persona c= new Persona();
						try {
							fis=new FileInputStream("Persona.dat");
							ois= new ObjectInputStream(fis);
					
							while(fis.available() > 0){
								c=(Persona) ois.readObject();
								System.out.println("Persona: " +c);
							}
						 // convierte los bytes leídos en un objeto de la clase Persona
					 
							ois.close();
							fis.close();
						} catch (FileNotFoundException ae) {
							// TODO Auto-generated catch block
							ae.printStackTrace();
						}catch (IOException ae) {
							// TODO Auto-generated catch block
							ae.printStackTrace();
						} catch (ClassNotFoundException ae) {
							// TODO Auto-generated catch block
							ae.printStackTrace();
						} 
						
					}
					else if (opcion== JOptionPane.NO_OPTION);
					else if(opcion== JOptionPane.CANCEL_OPTION)
					{
						return;
					}
					
					else if(opcion== JOptionPane.CLOSED_OPTION){
						return;
					}
					System.exit(0);
					
					
					
					
				}
		}
			
		

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
}