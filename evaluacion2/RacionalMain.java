package evaluacion2;

public class RacionalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prueb la clase Racional
		Racional r1;
		Racional r2;
//Constructores
	
		//Constructores por defecto
		r1=new Racional();//
		System.out.println(r1);
		//constructor Copia
		
		r2=new Racional(r1);
		r2.setNumerador(2);
		System.out.println(r1);
		System.out.println(r2);
	  //Personalizado
		Racional r3;
		r3=new Racional(3,4);
		System.out.println(r3);
		
		Racional r4;
		r4=new Racional(7);
		System.out.println(r4);
		//Getters and setters
		
		System.out.println("Num:"+r3.getNumerador());
		System.out.println("Num:"+r3.getNumerador());
		r4.setDenominador(0);
		System.out.println(r4);

		Racional r5;
		r5=new Racional(3,0);
		System.out.println(r5);
		
		Racional r6;
		r6=new Racional(6,8);
			if(r3.equals(r6))
			{
				System.out.println(r3+" y "+r6+" son iguales");
			}
			else
			
				{
					System.out.println(r3+" y "+r6+" NO son iguales");
				}
			
			
			String s="Prueba";
			if(r5.equals(s))
			{
				System.out.println(s+" y "+r5+"son iguales");
			}
			else
			
				{
					System.out.println("'"+s+"' y "+r5+" NO son iguales");
				}
			//Compare to
			if (r3.compareTo(r4)>0) {
				System.out.println(r3+"' es mayor que "+r4);
			}
			else if (r3.compareTo(r4)<0) {
				System.out.println(r3+" es menor que "+r4);
			}
			else{
				System.out.println(r3+" es igual que "+r4);
			}
	}

}
