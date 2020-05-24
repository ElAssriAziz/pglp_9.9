package uvsq.fr.pglp9_9;

import java.sql.Connection;

public interface DAO<T> {
	
	Connection connection =  ConnectionFactory.getConnection();

    public  abstract T  find(String t);
    
    public abstract T create(T t);
    
    public abstract T update(T t);
     
    public abstract void delete(T t);
}
