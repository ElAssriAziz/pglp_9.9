package uvsq.fr.pglp9_9.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
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
			File dir = new File("Formes");
			File[] filesGroupe = dir.listFiles(new FilenameFilter() {
			    public boolean accept(File dir, String name) {
			        return name.startsWith("Groupe");
			    }
			});
			Groupe elem=new Groupe();
			for(int j=0;j<filesGroupe.length;j++) {
				
			//	String id = filesGroupe[j].get.substring(0,filesRectangle[j].getName().length()-7);
				
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filesGroupe[j]));
					 elem =(Groupe) in.readObject();
					 if (elem.getID().equals(t))
						{ trouve=true;
							in.close();
							System.out.print("\nGroupe a été bien trouvé !\n");
							return elem;  
					}
					 in.close();
			}
			if (!trouve)	System.out.print("\nGroupe non trouvé !\n");
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}

	public Groupe create(Groupe gr) {
		try {
			File dir = new File("Formes");
			File[] filesGroupe = dir.listFiles(new FilenameFilter() {
			    public boolean accept(File dir, String name) {
			        return name.startsWith("Groupe");
			    }
			});
			int index = filesGroupe.length+1;
			 ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("Formes/Groupe"+index+".serial"));
			out.writeObject(gr);
			System.out.print("\ngroupe a été bien créé !\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return gr;
	}

	public Groupe update(Groupe t) {
		try {
			File dir = new File("Formes");
			File[] filesGroupe = dir.listFiles(new FilenameFilter() {
			    public boolean accept(File dir, String name) {
			        return name.startsWith("Groupe");
			    }
			});
			Groupe elem=new Groupe();
			for(int j=0;j<filesGroupe.length;j++) {
				
			//	String id = filesGroupe[j].get.substring(0,filesRectangle[j].getName().length()-7);
				
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(filesGroupe[j]));
					 elem =(Groupe) in.readObject();
					 if (elem.getID().equals(t.getID()))
						{	
						 filesGroupe[j].delete();
					this.create(t);
					System.out.println("\nGroupe a été bien modifié !\n");
					 in.close();
					return t;  
					
					}
					 in.close();
			}	
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}

		public void delete(Groupe t) {
			try {
				File dir = new File("Formes");
				File[] filesGroupe = dir.listFiles(new FilenameFilter() {
				    public boolean accept(File dir, String name) {
				        return name.startsWith("Groupe");
				    }
				});
				Groupe elem=new Groupe();
				for(int j=0;j<filesGroupe.length;j++) {
					
				//	String id = filesGroupe[j].get.substring(0,filesRectangle[j].getName().length()-7);
					
						ObjectInputStream in = new ObjectInputStream(new FileInputStream(filesGroupe[j]));
						 elem =(Groupe) in.readObject();
						 if (elem.getID().equals(t.getID()))
							{		
						if(filesGroupe[j].delete()) {
							System.out.print(filesGroupe[j].getName());
						System.out.print("\nFichier de groupe a été bien supprimé !\n");			
						}else {
							System.out.println(t.getID());
							System.out.println(elem.getID());
							System.out.print("\nErreur suppression !\n");
						}
						}
								in.close();
						}
			
				}	
				
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}

}
