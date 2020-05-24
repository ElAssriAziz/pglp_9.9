package uvsq.fr.pglp9_9.JDBC;

import uvsq.fr.pglp9_9.AbstractDaoFactory;
import uvsq.fr.pglp9_9.Carre;
import uvsq.fr.pglp9_9.Cercle;
import uvsq.fr.pglp9_9.DAO;
import uvsq.fr.pglp9_9.Groupe;
import uvsq.fr.pglp9_9.Rectangle;
import uvsq.fr.pglp9_9.Triangle;

public class JdbcDoaFactory extends AbstractDaoFactory{

	@Override
	public DAO<Carre> getCarreDAO() {
		return new CarreJDBC();
	}

	@Override
	public DAO<Cercle> getCercleDAO() {
		return  new CercleJDBC();
	}

	@Override
	public DAO<Rectangle> getRectangleDAO() {
		return  new RectangleJDBC();
	}

	@Override
	public DAO<Triangle> getTriangleDAO() {
		return  new TriangleJDBC();
	}

	@Override
	public DAO<Groupe> getGroupeDAO() {
		return new GroupeJDBC(); 
	}

}
