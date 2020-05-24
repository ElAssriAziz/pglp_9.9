package uvsq.fr.pglp9_9;

import uvsq.fr.pglp9_9.AbstractDaoFactory.DaoType;

public class Dessiner implements Commande{
	Forme forme;
	public Dessiner(Forme f) { 
		if( f instanceof Cercle) {
			  DAO<Cercle> CerclejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCercleDAO();
			 forme=CerclejdbcDao.find(f.getNom());
	  }
	  else  if( f instanceof Carre) {
		  DAO<Carre> CarrejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCarreDAO();
		  forme=CarrejdbcDao.find(f.getNom());
	  }
	  else  if( f instanceof Triangle) {
		  DAO<Triangle> TrianglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getTriangleDAO();
		  forme=TrianglejdbcDao.find(f.getNom());
		  }
	  else  if( f instanceof Rectangle) {
		  DAO<Rectangle> RectanglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getRectangleDAO();
		  forme=RectanglejdbcDao.find(f.getNom());
		  }
	  else  if( f instanceof Groupe) {
		  DAO<Groupe> GroupejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getGroupeDAO();
		  forme=GroupejdbcDao.find(f.getNom());
		  }
	}
	public void execute() {
		  System.out.println(forme);
		
	}
	@Override
	public void afficher() {
		System.out.println("Affichage de dessin : \n"+forme);
		
	}

}
