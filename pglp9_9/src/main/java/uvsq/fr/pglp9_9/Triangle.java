package uvsq.fr.pglp9_9;

public class Triangle extends Forme {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9111151419060246745L;
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
	public int getx() {
		return this.position.getx();
	}
	public int gety() {
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
	public void deplacer(int x, int y) {
		PointRef PointNouveau = new PointRef(this.getx()+x,this.gety()+y);
		this.position=PointNouveau;
	}
	public void dessiner() {
		System.out.println(this);
	}
	@Override
	public String toString() {
		return "Triangle (" + this.getNom() + ", Position(" + this.position.getx() + "," + this.position.gety() 
		+ "), Base = "+this.getBase() +", Hauteur = "+this.getHauteur()+")";
	}
	
}
