package evaluacion3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BDDeleteAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			Statement st = conexion.createStatement();
			int numeroFilas = st.executeUpdate("DELETE FROM bdalumnos.alumnos WHERE dni='00000000A';");
			if (numeroFilas==0) {
				System.out.println("No hay registros afectados");
			}else {
				System.out.println(numeroFilas + " registro/s afectado/s");
			}
		
		
			st.close();
			conexion.close();
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error SQL Numero "+e.getErrorCode()+":"+e.getMessage());
		}

	}

}
