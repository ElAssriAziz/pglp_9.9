package uvsq.fr.pglp9_9.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uvsq.fr.pglp9_9.*;
import uvsq.fr.pglp9_9.AbstractDaoFactory.DaoType;

public class GroupeJDBC implements DAO<Groupe> {

	@Override
	public Groupe find(String t) {
		 Groupe  gr = new Groupe(t);
		 try {	
			 PointRef p = new PointRef(0,0);
			 String sql1="SELECT * FROM Groupe WHERE id=?;";
				 PreparedStatement preparedStatement1 =
					        connection.prepareStatement(sql1);
				 preparedStatement1.setString(1,t);
				 ResultSet result1 = preparedStatement1.executeQuery();
				
				 if (result1.next()) {
					 System.out.println("tttt");
					   gr = new Groupe(result1.getString(1));
				 String sql2="SELECT * FROM Composer WHERE idGroupe=?;";
				 PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
				 preparedStatement2.setString(1,t);
				 ResultSet result2 = preparedStatement2.executeQuery();
				
				 while(result2.next()){
					 System.out.println("tttt  tttt");
					 sql1="SELECT * FROM Cercle WHERE nom=?;"; // recuperer tous les cercles du groupe de BD
					 preparedStatement1 = connection.prepareStatement(sql1);
					 preparedStatement1.setString(1,result2.getString(2));
					  result1 = preparedStatement1.executeQuery();
				
					  
					  if(result1.next()) {
						   p=new PointRef(result1.getInt(2),result1.getInt(3));
						  Cercle cer=new Cercle(result2.getString(2),p,result1.getInt(4));
						  gr.addForme(cer);
						  System.out.println("cer ajoute");
					  }
						 sql1="SELECT * FROM Carre WHERE nom=?;"; // recuperer tous les carrés du groupe de BD
						 preparedStatement1 = connection.prepareStatement(sql1);
						 preparedStatement1.setString(1,result2.getString(2));
						  result1 = preparedStatement1.executeQuery();
						  if(result1.next()) {
							   p=new PointRef(result1.getInt(2),result1.getInt(3));
							   Carre car=new Carre(result2.getString(2),p,result1.getInt(4));
							  gr.addForme(car);
							  System.out.println("car ajoute");
						  }
						  sql1="SELECT * FROM Triangle WHERE nom=?;"; // recuperer tous les triangles du groupe de BD
							 preparedStatement1 = connection.prepareStatement(sql1);
							 preparedStatement1.setString(1,result2.getString(2));
							  result1 = preparedStatement1.executeQuery();
							  if(result1.next()) {
								   p=new PointRef(result1.getInt(2),result1.getInt(3));
								   Triangle tr=new Triangle(result2.getString(2),p,result1.getInt(4),result1.getInt(5));
								  gr.addForme(tr);
								  System.out.println("tr ajoute");
							  }
					sql1="SELECT * FROM Rectangle WHERE nom=?;"; // recuperer tous les rectangles du groupe de BD
				 		preparedStatement1 = connection.prepareStatement(sql1);
						 preparedStatement1.setString(1,result2.getString(2));
					  result1 = preparedStatement1.executeQuery();
							  if(result1.next()) {
									   p=new PointRef(result1.getInt(2),result1.getInt(3));
									   Rectangle tr=new Rectangle(result2.getString(2),p,result1.getInt(4),result1.getInt(5));
									  gr.addForme(tr);
									  System.out.println("rec ajoute");
								  }
				 }
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
			 preparedStatement.setInt(2,t.getListeFormes().get(0).getPosition().getx());
			 preparedStatement.setInt(3,t.getListeFormes().get(0).getPosition().gety());
			 int result1 = preparedStatement.executeUpdate();

			
		
		      if(result1 == 1){
		    	  System.out.println("Groupe creé !");
		    	  g.setID(t.getID());
		    	  for(Forme elem : t.getListeFormes()) {
			    	  g.addForme(elem);
			    		 String sql2="INSERT INTO Composer VALUES (?,?);";
						 PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			    	System.out.println(elem.getClass().getSimpleName());
			  	  preparedStatement2.setString(1,t.getID());
		 		  preparedStatement2.setString(2,elem.getNom());
		 		 int result2 = preparedStatement2.executeUpdate();
		 		 if (result2==1)System.out.println("Ajouté à composer");
		    	  }
			    	 /* if( elem instanceof Cercle) {
			  DAO<Cercle> CerclejdbcDao = AbstractDaoFactory.getFactory(DaoType.jdbc).getCercleDAO();
			    		  CerclejdbcDao.find(elem.getNom());
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
			    	  }*/
		    	  
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

		preparedStatement2.setString (1, t.getID());
		preparedStatement2.executeUpdate();
		preparedStatement.setString (1, t.getID());
		preparedStatement.executeUpdate();
		//preparedStatement.executeUpdate()==1
		if(preparedStatement.executeUpdate()==1 )
			System.out.println("Groupe a été bien supprimé de la base de données");
		}catch (SQLException e) {
		      e.printStackTrace();
		    }
	}


}
