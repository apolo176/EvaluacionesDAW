package evaluacion1;

import java.util.Scanner;

public class Leerstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		//Defino un objeto de la clase Scanner
		Scanner teclado;
		//Creo un objeto de clase Scanner
		teclado=new Scanner(System.in);
		System.out.println("introdduce un nombre:");
		//leo s
		s=teclado.nextLine();
		//libero memoria
		teclado.close();
		//mostrarpor pantalla
		System.out.println("el valor introducido es " +s);
	}

}
