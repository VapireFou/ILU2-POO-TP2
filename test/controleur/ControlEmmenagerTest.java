package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private ControlEmmenager controleur;
	private Village v;
	
	
	@BeforeEach
	void setUp() throws Exception {
		v = new Village("test",3,10);
		controleur = new ControlEmmenager(v);
		
	}

	@Test
	void testIsHabitant() {
		Chef chef = new Chef("Chef",10,v);
		v.setChef(chef);
		assertTrue(controleur.isHabitant("Chef"));
	}

	@Test
	void testAjouterDruide() {
		Chef chef = new Chef("Chef",10,v);
		v.setChef(chef);
		assertFalse(controleur.isHabitant("panoramix"));
		controleur.ajouterDruide("panoramix", 2, 5, 8);
		assertTrue(controleur.isHabitant("panoramix"));
	
	}

	@Test
	void testAjouterGaulois() {
		Chef chef = new Chef("Chef",10,v);
		v.setChef(chef);
		controleur.ajouterGaulois("goule", 5);
		controleur.isHabitant("goule");
		assertTrue(controleur.isHabitant("goule"));
		
		
	}
	
	@Test
	void testAjouterGauloisMax() {
		Chef chef = new Chef("Chef",10,v);
		v.setChef(chef);
		controleur.ajouterGaulois("a", 5);
		assertTrue(controleur.isHabitant("a"));
		controleur.ajouterGaulois("b", 5);
		assertTrue(controleur.isHabitant("b"));
		controleur.ajouterGaulois("c", 5);
		assertTrue(controleur.isHabitant("c"));
		
		controleur.ajouterGaulois("d", 5);
		assertFalse(controleur.isHabitant("d"));
	}
	
	@Test
	void testVillageSansChef() {
		assertThrows(NullPointerException.class, ()->controleur.isHabitant("Poivron"));
	}
	
	@Test
	void testGetNom() {
		Gaulois a = new Gaulois("Pasteque", 10);
		assertEquals(a.getNom(), "Pasteque");
	}

}
