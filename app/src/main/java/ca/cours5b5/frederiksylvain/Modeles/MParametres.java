package ca.cours5b5.frederiksylvain.Modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.frederiksylvain.Global.GCommande;
import ca.cours5b5.frederiksylvain.Global.GConstantes;
import ca.cours5b5.frederiksylvain.Serialisation.AttributSerialisable;
import ca.cours5b5.frederiksylvain.controleurs.ControleurAction;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.Fournisseur;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerFournisseur;

public class MParametres  extends Modele implements Fournisseur{

    @AttributSerialisable
    public MParametresPartie parametresPartie ;
    private String __parametrePartie = "parametresPartie";


    public static MParametres instance = new MParametres();

    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    public MParametresPartie getParametresPartie() {
        return parametresPartie;
    }

    public MParametres(){
        choixHauteur = new ArrayList<Integer>();
        choixLargeur = new ArrayList<Integer>();
        choixPourGagner = new ArrayList<Integer>();
        parametresPartie = new MParametresPartie();
        genererListesDeChoix();

        ControleurAction.fournirAction(this, GCommande.CHOISIR_LARGEUR, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                parametresPartie.setLargeur((int) args[0]);
                choixPourGagner = genererListeDeChoix(GConstantes.POURGAGNERMIN, (Math.max(parametresPartie.getHauteur(),parametresPartie.getLargeur()) * 75/100));
            }
        });

        ControleurAction.fournirAction(this, GCommande.CHOISIR_HAUTEUR, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                parametresPartie.setHauteur((int) args[0]);
                choixPourGagner = genererListeDeChoix(GConstantes.POURGAGNERMIN, (Math.max(parametresPartie.getHauteur(),parametresPartie.getLargeur()) * 75/100));
            }
        });

        ControleurAction.fournirAction(this, GCommande.CHOISIR_POUR_GAGNER, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {

               parametresPartie.setPourGagner((int) args[0]);

            }
        });

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

    private void genererListesDeChoix(){
        choixHauteur = genererListeDeChoix(GConstantes.HAUTEURMIN, GConstantes.HAUTEURMAX);
        choixLargeur = genererListeDeChoix(GConstantes.LARGEURMIN, GConstantes.LARGEURMAX);
        choixPourGagner = genererListeDeChoix(GConstantes.POURGAGNERMIN, (Math.max(parametresPartie.getHauteur(),parametresPartie.getLargeur()) * 75/100));

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
            if(entry.getKey().equals(__parametrePartie)) {
                parametresPartie = (MParametresPartie) entry.getValue();
            }
        }
    }

    @Override
    public Map<String, Object> enObjetJson() {
        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(__parametrePartie,parametresPartie.enObjetJson());

        return objetJson;
    }



}
