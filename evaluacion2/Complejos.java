package evaluacion2;
import java.io.Serializable;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Complejos implements Comparable<Complejos>,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6388744867807969172L;
	private double real;
	private double imaginaria;
	//Constructor por defecto
	Complejos(){
		this.real=0;
		this.imaginaria=0;
	}
	
	public Complejos(int r, int i)
	{
		this.real=r;
		this.imaginaria=i;
		if(this.real==0 && this.imaginaria==0) {
		this.imaginaria=1;
		}
	}

	@Override
	public int compareTo(Complejos other) {
		// TODO Auto-generated method stub

		
		if(this.real + this.imaginaria > other.real + other.imaginaria)
		{
		return 1;
		}
		if(this.real + this.imaginaria < other.real + other.imaginaria)
		{
		return -1;
		}
	//Cuando sea igual
		
			return 0;
	}
	@Override
	public int hashCode() {
		return Objects.hash(imaginaria, real);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complejos other = (Complejos) obj;
		return Double.doubleToLongBits(imaginaria) == Double.doubleToLongBits(other.imaginaria)
				&& Double.doubleToLongBits(real) == Double.doubleToLongBits(other.real);
	}

	public String toString() {

		return ( real + " + " + imaginaria+"i");
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginaria() {
		return imaginaria;
	}

	public void setImaginaria(double imaginaria) {
		this.imaginaria = imaginaria;
	}
	
}

	
