package evaluacion2;

import java.util.Objects;

public abstract class Figura implements Comparable<Figura>{
protected int x;
protected int y;

public Figura(){
	this.x= 0;
	this.y=0;
}

public Figura(Figura f)
{
	this.x=f.x;
	this.y=f.y;
}
public Figura(int x, int y)
{
	this.x=x;
	this.y=y;
}

@Override
public int hashCode() {
	return Objects.hash(x, y);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Figura other = (Figura) obj;
	return x == other.x && y == other.y;
}

public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

@Override
public String toString() {
	return "Figura - X:"+x+" Y:"+y;
}
@Override
public int compareTo(Figura other) {
	return 1;
	
}
public abstract double area();
}
