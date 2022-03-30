package evaluacion2;
import java.io.*;
public class FicheroCopia {
	public static void main(String[] args) {
	// Declaro
		FileInputStream fis;
		BufferedInputStream bis;
		FileOutputStream fos;
		BufferedOutputStream bos;
		
		
		try {
			fis = new FileInputStream("txurdi.png");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("Logocopia.png");
			bos = new BufferedOutputStream(fos);
			int tamañobloque = 512;
			byte [] datos = new byte[tamañobloque];
			
			tamañobloque= bis.read(datos);
			while(tamañobloque != -1)
			{
				bos.write(datos,0,tamañobloque);
				tamañobloque= bis.read(datos);
			}
			 //cierro
			bos.close();
			fos.close();
			bis.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Archivo no encontrado");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Problema en el flujo de datos");
		}
	
		
	
	
	
	}
		
}
