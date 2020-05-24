package uvsq.fr.pglp9_9;



public class Cercle extends Forme {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6933249287310042735L;
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
	public int getx() {
		return this.position.getx();
	}
	public int gety() {
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
	@Override
	public String toString() {
		return "Cercle (" + this.getNom() + ", Centre( " + this.position.getx() + "," + this.position.gety() 
		+ "), Rayon = "+this.getRayon()+" )";
	}
	@Override
	public void deplacer(int x, int y) {
		PointRef PointNouveau = new PointRef(this.getx()+x,this.gety()+y);
		this.position=PointNouveau;
	}
	@Override
	public void dessiner() {
		System.out.println(this);
	}
	
}
