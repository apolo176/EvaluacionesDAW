package evaluacion1;

import java.util.Scanner;

public class LeerCaracter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c;
		//Defino un objeto de la clase Scanner
		Scanner teclado;
		//Creo un objeto de clase Scanner
		teclado=new Scanner(System.in);
		System.out.println("introdduce un caracter:");
		//leo n
		c = teclado.nextLine().charAt(2);

		//libero memoria
		teclado.close();
		//mostrarpor pantalla
		System.out.println("el valor introducido es " +c);
	}

	
}
