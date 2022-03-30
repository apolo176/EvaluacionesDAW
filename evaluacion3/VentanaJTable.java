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

public class VentanaJTable extends JFrame{
	
	
	public VentanaJTable() throws SQLException {
		
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
		
		JButton btnSalir = new JButton("SAlir\u00E7");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Contenedor.add(btnSalir, BorderLayout.SOUTH);

	

	
		// creo el vector para los datos de la tabla

	}
	public static void main(String[] args) throws SQLException {
		VentanaJTable vt = new VentanaJTable();
		vt.setVisible(true);
	}

}
