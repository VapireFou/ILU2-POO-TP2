package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private ControlTrouverEtalVendeur controleur;
	private Village v;

	@BeforeEach
	void setUp() throws Exception {
		v = new Village("test",3,10);
		controleur = new ControlTrouverEtalVendeur(v);
	}

	@Test
	void testTrouverEtalVendeur() {
		assertThrows(NullPointerException.class, ()->controleur.trouverEtalVendeur("Fromage"));
		Chef chef = new Chef("Chef",10,v);
		v.setChef(chef);
		assertNull(controleur.trouverEtalVendeur("Jambon"));
	}

}
