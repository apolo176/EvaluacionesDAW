package evaluacion2;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Alumno extends Persona{
	private Persona p1;
	private String grupo;
	//Constructor por defecto
	Alumno(){
super();

this.grupo="1dw3";
	}
//Constructor copia
	public Alumno(Alumno p) {
		// TODO Auto-generated constructor stub
	super(p);
	this.grupo="1dw3";


	}
	
	//Contructor personaliazdo(tocar)
	public Alumno(Persona p1, String grupo)
	{
		super(p1);
		this.grupo=grupo;
	

	}
//CompareTO
	
public Alumno(String dNI, String nombre, String apellido, Fecha f,String grupo) {
		// TODO Auto-generated constructor stub
	}
@Override
	public int compareTo(Alumno other) {
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
		Alumno other = (Alumno) obj;
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
				fechanaci+" "+grupo;
	}

	
}

	
