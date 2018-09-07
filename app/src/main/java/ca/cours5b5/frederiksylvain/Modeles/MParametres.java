package ca.cours5b5.frederiksylvain.Modeles;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.frederiksylvain.Global.GConstantes;
import ca.cours5b5.frederiksylvain.R;
import ca.cours5b5.frederiksylvain.Serialisation.AttributSerialisable;
import ca.cours5b5.frederiksylvain.Vue.VParametres;

public class MParametres  extends Modele{

    @AttributSerialisable
    public Integer hauteur;

    @AttributSerialisable
    public Integer largeur;

    @AttributSerialisable
    public Integer pourGagner;

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

//    private void genererListeChoixHauteur(){
//        choixHauteur.clear();
//        for(int i=GConstantes.HAUTEURMIN;i<=GConstantes.HAUTEURMAX;i++){
//            choixHauteur.add(i);
//        }
//
//    }
//
//    private void genererListeChoixLargeur(){
//        choixLargeur.clear();
//        for(int i=GConstantes.LARGEURMIN;i<=GConstantes.LARGEURMAX;i++){
//            choixLargeur.add(i);
//        }
//    }
//
//    private void genererListeChoixPourGagner(){
//        choixPourGagner.clear();
//        for(int i=GConstantes.POURGAGNERMIN;i<=GConstantes.POURGAGNERMAX;i++){
//            choixHauteur.add(i);
//        }
//    }


}
