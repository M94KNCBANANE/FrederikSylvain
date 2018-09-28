package ca.cours5b5.frederiksylvain.Modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.frederiksylvain.Global.GConstantes;
import ca.cours5b5.frederiksylvain.Serialisation.AttributSerialisable;

public class MParametresPartie extends Modele{

@AttributSerialisable
public Integer hauteur;
protected final String __hauteur = "hauteur";

@AttributSerialisable
public Integer  largeur ;
protected final String __largeur = "largeur";

    public Integer getHauteur() {
        return hauteur;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public void setLargeur(Integer largeur) {
        this.largeur = largeur;
    }

    public Integer getPourGagner() {
        return pourGagner;
    }

    public void setPourGagner(Integer pourGagner) {
        this.pourGagner = pourGagner;
    }

    @AttributSerialisable
public Integer pourGagner ;
protected final String __pourGagner = "pourGagner";

public static MParametresPartie aPartirMParametres(MParametres mParametres){

    MParametresPartie clone = new MParametresPartie();
    clone.setHauteur(mParametres.getParametresPartie().getHauteur());
    clone.setLargeur(mParametres.getParametresPartie().getLargeur());
    clone.setPourGagner(mParametres.getParametresPartie().getPourGagner());

    return clone;
}

    public MParametresPartie cloner(){
        MParametresPartie clone = new MParametresPartie();
        clone.setHauteur(hauteur);
        clone.setLargeur(largeur);
        clone.setPourGagner(pourGagner);
        return clone;

    }

        public MParametresPartie(){
            hauteur = GConstantes.HAUTEURDEF;
            largeur = GConstantes.LARGEURDEF;
            pourGagner = GConstantes.POURGAGNERDEF;
        }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {
        for(Map.Entry<String, Object> entry : objetJson.entrySet()){
            if(entry.getKey().equals(__hauteur)){
                hauteur = Integer.valueOf((String)entry.getValue());
            }else if(entry.getKey().equals(__largeur)) {
                largeur = Integer.valueOf((String) entry.getValue());
            }else if(entry.getKey().equals(__pourGagner)){
                pourGagner = Integer.valueOf((String)entry.getValue());
            }
        }
    }

    @Override
    public Map<String, Object> enObjetJson() {
        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(__hauteur,hauteur.toString());
        objetJson.put(__largeur,largeur.toString());
        objetJson.put(__pourGagner,pourGagner.toString());

        return objetJson;
    }
}
