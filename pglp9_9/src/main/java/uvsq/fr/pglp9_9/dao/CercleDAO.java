package uvsq.fr.pglp9_9.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import uvsq.fr.pglp9_9.Cercle;
import uvsq.fr.pglp9_9.DAO;

public class CercleDAO implements DAO<Cercle> ,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9048060779570680402L;

	public Cercle find(String t) {
		try {
			boolean trouve=false;
			File repertoire = new File("Formes");
			File[] filesCercle=repertoire.listFiles();
			Cercle elem=new Cercle(null,null,0);
			
		for(int j=0;j<filesCercle.length;j++) {
			String nomFichier = filesCercle[j].getName().substring(0,filesCercle[j].getName().length()-7);
			if (nomFichier.equals(t))
				{	
				trouve=true;
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(filesCercle[j]));
				 elem =(Cercle) in.readObject();
				in.close();
				System.out.print("\nFichier de cercle a été bien trouvé !\n");
				return elem;  
				}
	}	if (!trouve)	System.out.print("\nFichier de cercle non trouvé !\n");
		}catch (Exception e) {
			e.printStackTrace();
		}
				
			return null;
	}

	public Cercle create(Cercle cer) {
		try {			
			 ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("Formes/"+cer.getNom()+".serial"));
			out.writeObject(cer);
			System.out.print("\nFichier de cercle a été bien créé !\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cer;
	}

	public Cercle update(Cercle t) {
		try {
			File repertoire = new File("Formes");
			File[] filesCercle=repertoire.listFiles();
			for(int j=0;j<filesCercle.length;j++) {
				String nomFichier = filesCercle[j].getName().substring(0,filesCercle[j].getName().length()-7);
				if (nomFichier.equals(t.getNom()))
					{	
					filesCercle[j].delete();
					 ObjectOutputStream out = new ObjectOutputStream(
								new FileOutputStream("Formes/"+t.getNom()+".serial"));
					out.writeObject(t);
					out.close();
					System.out.print("\nCercle a été bien modifié !\n");
				
					return t;  
					}
			}	
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}

	public void delete(Cercle t) {
try {
			
			File repertoire = new File("Formes");
			File[] filesCercle=repertoire.listFiles();
			for(int j=0;j<filesCercle.length;j++) {

				// Enlever l'extention .serial
				String nomFichier = filesCercle[j].getName().substring(0,filesCercle[j].getName().length()-7);
				if (nomFichier.equals(t.getNom()))
					{	
					if(filesCercle[j].delete()) {
					System.out.print("\nFichier de Cercle a été bien supprimé !\n");			
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
