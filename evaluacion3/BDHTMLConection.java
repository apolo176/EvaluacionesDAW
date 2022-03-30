package evaluacion3;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class BDHTMLConection {
	BDHTMLConection() throws SQLException  {
	
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
		System.out.println("Correcto");
		Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = st.executeQuery("SELECT * FROM bdalumnos.alumnos;");
	
		//
		FileWriter fichero;
		PrintWriter pw;
		BufferedWriter bw;
		try {
			fichero = new FileWriter("BDHTML.html");
		
			pw = new PrintWriter(fichero);
			bw = new BufferedWriter(pw);
	
			bw.write("<html><head><style>"
					+ "table {"
					+ "  font-family: arial, sans-serif;"
					+ "  border-collapse: collapse;"
					+ "  width: 100%;"
					+ "}"
					+ ""
					+ "td, th {"
					+ "  border: 1px solid #dddddd;"
					+ "  text-align: left;"
					+ "  padding: 8px;"
					+ "}"
					+ ""
					+ "tr:nth-child(even) {"
					+ "  background-color: #dddddd;"
					+ "}</style><title>BDHTML</title></head> <body> <table>"
					+ "  <thead>"
					+ " <tr>   "
					+ "		 <th>DNI</th>"
					+ "    <th>Nombre</th>"
					+ "    <th>Apellidos</th>"
					+ "		 <th>Grupo</th>"
					+ " </tr>   "
					+  "	</thead>");
					bw.newLine();
		
					
					
						
						
					
					if(rs.first()== true) {
						rs.beforeFirst();								
						 while (rs.next()){
							 bw.write(" <tr>"
									 + "	    <td>"+rs.getObject("dni")+"</td>"
									 + "	    <td>"+rs.getObject("nombre")+"</td>"
									 + "	    <td>"+rs.getObject("apellidos")+"</td>"
									 + "	    <td>"+rs.getObject("grupo")+"</td>"
									 + "	  </tr>");
						 }
					}else {
						 bw.write(" <p> No hay ficheros</p>");
					}
						
					
		bw.close();
		pw.close();
		}catch(IOException e) {
			
			e.printStackTrace();
			System.out.println("Error");
			
		}
		st.close();
		
		rs.close();
		conexion.close();
		
	
	}
	

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
			new BDHTMLConection();
	}

}
