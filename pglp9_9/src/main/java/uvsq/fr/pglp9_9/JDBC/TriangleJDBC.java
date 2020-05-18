package uvsq.fr.pglp9_9.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uvsq.fr.pglp9_9.DAO;
import uvsq.fr.pglp9_9.PointRef;
import uvsq.fr.pglp9_9.Triangle;

public class TriangleJDBC implements DAO<Triangle>{

	public List<Triangle> getAll() {
		List<Triangle> triangles = new ArrayList<Triangle>();
		try { 
			PreparedStatement pst = connection.prepareStatement("select * from Triangle;");
	        pst.clearParameters();
	        ResultSet rs = pst.executeQuery();
	        while(rs.next()){
	        	PointRef PRef =new PointRef(rs.getDouble(2),rs.getDouble(3));
	        
	        	triangles.add(new Triangle(
	        			rs.getString(1), 
	        			PRef,
	        			rs.getInt(4),
	        			rs.getInt(5)
	        		));
	        }	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return triangles;
	}

	public Triangle find(String id) {
		Triangle triangle= new Triangle(null,null,0,0);
		 try {
			
			 String sql="SELECT * FROM Triangle WHERE nom=?;";
			 PreparedStatement preparedStatement =
				        connection.prepareStatement(sql);
			 preparedStatement.setString(1,id);
			 ResultSet result = preparedStatement.executeQuery();
		      
			 while(result.next()){
				  PointRef p=new PointRef(result.getDouble(2),result.getDouble(3));
				  triangle = new Triangle(result.getString(1),p,result.getInt(4),result.getInt(5));
		    	  System.out.println("Triangle a été bien est trouvé");		
		        }
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return triangle;		
	}

	public Triangle create(Triangle t) {
		try {
			 String sql="INSERT INTO Triangle VALUES (?,?,?,?,?);";
			 PreparedStatement preparedStatement =
				        connection.prepareStatement(sql);
			 preparedStatement.setString(1,t.getNom());
			 preparedStatement.setDouble(2,t.getx());
			 preparedStatement.setDouble(3,t.gety());
			 preparedStatement.setInt(4,t.getBase());
			 preparedStatement.setInt(5,t.getHauteur());
			 int result = preparedStatement.executeUpdate();
		      assert result == 1;
		      System.out.println("Triangle a été bien inséré dans la base de données");
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		 return t;
	}

	public Triangle update(Triangle t) {

		try{
			String sql = "update Triangle set x=? , y=? ,base=?,hauteur=? where nom=?";
		

		PreparedStatement preparedStatement =
		        connection.prepareStatement(sql);

		preparedStatement.setDouble(1, t.getx());
		preparedStatement.setDouble(2, t.gety());
		preparedStatement.setInt  (3, t.getBase());
		preparedStatement.setInt  (4, t.getHauteur());
		preparedStatement.setString  (5, t.getNom());
		int rowsAffected = preparedStatement.executeUpdate();
		System.out.println("Triangle a été bien modifié");
		}catch (SQLException e) {
		      e.printStackTrace();
		    }
		return t;
	}

	public void delete(Triangle t) {
		try{
			String sql = "delete from Triangle where nom=?;";
		

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString (1, t.getNom());
		int rowsAffected = preparedStatement.executeUpdate();
		assert rowsAffected == 1;
		System.out.println("Triangle a été bien supprimé");
		}catch (SQLException e) {
		      e.printStackTrace();
		    }
		
	}
		
	

}
