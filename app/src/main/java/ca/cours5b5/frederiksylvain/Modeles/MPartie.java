package ca.cours5b5.frederiksylvain.Modeles;

import java.util.Map;
import java.util.ResourceBundle;

import ca.cours5b5.frederiksylvain.Global.GCommande;
import ca.cours5b5.frederiksylvain.Global.GCouleur;
import ca.cours5b5.frederiksylvain.Serialisation.AttributSerialisable;
import ca.cours5b5.frederiksylvain.controleurs.ControleurAction;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.Fournisseur;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerFournisseur;

public class MPartie extends Modele implements Fournisseur{

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";
    private MGrille grille;
    private GCouleur couleurCourante;

    public MGrille getGrille(){ return grille; }

    public MPartie(MParametresPartie mParametresPartie){
        parametres = mParametresPartie;
        grille = new MGrille(mParametresPartie.getLargeur());
        initialiserCouleurCourante();
        fournirActionPlacerJeton();
    }

    public MParametresPartie getParametres() {
        return parametres;
    }

    private void initialiserCouleurCourante(){

        couleurCourante = GCouleur.ROUGE;

    }

    private void fournirActionPlacerJeton() {

        ControleurAction.fournirAction(this, GCommande.JOUER_COUP_ICI, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                jouerCoup((int) args[0]);
            }
        });

    }

    protected void jouerCoup(int colonne){

        grille.placerJeton(colonne, couleurCourante );

        prochaineCouleurCourante();
    }

    private void prochaineCouleurCourante(){
        if(couleurCourante == GCouleur.ROUGE){
            couleurCourante = GCouleur.JAUNE;
        }else{
            couleurCourante = GCouleur.ROUGE;
        }

    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
    }
}
