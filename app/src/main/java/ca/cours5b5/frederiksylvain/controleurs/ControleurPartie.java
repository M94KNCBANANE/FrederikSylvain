package ca.cours5b5.frederiksylvain.controleurs;

import ca.cours5b5.frederiksylvain.global.GCommande;
import ca.cours5b5.frederiksylvain.global.GCouleur;

public final class ControleurPartie {

    private ControleurPartie(){

    }
    private static final ControleurPartie instance = new ControleurPartie();

    public static ControleurPartie getInstance() {
        return instance;
    }

    public void gagnerPartie(GCouleur couleurGagnante){

        Action gagner = ControleurAction.demanderAction(GCommande.AFFICHER_GAGNANT);
        gagner.setArguments(couleurGagnante);
        gagner.executerDesQuePossible();
    }
}
