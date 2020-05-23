package uvsq.fr.pglp9_9;


public class Carre extends Forme {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3110761239476668770L;
	private String nom;
	private int largeur ;
	private int hauteur ; 
	/**
	 * Constructeur
	 * x et y sont les coordonnes du point reference
	 */
	public Carre(String nom,PointRef PRef,int larg) {
		this.nom=nom;
		this.position=PRef;
		this.largeur=larg;
		this.hauteur=larg;
	}
	/**
	 * Les getters
	 */

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

	public void setHauteur(int haut) {
		 this.hauteur=haut;
	}
	public void setLargeur(int larg) {
		 this.largeur=larg;
	}
	
	public void deplacer() {
		PointRef PointNouveau = new PointRef(this.getx(),this.gety());
		this.position=PointNouveau;
	}
	public void dessiner() {
	System.out.println(this);
		
	}
	@Override
	public String toString() {
		return "Carre (" + this.getNom() + " , Position( " + this.position.getx() + "," + this.position.gety() 
		+ "), "+this.getLargeur()+" )";
	}
	@Override
	public String getNom() {
	
			return this.nom;
		
	}
}
