package uvsq.fr.pglp9_9;

import java.io.Serializable;

public abstract class Forme implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6810827305987487444L;
	protected PointRef position;
	abstract public void deplacer();
	abstract public void dessiner();
	abstract public String getNom();
	abstract public String toString();
	public PointRef getPosition() {
		return this.position;
	}
}
