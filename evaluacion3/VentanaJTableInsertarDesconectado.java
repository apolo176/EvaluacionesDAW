package evaluacion3;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.sql.rowset.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class VentanaJTableInsertarDesconectado extends JFrame{
	Vector<Vector<String>> datosTabla = new Vector<Vector<String>>();
	Vector<String> columnas = new Vector<String>();
	DefaultTableModel dtm;
	CachedRowSet crs;
	JPanel Contenedor;
	 TableRowSorter<TableModel> metodoOrdenacion;
		JTable tabla;
		List<RowSorter.SortKey> sortKeys ;
		int columnIndexToSort;
		Connection conexion;
		private boolean modificado;
	public VentanaJTableInsertarDesconectado(){
		
		setTitle("VentanaJTableInsertar");
		
		setBounds(100, 100, 843, 739);
		setSize(796, 532);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
	
		 Contenedor = new JPanel();
		getContentPane().add(Contenedor, BorderLayout.CENTER);
		

		
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
	
columnas.add("DNI");
columnas.add("Nombre");
columnas.add("Apellidos");
columnas.add("Grupo");

// añado uno a uno los alumnos al vector de datos
while (crs.next()) {
Vector<String> fila = new Vector<String>();
fila.add(crs.getString("dni"));
fila.add(crs.getString("nombre"));
fila.add(crs.getString("apellidos"));
fila.add(crs.getString("grupo"));
fila.add("\n\n\n\n\n\n\n");
datosTabla.add(fila);
}
	
	// cierro la conexion con la base de datos
			conexion.close();
		}catch(SQLException ae){
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
	
			
		// Después de crear la tabla
		// Instanciamos el TableRowSorter y lo añadimos al JTable
		metodoOrdenacion = new TableRowSorter<TableModel>(dtm);
	// ordeno los datos de la tabla
		
		tabla.setRowSorter(metodoOrdenacion);
		 sortKeys = new ArrayList<>();
		// para que ordene por la primera columna (dni en este caso) en Ascendente
		 columnIndexToSort = 0;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
		metodoOrdenacion.setSortKeys(sortKeys);
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		Contenedor.add(scrollPane, BorderLayout.CENTER);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ejecutarInsert();
			}
		});

		Contenedor.add(btnInsertar, BorderLayout.SOUTH);
		
	

	

	
		// creo el vector para los datos de la tabla

	}
	protected void ejecutarInsert() {
		// TODO Auto-generated method stub
		try{
			String dni = "00000000A";
			String nombre = "N0";
			String apellidos = "A0";
			String grupo = "1DW3";
			// añado el registro al CachedRowSet
			crs.moveToInsertRow();
			crs.updateString(1, dni);
			crs.updateString(2, nombre);
			crs.updateString(3, apellidos);
			crs.updateString(4, grupo);
			crs.insertRow();
			crs.moveToCurrentRow();
			Vector<String> fila = new Vector<String>();
			fila.add(crs.getString("dni"));
			fila.add(crs.getString("nombre"));
			fila.add(crs.getString("apellidos"));
			fila.add(crs.getString("grupo"));
			fila.add("\n\n\n\n\n\n\n");
			datosTabla.add(fila);
			modificado = true;
			dtm.setDataVector(datosTabla, columnas);
			metodoOrdenacion.setSortKeys(sortKeys);
			actualizarBD();
//			actualizarTabla();
			// actualizo el valor de modificado
			
			} catch (SQLException e) {
			JOptionPane.showMessageDialog(Contenedor,(String)"Error. No se ha podido añadir el registro","Error",JOptionPane.ERROR_MESSAGE,null);
			}
		
	}
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
			JOptionPane.showMessageDialog(Contenedor,(String)"Error. No se han podido grabar los datos","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			}
	}
	public static void main(String[] args) throws SQLException {
		VentanaJTableInsertarDesconectado vt = new VentanaJTableInsertarDesconectado();
		vt.setVisible(true);
	}

}
