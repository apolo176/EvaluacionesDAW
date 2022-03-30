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
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class VentanaJTableBorrarDesconectado extends JFrame{
	Vector<Vector<String>> datosTabla = new Vector<Vector<String>>();
	Vector<String> columnas = new Vector<String>();
	DefaultTableModel dtm;
	JTable tabla;
	 TableRowSorter<TableModel> metodoOrdenacion;
	
		List<RowSorter.SortKey> sortKeys ;
		int columnIndexToSort;
	JPanel panel;
	JButton btnInsertar;
	JButton btnBorrar;
	Connection conexion;
	CachedRowSet crs;
	private boolean modificado;
	JPanel Contenedor;
	
	public VentanaJTableBorrarDesconectado(){
		
		setTitle("VentanaJTableBorrar");
		
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
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		
		metodoOrdenacion = new TableRowSorter<TableModel>(dtm);
		// ordeno los datos de la tabla
			
			tabla.setRowSorter(metodoOrdenacion);
			 sortKeys = new ArrayList<>();
			// para que ordene por la primera columna (dni en este caso) en Ascendente
			 columnIndexToSort = 0;
			sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
			metodoOrdenacion.setSortKeys(sortKeys);
		Contenedor.add(scrollPane, BorderLayout.CENTER);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ejecutarInsert();
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
		
	

	

	
		// creo el vector para los datos de la tabla

	}
	protected void borrarSeleccionados() {
		// TODO Auto-generated method stub
	int[] indicesSeleccionados = tabla.getSelectedRows();
	int cantIndSel = indicesSeleccionados.length;
	if(cantIndSel > 0) {
		try {
		// borro del crs el registro que está en la primera posición que es la posicion 1
		//voy a la posición 1 de los indices seleccionados
			 int iter =  0;
			while(cantIndSel > 0) {
		crs.absolute(indicesSeleccionados[cantIndSel-1] +1 );
		//borro el registro de esa posicion
		datosTabla.remove(indicesSeleccionados[cantIndSel-1]);
		
		crs.deleteRow();
		
		cantIndSel--;
		iter++;
			}
		// me posiciono en el primer registro para que los cambios tengan efecto
		crs.first();
		// actualizo el valor de modificado
		modificado = true;
		dtm.setDataVector(datosTabla, columnas);
		
		actualizarBD();
		} catch (SQLException e) {
	e.printStackTrace();
			JOptionPane.showMessageDialog(Contenedor,(String)"Error. No se ha podido borrar el registro","Error",JOptionPane.ERROR_MESSAGE,null);
		}
	
	}
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
		VentanaJTableBorrarDesconectado vt = new VentanaJTableBorrarDesconectado();
		vt.setVisible(true);
	}

}
