package evaluacion2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FicheoHolaHTML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
FileWriter fichero;
PrintWriter pw;
BufferedWriter bw;
try {
	fichero = new FileWriter("Hola.html");
	pw = new PrintWriter(fichero);
	bw = new BufferedWriter(pw);
	
	bw.write("<html><head><title>Hola HTML</title></head> <body> <p>Html generado por codigo </p></body></html>");
	bw.newLine();
	bw.close();
	pw.close();
}catch(IOException e) {
	System.out.println("Error");
}
	}

}
