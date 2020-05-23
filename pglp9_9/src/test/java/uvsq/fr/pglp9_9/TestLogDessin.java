package uvsq.fr.pglp9_9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	        cercleTest = new Cercle(null,null,0);
	        carreTest = new Carre(null,null,0);
	        
	        rectangle1  = new Rectangle("rctangle1",p3,8,4);
	        rectangle2 = new Rectangle("rectangle22",p3,9,6);
	    }
	@Test
	public void testSerialisatioForme() {
		try{
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
	carreDao.update(carre1);
	assertFalse("CarreTest a l'ancienne valeur de x",carre1.position.getx()==carreTest.position.getx());
	assertTrue("carre1 a la nouvelle valeur",carre1.position.getx()==15);

	// Tester delete
	CercleDao.delete(cercle1);

	cercleTest=CercleDao.find("cercle1");
	
	assertNull("cercle1 est supprimé ",cercleTest);

		}catch (Exception e) {
			e.printStackTrace();
		}
		}

		}
