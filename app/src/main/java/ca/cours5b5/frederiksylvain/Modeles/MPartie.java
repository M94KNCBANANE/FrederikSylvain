package ca.cours5b5.frederiksylvain.Modeles;

import java.util.Map;

import ca.cours5b5.frederiksylvain.Global.GCouleur;
import ca.cours5b5.frederiksylvain.Serialisation.AttributSerialisable;

public class MPartie extends Modele{

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";
    private MGrille grille;
    private GCouleur couleurCourante;

    public MGrille getGrille(){ return grille; }

    public MPartie(MParametresPartie mParametresPartie){
        parametres = mParametresPartie;
    }

    public MParametresPartie getParametres() {
        return parametres;
    }

    private void initialiserCouleurCourante(){

    }

    private void fournirActionPlacerJeton() {

    }

    protected void jouerCoup(int colonne){

    }

    private void prochaineCouleurCourante(){

    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
    }
}
