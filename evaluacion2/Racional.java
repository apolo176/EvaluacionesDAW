package evaluacion2;

import java.util.Objects;

public class Racional implements Comparable<Racional>{
//Defino la clase Racional
//Propiedades de la clase
private int numerador;
private int denominador;

//Constructores 

//Constructores por defecto
Racional(){
	this.numerador=0;
	this.denominador=1;
}

//Constructor copia
public Racional(Racional r) {
	// TODO Auto-generated constructor stub

this.numerador=r.numerador;
this.denominador=r.denominador;
}
//Constructores personalizados
public Racional(int n, int d) {
	// TODO Auto-generated constructor stub
	this.numerador=n;
	if(d!=0) {
	this.denominador=d;
	}
	else {
		this.denominador=1;
	}
}

public Racional(int n) {
	// TODO Auto-generated constructor stub
	this.numerador=n;
	this.denominador=1;
}
//Getters and setters
//Obtener o cambiar valores de las propiedades
public int getNumerador() {
	return numerador;
}

public void setNumerador(int numerador) {
	this.numerador = numerador;
}

public int getDenominador() {
	return denominador;
}

public void setDenominador(int denominador) {
	if(denominador!=0) {
	this.denominador = denominador;
	}
}

//toString
@Override
public String toString() {
	return ( numerador + "/" + denominador);
}

//hash code	
@Override
public int hashCode() {
	return Objects.hash(denominador, numerador);
}

@Override
public boolean equals(Object obj) {
	if (this == obj) {
		//Si es el mismo objeto
		return true;	
}
	if (obj == null)
		// si el objeto no esta  creado
		return false;
	if (getClass() != obj.getClass())
		//Si el objeto es de otra clase diferente
		return false;
	Racional other = (Racional) obj;
	if(this.denominador * other.numerador == other.denominador * this.numerador)
	{
		return true;
	}
	return false;
}

@Override
public int compareTo(Racional other) {
	// TODO Auto-generated method stub
	if(this.denominador * other.numerador > other.denominador * this.numerador)
	{
		return 1;
	}
	if(this.denominador * other.numerador < other.denominador * this.numerador)
	{
		return -1;
	}
	
	//pa cuando sean iguales
	return 0;
}
 //pro
	/*public int compareTo(Racional other) {
Integer n1= this.denominador * other.numerador;
Integer n2= this.denominador * other.numerador;
return (n1.compareTo(n2);
}
*/





}
