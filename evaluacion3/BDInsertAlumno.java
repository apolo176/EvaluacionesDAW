package evaluacion3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BDInsertAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			Statement st = conexion.createStatement();
			st.executeUpdate("INSERT INTO alumnos VALUES ('99999999G','N9','A9','1DW3');");
st.close();
conexion.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			int error = e.getErrorCode();
			if (error == 1062) {
				System.out.println("Error de clave duplicada. Ya existe un registro con esa Clave");
			}else {
			System.out.println("Error SQL Numero "+error+": "+e.getMessage());
			}
			}

	}

}
