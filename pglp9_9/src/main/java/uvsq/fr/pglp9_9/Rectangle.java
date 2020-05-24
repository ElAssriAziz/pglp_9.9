package uvsq.fr.pglp9_9;

public class Rectangle extends Forme{

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
	public int getx() {
		return this.position.getx();
	}
	public int gety() {
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
	public void deplacer(int x, int y) {
		PointRef PointNouveau = new PointRef(this.getx()+x,this.gety()+y);
		this.position=PointNouveau;
		
	}
	public void dessiner() {
		System.out.println(this);
	}
	@Override
	public String toString() {
		return "Rectangle (" + this.getNom() + " Position(" + this.position.getx() + "," + this.position.gety() 
		+ " ), Hauteur = "+this.getHauteur()+", Largeur = "+this.getLargeur()+")";
	}

	
}
