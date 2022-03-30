package evaluacion2;
import java.util.InputMismatchException;
import java.util.Scanner;
public class LeerRealRobusto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String cadena = "";
			//Defino un objeto de la clase Scanner
			Scanner teclado;
			String correcto = "";
			//Creo un objeto de clase Scanner
			teclado=new Scanner(System.in);
			System.out.println("introdduce un entero:");
			char caracter;
			double n;
			//leo n
			try {
			cadena=teclado.nextLine();
			n=Double.parseDouble(cadena);
			System.out.println("el valor introducido es " +n);
			
			}
			catch(NumberFormatException e)
			{
				boolean separador= false;
			
					for(int i = 0;i<cadena.length();i++)
					{
					caracter=cadena.charAt(i);
					
					
					if((caracter==',' || caracter == '.') &&separador==false) {
						caracter='.';
						separador=true;
						correcto=correcto+caracter;
					
					}else if(Character.isDigit(caracter))
					{
						correcto=correcto+caracter;
					}
					else if(caracter=='O'||caracter=='o')
					{
						caracter='0';
						correcto=correcto+caracter;
					}
					else if(caracter=='l')
					{
						caracter='1';
						correcto=correcto+caracter;
					}
					
					
			
					
					}
					
			}
			if(correcto.length()>0)
			{
				n=Double.parseDouble(correcto);
			}
			//mostrarpor pantalla
			System.out.println (" "+correcto);
	}

}

