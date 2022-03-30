package evaluacion2;
import java.io.*;
public class FicheroHola {

	public static void main(String[] args) {
		// Declaro
FileWriter fichero;
PrintWriter pw;
BufferedWriter bw;
//Intento
	try {
		//Abro
		fichero= new FileWriter("Prueba.txt");
		pw= new PrintWriter(fichero);
		bw=new BufferedWriter(pw);
		//Modifico
		bw.write("HolaMundo");
		bw.newLine();
		//Cierro
		bw.close();
		pw.close();
		fichero.close();
}
	//Compruebo errores
catch(IOException  e){
	System.out.println("ERROR");
	
}
	}
	
}
