package uvsq.fr.pglp9_9;



public class Carre {
	String nom;
	int x;
	int y;
	int rayon;
	/**
	 * Constructeur
	 * x et y sont les coordonnes du point reference
	 */
	public Carre(String nom,int x,int y,int rayon) {
		this.nom=nom;
		this.x=x;
		this.y=y;
		this.rayon=rayon;
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
	public int getRayon() {
		return this.rayon;
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
	public void setRayon(int rayon) {
		 this.rayon=rayon;
	}
	
}
