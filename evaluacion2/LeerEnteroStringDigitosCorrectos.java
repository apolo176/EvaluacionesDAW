package evaluacion2;
import java.util.InputMismatchException;
import java.util.Scanner;
public class LeerEnteroStringDigitosCorrectos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String cadena = "";
			//Defino un objeto de la clase Scanner
			Scanner teclado;
			//Creo un objeto de clase Scanner
			teclado=new Scanner(System.in);
			System.out.println("introdduce un entero:");
			//leo n
			int n;
			try {
			cadena=teclado.nextLine();
			 n=Integer.parseInt(cadena);
			System.out.println("el valor introducido es " +n);
			
			}
			catch(NumberFormatException e)
			{
			
				char caracter;
				String correcto = "";
				for(int i = 0;i<cadena.length();i++)
				{
					caracter=cadena.charAt(i);
					correcto= correcto +caracter;
				}
				if(correcto.length()>0)
				{
					n=Integer.parseInt(correcto);
				}
				System.out.println (" "+correcto);

			}
			//libero memoria
			teclado.close();
			
		
			
			
			}

			
	
			
	}

