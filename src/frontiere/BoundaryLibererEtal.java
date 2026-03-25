package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}
		else {
			String[] donnesEtal = controlLibererEtal.libererEtal(nomVendeur);
			
			String etalOccupe = donnesEtal[0];
			
			if (etalOccupe.equals("true")) {
				System.out.println("Vous avez vendu " + donnesEtal[4] + " sur " + donnesEtal[3] + " " + donnesEtal[2] + ".\n");
				System.out.println("Au revoir "+ nomVendeur + ",passez une bonne journée\n");
			}
		}
	}

}
