package uvsq.fr.pglp9_9.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uvsq.fr.pglp9_9.Cercle;
import uvsq.fr.pglp9_9.DAO;
import uvsq.fr.pglp9_9.PointRef;

public class CercleJDBC implements DAO<Cercle>{

	public List<Cercle> getAll() {
		List<Cercle> cercles = new ArrayList<Cercle>();
		try { 
			PreparedStatement pst = connection.prepareStatement("select * from Cercle;");
	        pst.clearParameters();
	        ResultSet rs = pst.executeQuery();
	        while(rs.next()){
	        	PointRef PRef =new PointRef(rs.getDouble(2),rs.getDouble(3));
	        	cercles.add(new Cercle(
	        			rs.getString(1), 
	        			PRef,
	        			rs.getInt(4)
	        		));
	        }	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cercles;
	}

	public Cercle find(String id) {
		Cercle cercle= new 	Cercle(null,null,0);
		 try {
			
			 String sql="SELECT * FROM Cercle WHERE nom=?;";
			 PreparedStatement preparedStatement =
				        connection.prepareStatement(sql);
			 preparedStatement.setString(1,id);
			 ResultSet result = preparedStatement.executeQuery();
		      
			 while(result.next()){
				  PointRef p=new PointRef(result.getDouble(2),result.getDouble(3));
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
			 preparedStatement.setDouble(2,t.getx());
			 preparedStatement.setDouble(3,t.gety());
			 preparedStatement.setInt(4,t.getRayon());
			 int result = preparedStatement.executeUpdate();
		      assert result == 1;
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

		preparedStatement.setDouble(1, t.getx());
		preparedStatement.setDouble(2, t.gety());
		preparedStatement.setInt  (3, t.getRayon());
		preparedStatement.setString  (4, t.getNom());
		int rowsAffected = preparedStatement.executeUpdate();
		System.out.println("Cercle a été bien modifié");
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
		assert rowsAffected == 1;
		System.out.println("Cercle a été bien supprimé de la base de données");
		}catch (SQLException e) {
		      e.printStackTrace();
		    }
		
	}

	

}
