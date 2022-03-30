package evaluacion2;
import java.io.*;
public class FicheroBufferLectura {

	public static void main(String[] args) {
	// Declaro
File fichero;
FileReader fr;
BufferedReader br;
//Intento
	try {
		
		//Abro
		fichero= new File("Prueba.txt");
		fr= new FileReader(fichero);
		br=new BufferedReader(fr);
		
		//Modifico
		String linea;
		while((linea=br.readLine())!=null){
		System.out.println(linea);
		}
		
		
		//Cierro
		br.close();
		fr.close();
		
}
	//Compruebo errores
catch(IOException  e){
	System.out.println("ERROR");
	
}
	}
}
