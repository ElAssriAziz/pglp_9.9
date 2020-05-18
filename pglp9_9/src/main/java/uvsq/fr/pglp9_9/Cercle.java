package uvsq.fr.pglp9_9;



public class Cercle extends Forme {
	
	
	private String nom;
	private int rayon;
	/**
	 * Constructeur
	 * x et y sont les coordonnees du point reference (centre)
	 */
	public Cercle(String nom,PointRef PRef,int rayon) {
		this.nom=nom;
		this.position=PRef;
		this.rayon=rayon;
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
	public int getRayon() {
		return this.rayon;
	}
	
	/**
	 * Les setters
	 */
	public void setNom(String n) {
		 this.nom=n;
	}
	
	public void setRayon(int rayon) {
		 this.rayon=rayon;
	}
	public void deplacer() {
		// TODO Auto-generated method stub
		
	}
	public void dessiner() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "Cercle (" + this.getNom() + ",centre( " + this.position.getx() + "," + this.position.gety() 
		+ "), rayon = "+this.getRayon()+" )";
	}
	
}
