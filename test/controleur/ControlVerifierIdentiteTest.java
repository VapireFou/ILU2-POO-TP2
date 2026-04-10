package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private ControlVerifierIdentite controleur;
	private Village v;

	@BeforeEach
	void setUp() throws Exception {
		v = new Village("test",3,10);
		controleur = new ControlVerifierIdentite(v);
	}

	@Test
	void testVerifierIdentite() {
		Chef chef = new Chef("Chef",10,v);
		v.setChef(chef);
		
		assertFalse(controleur.verifierIdentite("Peperonni"));
		ControlEmmenager controleur2 = new ControlEmmenager(v);
		controleur2.ajouterGaulois("Peperonni", 10);
		assertTrue(controleur.verifierIdentite("Peperonni"));
		
		assertTrue(controleur.verifierIdentite("Chef"));
		
		assertFalse(controleur.verifierIdentite("Pizza"));
		


	}

}
