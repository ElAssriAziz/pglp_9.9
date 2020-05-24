package uvsq.fr.pglp9_9.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uvsq.fr.pglp9_9.*;
import uvsq.fr.pglp9_9.AbstractDaoFactory.DaoType;

public class GroupeJDBC implements DAO<Groupe> {

	@Override
	public Groupe find(String t) {

		 try {	
			 String sql1="SELECT * FROM Groupe WHERE id=?;";
				 PreparedStatement preparedStatement1 =
					        connection.prepareStatement(sql1);
				 preparedStatement1.setString(1,t);
				 ResultSet result1 = preparedStatement1.executeQuery();
				 while(result1.next()){
					 PointRef p=new PointRef(result1.getInt(2),result1.getInt(3));
					 Groupe gr = new Groupe(result1.getString(1));
		    	  System.out.println("Groupe a été bien trouvé dans la base de données");
		    	  return gr;
				 }

		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return null;		
	}

	@Override
	public Groupe create(Groupe t) {
		 Groupe g = new Groupe("");
		try {
			 String sql1="INSERT INTO Groupe VALUES (?,?,?);";
			 PreparedStatement preparedStatement =
				        connection.prepareStatement(sql1);
			 preparedStatement.setString(1,t.getID());
			 // la position du groupe est la position de premiere forme composante
			 preparedStatement.setDouble(2,t.getListeFormes().get(0).getPosition().getx());
			 preparedStatement.setDouble(3,t.getListeFormes().get(0).getPosition().gety());
			 int result1 = preparedStatement.executeUpdate();
			 String sql2="INSERT INTO Composer VALUES (?,?);";
			 PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
		      if(result1 == 1){
		    	  g.setID(t.getID());
		    	  for(Forme elem : t.getListeFormes()) {
			    	  g.addForme(elem);
			    	System.out.println(elem.getClass().getSimpleName());
			    	
			    	  if( elem instanceof Cercle) {
			  DAO<Cercle> CerclejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCercleDAO();
			    		  CerclejdbcDao.create((Cercle) elem);
			    		  preparedStatement2.setString(1,t.getID());
			 			 preparedStatement2.setString(2,elem.getNom());
			 			int result2 = preparedStatement2.executeUpdate();
			    		  
			    	  }else if(elem instanceof Carre) {
			    		  DAO<Carre> CarrejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCarreDAO();
			    		  CarrejdbcDao.create((Carre)elem);
			    		  preparedStatement2.setString(1,t.getID());
			 			 preparedStatement2.setString(2,elem.getNom());
			 			int result2 = preparedStatement2.executeUpdate();
			    	  }else if(elem instanceof Triangle) {
			    		  DAO<Triangle> TrianglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getTriangleDAO();
			    		  TrianglejdbcDao.create((Triangle)elem);
			    		  preparedStatement2.setString(1,t.getID());
				 			 preparedStatement2.setString(2,elem.getNom());
				 			int  result2 = preparedStatement2.executeUpdate();
			    	  }else if(elem instanceof Rectangle) {
			    		  DAO<Rectangle> RectanglejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getRectangleDAO();
			    		  RectanglejdbcDao.create((Rectangle)elem);
			    		  preparedStatement2.setString(1,t.getID());
				 		  preparedStatement2.setString(2,elem.getNom());
				 		  int result2 = preparedStatement2.executeUpdate();
			    	  }
			    	  if( elem instanceof Groupe) {
			    		  DAO<Groupe> GroupejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getGroupeDAO();
			    		  GroupejdbcDao.create((Groupe)elem);
			    		  preparedStatement2.setString(1,t.getID());
				 		  preparedStatement2.setString(2,((Groupe) elem).getID());
				 		  int result2 = preparedStatement2.executeUpdate();  
			    	  }
		    	  }
		    	  System.out.println("groupe a été bien inséré dans la base de données");
		      }	      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		 return g;
	}

	@Override
	public Groupe update(Groupe t) {
		this.delete(t);
		this.create(t);
		return t;
	}

	@Override
	public void delete(Groupe t) {
		try{
			String sql = "delete from Groupe where id=?;";
			String sql2 = "delete from Composer where idGroupe=?;";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

		preparedStatement.setString (1, t.getID());
		preparedStatement.executeUpdate();
		preparedStatement2.setString (1, t.getID());
		preparedStatement2.executeUpdate();
		if(preparedStatement.executeUpdate()==1)
			System.out.println("Groupe a été bien supprimé de la base de données");
		}catch (SQLException e) {
		      e.printStackTrace();
		    }
	}


}
