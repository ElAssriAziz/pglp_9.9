package uvsq.fr.pglp9_9;

public class Rectangle extends Forme{

	private static final long serialVersionUID = 3419567554788899839L;
	private PointRef position ;
	private String nom;
	private int largeur;
	private int hauteur;
	/**
	 * Constructeur
	 * 
	 */
	public Rectangle(String nom,PointRef PRef,int largeur,int hauteur) {
		this.nom=nom;
		this.position=PRef;
		this.largeur=largeur;
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
	
	public void setLargeur(int largeur) {
		 this.largeur=largeur;
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
		return "Rectangle (" + this.getNom() + " (" + this.position.getx() + "," + this.position.gety() 
		+ " ), H = "+this.getHauteur()+", L = "+this.getLargeur()+")";
	}

	
}
