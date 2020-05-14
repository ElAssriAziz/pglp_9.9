package uvsq.fr.pglp9_9;

public class Triangle {
	String nom;
	int x;
	int y;
	int base;
	int hauteur;
	/**
	 * Constructeur
	 * x et y sont les coordonnes du point reference
	 */
	public Triangle(String nom,int x,int y,int base,int hauteur) {
		this.nom=nom;
		this.x=x;
		this.y=y;
		this.base=base;
		this.hauteur=hauteur;
	}
	/**
	 * Les getters
	 */
	public String getNom() {
		return this.nom;
	}
	public int getx() {
		return this.x;
	}
	public int gety() {
		return this.y;
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
	public void setx(int x) {
		 this.x=x;
	}
	public void setY(int y) {
		 this.y=y;
	}
	public void setBase(int base) {
		 this.base=base;
	}
	public void setHauteur(int hauteur) {
		 this.hauteur=hauteur;
	}
	
}
