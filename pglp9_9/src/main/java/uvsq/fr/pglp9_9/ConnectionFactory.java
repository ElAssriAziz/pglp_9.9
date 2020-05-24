package uvsq.fr.pglp9_9;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;





public class ConnectionFactory {
		 static Connection con=null;

		public static  Connection getConnection() {
			
			try {
					Class.forName("org.hsqldb.jdbc.JDBCDriver");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			
			try {
				// get db properties
				Properties props = new Properties();
				props.load(new FileInputStream("connexion.properties"));
				
				String user = props.getProperty("user");
				String password = props.getProperty("password");
				String dburl = props.getProperty("dburl");
		
				// will create DB if does not exist
				// "SA" is default user with hypersql
				con = DriverManager.getConnection(dburl,user,password);
				//System.out.println("DB connection successful to: " + dburl);
				// creation des tables
				String createTables =readToString("sql/formes.sql");
				con.createStatement()
						.executeUpdate(createTables);
		        
				} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		public static String readToString(String fname) throws Exception {
			File file = new File(fname);
			String string = FileUtils.readFileToString(file, "utf-8");
			return string;
		}
			
}
