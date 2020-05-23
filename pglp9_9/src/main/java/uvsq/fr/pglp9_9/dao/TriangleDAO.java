package uvsq.fr.pglp9_9.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import uvsq.fr.pglp9_9.DAO;

import uvsq.fr.pglp9_9.Triangle;

public class TriangleDAO implements DAO<Triangle> ,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5679541274610423470L;

	public Triangle find(String t) {
		try {
			boolean trouve=false;
			File repertoire = new File("Formes");
			File[] filesTriangle=repertoire.listFiles();
			Triangle elem=new Triangle(null,null,0,0);
			
		for(int j=0;j<filesTriangle.length;j++) {
			String nomFichier = filesTriangle[j].getName().substring(0,filesTriangle[j].getName().length()-7);
			if (nomFichier.equals(t))
				{	
				trouve=true;
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(filesTriangle[j]));
				 elem =(Triangle) in.readObject();
				in.close();
				System.out.print("\nFichier de triangle a été bien trouvé !\n");
				return elem;  
				}
	           }
		if (!trouve)	System.out.print("\nFichier de triangle non trouvé !\n");
			}catch (Exception e) {
				e.printStackTrace();
			}			
			return null;
	}

	public Triangle create(Triangle t) {
		try {
			 ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("Formes/"+t.getNom()+".serial"));
			out.writeObject(t);
			System.out.print("\nFichier de triangle a été bien créé !\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t;
		}

	public Triangle update(Triangle t) {
		try {
			File repertoire = new File("Formes");
			File[] filesTriangle=repertoire.listFiles();

			for(int j=0;j<filesTriangle.length;j++) {
				
				String nomFichier = filesTriangle[j].getName().substring(0,filesTriangle[j].getName().length()-7);
				if (nomFichier.equals(t.getNom()))
					{	
					filesTriangle[j].delete();
					this.create(t);
					System.out.println("\nFichier triangle a été bien modifié !\n");
					return t;  
					}
			}	
			}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

	public void delete(Triangle t) {
	
		try {
			File repertoire = new File("Formes");
			File[] filesTriangle=repertoire.listFiles();
			for(int j=0;j<filesTriangle.length;j++) {
				// Enlever l'extention .serial
				String nomFichier = filesTriangle[j].getName().substring(0,filesTriangle[j].getName().length()-7);
				System.out.println(nomFichier);
				if (nomFichier.equals(t.getNom()))
					{	
					if(filesTriangle[j].delete()) {
						System.out.print(filesTriangle[j].getName());
					System.out.print("\nFichier de Carre a été bien supprimé !\n");			
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
