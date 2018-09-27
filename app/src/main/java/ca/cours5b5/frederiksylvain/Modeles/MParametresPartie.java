package ca.cours5b5.frederiksylvain.Modeles;

import java.util.Map;

import ca.cours5b5.frederiksylvain.Serialisation.AttributSerialisable;

public class MParametresPartie extends Modele{

@AttributSerialisable
public Integer hauteur;
protected final String __hauteur = "hauteur";

@AttributSerialisable
public Integer largeur;
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
public Integer pourGagner;
protected final String __pourGagner = "pourGagner";

public static MParametresPartie aPartirMParametres(MParametres mParametres){

    MParametresPartie clone = new MParametresPartie();
    clone.setHauteur(mParametres.getHauteur());
    clone.setLargeur(mParametres.getLargeur());
    clone.setPourGagner(mParametres.getPourGagner());

    return clone;
}

    public MParametresPartie cloner(){
        MParametresPartie clone = new MParametresPartie();
        clone.setHauteur(this.getHauteur());
        clone.setLargeur(this.getLargeur());
        clone.setPourGagner(this.getPourGagner());
        return clone;

    }

    public MParametresPartie(){

    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
    }
}
