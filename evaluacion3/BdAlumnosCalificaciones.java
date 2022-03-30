package evaluacion3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.GridBagLayout;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
import javax.swing.RowSorter;
import javax.swing.SortOrder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BdAlumnosCalificaciones<T> extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtGrupo;
	Connection conexion;
	CachedRowSet crs;
	private ArrayList<Alumno> arrayAlumnos;
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
	private JTable tabla;
	TableRowSorter<TableModel> metodoOrdenacion;
	List<RowSorter.SortKey> sortKeys ;
	DefaultTableModel dtm;
	Vector<Vector<String>> datosTabla = new Vector<Vector<String>>();
	Vector<String> columnas = new Vector<String>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BdAlumnosCalificaciones frame = new BdAlumnosCalificaciones();
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
	public BdAlumnosCalificaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(93, 10, 592, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		

		
		lblRegistros = new JLabel("No hay registros");
		lblRegistros.setBounds(204, 10, 196, 22);
		lblRegistros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblRegistros);
		
		
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(93, 58, 592, 201);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dni: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 90, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(10, 63, 90, 26);
		panel_1.add(lblNombre);
		
		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGrupo.setBounds(10, 153, 90, 26);
		panel_1.add(lblGrupo);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellidos.setBounds(10, 111, 90, 26);
		panel_1.add(lblApellidos);
		
		txtDni = new JTextField();
		txtDni.setBounds(115, 10, 395, 31);
		panel_1.add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(115, 57, 395, 31);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(115, 103, 395, 31);
		panel_1.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtGrupo = new JTextField();
		txtGrupo.setBounds(114, 159, 396, 31);
		panel_1.add(txtGrupo);
		txtGrupo.setColumns(10);
		
		
		arrayAlumnos = new ArrayList<Alumno>();
		
		columnas.add("DNI");
		columnas.add("CodAsignatura");
		columnas.add("Calificacion");
	

		 dtm = new DefaultTableModel(datosTabla, columnas);
		
		tabla = new JTable(dtm);
		
		metodoOrdenacion = new TableRowSorter<TableModel>(dtm);
		// ordeno los datos de la tabla
			
			tabla.setRowSorter(metodoOrdenacion);
			 sortKeys = new ArrayList<>();
			// para que ordene por la primera columna (dni en este caso) en Ascendente
			int columnIndexToSort = 0;
			sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
			metodoOrdenacion.setSortKeys(sortKeys);
		tabla.setBounds(0, 0, 1, 1);
		contentPane.add(tabla);
		JScrollPane scrollPane = new JScrollPane(tabla);
		
		
		scrollPane.setBounds(93, 269, 592, 157);
		contentPane.add(scrollPane);
		
		
		//---------------------------------------------------------------------
	
		//Botones
	 
		btnAdelante = new JButton(">");
		btnAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			adelantarAlumno();
			}
		});
		btnAdelante.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAdelante.setBounds(453, 10, 58, 21);
		panel.add(btnAdelante);
		
		btnAtras = new JButton("<");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			atrasarAlumno();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAtras.setBounds(97, 10, 58, 21);
		panel.add(btnAtras);
		
		 btnAlPrincipio = new JButton("<<");
		btnAlPrincipio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 primeraPosicion();
			}
		});
		btnAlPrincipio.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAlPrincipio.setBounds(10, 10, 77, 21);
		panel.add(btnAlPrincipio);
	
		btnAlFinal = new JButton(">>");
		btnAlFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			UltimaPosicion();
			}
		});
		btnAlFinal.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAlFinal.setBounds(521, 9, 71, 22);
		panel.add(btnAlFinal);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(93, 439, 592, 38);
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
		mostrarAlumno(index);
		actualizarTabla(index);
	}
	
//----------------------------------------------------------------------------------------------------------

	protected void actualizarActual() {
		// TODO Auto-generated method stub
		try {
			
			String dni = txtDni.getText();
			String nombre = txtNombre.getText();
			String apellidos = txtApellidos.getText();
			String grupo = txtGrupo.getText();
			Alumno alumno = new Alumno(dni,nombre,apellidos,grupo);
			crs.absolute(index+1);
			
			crs.updateString(2, nombre);
			crs.updateString(3, apellidos);
			crs.updateString(4, grupo);
			crs.updateRow();
			arrayAlumnos.set(index, alumno);
			modificado = true;
		
			mostrarAlumno(index);
			actualizarBD();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//-------------------------------------------------------------------------------------------------------------

	private void actualizarBD() {
		// TODO Auto-generated method stub
		if (modificado){
			try{
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			// si se ha conectado correctamente
			// desactivo la actualizacion automatica de datos
			conexion.setAutoCommit(false);
			crs.acceptChanges(conexion);
			} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(this,(String)"Error. No se han podido grabar los datos","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			}
	}
	
	//---------------------------------------------------------------------
	
	private void actualizarLabelRegistros() {
		// TODO Auto-generated method stub
		int tamaño = arrayAlumnos.size();
		int registroActual = index + 1 ;
		lblRegistros.setText("Registro: " + registroActual + " de " + tamaño );
	}

	//-------------------------------------------------------------------------------------------------------------
	private void actualizarTabla(int index) {
		// TODO Auto-generated method stub
		try {
		Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String consulta = "SELECT * FROM bdalumnos.calificaciones WHERE dni like ('"+ arrayAlumnos.get(index).getDni() + "');";
		ResultSet rs = st.executeQuery(consulta);
		datosTabla.clear();
		while (rs.next()) {
			Vector<String> fila = new Vector<String>();
			fila.add(rs.getString("dni"));
			fila.add(rs.getString("codasignatura"));
			fila.add(rs.getString("nota"));
			
			fila.add("\n\n\n\n\n\n\n");
			datosTabla.add(fila);

		}
		dtm.setDataVector(datosTabla, columnas);
		
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}

	}
	
	//-------------------------------------------------------------------------------------------------------------

	protected void borrarActual() {
		// TODO Auto-generated method stub
		try {
			crs.absolute(index+1);
			crs.deleteRow();
			arrayAlumnos.remove(index);
			modificado = true;
			actualizarLabelRegistros();
			mostrarAlumno(index);
			actualizarBD();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//--------------------------------------------------------------------------------------------------------------

	protected void ejecutarInsert() {
		// TODO Auto-generated method stub
		try{
			String dni = txtDni.getText();
			String nombre = txtNombre.getText();
			String apellidos = txtApellidos.getText();
			String grupo = txtGrupo.getText();
			Alumno alumno = new Alumno(dni,nombre,apellidos,grupo);
			
			// añado el registro al CachedRowSet
			crs.moveToInsertRow();
			crs.updateString(1, dni);
			crs.updateString(2, nombre);
			crs.updateString(3, apellidos);
			crs.updateString(4, grupo);
			crs.insertRow();
			crs.moveToCurrentRow();
			arrayAlumnos.add(alumno);
			actualizarLabelRegistros();
			modificado = true;
			actualizarBD();

			
			//			actualizarTabla();
			// actualizo el valor de modificado
			
			} catch (SQLException e) {
			JOptionPane.showMessageDialog(this,(String)"Error. No se ha podido añadir el registro","Error",JOptionPane.ERROR_MESSAGE,null);
			}
	}
	

	//---------------------------------------------------------------------

	protected void primeraPosicion() {
		// TODO Auto-generated method stub
		index = 0;
		actualizarTabla(index);
		actualizarLabelRegistros();
		mostrarAlumno(index);
	}



	//---------------------------------------------------------------------

	protected void UltimaPosicion() {
		// TODO Auto-generated method stub
	index = arrayAlumnos.size()-1;
	actualizarTabla(index);
	actualizarLabelRegistros();

	mostrarAlumno(index);
	
	}

	//---------------------------------------------------------------------

	protected void atrasarAlumno() {
		// TODO Auto-generated method stub
	
				if(index>0) {
					index--;
					actualizarTabla(index);
					actualizarLabelRegistros();

					mostrarAlumno(index);
				} else {
					JOptionPane.showMessageDialog(this, (String)"Error, no hay mas registros", "Error", JOptionPane.ERROR_MESSAGE);

				}
	
	}
		
	//--------------------------------------------------------------------
	
	protected void adelantarAlumno() {
		// TODO Auto-generated method stub
		if(index < arrayAlumnos.size()-1)
		{
		 index++;
			actualizarLabelRegistros();
			actualizarTabla(index);
			mostrarAlumno(index);

	} else {
		JOptionPane.showMessageDialog(this, (String)"Error, no hay mas registros", "Error", JOptionPane.ERROR_MESSAGE);

	}
	}

	//-------------------------------------------------------------------------------------------------------------

	private void mostrarAlumno(int indice) {
		// TODO Auto-generated method stub
		String dni = "",grupo = "", apellidos = "", nombre="";

		dni = arrayAlumnos.get(indice).getDni();
		grupo = arrayAlumnos.get(indice).getGrupo();
		nombre = arrayAlumnos.get(indice).getNombre();
		apellidos = arrayAlumnos.get(indice).getApellido();
		
		txtDni.setText(dni);
		txtGrupo.setText(grupo);
		txtNombre.setText(nombre);
		txtApellidos.setText(apellidos);

	}

	//------------------------------------------------------------------------------------------------------------------------

	private void ConectarBD() {
		// TODO Auto-generated method stub
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			// desactivo la actualizacion automatica de datos
			conexion.setAutoCommit(false);
			// creo el CachedRowSet
			
			RowSetFactory myRowSetFactory = null;
			myRowSetFactory = RowSetProvider.newFactory();
			crs = myRowSetFactory.createCachedRowSet();
			crs.setCommand("SELECT * FROM alumnos");
			crs.execute(conexion);
			crs.beforeFirst();
		
			cargarArrayList();
		
		
	}catch(SQLException ae){
		System.out.println("Error en la conexion");
	}
}

	//--------------------------------------------------------------------------------------------------

	private void cargarArrayList() {
		// TODO Auto-generated method stub
		try {
			String dni = "",grupo = "", apellidos = "", nombre="";
			while (crs.next()) {
			dni = crs.getString("dni");
			grupo = crs.getString("grupo");
			nombre = crs.getString("nombre");
			apellidos = crs.getString("apellidos");

			Alumno alumno = new Alumno(dni,nombre, apellidos, grupo);
			arrayAlumnos.add(alumno);
			}
			}catch(SQLException e) {
				System.out.println("Error en la conexion");

			}
		
	}
}

