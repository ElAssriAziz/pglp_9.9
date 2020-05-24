package uvsq.fr.pglp9_9;

import uvsq.fr.pglp9_9.JDBC.JdbcDoaFactory;
import uvsq.fr.pglp9_9.dao.DAOFactory;

public abstract class AbstractDaoFactory {
	
	public enum DaoType{dao,jdbc}
	public abstract DAO<Carre> getCarreDAO();
	public abstract DAO<Cercle> getCercleDAO();
	public abstract DAO<Rectangle> getRectangleDAO();
	public abstract DAO<Triangle> getTriangleDAO();
	public abstract DAO<Groupe> getGroupeDAO();
	
	public static AbstractDaoFactory getFactory(DaoType type) {
		if(type == DaoType.dao) return new DAOFactory();
		if(type == DaoType.jdbc) return new JdbcDoaFactory();
		return null;
	}
}
