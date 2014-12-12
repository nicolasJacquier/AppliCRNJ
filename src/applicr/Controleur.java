package applicr;

import java.util.* ;

/** Contrôleur de l'application
 * 
 * @author xilim
 *
 */
public class Controleur {

	private Guiapplicr vuePrincipale ;
	private Modele modele ;
	
	/** Créer le contrôleur
	 * 
	 * @param modele Le modèle
	 */
	public Controleur(Modele modele) {
		super();
		System.out.println("Controleur::Controleur()") ;
		this.modele = modele;
	}
	
	/** Obtenir la vue principale
	 * 
	 * @return La vue principale
	 */
	public Guiapplicr getVuePrincipale() {
		System.out.println("Controleur::getVuePrincipale()") ;
		return vuePrincipale ;
	}

	/** Modifier la vue principale
	 * 
	 * @param vuePrincipale La nouvelle vue principale
	 */
	public void setVuePrincipales(Guiapplicr vuePrincipale) {
		System.out.println("Controleur::setVuePrincipale()") ;
		this.vuePrincipale = vuePrincipale ;
	}
	
	/** Visualiser la liste des Praticiens Hesitants sous une forme tabulaire
	 * 
	 */
	public void visualiserPraticiensH(){
		System.out.println("Controleur::visualiserPraticiensH()") ;
		this.vuePrincipale.changerDeVue("ListePraticiens");
	}
	

	
	/** Quitter l'application
	 * 
	 */
	public void quitterApplication(){
		System.out.println("Controleur::quitterApplication()") ;
		System.exit(0) ;
	}
	
	
	
}
