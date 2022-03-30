package evaluacion2;
import java.util.InputMismatchException;
import java.util.Scanner;
public class LeerEnteroRobusto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String cadena = "";
			//Defino un objeto de la clase Scanner
			Scanner teclado;
			//Creo un objeto de clase Scanner
			teclado=new Scanner(System.in);
			System.out.println("introdduce un entero:");
			char caracter;
			int n;
			//leo n
			try {
			cadena=teclado.nextLine();
			n=Integer.parseInt(cadena);
			System.out.println("el valor introducido es " +n);
			
			}
			catch(NumberFormatException e)
			{
				String correcto = "";
				if(cadena.contains("l")||cadena.contains("O")||cadena.contains("o"))
				{
					for(int i = 0;i<cadena.length();i++)
					{
					caracter=cadena.charAt(i);
					
					
					if(caracter=='l') {
						caracter='1';
					
					}else if(caracter=='O'||caracter=='o')
					{
						caracter='0';
					
					}
					
					correcto=correcto+caracter;
					
	
					}
			}else {
				System.out.println("error");
			}
			if(correcto.length()>0)
			{
				n=Integer.parseInt(correcto);
			}
			//mostrarpor pantalla
			System.out.println (" "+correcto);
	}
teclado.close();
}
}
