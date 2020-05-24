package uvsq.fr.pglp9_9;

import uvsq.fr.pglp9_9.AbstractDaoFactory.DaoType;

public class CreerGroupe implements Commande{
	

	Forme forme;
	public CreerGroupe(Groupe f,String[] listeForme) {
		  DAO<Cercle> CerclejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCercleDAO();
		  DAO<Carre> CarrejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCarreDAO();
		  DAO<Triangle> TrianglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getTriangleDAO();
		  DAO<Rectangle> RectanglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getRectangleDAO();
			DAO<Groupe> GroupejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getGroupeDAO();
		  forme=new Groupe(f.getNom());
		  for(String elem : listeForme ) {
			  Cercle ce= CerclejdbcDao.find(elem);
			  if(ce.getNom()!=null)((Groupe) forme).addForme(ce);
			  Carre ca= CarrejdbcDao.find(elem);
			  if(ca.getNom()!=null)((Groupe) forme).addForme(ca);
			  Rectangle re= RectanglejdbcDao.find(elem);
			  if(re.getNom()!=null)((Groupe) forme).addForme(re);
			  Triangle tr= TrianglejdbcDao.find(elem);
			  if(tr.getNom()!=null)((Groupe) forme).addForme(tr);
			 /* Groupe g= GroupejdbcDao.find(elem);
			  if(g.getID()!=null)((Groupe) forme).addForme(g);*/
		  }
	}
	
	@Override
	public void execute() {
		DAO<Groupe> GroupejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getGroupeDAO();

		GroupejdbcDao.create((Groupe) forme);	
	}
	
	@Override
	public void afficher() {
		System.out.println(forme);
	}

}
