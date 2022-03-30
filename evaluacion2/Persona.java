package evaluacion2;
import java.io.Serializable;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Persona implements Comparable<Persona>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9195085326324228102L;
	
	protected String dni;
	protected String apellido;
	public String nombre;
	public Fecha fechanaci;
	//Constructor por defecto
	public Persona(){
		this.dni="";
		this.nombre="";
		this.apellido="";
		fechanaci= new Fecha();
	}
//Constructor copia
	public Persona(Persona p) {
		// TODO Auto-generated constructor stub

	this.dni=p.dni;
	this.nombre=p.nombre;
	this.apellido=p.apellido;
this.fechanaci= new Fecha(p.fechanaci);
	}
	
	//Contructor personaliazdo(tocar)
	public Persona(String dni, String n, String a, Fecha f)
	{
		this.dni=dni;
		this.nombre=n;
		this.apellido=a;
		this.fechanaci=new Fecha(f);
	/*	if(this.dni==0 || this.mes==0) {
		this.dia=1;+
		}*/
	}
public Persona(String DNI2, String nombre2, String apellido2) {
		// TODO Auto-generated constructor stub
	this.dni=DNI2;
	this.nombre= nombre2;
	this.apellido=apellido2;
	new Fecha();
	
}
	//CompareTO
	@Override
	public int compareTo(Persona other) {
		// TODO Auto-generated method stub
		return (this.dni.compareTo(other.dni));
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, fechanaci, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return (this.dni.equals(other.dni));
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Fecha getFechanaci() {
		return fechanaci;
	}
	public void setFechanaci(Fecha fechanaci) {
		this.fechanaci = fechanaci;
	}
	@Override
	public String toString() {
		return dni + " " + nombre + " " + apellido + " " +
				fechanaci;
	}
	public int compareTo(Alumno other) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

	
