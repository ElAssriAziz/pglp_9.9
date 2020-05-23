package uvsq.fr.pglp9_9.dao;

import uvsq.fr.pglp9_9.AbstractDaoFactory;
import uvsq.fr.pglp9_9.Carre;
import uvsq.fr.pglp9_9.Cercle;
import uvsq.fr.pglp9_9.DAO;
import uvsq.fr.pglp9_9.Groupe;
import uvsq.fr.pglp9_9.Rectangle;
import uvsq.fr.pglp9_9.Triangle;

public class DAOFactory extends AbstractDaoFactory{
	


	@Override
	public DAO<Cercle> getCercleDAO() {
		return new CercleDAO();
	}


	@Override
	public DAO<Triangle> getTriangleDAO() {
		return new TriangleDAO();
	}

	@Override
	public DAO<Carre> getCarreDAO() {
		return new CarreDAO();
	
	}

	@Override
	public DAO<Rectangle> getRectangleDAO() {
	 	return new RectangleDAO();
	}


	@Override
	public DAO<Groupe> getGroupeDAO() {
		return new GroupeDAO();
	}
}
