package evaluacion2;
import java.io.Serializable;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Fecha implements Comparable<Fecha>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 598196613836221551L;
	private int dia;
	private int mes;
	private int ano;
	//Constructor por defecto
	Fecha(){
		this.dia=1;
		this.mes=1;
		this.ano=2020;

	}
//Constructor copia
	public Fecha(Fecha f) {
		// TODO Auto-generated constructor stub

	this.dia=f.dia;
	this.mes=f.mes;
	this.ano=f.ano;

	}
	
	//Contructor personaliazdo(tocar)
	public Fecha(int d, int m, int a)
	{
		this.dia=d;
		this.mes=m;
		this.ano=a;

		if(this.dia==0 || this.mes==0) {
		this.dia=1;
		}
	}
//CompareTO
	@Override
	public int compareTo(Fecha other) {
		// TODO Auto-generated method stub
if(this.ano>other.ano)
{
return 1;
}
else if(this.ano<other.ano)
{
	return -1;
	}
else 
{
	if(this.mes>other.mes)
	{
	return 1;
	}
	else if(this.mes<other.mes)
	{
		return -1;
		}	

	else
	{
		if(this.dia>other.dia)
		{
		return 1;
		}
		else if(this.dia<other.dia)
		{
			return -1;
			}
	}
}
return 0;
}
	


	@Override
	public int hashCode() {
		return Objects.hash(ano, dia, mes);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fecha other = (Fecha) obj;
		return ano == other.ano && dia == other.dia && mes == other.mes;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}

	
}

	
