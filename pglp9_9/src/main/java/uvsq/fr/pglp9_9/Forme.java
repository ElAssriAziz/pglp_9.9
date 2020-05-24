package uvsq.fr.pglp9_9;

import java.io.Serializable;

public abstract class Forme implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6810827305987487444L;
	protected PointRef position;
	protected String nom;
	abstract public void deplacer(int x,int y);
	abstract public void dessiner();
	abstract public String getNom();
	public abstract void setNom(String nom);
	abstract public String toString();
	public PointRef getPosition() {
		return this.position;
	}
	
}
