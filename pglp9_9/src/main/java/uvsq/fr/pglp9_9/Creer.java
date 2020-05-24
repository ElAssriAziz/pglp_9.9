package uvsq.fr.pglp9_9;

import uvsq.fr.pglp9_9.AbstractDaoFactory.DaoType;

public class Creer implements Commande {
	
	 Forme forme;
	 
	public Creer(Forme f) {
		  if( f instanceof Cercle) {
			  forme=new Cercle(f.getNom(),f.getPosition(),((Cercle) f).getRayon());
		  }
		  else  if( f instanceof Carre) {
			  forme=new Carre(f.getNom(),f.getPosition(),((Carre) f).getHauteur()); 
		  }
		  else  if( f instanceof Triangle) {
			  forme=new Triangle(f.getNom(),f.getPosition(),((Triangle) f).getBase(),((Triangle) f).getHauteur()); 
		  }
		  else  if( f instanceof Rectangle) {
			 // System.out.println(f.getPosition().getx());
			  forme=new Rectangle(f.getNom(),f.getPosition(),((Rectangle) f).getLargeur(),((Rectangle) f).getHauteur());
		  }
	
	}
	@Override
	public void execute() {
		
		  if( forme instanceof Cercle) {
			  DAO<Cercle> CerclejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCercleDAO();
			  CerclejdbcDao.create((Cercle) forme);
		  }
		  else  if( forme instanceof Carre) {
			  DAO<Carre> CarrejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCarreDAO();
			  CarrejdbcDao.create((Carre) forme);
		  }
		  else  if( forme instanceof Triangle) {
			  DAO<Triangle> TrianglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getTriangleDAO();
			  TrianglejdbcDao.create((Triangle) forme); 
			  }
		  else  if( forme instanceof Rectangle) {
			  DAO<Rectangle> RectanglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getRectangleDAO();
			  RectanglejdbcDao.create((Rectangle) forme);
			  }
	}
	@Override
	public void afficher() {
		System.out.println(forme);
		
	}
	
}
