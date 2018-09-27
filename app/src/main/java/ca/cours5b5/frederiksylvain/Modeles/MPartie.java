package ca.cours5b5.frederiksylvain.Modeles;

import java.util.Map;

import ca.cours5b5.frederiksylvain.Serialisation.AttributSerialisable;

public class MPartie extends Modele{

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    public MPartie(MParametresPartie mParametresPartie){
        parametres = mParametresPartie;
    }

    public MParametresPartie getParametres() {
        return parametres;
    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
    }
}
