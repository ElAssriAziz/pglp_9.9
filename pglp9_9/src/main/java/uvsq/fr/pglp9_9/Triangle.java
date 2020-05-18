package uvsq.fr.pglp9_9;

public class Triangle extends Forme {
	
	private String nom;
	private int base;
	private int hauteur;
	/**
	 * Constructeur
	 * 
	 */
	public Triangle(String nom,PointRef PRef,int base,int hauteur) {
		this.nom=nom;
		this.position=PRef;
		this.base=base;
		this.hauteur=hauteur;
	}
	/**
	 * Les getters
	 */
	public String getNom() {
		return this.nom;
	}
	public double getx() {
		return this.position.getx();
	}
	public double gety() {
		return this.position.gety();
	}
	public int getBase() {
		return this.base;
	}
	public int getHauteur() {
		return this.hauteur;
	}
	
	/**
	 * Les setters
	 */
	public void setNom(String n) {
		 this.nom=n;
	}
	
	public void setBase(int base) {
		 this.base=base;
	}
	public void setHauteur(int hauteur) {
		 this.hauteur=hauteur;
	}
	public void deplacer() {
		// TODO Auto-generated method stub
		
	}
	public void dessiner() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "Triangle (" + this.getNom() + "(" + this.position.getx() + "," + this.position.gety() 
		+ " ), H="+this.getHauteur()+", B="+this.getBase()+")";
	}
	
}
