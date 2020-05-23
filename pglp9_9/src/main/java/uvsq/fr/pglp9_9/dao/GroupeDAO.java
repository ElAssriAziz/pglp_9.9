package uvsq.fr.pglp9_9.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import uvsq.fr.pglp9_9.DAO;
import uvsq.fr.pglp9_9.Groupe;


public class GroupeDAO implements DAO<Groupe>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1567939172943888094L;

	public Groupe find(String t) {
		try {
			boolean trouve=false;
			File repertoire = new File("Formes");
			File[] filesGroupe=repertoire.listFiles();
			Groupe elem=new Groupe("");
			for(int j=0;j<filesGroupe.length;j++) {
				String nomFichier = filesGroupe[j].getName().substring(0,filesGroupe[j].getName().length()-7);
				if (nomFichier.equals(t))
					{	
					trouve=true;
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(filesGroupe[j]));
					 elem =(Groupe) in.readObject();
					in.close();
					System.out.print("\nGroupe "+t+" a été bien trouvé !\n");
					return elem;  
					}
		}	if (!trouve)	System.out.print("\nGroupe "+t+" non trouvé !\n");
			}catch (Exception e) {
				e.printStackTrace();
			}
					
				return null;
	}

	public Groupe create(Groupe gr) {
		try {	
			 ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("Formes/"+gr.getNom()+".serial"));
			out.writeObject(gr);
			System.out.print("\nFichier de groupe a été bien créé !\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return gr;
	}

	public Groupe update(Groupe t) {
		try {
			File repertoire = new File("Formes");
			File[] filesGroupe=repertoire.listFiles();
			for(int j=0;j<filesGroupe.length;j++) {
		String nomFichier = filesGroupe[j].getName().substring(0,filesGroupe[j].getName().length()-7);
				if (nomFichier.equals(t.getNom()))
					{	
					if(filesGroupe[j].delete()) {
					 ObjectOutputStream out = new ObjectOutputStream(
								new FileOutputStream("Formes/"+t.getNom()+".serial"));
					out.writeObject(t);
					out.close();
					System.out.println("\nGroupe a été bien modifié !\n");
					return t; 
					}
					}
			
			}	
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return null;
	
	}
		public void delete(Groupe t) {
			try {	
				File repertoire = new File("Formes");
				File[] filesGroupe=repertoire.listFiles();
				for(int j=0;j<filesGroupe.length;j++) {
					// Enlever l'extention .serial
		String nomFichier = filesGroupe[j].getName().substring(0,filesGroupe[j].getName().length()-7);
					if (nomFichier.equals(t.getID()))
						{	
						if(filesGroupe[j].delete()) {
						System.out.print("\nFichier de groupe a été bien supprimé !\n");			
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
