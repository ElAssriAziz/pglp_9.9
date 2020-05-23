package uvsq.fr.pglp9_9;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;


public class Groupe extends Forme{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1977951088758555065L;
	private final ArrayList<Forme> ListeDeFormes;
	private String id;
	public Groupe(String id) {
		ListeDeFormes = new ArrayList<Forme>();
		/*
		 * Générer une chaine aléatoire pour identifier chhaque groupe
		 */
		byte[] array = new byte[4]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    this.id=id;
	}
	public Groupe(Groupe g) {
		this.id=g.id;
		this.ListeDeFormes=g.ListeDeFormes;
	}
	
	public void addForme(Forme f) {
		
		ListeDeFormes.add(f);
	}
	
	public void removeForme(Forme f) {
	
		ListeDeFormes.remove(f);
	}
	
	public ArrayList<Forme> getListeFormes() {
		return ListeDeFormes;
	}

	
	public String getID() {
		return this.id;
	}

	public void deplacer() {
		// TODO Auto-generated method stub
		
	}

	public void dessiner() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		String chaine="";
		System.out.println("\n-------Groupe-----");
		for (Forme elem : ListeDeFormes )
			chaine+=elem.toString()+"\n";
		return chaine;
	}
	public void setID(String id) {
		this.id=id;
	}
	@Override
	public String getNom() {
		return this.getID();
	}
	

}
