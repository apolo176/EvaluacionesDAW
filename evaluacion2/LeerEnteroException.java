package evaluacion2;
import java.util.InputMismatchException;
import java.util.Scanner;
public class LeerEnteroException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String cadena;
			//Defino un objeto de la clase Scanner
			Scanner teclado;
			//Creo un objeto de clase Scanner
			teclado=new Scanner (System.in);
			System.out.println ("introdduce un entero:");
			cadena = teclado.nextLine();
			int n;
			//leo n
			try {
			
			 n= Integer.parseInt(cadena);
			System.out.println("el valor introducido es " + n);
			}
			catch(NumberFormatException e) {
				char caracter;
				String correcto = "";
				for(int i = 0;i<cadena.length();i++)
				{
					caracter=cadena.charAt(i);
					if(Character.isDigit(caracter))correcto=correcto+caracter;
				
				}
				if(correcto.length()>0)
				{
					n=Integer.parseInt(correcto);
				}
				System.out.println (" "+correcto);

			}
			//libero memoria
			teclado.close();
			//mostrarpor pantalla
			
	}

}
