package uvsq.fr.pglp9_9;

import uvsq.fr.pglp9_9.AbstractDaoFactory.DaoType;

public class DeplacerGroupe implements Commande{
	Forme forme;
	public DeplacerGroupe(Forme f,int x,int y) {
		 DAO<Groupe> GroupejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getGroupeDAO();
		  forme=GroupejdbcDao.find(((Groupe) f).getID());
		  for(Forme elem: ((Groupe) forme).getListeFormes()) {
			  if( elem instanceof Cercle) {
				  System.out.print(((Cercle) elem).getx());
				  DAO<Cercle> CerclejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCercleDAO();
				  elem.position.setx(elem.position.getx()+x);
				  elem.position.sety(elem.position.gety()+y);
				  CerclejdbcDao.update((Cercle) elem);
				  System.out.print(((Cercle) elem).getx());
			  }
			  else  if( elem instanceof Carre) {
				  System.out.print(((Carre) elem).getx());
				  DAO<Carre> CarrejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCarreDAO();
				  elem.position.setx(elem.position.getx()+x);
				  elem.position.sety(elem.position.gety()+y);
				  CarrejdbcDao.update((Carre) elem);
			  }
			  else  if( elem instanceof Triangle) {
				  System.out.print(((Triangle) elem).getx());
				  DAO<Triangle> TrianglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getTriangleDAO();
				  elem.position.setx(elem.position.getx()+x);
				  elem.position.sety(elem.position.gety()+y);
				  TrianglejdbcDao.update((Triangle) elem);
				  }
			  else  if( elem instanceof Rectangle) {
				  System.out.print(((Rectangle) elem).getx());
				  DAO<Rectangle> RectanglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getRectangleDAO();
				  elem.position.setx(elem.position.getx()+x);
				  elem.position.sety(elem.position.gety()+y);
				  RectanglejdbcDao.update((Rectangle) elem);
				  }
		  }			  
		  // Recuperer la position de la première forme de la liste des formes du groupe 
		  // et la deplacer de (x,y)
		  PointRef p1= new PointRef(((Groupe) forme).getListeFormes().get(0).getPosition().getx()+x
				  ,((Groupe) forme).getListeFormes().get(0).getPosition().gety()+y);
		  ((Groupe) forme).setID(((Groupe) f).getID());
		  forme.position=p1;
	}
	@Override
	public void execute() {
		  DAO<Groupe> GroupejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getGroupeDAO();
		  GroupejdbcDao.update((Groupe) forme);
	}

	@Override
	public void afficher() {
		System.out.println(forme);
	}

}
