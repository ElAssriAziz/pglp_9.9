package uvsq.fr.pglp9_9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uvsq.fr.pglp9_9.AbstractDaoFactory.DaoType;

public class TestLogDessin {
	PointRef p1;
	PointRef p2;
	PointRef p3;
	 Carre carre1;
	 Carre carre2;
	 Carre carre3;
	 Carre carreTest;
	 Cercle cercle1;
	 Cercle cercle2;
	 Cercle cercleTest;
	 Rectangle rectangle1;
	 Rectangle rectangle2;
	 Triangle triangle1;
	 Triangle triangle2;
	 @Before
	    public void setUp() {
	   
	        this.p1 = new PointRef(5,4);
	        this.p2 =  new PointRef(8,8);
	        this.p3 = new PointRef(6,2);
	        
	        this.carre1=new Carre("carre1",p1,10);
	        this.carre2=new Carre("carre2",p2,6);
	        this.cercle1=new Cercle("cercle1",p3,10);
	        this.cercleTest = new Cercle(null,null,0);
	        this.carreTest = new Carre(null,null,0);
	        
	        this.rectangle1  = new Rectangle("rctangle1",p3,8,4);
	        this.rectangle2 = new Rectangle("rectangle22",p3,9,6);
	    }
	@Test
	public void testSerialisatioForme() {
		try{
			
	System.out.println("\n************* Tests de Formes *************");
	// Creation des doa pour cercle et carré
    DAO<Carre> carreDao = AbstractDaoFactory.getFactory(DaoType.dao).getCarreDAO();
	DAO<Cercle> CercleDao = AbstractDaoFactory.getFactory(DaoType.dao).getCercleDAO();
	
	//creation des formes et test des formes serialisé
	carreDao.create(carre1);
	carreDao.create(carre2);
	CercleDao.create(cercle1);
	ObjectInputStream in = new ObjectInputStream(new FileInputStream("Formes/carre1.serial"));
	 Carre elem = (Carre) in.readObject();
	 in.close();
	assertEquals("Les deux objets sont identiques",elem.getNom(),carre1.getNom());
		
	// Tester find
	cercleTest=CercleDao.find("cercle1");
	assertTrue("Les deux objets ont les memes noms",cercleTest.getNom().equals(cercle1.getNom()));
	
	// Tester update
	carre1.position.setx(15);
	carre1.position.sety(20);
	carreTest=carreDao.find("carre1");
	assertFalse("CarreTest a l'ancienne valeur de x de carre1 ",carre1.position.getx()==carreTest.position.getx());
	 in = new ObjectInputStream(new FileInputStream("Formes/carre1.serial"));
	 Carre carreTest = (Carre) in.readObject();
	 
	 // Apres desiarialisation
	assertTrue("CarreTest a la nouvelle valeur x de carre 1 ",carre1.position.getx()!=carreTest.position.getx());
	// Tester delete
	CercleDao.delete(cercle1);

	cercleTest=CercleDao.find("cercle1");
	
	assertNull("cercle1 est supprimé ",cercleTest);

		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	@Test
	public void testSerialisatioGroupeForme() {
		
		try{
		System.out.println("\n************* Tests de GroupeForme *************");
		Groupe grp =new Groupe("grp");
		grp.addForme(rectangle1);
		grp.addForme(rectangle2);
		grp.addForme(cercle1);
		
		DAO<Groupe> groupeDAO = AbstractDaoFactory.getFactory(DaoType.dao).getGroupeDAO();
		//test create et find groupe
		groupeDAO.create(grp);
		Groupe GroupeTest1  = new Groupe("GrpTest1");
		Object test= groupeDAO.find(grp.getID());
		 Assert.assertTrue("test est un groupe ",test instanceof Groupe);
		 
		 // tester la serialisation
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Formes/"+grp.getID()+".serial"));
			 Groupe elem = (Groupe) in.readObject();
			 in.close();
		assertTrue("les groupes g et  groupeTest ont le meme id ",grp.getID().equals(elem.getID()));
		
		// test update groupe
		Groupe nvGroupe = new Groupe("nvGroupe"); nvGroupe.addForme(cercle1); nvGroupe.addForme(cercle2);
		GroupeTest1.addForme(carre1);
		GroupeTest1.addForme(carre2);
		GroupeTest1.addForme(rectangle1);
		GroupeTest1.addForme(nvGroupe);

		assertFalse("les groupes g et  groupeTest1 n'ont pas le meme nbr de formes ( 3 vs 4)",
				grp.getListeFormes().size() == GroupeTest1.getListeFormes().size());
	
		grp.addForme(nvGroupe);
	
		groupeDAO.update(grp);
	
		assertTrue("les groupes g et  groupeTest1 ont le meme nbr de formes ( 4 vs 4)",
				grp.getListeFormes().size() == GroupeTest1.getListeFormes().size());
		
		//test delete Groupe
		groupeDAO.create(GroupeTest1);
		in = new ObjectInputStream(new FileInputStream("Formes/"+GroupeTest1.getID()+".serial"));
		elem = (Groupe) in.readObject();
		in.close();
		
		assertTrue("les groupes elem et  groupeTest1 ont les memes noms ",
				elem.getID().equals(GroupeTest1.getID()));
		
		groupeDAO.delete(GroupeTest1);
		GroupeTest1=groupeDAO.find(GroupeTest1.getID());
		assertNull("GroupeTest1 est null car il est pas trouvé par le doa ",GroupeTest1);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		}

}
