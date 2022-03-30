package evaluacion2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ComplejoMainSerializable {

	public static void main(String[] args) {
		
		Complejos c1= new Complejos(2,3);
		Complejos c2= new Complejos(1,4);
		Complejos c3= new Complejos(3,5);
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("complejos.dat");
			 oos = new ObjectOutputStream (fos);
			// lo grabo
			oos.writeObject(c1);
			oos.writeObject(c3);
			// cierro el fichero
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream fis;
		ObjectInputStream ois;
		Complejos c= new Complejos();
		try {
			fis=new FileInputStream("complejos.dat");
			ois= new ObjectInputStream(fis);
	
			while(fis.available() > 0){
				c=(Complejos)ois.readObject();
				System.out.println("Complejo: " +c);
			}
		 // convierte los bytes leídos en un objeto de la clase Complejo
	 
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	
}
