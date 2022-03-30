package evaluacion3;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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

public class VentanaJTableMetaData extends JFrame{
	
	
	public VentanaJTableMetaData() throws SQLException {
		
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
		ResultSet rs = st.executeQuery("SELECT * FROM bdalumnos.alumnos;");
		
//		Vector<String> columnas = new Vector<String>();
//		columnas.add("DNI");
//		columnas.add("Nombre");
//		columnas.add("Apellidos");
//		columnas.add("Grupo");
//		
	// cabeceras de las columnas
		ResultSetMetaData metaDatos = rs.getMetaData();
		// Se obtiene el número de columnas.
		int numeroColumnas = metaDatos.getColumnCount();
		Vector<String> columnas = new Vector<String>();
		// Se obtiene cada una de las etiquetas para cada columna
		for (int i = 0; i < numeroColumnas; i++){
		// cojo el valor de la etiqueta de la columna
		// los índices del rs empiezan en 1 pero los índices de las columnas empiezan en 0
		columnas.add(metaDatos.getColumnLabel(i + 1));
		}
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

	

	
		// creo el vector para los datos de la tabla

	}
	public static void main(String[] args) throws SQLException {
		VentanaJTableMetaData vt = new VentanaJTableMetaData();
		vt.setVisible(true);
	}

}
