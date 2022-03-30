package evaluacion2;

public class AsignaturaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prueb la clase Racional
		Asignatura a;
		Asignatura a2;
//Constructores
	
		//Constructores por defecto
		a=new Asignatura();//
		
		//constructor Copia
		
		a2=new Asignatura(a);
		a2.setCodigo("22222");
		a2.setNota(4.5);
		a2.setDescripcion("Descripcion");
		
		System.out.println(a2);
	  //Personalizado
		Asignatura a3;
		a3=new Asignatura("Descripcion","33333",7.7);
		System.out.println(a3);
		
		//Racional r4;
		//r4=new Racional(7);
		//System.out.println(r4);
		//Getters and setters
		System.out.println("Descripcion: "+a3.getDescripcion());
		System.out.println("Codigo: "+a3.getCodigo());
		System.out.println("Nota: "+a3.getNota());

		//r4.setDenominador(0);
		//System.out.println(r4);

		/*Racional r5;
		r5=new Racional(3,0);
		System.out.println(r5);
		*/
		Asignatura a6;
		a6=new Asignatura("222222222A","33333",7.7);
			if(a3.equals(a6))
			{
				System.out.println(a3+" y "+a6+" son iguales");
			}
			else
			
				{
					System.out.println(a3+" y "+a6+" NO son iguales");
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
			if (a3.compareTo(a6)<0) {
				System.out.println(a3+"' es mayor que "+a6);
			}
			else if (a3.compareTo(a6)>0) {
				System.out.println(a3+" es menor que "+a6);
			}
			else{
				System.out.println(a3+" es igual que "+a6);
			}
	}

}
