package evaluacion2;
import java.util.Random;
import java.util.Scanner;
public class RandomNumeroSecreto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Random rnd = new Random();
	int num=(int)((rnd.nextDouble()*10000))%10+1;
	int resp;
	Scanner teclado= new Scanner(System.in);
	int respuesta = 0;
	System.out.println("Introduce un numero: ");
	do {
	
		resp=teclado.nextInt();
		
	
		if (resp<num)
			{
			System.out.println("el valor introducido es menor ");
			}
		else if (resp>num)
			{
			System.out.println("el valor introducido es mayor ");
			
			}
		else if ( resp==num)
		{
			System.out.println("Felicidades!!");
			break;
			
		}
		
	
	
	}while (resp!=num);
	
	
	

}
}
