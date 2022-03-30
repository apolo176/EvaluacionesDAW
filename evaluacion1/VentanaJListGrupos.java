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

import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JList;
import java.awt.Panel;

public class VentanaJListGrupos extends JFrame implements ListSelectionListener,ActionListener{

	private static final long serialVersionUID = 1531539371445418371L;
	private JPanel Holamundo;
	private JLabel lblTexto;
	private DefaultListModel<String> dlm;
  private JList<String> lstGrupos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListGrupos frame = new VentanaJListGrupos();
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
	public VentanaJListGrupos() {
		setResizable(false);
		setTitle("VentanaJListGroupos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Holamundo = new JPanel();
		Holamundo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Holamundo);
		Holamundo.setLayout(null);
		
		lblTexto = new JLabel("No se ha seleccionado un grupo");
		lblTexto.setBounds(5, 5, 426, 41);
		lblTexto.setForeground(Color.BLUE);
		lblTexto.setBackground(Color.BLUE);
		lblTexto.setVerticalAlignment(SwingConstants.TOP);
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setFont(new Font("Verdana", Font.ITALIC, 24));
		Holamundo.add(lblTexto);
		
		Panel panel = new Panel();
		panel.setBounds(5, 55, 360, 154);
		Holamundo.add(panel);
		
		JList<String> lstGrupos = new JList<String>();
		lstGrupos.setBounds(306, 141, -279, -136);
		lstGrupos.setBackground(Color.WHITE);
		lstGrupos.addListSelectionListener(this);
	
		
		// Modelo de datos
		dlm = new DefaultListModel<String>();
		dlm.addElement("1AS3");
		dlm.addElement("2AS3");
		dlm.addElement("1DW3");
		dlm.addElement("2DW3");
		lstGrupos.setModel(dlm);
		panel.add(lstGrupos);

		lstGrupos.addListSelectionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		String seleccion = (String) this.lstGrupos.getSelectedValue();
		this.lblTexto.setText(seleccion);
	}
}