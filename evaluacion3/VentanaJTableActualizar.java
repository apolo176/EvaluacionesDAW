package evaluacion3;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;

public class VentanaJTableActualizar extends JFrame {
	Vector<Vector<String>> datosTabla = new Vector<Vector<String>>();
	Vector<String> columnas = new Vector<String>();
	DefaultTableModel dtm;
	JTable tabla;
	JPanel panel;
	JButton btnInsertar;
	JButton btnBorrar;
	private JButton btnActualizar;

	public VentanaJTableActualizar() {

		setTitle("VentanaJTable");

		setBounds(100, 100, 843, 739);
		setSize(796, 532);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel Contenedor = new JPanel();
		getContentPane().add(Contenedor, BorderLayout.CENTER);

		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			System.out.println("Conexion realizada: Correcto");
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String consulta = "SELECT * FROM bdalumnos.alumnos;";
			ResultSet rs = st.executeQuery(consulta);

			columnas.add("DNI");
			columnas.add("Nombre");
			columnas.add("Apellidos");
			columnas.add("Grupo");

			// añado uno a uno los alumnos al vector de datos
			while (rs.next()) {
				Vector<String> fila = new Vector<String>();
				fila.add(rs.getString("dni"));
				fila.add(rs.getString("nombre"));
				fila.add(rs.getString("apellidos"));
				fila.add(rs.getString("grupo"));
				fila.add("\n\n\n\n\n\n\n");
				datosTabla.add(fila);

			}
		} catch (SQLException e) {
			System.out.println("error");
		}

		dtm = new DefaultTableModel(datosTabla, columnas);

		getContentPane().add(Contenedor);
		Contenedor.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Tabla de Alumnos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		Contenedor.add(lblNewLabel, BorderLayout.NORTH);
		tabla = new JTable(dtm);
		tabla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollPane = new JScrollPane(tabla);
		Contenedor.add(scrollPane, BorderLayout.CENTER);

		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutarInsert("10000000A", "N0", "A0", "1DW3");
			}
		});

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarSeleccionados();
			}
		});

		panel = new JPanel();
		Contenedor.add(panel, BorderLayout.SOUTH);
		panel.add(btnInsertar);
		panel.add(btnBorrar);

		btnActualizar = new JButton("Actualizar ");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarSeleccionado();
			}
		});
		panel.add(btnActualizar);

		// creo el vector para los datos de la tabla

	}

	//--------------------------------------------------------------------------------------------------------

	protected void actualizarSeleccionado() {
		// TODO Auto-generated method stub
		int[] indicesSeleccionados = tabla.getSelectedRows();
		if (indicesSeleccionados.length > 0) {
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
				System.out.println("Conexion realizada: Correcto");
				
				Statement st = conexion.createStatement();
				String dni = "";
				int cantIndSel = indicesSeleccionados.length;
				int registrosModificados = 0;
				int iter = 0;
				while (cantIndSel > 0) {
					
					dni = "" + dtm.getValueAt(indicesSeleccionados[iter], 0);
					String Delete = "UPDATE bdalumnos.alumnos SET grupo = 'ADW3' where dni like ('" + dni + "');";
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
	
	//----------------------------------------------------------------------------------------------------------------

	protected void borrarSeleccionados() {
		// TODO Auto-generated method stub
		int[] indicesSeleccionados = tabla.getSelectedRows();
		if (indicesSeleccionados.length > 0) {
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
				System.out.println("Conexion realizada: Correcto");
				
				Statement st = conexion.createStatement();
				String dni = "";
				int cantIndSel = indicesSeleccionados.length;
				int reg = 0;
				int iter = 0;
				while (cantIndSel > 0) {
					
					dni = "" + dtm.getValueAt(indicesSeleccionados[iter], 0);
					String Delete = "DELETE FROM bdalumnos.alumnos where dni like ('" + dni + "');";
					reg = st.executeUpdate(Delete);
					cantIndSel--;
					iter++;
				}

				if (reg > 0) {
					actualizarTabla();
				} else if (reg == 0) {
					System.out.println("Ninguna fila ha sido afectada. Comprueba : Que la INSERT corresponda con lo deseado");
				}
			} catch (SQLException e) {
				int error = e.getErrorCode();
				System.out.println("Error: #" + error);
				if (error == 1062) {
					System.out.println("Error al insertar datos, error:#1062--Datos Duplicados");
				}
			}
		}
	}
	
	//--------------------------------------------------------------------------------------------------------------------

	protected void ejecutarInsert(String dni, String nombre, String apellido, String grupo) {
		// TODO Auto-generated method stub
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			System.out.println("Conexion realizada: Correcto");
			;
			Statement st = conexion.createStatement();
			String Insert = "INSERT INTO bdalumnos.alumnos VALUES('" + dni + "','" + nombre + "','" + apellido + "','" + grupo
					+ "');";
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

	private void actualizarTabla() {
		// TODO Auto-generated method stub
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			System.out.println("Conexion realizada: Correcto");
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String consulta = "SELECT * FROM bdalumnos.alumnos;";
			ResultSet rs = st.executeQuery(consulta);

			datosTabla.clear();
			// añado uno a uno los alumnos al vector de datos
			while (rs.next()) {
				Vector<String> fila = new Vector<String>();
				fila.add(rs.getString("dni"));
				fila.add(rs.getString("nombre"));
				fila.add(rs.getString("apellidos"));
				fila.add(rs.getString("grupo"));
				fila.add("\n\n\n\n\n\n\n");
				datosTabla.add(fila);

			}
			dtm.setDataVector(datosTabla, columnas);
		} catch (SQLException e) {
			System.out.println("error");
		}
	}

	public static void main(String[] args) throws SQLException {
		VentanaJTableActualizar vt = new VentanaJTableActualizar();
		vt.setVisible(true);
	}

}
