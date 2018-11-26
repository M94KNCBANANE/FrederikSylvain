package ca.cours5b5.frederiksylvain.controleurs;

import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.frederiksylvain.global.GCommande;
import ca.cours5b5.frederiksylvain.global.GCouleur;
import ca.cours5b5.frederiksylvain.modeles.MParametres;
import ca.cours5b5.frederiksylvain.modeles.MPartie;
import ca.cours5b5.frederiksylvain.modeles.MPartieReseau;

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

    public void finirPartie(){
        Action effacer = ControleurAction.demanderAction(GCommande.EFFACER_PARTIE);
        effacer.executerDesQuePossible();
        Action quitter = ControleurAction.demanderAction(GCommande.QUITTER);
        quitter.executerDesQuePossible();
    }
}
