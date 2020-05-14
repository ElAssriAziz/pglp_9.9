package uvsq.fr.pglp9_9;

public class Rectangle {
	String nom;
	int x;
	int y;
	int largeur;
	int hauteur;
	/**
	 * Constructeur
	 * x et y sont les coordonnees du point reference
	 */
	public Rectangle(String nom,int x,int y,int largeur,int hauteur) {
		this.nom=nom;
		this.x=x;
		this.y=y;
		this.largeur=largeur;
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
	public int getLargeur() {
		return this.largeur;
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
	public void setLargeur(int largeur) {
		 this.largeur=largeur;
	}
	public void setHauteur(int hauteur) {
		 this.hauteur=hauteur;
	}
	
}
