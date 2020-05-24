package uvsq.fr.pglp9_9;

import uvsq.fr.pglp9_9.AbstractDaoFactory.DaoType;
import uvsq.fr.pglp9_9.Commande;
public class Deplacer implements Commande{
	Forme forme;
	public Deplacer(Forme f,int x,int y) {
		  if( f instanceof Cercle) {
			  DAO<Cercle> CerclejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCercleDAO();
			  forme=CerclejdbcDao.find(f.getNom());
			  PointRef p1= new PointRef(forme.getPosition().getx()+x,forme.getPosition().gety()+y);
			  // on change juste la position
			  forme=new Cercle(forme.getNom(),p1,((Cercle) forme).getRayon());
		  }
		  else  if( f instanceof Carre) {
			  DAO<Carre> CarrejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCarreDAO();
			  forme=CarrejdbcDao.find(f.getNom());
			  PointRef p1= new PointRef(forme.getPosition().getx()+x,forme.getPosition().gety()+y);
			  // on change juste la position
			  forme=new Carre(f.getNom(),p1,((Carre) f).getHauteur());
		  }
		  else  if( f instanceof Triangle) {
			  DAO<Triangle> TrianglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getTriangleDAO();
			  forme=TrianglejdbcDao.find(f.getNom());
			  PointRef p1= new PointRef(forme.getPosition().getx()+x,forme.getPosition().gety()+y);
			  // on change juste la position
			  forme=new Triangle(f.getNom(),p1,((Triangle) f).getBase(),((Triangle) f).getHauteur()); 
			  }
		  else  if( f instanceof Rectangle) {
		
			  DAO<Rectangle> RectanglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getRectangleDAO();
			  forme=RectanglejdbcDao.find(f.getNom());
			  PointRef p1= new PointRef(forme.getPosition().getx()+x,forme.getPosition().gety()+y);
			  // on change juste la position
			  forme=new Rectangle(f.getNom(),p1,((Rectangle) f).getLargeur(),((Rectangle) f).getHauteur());
			  }		
	}
	
	public void execute() {
		  if( forme instanceof Cercle) {
			  DAO<Cercle> CerclejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCercleDAO();
			  CerclejdbcDao.update((Cercle) forme);
		  }
		  else  if( forme instanceof Carre) {
			  DAO<Carre> CarrejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCarreDAO();
			  CarrejdbcDao.update((Carre) forme);
		  }
		  else  if( forme instanceof Triangle) {
			  DAO<Triangle> TrianglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getTriangleDAO();
			  TrianglejdbcDao.update((Triangle) forme); }
		  else  if( forme instanceof Rectangle) {
			  DAO<Rectangle> RectanglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getRectangleDAO();
			  RectanglejdbcDao.update((Rectangle) forme); }
		
	}
	@Override
	public void afficher() {
		System.out.println(forme);	
	}
	

}
