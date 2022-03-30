package evaluacion3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class BDConection {
	BDConection() throws SQLException  {
	
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
		System.out.println("Correcto");
		Statement st = conexion.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM bdalumnos.alumnos;");
	
		while (rs.next()){
			System.out.println("DNI: " + rs.getObject("dni") + ", nombre: " + rs.getObject("nombre") + ", Apellidos: " +
			rs.getObject("apellidos") + ", Grupo: " + rs.getObject("grupo"));
			}
		rs.close();
		conexion.close();
		
	
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
			new BDConection();
	}

}
