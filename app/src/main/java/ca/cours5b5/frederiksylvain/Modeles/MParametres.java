package ca.cours5b5.frederiksylvain.Modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.frederiksylvain.Global.GConstantes;
import ca.cours5b5.frederiksylvain.Serialisation.AttributSerialisable;

public class MParametres  extends Modele{

    @AttributSerialisable
    public Integer hauteur;
    private final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    private final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    private final String __pourGagner = "pourGagner";

    public static MParametres instance = new MParametres();

    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    public MParametres(){
        pourGagner = GConstantes.POURGAGNERDEF;
        largeur = GConstantes.LARGEURDEF;
        hauteur = GConstantes.HAUTEURDEF;
        choixHauteur = new ArrayList<Integer>();
        choixLargeur = new ArrayList<Integer>();
        choixPourGagner = new ArrayList<Integer>();
        genererListesDeChoix();

    }

    public List<Integer> getChoixHauteur(){
         return choixHauteur;
    }

    public List<Integer> getChoixLargeur() {
        return choixLargeur;
    }

    public List<Integer> getChoixPourGagner() {
        return choixPourGagner;
    }

    public Integer getHauteur() {
        return hauteur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public Integer getPourGagner() {
        return pourGagner;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(Integer largeur) {
        this.largeur = largeur;
    }

    public void setPourGagner(Integer pourGagner) {
        this.pourGagner = pourGagner;
    }

    private void genererListesDeChoix(){
        choixHauteur = genererListeDeChoix(GConstantes.HAUTEURMIN, GConstantes.HAUTEURMAX);
        choixLargeur = genererListeDeChoix(GConstantes.LARGEURMIN, GConstantes.LARGEURMAX);
        choixPourGagner = genererListeDeChoix(GConstantes.POURGAGNERMIN, GConstantes.POURGAGNERMAX);

    }

    private List<Integer> genererListeDeChoix ( int min, int max){
    List<Integer> liste = new ArrayList<Integer>();
    for(int i=min; i<=max;i++) {
        liste.add(i);
    }
    return liste;
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
