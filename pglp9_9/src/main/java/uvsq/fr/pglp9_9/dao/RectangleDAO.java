package uvsq.fr.pglp9_9.dao;

import uvsq.fr.pglp9_9.Rectangle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import uvsq.fr.pglp9_9.DAO;
public class RectangleDAO implements DAO<Rectangle> ,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2763541319224610371L;

	
	public Rectangle find(String t) {
		try {
		boolean trouve=false;
		File repertoire = new File("Formes");
		File[] filesRectangle=repertoire.listFiles();
		Rectangle elem=new Rectangle(null,null,0,0);
		
	for(int j=0;j<filesRectangle.length;j++) {
	String nomFichier = filesRectangle[j].getName().substring(0,filesRectangle[j].getName().length()-7);
		if (nomFichier.equals(t))
			{	
			trouve=true;
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filesRectangle[j]));
			elem =(Rectangle) in.readObject();
			in.close();
			System.out.print("\nFichier de rectangle a été bien trouvé !\n");
			return elem;  
			}
}	if (!trouve)	System.out.print("\nFichier de rectangle non trouvé !\n");
	}catch (Exception e) {
		e.printStackTrace();
	}
			
		return null;
	}

	public Rectangle create(Rectangle r) {
		try {
			 ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("Formes/"+r.getNom()+".serial"));
			out.writeObject(r);
			System.out.print("\nFichier de rectangle a été bien créé !\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return r;
	}

	public Rectangle update(Rectangle r) {
		try {
			File repertoire = new File("Formes");
			File[] filesRectangle=repertoire.listFiles();

			for(int j=0;j<filesRectangle.length;j++) {
				String nomFichier = filesRectangle[j].getName().substring(0,filesRectangle[j].getName().length()-7);
				if (nomFichier.equals(r.getNom()))
					{	
					filesRectangle[j].delete();
					this.create(r);
					System.out.println("\nFichier rectangle a été bien modifié !\n");
					return r;  
					}
			
			}	
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}

	public void delete(Rectangle t) {

		try {
			File repertoire = new File("Formes");
			File[] filesRectangle=repertoire.listFiles();
			for(int j=0;j<filesRectangle.length;j++) {
				// Enlever l'extention .serial
				String nomFichier = filesRectangle[j].getName().substring(0,filesRectangle[j].getName().length()-7);
				System.out.println(nomFichier);
				if (nomFichier.equals(t.getNom()))
					{	
					if(filesRectangle[j].delete()) {
					System.out.print("\nFichier de rectangle a été bien supprimé !\n");			
					}else {
						System.out.print("\nErreur suppression !\n");
					}
					}
					}
			}				
		catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
