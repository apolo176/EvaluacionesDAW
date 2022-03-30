package evaluacion1;

import java.util.Scanner;

public class LeerReal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d;
		//Defino un objeto de la clase Scanner
		Scanner teclado;
		//Creo un objeto de clase Scanner
		teclado=new Scanner(System.in);
		System.out.println("introdduce un real:");
		//leo d
		d=teclado.nextDouble();
		//libero memoria
		teclado.close();
		//mostrarpor pantalla
		System.out.println("el valor introducido es " +d);

	}

}
