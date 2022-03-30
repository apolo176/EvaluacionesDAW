package evaluacion1;
import java.util.Scanner;
public class leernum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int n;
			//Defino un objeto de la clase Scanner
			Scanner teclado;
			//Creo un objeto de clase Scanner
			teclado=new Scanner(System.in);
			System.out.println("introdduce un entero:");
			//leo n
			n=teclado.nextInt();
			//libero memoria
			teclado.close();
			//mostrarpor pantalla
			System.out.println("el valor introducido es " +n);
	}

}
