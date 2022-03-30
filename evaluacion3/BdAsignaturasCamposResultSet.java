package evaluacion3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import evaluacion2.Asignatura;

import java.awt.GridBagLayout;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.Connection;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BdAsignaturasCamposResultSet<T> extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodAsignatura;
	private JTextField txtNombreAsignatura;
	private JTextField txtDescripcion;
	Connection conexion;
	ResultSet rs;
	private ArrayList<Asignatura> arrayAsignaturas;
	private int index = 0;
	JButton btnAdelante;
	JButton btnAtras;
	JButton btnAlPrincipio;
	JButton btnAlFinal;
	JButton btnInsertar;
	JButton btnBorrar;
	JButton btnActualizar;
	JButton btnSalir;
	JLabel lblRegistros;
	private boolean modificado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BdAsignaturasCamposResultSet frame = new BdAsignaturasCamposResultSet();
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
	public BdAsignaturasCamposResultSet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(39, 10, 592, 62);
		contentPane.add(panel);
		panel.setLayout(null);
		

		
		lblRegistros = new JLabel("No hay registros");
		lblRegistros.setBounds(208, 20, 196, 22);
		lblRegistros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblRegistros);
		
		
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(39, 82, 592, 218);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo Asignatura");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 141, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre Asignatura: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(10, 63, 141, 26);
		panel_1.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Descripcion");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellidos.setBounds(10, 111, 90, 26);
		panel_1.add(lblApellidos);
		
		txtCodAsignatura = new JTextField();
		txtCodAsignatura.setBounds(187, 10, 395, 31);
		panel_1.add(txtCodAsignatura);
		txtCodAsignatura.setColumns(10);
		
		txtNombreAsignatura = new JTextField();
		txtNombreAsignatura.setBounds(187, 58, 395, 31);
		panel_1.add(txtNombreAsignatura);
		txtNombreAsignatura.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(187, 99, 395, 31);
		panel_1.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		
		arrayAsignaturas = new ArrayList<Asignatura>();
		
		//---------------------------------------------------------------------
		//Botones
	 btnAdelante = new JButton(">");
		btnAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			adelantarAlumno();
			}
		});
		btnAdelante.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAdelante.setBounds(453, 21, 58, 21);
		panel.add(btnAdelante);
		
		btnAtras = new JButton("<");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			atrasarAlumno();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAtras.setBounds(97, 20, 58, 21);
		panel.add(btnAtras);
		
		 btnAlPrincipio = new JButton("<<");
		btnAlPrincipio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 primeraPosicion();
			}
		});
		btnAlPrincipio.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAlPrincipio.setBounds(10, 20, 77, 21);
		panel.add(btnAlPrincipio);
	
		btnAlFinal = new JButton(">>");
		btnAlFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			UltimaPosicion();
			}
		});
		btnAlFinal.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAlFinal.setBounds(521, 20, 71, 22);
		panel.add(btnAlFinal);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(39, 310, 592, 38);
		contentPane.add(panelBotones);
		
	  btnInsertar = new JButton("Insertar");
	  btnInsertar.addActionListener(new ActionListener() {
	  	public void actionPerformed(ActionEvent e) {
	 ejecutarInsert();
	  	}
	  });
		panelBotones.add(btnInsertar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			borrarActual();
			}
		});
		panelBotones.add(btnBorrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			actualizarActual();
			}
		});
		panelBotones.add(btnActualizar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		panelBotones.add(btnSalir);
		
		//----------------------------------------------------------------------------------------------------------
		//Metodos de carga
		ConectarBD();
		actualizarLabelRegistros();
		mostrarAsignatura(index);
	}

	//-------------------------------------------------------------------------------------------------------------

	protected void borrarActual() {
		// TODO Auto-generated method stub
		try {
			String codAsignaturas = txtCodAsignatura.getText();
			String Delete = "DELETE FROM bdalumnos.asignaturas where codAsignatura like ('" + codAsignaturas + "');";
			Statement st = conexion.createStatement();
			int reg = st.executeUpdate(Delete);
			arrayAsignaturas.remove(index);
			modificado = true;
			actualizarLabelRegistros();
			mostrarAsignatura(index);
			//actualizarBD();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//-------------------------------------------------------------------------------------------------------------


	protected void actualizarActual() {
		// TODO Auto-generated method stub
		try {
			
			String codAsignatura = txtCodAsignatura.getText();
			String nombreAsignatura = txtNombreAsignatura.getText();
			String desc = txtDescripcion.getText();

			Asignatura asignatura = new Asignatura(codAsignatura,nombreAsignatura,desc);
			Statement st = conexion.createStatement();
			int regModificados = st.executeUpdate("UPDATE bdalumnos.asignaturas SET descripcion = '"+desc+"' where codasignatura like '" + codAsignatura + "';");
			st.executeUpdate("UPDATE bdalumnos.asignaturas SET nombreasignatura = '"+nombreAsignatura+"' where codasignatura like '" + codAsignatura + "';");
			arrayAsignaturas.set(index, asignatura);
			modificado = true;
		
			mostrarAsignatura(index);
			//actualizarBD();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//-------------------------------------------------------------------------------------------------------------
//	private void actualizarBD() {
//		// TODO Auto-generated method stub
//		if (modificado){
//			try{
//	
//			// si se ha conectado correctamente
//			// desactivo la actualizacion automatica de datos
//			conexion.setAutoCommit(false);
//			crs.acceptChanges(conexion);
//			} catch (SQLException sqle) {
//			JOptionPane.showMessageDialog(this,(String)"Error. No se han podido grabar los datos","Error",JOptionPane.ERROR_MESSAGE,null);
//			}
//			}
//	}
//	
	//--------------------------------------------------------------------------------------------------------------

	protected void ejecutarInsert() {
		// TODO Auto-generated method stub

			String codAsignatura = txtCodAsignatura.getText();
			String nombreAsignatura = txtNombreAsignatura.getText();
			String desc = txtDescripcion.getText();
		
			Asignatura asignatura = new Asignatura(codAsignatura,nombreAsignatura,desc);
			
			// añado el registro al CachedRowSet
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
				System.out.println("Conexion realizada: Correcto");
				;
				Statement st = conexion.createStatement();
				String Insert = "INSERT INTO bdalumnos.asignaturas VALUES('" + codAsignatura + "','" + nombreAsignatura + "','" + desc + "');";
				int reg = st.executeUpdate(Insert);
				if (reg > 0) {
					System.out.println("Exito");

				} else if (reg == 0) {
					System.out.println("Ninguna fila ha sido afectada. Comprueba : Que la INSERT corresponda con lo deseado");
				}
			} catch (SQLException e) {
				int error = e.getErrorCode();
				if (error == 1062) {
					System.out.println("Error al insertar datos, error:#1062--Datos Duplicados");
				}
			}

	
			arrayAsignaturas.add(asignatura);
			actualizarLabelRegistros();
			modificado = true;
			//actualizarBD();

			
			
			// actualizo el valor de modificado
			
			
	}
	
	//---------------------------------------------------------------------
	
	private void actualizarLabelRegistros() {
		// TODO Auto-generated method stub
		int tamaño = arrayAsignaturas.size();
		int registroActual = index + 1 ;
		lblRegistros.setText("Registro: " + registroActual + " de " + tamaño );
	}

	//---------------------------------------------------------------------

	protected void primeraPosicion() {
		// TODO Auto-generated method stub
		index = 0;
		actualizarLabelRegistros();
		mostrarAsignatura(index);
	}

	//---------------------------------------------------------------------

	protected void UltimaPosicion() {
		// TODO Auto-generated method stub
	index = arrayAsignaturas.size()-1;
	actualizarLabelRegistros();

	mostrarAsignatura(index);
	
	}

	//---------------------------------------------------------------------

	protected void atrasarAlumno() {
		// TODO Auto-generated method stub
	
				if(index>0) {
					index--;
					actualizarLabelRegistros();

					mostrarAsignatura(index);
				} else {
					JOptionPane.showMessageDialog(this, (String)"Error, no hay mas registros", "Error", JOptionPane.ERROR_MESSAGE);

				}
	
	}
		

	
	protected void adelantarAlumno() {
		// TODO Auto-generated method stub
		if(index < arrayAsignaturas.size()-1)
		{
		 index++;
			actualizarLabelRegistros();

			mostrarAsignatura(index);

	} else {
		JOptionPane.showMessageDialog(this, (String)"Error, no hay mas registros", "Error", JOptionPane.ERROR_MESSAGE);

	}
	}

	//-------------------------------------------------------------------------------------------------------------

	private void mostrarAsignatura(int indice) {
		// TODO Auto-generated method stub
		String codAsignatura = "", desc = "", nombreAsignatura="";

		codAsignatura = arrayAsignaturas.get(indice).getCodigo();
		
		nombreAsignatura = arrayAsignaturas.get(indice).getNombre();
		desc = arrayAsignaturas.get(indice).getDescripcion();
		
		txtCodAsignatura.setText(codAsignatura);
		txtNombreAsignatura.setText(nombreAsignatura);
		txtDescripcion.setText(desc);

	}

	//------------------------------------------------------------------------------------------------------------------------

	private void ConectarBD() {
		// TODO Auto-generated method stub
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			// desactivo la actualizacion automatica de datos
			conexion.setAutoCommit(true);
			// creo el CachedRowSet
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			 rs = st.executeQuery("SELECT * FROM bdalumnos.asignaturas;");

		
			cargarArrayList();
		
		
	}catch(SQLException ae){
		System.out.println("Error en la conexion");
	}
}

	//--------------------------------------------------------------------------------------------------

	private void cargarArrayList() {
		// TODO Auto-generated method stub
		try {
			String codAsignatura = "",nombreAsignatura = "", apellidos = "", descripcion="";
			while (rs.next()) {
			codAsignatura = rs.getString("codasignatura");
			nombreAsignatura = rs.getString("nombreasignatura");
			descripcion = rs.getString("descripcion");


			Asignatura asignatura = new Asignatura(codAsignatura,nombreAsignatura,descripcion );
			arrayAsignaturas.add(asignatura);
			}
			}catch(SQLException e) {
				System.out.println("Error en la conexion");

			}
		
	}
}

