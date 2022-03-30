package evaluacion1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.Panel;
import java.awt.GridLayout;

public class VentanaJListNumeroVariosCampos extends JFrame implements ActionListener,ListSelectionListener{

	private static final long serialVersionUID = 1531539371445418371L;
	private JPanel JFrameListNumero;
	private DefaultListModel<String> dlm;
	private DefaultListModel<String> dlmNomb;
  private JPanel panel_1;
  private JPanel panelbotones;
  private JPanel panelListas;
  private JLabel lblNumero;
  private JTextField txtNumero;
  private JList<String> lstNombre;
  private JList<String> lstNumero;
  private JButton btnInsertar;
  private JButton btnBorrar;
  private JButton btnLimpiar;
  private JLabel lblNewLabel;
  private JTextField txtNombre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListNumeroVariosCampos frame = new VentanaJListNumeroVariosCampos();
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
	public VentanaJListNumeroVariosCampos() {
		setResizable(false);
		setTitle("VentanaJListGroupos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JFrameListNumero = new JPanel();
		JFrameListNumero.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JFrameListNumero);
		JFrameListNumero.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		JFrameListNumero.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_1.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setToolTipText("");
		txtNumero.addActionListener(this);
		txtNumero.setText("");
		panel_1.add(txtNumero);
		txtNumero.setColumns(5);
	  
	  lblNewLabel = new JLabel("Nombre");
	  lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
	  panel_1.add(lblNewLabel);
	  
	  txtNombre = new JTextField();
	  panel_1.add(txtNombre);
	  txtNombre.setColumns(5);
	
		
	  panelbotones = new JPanel();
		panel_1.add(panelbotones);
		
		btnInsertar= new JButton("Insertar");
		btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 8));
		panelbotones.add(btnInsertar);
		btnInsertar.addActionListener(this);
		
		btnLimpiar= new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 8));
		panelbotones.add(btnLimpiar);
		btnLimpiar.addActionListener(this);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 8));
		panelbotones.add(btnBorrar);
		btnBorrar.addActionListener(this);
	
		
		dlm = new DefaultListModel<String>();
	  dlmNomb = new DefaultListModel<String>();
		
	
		
		panelListas = new JPanel();
		JFrameListNumero.add(panelListas);
		panelListas.setLayout(new GridLayout(1, 2, 0, 0));
		
		lstNumero = new JList<String>();
		lstNumero.setModel(dlm);
		lstNumero.addListSelectionListener(this);
		lstNumero.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelListas.add(lstNumero);
		
		lstNombre = new JList<String>();
		lstNombre.setModel(dlmNomb);
		lstNombre.addListSelectionListener(this);
		lstNombre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstNombre.setBackground(Color.WHITE);
		panelListas.add(lstNombre);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Object o = ae.getSource();
		
		if(o == this.btnInsertar || o==this.txtNumero)
		{
			String DNI;
			DNI=txtNumero.getText();
			
			if(DNI.equals( ""))
			{
				JOptionPane.showMessageDialog(this, (String)"Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
				
			else{
				if (dlm.contains(DNI)) {
					JOptionPane.showMessageDialog(this, (String)"Error", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
							dlm.addElement(DNI);
							String nombre;
							nombre=txtNombre.getText();
							dlmNomb.addElement(nombre);
		}
		}
		}
		
		else if(o==this.btnBorrar)
		{
			
			

			if(lstNumero.isSelectionEmpty()) {
				JOptionPane.showMessageDialog(this, (String)"Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
			int posicion;
			posicion=lstNumero.getSelectedIndex();
				dlm.removeElementAt(posicion);
				dlmNomb.removeElementAt(posicion);
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
				dlmNomb.clear();
			}

		}
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		int posicion;
		posicion=((JList<String>)o).getSelectedIndex();
		lstNumero.setSelectedIndex(posicion);
		lstNombre.setSelectedIndex(posicion);
		
	}
}