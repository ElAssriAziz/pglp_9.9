package uvsq.fr.pglp9_9;

import java.util.ArrayList;
import java.util.Scanner;

import uvsq.fr.pglp9_9.AbstractDaoFactory.DaoType;

public class DrawingTUI {
	
public Commande nextCommand() {
	
	PointRef p1= new PointRef(0,0);
	 Scanner scanner = new Scanner( System.in );
	 String  params;
	 String nom="";		 Scanner scanner2;
	 ArrayList<Integer> listeParams = new ArrayList<Integer>();
	 
	 boolean validChoiceCommand=false;
	 boolean validChoiceForme=false;
	 System.out.println( "\n******************************************************************************");
	 System.out.println( "Veuillez taper la commande à exécuter ("
	 	
			 + "Creer, deplacer, dessiner, Quitter ) : " );
	 while(!validChoiceCommand){
	 String commande=scanner.nextLine(); 
	 switch(commande.toLowerCase()) {
	 case "creer":
		 
		 System.out.println( "Veuillez choisir quelle forme ("
			 		+ "Cercle, Carre, Rectangle, Triangle, Groupe ) : " );

			 boolean validChoice2=false;
			 while(!validChoiceForme){
				 String forme=scanner.nextLine();
	switch(forme.toLowerCase()) {
	case "cercle": 
		listeParams.clear();
		Cercle cercle= new Cercle(null,null,0);
		System.out.println( "Veuillez entrer le nom du cercle : " );
		nom=scanner.nextLine();
		System.out.println( "Veuillez entrer les paramètres sous forme \"((n,n),n)\" : " );
		params = scanner.nextLine();
		listeParams = getParams(params);
		listeParams = getParams(params);
		p1= new PointRef(listeParams.get(0),listeParams.get(1));	
		   cercle= new Cercle(nom,p1, listeParams.get(2));
		  return new Creer(cercle);
		  
	case "carre":
		listeParams.clear();
		Carre carre= new Carre(null,null,0);
		System.out.println( "Veuillez entrer le nom du carré : " );
		nom=scanner.nextLine();
		System.out.println( "Veuillez entrer les paramètres sous forme \"((n,n),n)\" : " );
		params = scanner.nextLine();
		scanner2 = new Scanner(params );
		listeParams = getParams(params);
			
			p1= new PointRef(listeParams.get(0),listeParams.get(1));
		   carre= new Carre(nom,p1, listeParams.get(2));
		   scanner2.close();
		  return new Creer(carre);
		  
	case "triangle":
		listeParams.clear();
		Triangle triangle= new Triangle(null,null,0,0);
		System.out.println( "Veuillez entrer le nom du triangle : " );
		nom=scanner.nextLine();
		System.out.println( "Veuillez entrer les paramètres sous forme ((n,n),base,hauteur) : " );
		params = scanner.nextLine();
		scanner2 = new Scanner(params);
		listeParams= getParams(params);
		   p1= new PointRef(listeParams.get(0),listeParams.get(1));
		   triangle= new Triangle(nom,p1, listeParams.get(2),listeParams.get(3));
		   scanner2.close();
		  return new Creer(triangle);
		  
	case "rectangle":
		listeParams.clear();
		Rectangle rectangle= new Rectangle(null,null,0,0);
		System.out.println( "Veuillez entrer le nom du rectangle : " );
		nom=scanner.nextLine();
		System.out.println( "Veuillez entrer les paramètres sous forme ((n,n),largeur,hauteur) : " );
		params = scanner.nextLine();
		scanner2 = new Scanner(params);
		listeParams= getParams(params);
		   p1= new PointRef(listeParams.get(0),listeParams.get(1));
		   rectangle= new Rectangle(nom,p1, listeParams.get(2),listeParams.get(3));
		   scanner2.close();
		  return new Creer(rectangle);
	case "groupe":
		listeParams.clear();
		System.out.println( "Veuillez entrer le nom du groupe : " );
		nom=scanner.nextLine();
		System.out.println( "Veuillez entrer les composantes " );
		String []composantes = scanner.nextLine().split(" ");
		Groupe groupe= new Groupe(nom);
		  return new CreerGroupe(groupe,composantes);
	default:
		System.out.println( "Erreur saisie ! retaper le nom de la forme : ");	
	}}
		
   case "deplacer":
		
		 System.out.println( "Veuillez deplacer quelle forme "
	 		+ "( Cercle, Carre, Rectangle, Triangle, Groupe ) : " );
	while(!validChoiceForme) {
	  String forme=scanner.nextLine();
	 switch(forme.toLowerCase()) {
	 case "cercle" :
		 System.out.println( "nom de la forme à déplacer : " );
		 nom=scanner.nextLine();
		 System.out.println( "Veuillez le déplacer de (n,n) : " );
			params = scanner.nextLine();
			listeParams = getParams(params);
			Cercle cer= new Cercle(nom,p1,0);
			return new Deplacer(cer,listeParams.get(0),listeParams.get(1));
		
	 case "carre" :
		 System.out.println( "nom de la forme à déplacer : " );
		 nom=scanner.nextLine();
		 System.out.println( "Veuillez le déplacer de (n,n) : " );
			params = scanner.nextLine();
			listeParams = getParams(params);
			Carre car= new Carre(nom,p1,0);
			return new Deplacer(car,listeParams.get(0),listeParams.get(1));
			
	case "rectangle" : System.out.println( "nom de la forme à déplacer : " );
	 nom=scanner.nextLine();
	 System.out.println( "Veuillez le déplacer de (n,n) : " );
		params = scanner.nextLine();
		listeParams = getParams(params);		
		Rectangle rec= new Rectangle(nom,p1,0,0);
		return new Deplacer(rec,listeParams.get(0),listeParams.get(1));
		
	case "triangle" :
		System.out.println( "nom de la forme à déplacer : " );
	 nom=scanner.nextLine();
	 System.out.println( "Veuillez le déplacer de (n,n) : " );
		params = scanner.nextLine();
		listeParams = getParams(params);		
		Triangle tri= new Triangle(nom,p1,0,0);
		return new Deplacer(tri,listeParams.get(0),listeParams.get(1));
	case "groupe":
		System.out.println( "nom du groupe à déplacer : " );
		 nom=scanner.nextLine();
		 System.out.println( "Veuillez déplacer le groupe de (n,n) : " );
			params = scanner.nextLine();
			listeParams = getParams(params);
		Groupe groupe= new Groupe(nom);
		  return new DeplacerGroupe(groupe,listeParams.get(0),listeParams.get(1));
	default:
		  System.out.println( "Erreur saisie ! retaper le nom de la forme : ");
	 }}
	 case "dessiner":	
		 System.out.println( "Veuillez dessiner quelle forme "
	 		+ "( Cercle, Carre, Rectangle, Triangle, Groupe ) : " );
	while(!validChoiceForme) {
	  String forme=scanner.nextLine();
	 switch(forme.toLowerCase()) {
	 case "cercle" :
		 System.out.println( "nom de la forme à dessiner : " );
		 nom=scanner.nextLine();
			Cercle cer= new Cercle(nom,p1,0);
			return new Dessiner(cer);
		
	 case "carre" :
		 System.out.println( "nom de la forme à dessiner : " );
		 nom=scanner.nextLine();
			Carre car= new Carre(nom,p1,0);
			return new Dessiner(car);
			
	case "rectangle" : 
		System.out.println( "nom de la forme à dessiner : " );
	 nom=scanner.nextLine();
		Rectangle rec= new Rectangle(nom,p1,0,0);
		return new Dessiner(rec);
		
	case "triangle" : 
		System.out.println( "nom de la forme à dessiner : " );
	 nom=scanner.nextLine();
		Triangle tri= new Triangle(nom,p1,0,0);
		return new Dessiner(tri);
	case "groupe" : 
		System.out.println( "nom du groupe à dessiner : " );
		nom=scanner.nextLine();
		Groupe gr= new Groupe(nom);
		return new Dessiner(gr);
	default:
		  System.out.println( "Erreur saisie ! retaper le nom de la forme : ");
	 }}
	 case "quitter":return null;
	  default: 
		  System.out.println( "Erreur saisie ! retaper la commande : ");
		  
	 }
	
	
	 }
	return null;
				
				/*
	String forme = scanner.nextLine();
	switch (forme) {
	case "Cercle": 
		System.out.print( "Entrez le nom du carré (exemple \"MonCarre\"): " );
		String nomForme = scanner.nextLine();
		System.out.println(nomForme);
		
		String nom = scanner.nextLine();
		 System.out.print( "Entrez la position (x,y) : x = " );
		 double x = scanner.nextDouble();
		 position.setx(x); 
		 System.out.print( " y = " );
		 double y = scanner.nextDouble();
		 position.sety(y);
		 System.out.print( "Rayon en int = " );
		 int rayon = scanner.nextInt();
		Creer c1= new Creer(new Carre(nom,position,rayon));
		invocateur.exec(c1);
	//case "Dessiner" : return new Dessiner(); break;
	default :  System.out.print( "Erreur Saisie !");
	scanner.close();
	}*/
	

}
	public void Affichage(Commande cmd) {
		cmd.afficher();
	}
	public  ArrayList<Integer> getParams(String s) {
		
		ArrayList<Integer> listeParams = new ArrayList<Integer>();
		Scanner scanner = new Scanner(s);
		scanner.useDelimiter("[^0-9]+"); // note we use + not *
		 while (scanner.hasNextInt()) {
		   int p = scanner.nextInt();
		  listeParams.add(p); 
		 }
		 scanner.close();
		 return listeParams;
		/* switch(forme) {
		 case "Rectangle":
			 if(listeParams.size()<4);
			 System.out.println("il manque un parametre ! retaper à nouveau : ");
				
				 params = scanner.nextLine();
				//scanner = new Scanner(params );
			
				//s = scanner.nextLine();
				//scanner = new Scanner(s);
				 getParams(params,"Rectangle");
			 break ;
		 }
		 scanner.close();
		*/
	}
} 
