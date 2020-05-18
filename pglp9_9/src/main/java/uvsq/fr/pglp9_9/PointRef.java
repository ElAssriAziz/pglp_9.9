package uvsq.fr.pglp9_9;



public class PointRef{

	private double x;
	private double y;
	/**
	 * Constructeur
	 * x et y sont les coordonnees du point reference
	 */
	public PointRef(double x,double y) {
		this.x=x;
		this.y=y;
	}
	public double getx() { return this.x;}
	public double gety() { return this.y;}
	
	public void setx(double x) {  this.x=x;}
	public void sety(double y) {  this.y=y;}
}
