package uvsq.fr.pglp9_9.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uvsq.fr.pglp9_9.Cercle;
import uvsq.fr.pglp9_9.DAO;
import uvsq.fr.pglp9_9.PointRef;

public class CercleJDBC implements DAO<Cercle>{

	public Cercle find(String id) {
		Cercle cercle= new 	Cercle(null,null,0);
		 try {
			
			 String sql="SELECT * FROM Cercle WHERE nom=?;";
			 PreparedStatement preparedStatement =
				        connection.prepareStatement(sql);
			 preparedStatement.setString(1,id);
			 ResultSet result = preparedStatement.executeQuery();
		      
			 while(result.next()){
				  PointRef p=new PointRef(result.getInt(2),result.getInt(3));
		    	  cercle = new 	Cercle(result.getString(1),p,result.getInt(4));
		    	  System.out.println("Cercle a été bien trouvé dans la base de données");		
		        }
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return cercle;		
		}

	public Cercle create(Cercle t) {

		 try {
			 String sql="INSERT INTO Cercle VALUES (?,?,?,?);";
			 PreparedStatement preparedStatement =
				        connection.prepareStatement(sql);
			 preparedStatement.setString(1,t.getNom());
			 preparedStatement.setInt(2,t.getx());
			 preparedStatement.setInt(3,t.gety());
			 preparedStatement.setInt(4,t.getRayon());
			 int result = preparedStatement.executeUpdate();
		
		      if (result == 1)
		    	  System.out.println("Cercle a été bien inséré dans la base de données");
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		 return t;
	}

	public Cercle update(Cercle t) {

		try{
			String sql = "update Cercle set x=? , y=? ,rayon=? where nom=?";
		

		PreparedStatement preparedStatement =
		        connection.prepareStatement(sql);

		preparedStatement.setInt(1, t.getx());
		preparedStatement.setInt(2, t.gety());
		preparedStatement.setInt  (3, t.getRayon());
		preparedStatement.setString  (4, t.getNom());
		int rowsAffected = preparedStatement.executeUpdate();
		if (rowsAffected>0)System.out.println("Cercle a été bien modifié");
		}catch (SQLException e) {
		      e.printStackTrace();
		    }
		return t;
	}

	public void delete(Cercle t) {
		try{
			String sql = "delete from Cercle where nom=?;";
		

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString (1, t.getNom());
		int rowsAffected = preparedStatement.executeUpdate();
		 if (rowsAffected == 1)System.out.println("Cercle a été bien supprimé de la base de données");
		}catch (SQLException e) {
		      e.printStackTrace();
		    }
		
	}

	

}
