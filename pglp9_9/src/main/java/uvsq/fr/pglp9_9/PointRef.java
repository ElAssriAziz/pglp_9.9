package uvsq.fr.pglp9_9;

import java.io.Serializable;

public class PointRef implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7847006374460651840L;
	private int x;
	private int y;
	/**
	 * Constructeur
	 * x et y sont les coordonnees du point reference
	 */
	public PointRef(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int getx() { return this.x;}
	public int gety() { return this.y;}
	
	public void setx(int x) {  this.x=x;}
	public void sety(int y) {  this.y=y;}
}
