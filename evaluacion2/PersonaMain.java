package evaluacion2;

public class PersonaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prueb la clase Racional
		Persona p;
		p=new Persona();
		p.setDni("222222222A");
		p.setNombre("Eder");
		p.setApellido("Torres");
		Persona p2;
//Constructores
	
		//Constructores por defecto

		
		//constructor Copia
		Fecha f=new Fecha(9,12,2021);
		p2=new Persona(p);

		
		System.out.println(p2);
	  //Personalizado
		Persona p3;
		p3=new Persona("222222222C","Alex","Navas",f);
		System.out.println(p3);
		
		//Racional r4;
		//r4=new Racional(7);
		//System.out.println(r4);
		//Getters and setters
		System.out.println("DNi:"+p3.getDni());
		System.out.println("Nombre:"+p3.getNombre());
		System.out.println("Apellido:"+p3.getApellido());
		System.out.println("Fecha de nacimiento:"+p3.getFechanaci());
		//r4.setDenominador(0);
		//System.out.println(r4);

		/*Racional r5;
		r5=new Racional(3,0);
		System.out.println(r5);
		*/
		Persona p6;
		p6=new Persona("222222222A","Eder","Torres",f);
			if(p3.equals(p2))
			{
				System.out.println(p3+" y "+p2+" son iguales");
			}
			else
			
				{
					System.out.println(p3+" y "+p2+" NO son iguales");
				}
			
			/*
			String s="Prueba";
			if(r5.equals(s))
			{
				System.out.println(s+" y "+p6+"son iguales");
			}
			else
			
				{
					System.out.println("'"+s+"' y "+p6+" NO son iguales");
				}
				*/
			//Compare to
			if (p3.compareTo(p2)<0) {
				System.out.println(p3+"' es mayor que "+p2);
			}
			else if (p3.compareTo(p2)>0) {
				System.out.println(p3+" es menor que "+p2);
			}
			else{
				System.out.println(p3+" es igual que "+p2);
			}
	}

}
