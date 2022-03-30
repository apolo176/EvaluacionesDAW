package evaluacion2;

public class Circulo extends Figura{
	protected double radio;


	public Circulo() {
		// TODO Auto-generated constructor stub
		super();
		this.radio=1.0;
		
	}
	public Circulo(Circulo c) {
		// TODO Auto-generated constructor stub
	super(c);
		this.radio=1.0;
		
	}
	public Circulo(double r) {
		super();
		this.radio=r;
	}
	public Circulo(int x, int y, double radio){
	super(x,y);
	this.radio=radio;
	}
	@Override
	public double area(){
	return Math.PI*radio*radio;
	}
	@Override
	public String toString() {
		return "Circulo - X:"+x+" Y:"+y+" Radio:"+radio+" Area:"+Math.PI*radio*radio;
	}

}
