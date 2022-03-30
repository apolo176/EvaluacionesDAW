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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class VentanaJTableCalificaciones extends JFrame{
	
	
	public VentanaJTableCalificaciones() throws SQLException {
		
		setTitle("VentanaJTable");
		
		setBounds(100, 100, 843, 739);
		setSize(796, 532);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
	
		JPanel Contenedor = new JPanel();
		getContentPane().add(Contenedor, BorderLayout.CENTER);
		
		
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
		System.out.println("Correcto");
		Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String dni = "11111111A";
		ResultSet rs = st.executeQuery("SELECT * FROM bdalumnos.alumnos;");
		
		Vector<String> columnas = new Vector<String>();
		columnas.add("DNI");
		columnas.add("Nombre");
		columnas.add("Apellidos");
		columnas.add("Grupo");
		
		Vector<Vector<String>> datosTabla = new Vector<Vector<String>>();
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
	
		DefaultTableModel dtm = new DefaultTableModel(datosTabla, columnas);
		
	
		getContentPane().add(Contenedor);
		Contenedor.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Tabla de Alumnos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		Contenedor.add(lblNewLabel, BorderLayout.NORTH);
		JTable tabla = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(tabla);
		Contenedor.add(scrollPane, BorderLayout.CENTER);
		 TableRowSorter<TableModel> metodoOrdenacion;
	
		// Después de crear la tabla
		// Instanciamos el TableRowSorter y lo añadimos al JTable
		metodoOrdenacion = new TableRowSorter<TableModel>(dtm);
		tabla.setRowSorter(metodoOrdenacion);

		// A partir de aquí podemos definir un filtro basado en metodoOrdenacion
		// cambio el filtro de la tabla de calificaciones
		// muestro solo los datos del alumno con DNI 11111111A
		metodoOrdenacion.setRowFilter(RowFilter.regexFilter("11111111A", 0));
		// podemos poner un filtro por grupo para sacar solo los alumnos de 1DW3
		//	metodoOrdenacion.setRowFilter(RowFilter.regexFilter("1DW3", 3));
	

	
		// creo el vector para los datos de la tabla

	}
	public static void main(String[] args) throws SQLException {
		VentanaJTableCalificaciones vt = new VentanaJTableCalificaciones();
		vt.setVisible(true);
	}

}
