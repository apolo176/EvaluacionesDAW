package evaluacion2;
import java.util.InputMismatchException;
import java.util.Scanner;


public class LeerEnterString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int n;
			//Defino un objeto de la clase Scanner
			Scanner teclado;
			//Creo un objeto de clase Scanner
			teclado=new Scanner(System.in);
			System.out.println("introdduce un entero:");
			//leo n
			try {
			n=teclado.nextInt();
			System.out.println("el valor introducido es " +n);
			}
			catch(InputMismatchException e)
			{
				System.out.println("Se ha producido un error al leer el numero");
			}
			//libero memoria
			teclado.close();
			//mostrarpor pantalla
			
	}

}
