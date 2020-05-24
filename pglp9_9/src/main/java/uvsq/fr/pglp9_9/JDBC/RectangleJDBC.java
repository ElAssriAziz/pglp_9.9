package uvsq.fr.pglp9_9.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uvsq.fr.pglp9_9.DAO;
import uvsq.fr.pglp9_9.PointRef;
import uvsq.fr.pglp9_9.Rectangle;

public class RectangleJDBC implements DAO<Rectangle>{

	public Rectangle find(String id) {
		Rectangle rectangle= new Rectangle(null,null,0,0);
		 try {
			
			 String sql="SELECT * FROM Rectangle WHERE nom=?;";
			 PreparedStatement preparedStatement =
				        connection.prepareStatement(sql);
			 preparedStatement.setString(1,id);
			 ResultSet result = preparedStatement.executeQuery();
		      
			 while(result.next()){
				  PointRef p=new PointRef(result.getInt(2),result.getInt(3));
				  rectangle = new Rectangle(result.getString(1),p,result.getInt(4),result.getInt(5));
		    	  System.out.println("rectangle est bien trouvé ");		
		        }
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return rectangle;	
	}

	public Rectangle create(Rectangle t) {
		
		 try {
			 String sql="INSERT INTO Rectangle VALUES (?,?,?,?,?);";
			 PreparedStatement preparedStatement =
				        connection.prepareStatement(sql);
			 preparedStatement.setString(1,t.getNom());
			 preparedStatement.setDouble(2,t.getx());
			 preparedStatement.setDouble(3,t.gety());
			 preparedStatement.setInt(4,t.getLargeur());
			 preparedStatement.setInt(5,t.getHauteur());
			 int result = preparedStatement.executeUpdate();
		      assert result == 1;
		      System.out.println("Rectangle a été inséré");
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		 return t;
	}

	public Rectangle update(Rectangle t) {
		try{
			String sql = "update Rectangle set x=? , y=? ,largeur=?,hauteur=? where nom=?";
		

		PreparedStatement preparedStatement =
		        connection.prepareStatement(sql);

		preparedStatement.setDouble(1, t.getx());
		preparedStatement.setDouble(2, t.gety());
		preparedStatement.setInt  (3, t.getLargeur());
		preparedStatement.setInt  (4, t.getHauteur());
		preparedStatement.setString  (5, t.getNom());
		int rowsAffected = preparedStatement.executeUpdate();
		if (rowsAffected>0) System.out.println("Ractengle a été bien modifié");
		}catch (SQLException e) {
		      e.printStackTrace();
		    }
		return t;
	}

	public void delete(Rectangle t) {
		try{
			String sql = "delete from Rectangle where nom=?;";
		

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString (1, t.getNom());
		int rowsAffected = preparedStatement.executeUpdate();
		assert rowsAffected == 1;
		System.out.println("Rectabgle a été bien supprimé");
		}catch (SQLException e) {
		      e.printStackTrace();
		    }
		
	}

	

}
