package ca.cours5b5.frederiksylvain.Modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.cours5b5.frederiksylvain.Global.GCouleur;

public class MColonne extends Modele {


    private List<GCouleur> jetons;

    public MColonne(){

        jetons = new ArrayList<>();
        jetons.add(GCouleur.ROUGE);
        jetons.add(GCouleur.JAUNE)

    }

    public List<GCouleur> getJetons(){ return jetons; }

    public void placerJeton(GCouleur couleur){
    getJetons().

    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
    }
}