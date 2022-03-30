package evaluacion2;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Asignatura implements Comparable<Asignatura>{
	private String descripcion;
	private String nombre ;
	private String codigo;
private double nota;
	//Constructor por defecto
	Asignatura(){
		this.descripcion="";
		this.codigo="";
		this.nota=0.0;
		this.nombre = "";
		
	}
//Constructor copia
	public Asignatura(Asignatura p) {
		// TODO Auto-generated constructor stub

	this.descripcion=p.descripcion;
	this.codigo=p.codigo;
	this.nota=p.nota;
	this.nombre = p.nombre;

	}
	
	//Contructor personaliazdo(tocar)
	 public Asignatura( String cod,  String nombre, String desc)
	{
		this.descripcion=desc;
	
		this.codigo=cod;
		this.nombre = nombre;


	}
	 
	 public Asignatura(String d, String c, Double n)
	{
		this.descripcion=d;
		this.nota=n;
		this.codigo=c;
		this.nombre = "";


	}
//CompareTO
	@Override
	public int compareTo(Asignatura other) {
		// TODO Auto-generated method stub
/*return(this.codigo.compareTo(other.codigo)*/
 if(this.codigo.compareTo(other.codigo)>0)
		{
		return 1;
		}
		if(this.codigo.compareTo(other.codigo)<0)
		{
		return -1;
		}
	//Cuando sea igual
		if(this.codigo.compareTo(other.codigo)==0)
		{
			if(this.nota<other.nota)
			{
			return 1;
			}
			if(this.nota>other.nota)
			{
			return -1;
			}
		
	}
		return 0;
	}
	/*public int compareTo(Asignatura other) {
	 int comparacion
	 comparacion= this.codigo.compareTo(other.codigo)
	 if comparacion==0
	 {
Double n1= this.nota;
Double n2= other.nota;
comparacion= (n1.compareTo(n2));
}
return(comparacion)*/
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo, descripcion, nota);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return (this.codigo.equals (other.codigo)
				&& this.nota==other.nota);
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	@Override
	public String toString() {
		return codigo + " - " + nota;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}

	
