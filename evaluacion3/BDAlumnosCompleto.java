package evaluacion3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BDAlumnosCompleto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNota;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtGrupo;
	JButton btnAdelante;
	JButton btnAtras;
	JButton btnAlPrincipio;
	JButton btnAlFinal;
	JButton btnInsertar;
	JButton btnBorrar;
	JButton btnActualizar;
	JButton btnInsertarC;
	JButton btnBorrarC;
	JButton btnActualizarC;
	JButton btnSalir;
	JLabel lblRegistros;
	Connection conexion;
	ResultSet rsAlumnos;
	private JTable tabla;
	TableRowSorter<TableModel> metodoOrdenacion;
	List<RowSorter.SortKey> sortKeys ;
	DefaultTableModel dtm;
	Vector<Vector<String>> datosTabla = new Vector<Vector<String>>();
	Vector<String> columnas = new Vector<String>();

	JScrollPane scrollPane;

	JComboBox<String> cmb;
	DefaultComboBoxModel<String> dcm;
	private ArrayList<Alumno> arrayAlumnos;

	private int index = 0;
	private boolean modificado;
	private ResultSet rsCalificaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BDAlumnosCompleto frame = new BDAlumnosCompleto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private DefaultTableModel obtenerModelSoloLectura(Vector<Vector<String>> datosTabla2, Vector<String> columnas2) {
		return new DefaultTableModel(datosTabla2, columnas2) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}
	/**
	 * Create the frame.
	 */
	public BDAlumnosCompleto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);



		JPanel panelAlumnos = new JPanel();
		panelAlumnos.setBounds(27, 21, 345, 289);
		contentPane.add(panelAlumnos);
		panelAlumnos.setLayout(null);


		JPanel panelCambiarRegistros = new JPanel();
		panelCambiarRegistros.setBounds(0, 10, 344, 43);
		panelAlumnos.add(panelCambiarRegistros);
		panelCambiarRegistros.setLayout(null);
		columnas.add("DNI");
		columnas.add("CodAsignatura");
		columnas.add("Calificacion");


		JPanel panelBotones1 = new JPanel();
		panelBotones1.setBounds(382, 309, 385, 76);
		contentPane.add(panelBotones1);

		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(27, 333, 344, 42);
		contentPane.add(panelBotones);

		arrayAlumnos = new ArrayList<Alumno>();

		dtm = obtenerModelSoloLectura(datosTabla, columnas);

		tabla = new JTable(dtm);

		metodoOrdenacion = new TableRowSorter<TableModel>(dtm);
		// ordeno los datos de la tabla

		tabla.setRowSorter(metodoOrdenacion);
		sortKeys = new ArrayList<>();
		// para que ordene por la primera columna (dni en este caso) en Ascendente
		int columnIndexToSort = 0;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
		metodoOrdenacion.setSortKeys(sortKeys);
		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(398, 21, 344, 278);
		contentPane.add(scrollPane);



		btnAtras = new JButton("<");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atrasarAlumno();
			}
		});
		btnAtras.setBounds(71, 10, 51, 21);
		panelCambiarRegistros.add(btnAtras);

		btnAlPrincipio = new JButton("<<");
		btnAlPrincipio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primeraPosicion();
			}
		});
		btnAlPrincipio.setBounds(10, 10, 51, 21);
		panelCambiarRegistros.add(btnAlPrincipio);

		btnAdelante = new JButton(">");
		btnAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adelantarAlumno();
			}
		});
		btnAdelante.setBounds(222, 10, 51, 21);
		panelCambiarRegistros.add(btnAdelante);

		btnAlFinal = new JButton(">>");
		btnAlFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ultimaPosicion();
			}
		});
		btnAlFinal.setBounds(283, 10, 51, 21);
		panelCambiarRegistros.add(btnAlFinal);

		btnInsertarC = new JButton("InsertarC");
		btnInsertarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertCalificacion();
			}
		});
		btnInsertarC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBotones1.add(btnInsertarC);

		btnBorrarC = new JButton("BorrarC");
		btnBorrarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarCalificacion();
			}
		});
		btnBorrarC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBotones1.add(btnBorrarC);

		btnActualizarC = new JButton("ActualizarC");
		btnActualizarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarCalificacion();
			}
		});
		panelBotones1.add(btnActualizarC);


		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutarInsertAlumno();
			}
		});
		btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBotones.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarActual();
			}
		});
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBotones.add(btnBorrar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarActual();
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBotones.add(btnActualizar);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBotones.add(btnSalir);






		JLabel lblNewLabel_3 = new JLabel("Dni:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(0, 71, 68, 20);
		panelAlumnos.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Nombre:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(0, 119, 68, 20);
		panelAlumnos.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Apellidos: ");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(0, 169, 68, 20);
		panelAlumnos.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("Grupo:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(0, 214, 68, 20);
		panelAlumnos.add(lblNewLabel_3_3);
		lblRegistros = new JLabel("SinRegistros");
		lblRegistros.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistros.setBounds(120, 10, 104, 21);
		panelCambiarRegistros.add(lblRegistros);




		txtDni = new JTextField();
		txtDni.setBounds(47, 71, 241, 22);
		panelAlumnos.add(txtDni);
		txtDni.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(67, 119, 221, 22);
		panelAlumnos.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellidos.setBounds(67, 169, 221, 22);
		panelAlumnos.add(txtApellidos);
		txtApellidos.setColumns(10);

		txtGrupo = new JTextField();
		txtGrupo.setBounds(47, 214, 241, 22);
		panelAlumnos.add(txtGrupo);
		txtGrupo.setColumns(10);



		JLabel lblNewLabel = new JLabel("Codigo Asignatura");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotones1.add(lblNewLabel);
		dcm = new DefaultComboBoxModel<String>();
		cmb = new JComboBox<String>(dcm);
		panelBotones1.add(cmb);

		JLabel lblNewLabel_1 = new JLabel("Nota");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotones1.add(lblNewLabel_1);

		txtNota = new JTextField();
		panelBotones1.add(txtNota);
		txtNota.setColumns(10);

		ConectarBD();
		actualizarLabelRegistros();
		mostrarAlumno(index);
		actualizarTabla();


	}
	protected void actualizarCalificacion() {
		// TODO Auto-generated method stub
		int[] indicesSeleccionados = tabla.getSelectedRows();
		if (indicesSeleccionados.length > 0) {
			try {
				Statement st = conexion.createStatement();
				String dni = "";
				int cantIndSel = indicesSeleccionados.length;
				int registrosModificados = 0;
				int iter = 0;
				while (cantIndSel > 0) {

					dni = txtDni.getText();
					String codAsignaturas = "" + dtm.getValueAt(indicesSeleccionados[iter], 1) ;
					String nota = txtNota.getText();
					String Delete = "UPDATE bdalumnos.calificaciones SET nota = '"+nota+"' where dni like ('" + dni + "') and codasignatura like ('" + codAsignaturas + "');";
					registrosModificados = st.executeUpdate(Delete);
					cantIndSel--;
					iter++;
				}
				if (registrosModificados > 0) {
					actualizarTabla();
				} 
				else if (registrosModificados == 0) {
					System.out.println("Ninguna fila ha sido afectada. Comprueba : Que la INSERT corresponda con lo deseado");
				}
				st.close(); 

			} catch (SQLException e) {
				int error = e.getErrorCode();
				System.out.println("Error: #" + error);
				if (error == 1062) {
					System.out.println("Error al insertar datos, error:#1062--Datos Duplicados");
				}
			}
		}
	}

	protected void insertCalificacion() {
		// TODO Auto-generated method stub
		String dni = txtDni.getText();
		String codAsignatura = "" + dcm.getSelectedItem();

		int nota  = Integer.parseInt(txtNota.getText());



		// añado el registro al CachedRowSet
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			System.out.println("Conexion realizada: Correcto");

			Statement st = conexion.createStatement();
			String Insert = "INSERT INTO bdalumnos.calificaciones VALUES('" + dni + "','" + codAsignatura + "','" + nota + "');";
			int reg = st.executeUpdate(Insert);
			if (reg > 0) {
				actualizarTabla();


			} else if (reg == 0) {
				System.out.println("Ninguna fila ha sido afectada. Comprueba : Que la INSERT corresponda con lo deseado");
			}
		} catch (SQLException e) {
			int error = e.getErrorCode();
			if (error == 1062) {
				System.out.println("Error al insertar datos, error:#1062--Datos Duplicados");
			}
		}

	}

	protected void borrarCalificacion() {
		// TODO Auto-generated method stub
		int[] indicesSeleccionados =  tabla.getSelectedRows();
		if(indicesSeleccionados.length>0) {
			try {

				Statement st = conexion.createStatement();
				String dni = "";
				int cantIndSel = indicesSeleccionados.length;
				int reg = 0;
				int iteradorIndicesSeleccionados = 0;
				while(cantIndSel>0) {

					String codAsignaturas = "" + dtm.getValueAt(indicesSeleccionados[iteradorIndicesSeleccionados], 1) ;
					dni = txtDni.getText() ;
					String Delete = "DELETE FROM bdalumnos.calificaciones where codasignatura like ('" + codAsignaturas + "') and dni like ('"+dni+"') ";

					reg  = st.executeUpdate(Delete);
					cantIndSel--;
					iteradorIndicesSeleccionados++;
				}
				actualizarTabla();

				//actualizarBD();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void ejecutarInsertAlumno() {
		// TODO Auto-generated method stub

		String dni = txtDni.getText();
		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		String grupo = txtGrupo.getText();
		Alumno alumno = new Alumno(dni,nombre,apellidos,grupo);

		try {

			Statement st = conexion.createStatement();
			String Insert = "INSERT INTO bdalumnos.alumnos VALUES('" + dni + "','" + nombre + "','" + apellidos + "','"+grupo+"');";
			int reg = st.executeUpdate(Insert);
			if (reg > 0) {
				arrayAlumnos.add(alumno);
				actualizarLabelRegistros();
				modificado = true;

			} else if (reg == 0) {
				System.out.println("Ninguna fila ha sido afectada. Comprueba : Que la INSERT corresponda con lo deseado");
			}
		} catch (SQLException e) {
			int error = e.getErrorCode();
			if (error == 1062) {
				System.out.println("Error al insertar datos, error:#1062--Datos Duplicados");
			}
		}


	}

	//---------------------------------------------------------------------

	protected void borrarActual() {
		// TODO Auto-generated method stub
		try {
			String dni = txtDni.getText();
			String Delete = "DELETE FROM bdalumnos.alumnos where dni like ('" + dni + "');";
			Statement st = conexion.createStatement();
			int reg = st.executeUpdate(Delete);
			arrayAlumnos.remove(index);
			modificado = true;
			if (index > 0) {
				index--;
			}
			
			mostrarAlumno(index);
			actualizarLabelRegistros();

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

			String dni = txtDni.getText();
			String nombre = txtNombre.getText();
			String apellidos = txtApellidos.getText();
			String grupo = txtGrupo.getText();
			Alumno alumno = new Alumno(dni,nombre,apellidos,grupo);
			Statement stA = conexion.createStatement();
			String update = "UPDATE bdalumnos.alumnos SET nombre = '"+nombre+"' where dni like '" + dni + "';";
			int regModificados = stA.executeUpdate(update);
			//System.out.println(""+regModificados);
			update = "UPDATE bdalumnos.alumnos SET apellidos = '"+apellidos+"' where dni like '" + dni + "';";
			regModificados = stA.executeUpdate(update);
			//System.out.println(""+regModificados);

			update = "UPDATE bdalumnos.alumnos SET grupo = '"+grupo+"' where dni like '" + dni + "';";
			stA.executeUpdate(update);
			//System.out.println(""+regModificados);

			arrayAlumnos.set(index, alumno);
			modificado = true;
			mostrarAlumno(index);
			stA.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//-------------------------------------------------------------------------------------------------------------

	private void actualizarLabelRegistros() {
		// TODO Auto-generated method stub
		int tamaño = arrayAlumnos.size();
		int registroActual = index + 1 ;
		lblRegistros.setText("Registro: " + registroActual + " de " + tamaño );
	}

	//---------------------------------------------------------------------

	protected void primeraPosicion() {
		// TODO Auto-generated method stub
		index = 0;
		mostrarAlumno(index);
		actualizarTabla();
		actualizarLabelRegistros();

	}

	//---------------------------------------------------------------------

	protected void ultimaPosicion() {
		// TODO Auto-generated method stub
		index = arrayAlumnos.size()-1;
		mostrarAlumno(index);
		actualizarTabla();
		actualizarLabelRegistros();

	}

	//---------------------------------------------------------------------

	protected void atrasarAlumno() {
		// TODO Auto-generated method stub

		if(index>0) {
			index--;
			mostrarAlumno(index);
			actualizarTabla();
			actualizarLabelRegistros();


		} else {
			JOptionPane.showMessageDialog(this, (String)"Error, no hay mas registros", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	//---------------------------------------------------------------------

	protected void adelantarAlumno() {
		// TODO Auto-generated method stub
		if(index < arrayAlumnos.size()-1)
		{
			index++;
			actualizarLabelRegistros();
			mostrarAlumno(index);
			actualizarTabla();


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
			conexion.setAutoCommit(true);
			// creo el CachedRowSet
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			rsAlumnos = st.executeQuery("SELECT * FROM bdalumnos.alumnos;");
			Statement stC = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String consulta = "SELECT * FROM bdalumnos.calificaciones;";
			rsCalificaciones = stC.executeQuery(consulta);
			cargarArrayListAlumnos();
			cargarComboBox();


		}catch(SQLException ae){
			System.out.println("Error en la conexion");
		}
	}

	//--------------------------------------------------------------------------------------------------

	private void cargarArrayListAlumnos() {
		// TODO Auto-generated method stub
		try {
			String dni = "",grupo = "", apellidos = "", nombre="";
			while (rsAlumnos.next()) {
				dni = rsAlumnos.getString("dni");
				grupo = rsAlumnos.getString("grupo");
				nombre = rsAlumnos.getString("nombre");
				apellidos = rsAlumnos.getString("apellidos");

				Alumno alumno = new Alumno(dni,nombre, apellidos, grupo);
				arrayAlumnos.add(alumno);
			}

		}catch(SQLException e) {
			System.out.println("Error en la conexion");

		}

	}

	//---------------------------------------------------------------------

	private void cargarComboBox() {
		// TODO Auto-generated method stub

		try {
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rsCodAsignatura = st.executeQuery("SELECT codasignatura FROM bdalumnos.asignaturas;");

			while(rsCodAsignatura.next()) {

				dcm.addElement("" + rsCodAsignatura.getString("codasignatura"));

			}
			rsCodAsignatura.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//---------------------------------------------------------------------

	private void actualizarTabla() {
		// TODO Auto-generated method stub
		try {
			tabla.setRowSorter(metodoOrdenacion);

			// A partir de aquí podemos definir un filtro basado en metodoOrdenacion
			// cambio el filtro de la tabla de calificaciones
			// muestro solo los datos del alumno con DNI 11111111A

			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			rsCalificaciones = st.executeQuery("SELECT * FROM bdalumnos.calificaciones;");
			String	dni = txtDni.getText();
			metodoOrdenacion.setRowFilter(RowFilter.regexFilter("" + dni, 0));
			rsCalificaciones.beforeFirst();
			datosTabla.clear();
			while (rsCalificaciones.next()) {
				Vector<String> fila = new Vector<String>();
				fila.add(rsCalificaciones.getString("dni"));
				fila.add(rsCalificaciones.getString("codasignatura"));
				fila.add(rsCalificaciones.getString("nota"));

				fila.add("\n\n\n\n\n\n\n");
				datosTabla.add(fila);

			}
			dtm.setDataVector(datosTabla, columnas);

		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}

	}

}
