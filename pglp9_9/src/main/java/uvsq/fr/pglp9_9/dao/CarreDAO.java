package uvsq.fr.pglp9_9.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import uvsq.fr.pglp9_9.Carre;

import uvsq.fr.pglp9_9.DAO;



public class CarreDAO   implements DAO<Carre> ,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 487531011748219179L;


	public Carre find(String t) {
		try {
			boolean trouve=false;
			File repertoire = new File("Formes");
			File[] filesCarre=repertoire.listFiles();
			Carre elem=new Carre(null,null,0);
			
		for(int j=0;j<filesCarre.length;j++) {
			String nomFichier = filesCarre[j].getName().substring(0,filesCarre[j].getName().length()-7);
			if (nomFichier.equals(t))
				{	
				trouve=true;
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(filesCarre[j]));
				 elem =(Carre) in.readObject();
				in.close();
				System.out.print("\nFichier de carré a été bien trouvé !\n");
				return elem;  
				}
	}	if (!trouve)	System.out.print("\nFichier de carre non trouvé !\n");
		}catch (Exception e) {
			e.printStackTrace();
		}
				
			return null;
	}

	public Carre create(Carre c) {
		
		try {
			 ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("Formes/"+c.getNom()+".serial"));
			out.writeObject(c);
			System.out.print("\nFichier de carré a été bien créé !\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	public Carre update(Carre t) {
		try {
			File repertoire = new File("Formes");
			File[] filesCarre=repertoire.listFiles();
			for(int j=0;j<filesCarre.length;j++) {
				
				String nomFichier = filesCarre[j].getName().substring(0,filesCarre[j].getName().length()-7);
				if (nomFichier.equals(t.getNom()))
					{	
					filesCarre[j].delete();
					 ObjectOutputStream out = new ObjectOutputStream(
								new FileOutputStream("Formes/"+t.getNom()+".serial"));
					out.writeObject(t);
					out.close();
					System.out.println("\nCarré a été bien modifié !\n");
					return t;  
					}
			
			}	
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}

	public void delete(Carre t) {
		try {
			
			File repertoire = new File("Formes");
			File[] filesCarre=repertoire.listFiles();
			for(int j=0;j<filesCarre.length;j++) {
			
				// Enlever l'extention .serial
				String nomFichier = filesCarre[j].getName().substring(0,filesCarre[j].getName().length()-7);
				System.out.println(nomFichier);
				if (nomFichier.equals(t.getNom()))
					{	
					if(filesCarre[j].delete()) {
						System.out.print(filesCarre[j].getName());
					System.out.print("\nFichier de Carre a été bien supprimé !\n");			
					}else {
						System.out.print(filesCarre[j].getName());
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
