package evaluacion2;

public class Rectangulo extends Figura {
	double ancho;
	double alto;
	public Rectangulo() {
		// TODO Auto-generated constructor stub
		super();
		this.ancho=1.0;
		this.alto=1.0;
	}
	
	public Rectangulo(Rectangulo r) {
		// TODO Auto-generated constructor stub
		super(r);
		
		this.ancho=r.ancho;
		this.alto=r.alto;
	}
	public Rectangulo(int x, int y) {
		super(x,y);
		
	}

	public Rectangulo(double o, double l) {
		// TODO Auto-generated constructor stub
		super();
		
		this.ancho=o;
		this.alto=l;
	}
	public Rectangulo(Figura f,double o, double l) {
		super(f);
		this.ancho=o;
		this.alto=l;
	}
	public Rectangulo(int x, int y,double o, double l) {
		super(x,y);
		this.ancho=o;
		this.alto=l;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
return ancho*alto;
	}

	@Override
	public String toString() {
		return "Rectangulo- X:"+x+" Y:"+y+" Alto:"+alto+" Ancho:"+ancho+" Area:"+ancho*alto;
	}

}
