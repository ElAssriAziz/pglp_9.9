package uvsq.fr.pglp9_9.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uvsq.fr.pglp9_9.Carre;
import uvsq.fr.pglp9_9.DAO;
import uvsq.fr.pglp9_9.PointRef;

public class CarreJDBC implements DAO<Carre>{

	public List<Carre> getAll() {
		List<Carre> carres = new ArrayList<Carre>();
		try { 
			PreparedStatement pst = connection.prepareStatement("select * from Carre;");
	        pst.clearParameters();
	        ResultSet rs = pst.executeQuery();
	        while(rs.next()){
	        	PointRef PRef =new PointRef(rs.getDouble(2),rs.getDouble(3));
	        
	        	carres.add(new Carre(
	        			rs.getString(1), 
	        			PRef,
	        			rs.getInt(4)
	        		));
	        }	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carres;
	}

	public Carre find(String id) {
		Carre car= new Carre(null,null,0);
		 try {
			
			 String sql="SELECT * FROM Carre WHERE nom=?;";
			 PreparedStatement preparedStatement =
				        connection.prepareStatement(sql);
			 preparedStatement.setString(1,id);
			 ResultSet result = preparedStatement.executeQuery();
		      
			 while(result.next()){
				  PointRef p=new PointRef(result.getDouble(2),result.getDouble(3));
		    	  car = new Carre(result.getString(1),p,result.getInt(4));
		    	  System.out.println("Carré a été bien trouvé dans la base de données");		
		        }
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return car;		
	}

	public Carre create(Carre t) {
		
		 try {
			 String sql="INSERT INTO Carre VALUES (?,?,?,?,?);";
			 PreparedStatement preparedStatement =
				        connection.prepareStatement(sql);
			 preparedStatement.setString(1,t.getNom());
			 preparedStatement.setDouble(2,t.getx());
			 preparedStatement.setDouble(3,t.gety());
			 preparedStatement.setInt(4,t.getLargeur());
			 preparedStatement.setInt(5,t.getHauteur());
			 int result = preparedStatement.executeUpdate();
		      assert result == 1;
		      System.out.println("Carré a été bien inséré dans la base de données");
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		 return t;
	}

	public Carre update(Carre t) {
		
		try{
			String sql = "update Carre set x=? , y=? ,largeur=? where nom=?";
		

		PreparedStatement preparedStatement =
		        connection.prepareStatement(sql);

		preparedStatement.setDouble(1, t.getx());
		preparedStatement.setDouble(2, t.gety());
		preparedStatement.setInt  (3, t.getLargeur());
		preparedStatement.setString  (4, t.getNom());
		int rowsAffected = preparedStatement.executeUpdate();
		System.out.println("Carré a été bien modifié dans la base de données");
		}catch (SQLException e) {
		      e.printStackTrace();
		    }
		return t;
	}

	public void delete(Carre t) {
		try{
			String sql = "delete from Carre where nom=?;";
		

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString (1, t.getNom());
		int rowsAffected = preparedStatement.executeUpdate();
		assert rowsAffected == 1;
		System.out.println("Carré a été bien supprimé de la base de données");
		}catch (SQLException e) {
		      e.printStackTrace();
		    }
		
	}

}
