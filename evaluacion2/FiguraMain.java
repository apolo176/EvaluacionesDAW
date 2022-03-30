package evaluacion2;

public class FiguraMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo r1= new Rectangulo();
System.out.println("Area: "+r1.area());
Rectangulo r2= new Rectangulo(r1);
System.out.println("Area: "+r2.area());
Rectangulo r3= new Rectangulo(5.0,3.0);
System.out.println("Area: "+r3.area());
Rectangulo r4= new Rectangulo(1,1,5.0,3.0);
System.out.println(r4);
	
Circulo c1= new Circulo();
System.out.println("Area: "+c1.area());
Circulo c2= new Circulo(c1);
System.out.println("Area: "+c2.area());
Circulo c3= new Circulo(5.0);
System.out.println("Area: "+c3.area());
Circulo c4= new Circulo(1,1,5.0);
System.out.println(c4);
	
Cuadrado C1= new Cuadrado();
System.out.println("Area: "+C1.area());
Cuadrado C2= new Cuadrado(C1);
System.out.println("Area: "+C2.area());
Cuadrado C3= new Cuadrado(5.0);
System.out.println("Area: "+C3.area());
Cuadrado C4= new Cuadrado(1,2,6.0);
System.out.println(C4);
	}

}
