package evaluacion2;

public final class Cuadrado extends Rectangulo{

	public Cuadrado() {
		// TODO Auto-generated constructor stub
	super();

	}
	public Cuadrado(Cuadrado C) {
		// TODO Auto-generated constructor stub
	super(C);

	}
	public Cuadrado(double lado) {
		// TODO Auto-generated constructor stub
	super(lado,lado);

	}
	public Cuadrado(int x, int y, double lado) {
		super(x,y,lado,lado);

	}
	
	@Override
	public String toString() {
		return "Cuadrado - X:"+x+" Y:"+y+" Lado:"+ancho+" Area:"+ancho*ancho;
	}
	
}
