package evaluacion3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import evaluacion2.Asignatura;

import javax.swing.JComboBox;
import javax.swing.JLabel;
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
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BDCalificaciones extends JFrame {

	private JPanel contentPane;
	private JTextField txtNota;
	private JTable tabla;
	private DefaultTableModel dtm;
	TableRowSorter<TableModel> metodoOrdenacion;
	List<RowSorter.SortKey> sortKeys ;
	Connection conexion;
	ResultSet rs;
	private ArrayList<Asignatura> arrayAsignaturas;
	Vector<Vector<String>> datosTabla = new Vector<Vector<String>>();
	Vector<String> columnas = new Vector<String>();
	JScrollPane scrollPane;
	
	JComboBox<String> cmbCodAsignatura;
	JComboBox<String> cmbDni;
	DefaultComboBoxModel<String> dcmDni;
	DefaultComboBoxModel<String> dcmCodAsignatura;

	JButton btnInsertar;
	JButton btnBorrar;
	JButton btnActualizar;
	JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BDCalificaciones frame = new BDCalificaciones();
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
	public BDCalificaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("DNI: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		//---------------------------------------------------------------------
		dcmDni = new DefaultComboBoxModel<String>();
		
		dcmCodAsignatura = new DefaultComboBoxModel<String>();
		cmbDni = new JComboBox();
		panel.add(cmbDni);
		cmbDni.setModel(dcmDni);

		
		
	
		
		JLabel lblNewLabel_1 = new JLabel("Cod Asignatura: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1);
		cmbCodAsignatura = new JComboBox();
		panel.add(cmbCodAsignatura);
		cmbCodAsignatura.setModel(dcmCodAsignatura);
		
					
		
				
					
	
		
		JLabel lblNewLabel_2 = new JLabel("Nota: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_2);
		
		txtNota = new JTextField();
		panel.add(txtNota);
		txtNota.setColumns(10);
	
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		

	
				//---------------------------------------------------------------------

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
		
		contentPane.add(tabla, BorderLayout.WEST);
				scrollPane = new JScrollPane(tabla);
				contentPane.add(scrollPane, BorderLayout.CENTER);
				
				//---------------------------------------------------------------------

		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		ejecutarInsert();
			}
		});
		btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnInsertar);
		
		 btnBorrar = new JButton("Borrar");
		 btnBorrar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		borrarSeleccionado();
		 	}
		 });
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnBorrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			actualizarSeleccionado();
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnActualizar);
		
	 btnSalir = new JButton("Salir");
	 btnSalir.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 System.exit(0);
	 	}
	 });
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnSalir);
	
		//---------------------------------------------------------------------
		ConectarBD();
	
	
	}

	protected void actualizarSeleccionado() {
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
					
					dni = "" + dtm.getValueAt(indicesSeleccionados[iter], 0);
					String codAsignaturas = "" + dtm.getValueAt(indicesSeleccionados[iter], 1) ;
					String nota = txtNota.getText();
					String Delete = "UPDATE bdalumnos.calificaciones SET nota = '"+nota+"' where dni like ('" + dni + "') and codasignatura like ('" + codAsignaturas + "');";
					registrosModificados = st.executeUpdate(Delete);
					cantIndSel--;
					iter++;
				}
				if (registrosModificados > 0) {
					cargarTabla();
				} 
				else if (registrosModificados == 0) {
					System.out.println("Ninguna fila ha sido afectada. Comprueba : Que la INSERT corresponda con lo deseado");
				}
				st.close(); 
				conexion.close();
			} catch (SQLException e) {
				int error = e.getErrorCode();
				System.out.println("Error: #" + error);
				if (error == 1062) {
					System.out.println("Error al insertar datos, error:#1062--Datos Duplicados");
				}
			}
		}
			
	}

	//---------------------------------------------------------------------

	protected void borrarSeleccionado() {
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
				dni = "" + dtm.getValueAt(indicesSeleccionados[iteradorIndicesSeleccionados], 0) ;
				String Delete = "DELETE FROM bdalumnos.calificaciones where codasignatura like ('" + codAsignaturas + "') and dni like ('"+dni+"') ";
	
			reg  = st.executeUpdate(Delete);
			cantIndSel--;
			iteradorIndicesSeleccionados++;
			}
			cargarTabla();
	
			//actualizarBD();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		}
	
	//---------------------------------------------------------------------

	protected void ejecutarInsert() {
		// TODO Auto-generated method stub

			String codAsignatura = "" + dcmCodAsignatura.getSelectedItem();
			String dni = "" + dcmDni.getSelectedItem();
			
			int nota  = Integer.parseInt(txtNota.getText());
		

			
			// añado el registro al CachedRowSet
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
				System.out.println("Conexion realizada: Correcto");
				
				Statement st = conexion.createStatement();
				String Insert = "INSERT INTO bdalumnos.calificaciones VALUES('" + dni + "','" + codAsignatura + "','" + nota + "');";
				int reg = st.executeUpdate(Insert);
				if (reg > 0) {
					cargarTabla();

				} else if (reg == 0) {
					System.out.println("Ninguna fila ha sido afectada. Comprueba : Que la INSERT corresponda con lo deseado");
				}
			} catch (SQLException e) {
				int error = e.getErrorCode();
				if (error == 1062) {
					System.out.println("Error al insertar datos, error:#1062--Datos Duplicados");
				}
			}

	


			//actualizarBD();

			
			
			// actualizo el valor de modificado
			
			
	}
	

	//---------------------------------------------------------------------
	private void ConectarBD() {
		// TODO Auto-generated method stub
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			// desactivo la actualizacion automatica de datos
			conexion.setAutoCommit(true);
			// creo el CachedRowSet
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			 rs = st.executeQuery("SELECT * FROM bdalumnos.calificaciones;");
				System.out.println("Correcto");
			 cargarTabla();
			 cargarComboBox();
			//cargarArrayList();
		
		
	}catch(SQLException ae){
		System.out.println("Error en la conexion");
	}
}
	
	//---------------------------------------------------------------------

	private void cargarComboBox() {
		// TODO Auto-generated method stub
		
		try {
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rsDNI = st.executeQuery("SELECT dni FROM bdalumnos.alumnos;");
	
			while(rsDNI.next()) {
			
				dcmDni.addElement("" + rsDNI.getString("dni"));
				
			}
			ResultSet rsCodA = st.executeQuery("SELECT codasignatura FROM bdalumnos.asignaturas;");
			while(rsCodA.next()) {
				
				dcmCodAsignatura.addElement("" + rsCodA.getString("codasignatura"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void cargarTabla() {
		// TODO Auto-generated method stub
		try {
			datosTabla.clear();
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			 rs = st.executeQuery("SELECT * FROM bdalumnos.calificaciones;");

	rs.beforeFirst();
			while (rs.next()) {
			Vector<String> fila = new Vector<String>();
			fila.add(rs.getString("dni"));
			fila.add(rs.getString("codasignatura"));
			fila.add(rs.getString("nota"));
			
			fila.add("\n\n\n\n\n\n\n");
			datosTabla.add(fila);
		}
		dtm.setDataVector(datosTabla, columnas);
		}catch(SQLException e) {
			System.out.println("Error en la conexion");
		}
	}

	//--------------------------------------------------------------------------------------------------

	private void cargarArrayList() {
		// TODO Auto-generated method stub
		try {
			String codAsignatura = "",nombreAsignatura = "", descripcion="";
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
