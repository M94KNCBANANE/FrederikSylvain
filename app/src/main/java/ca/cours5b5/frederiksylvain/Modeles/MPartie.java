package ca.cours5b5.frederiksylvain.Modeles;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import ca.cours5b5.frederiksylvain.Exceptions.ErreurDeSerialisation;
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

    @AttributSerialisable
    public List<Integer> coups;
    private final String __coups = "coups";

    public MGrille getGrille(){ return grille; }

    public MPartie(MParametresPartie mParametresPartie){
        parametres = mParametresPartie;
        grille = new MGrille(mParametresPartie.getLargeur());
        coups = new ArrayList<>();
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
        Log.d("Atelier05", " "+colonne + couleurCourante);
        grille.placerJeton(colonne, couleurCourante );
        coups.add(colonne);
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
    List<Integer> temp ;
        if(objetJson.containsKey("parametresPartie")){


            parametres.aPartirObjetJson((Map<String, Object>) objetJson.get("parametresPartie"));
            Log.d("Atelier05", "Parametres");
        }else{

            throw new ErreurDeSerialisation("Heille Bob, le Json devrait contenir les parametres");

        }
        grille = new MGrille(parametres.getLargeur());
        Log.d("Atelier05", "Grille");
        initialiserCouleurCourante();

        if(objetJson.containsKey(__coups)){


            temp = listeCoupsAPartirJson((List<String>) objetJson.get(__coups));

        }else{

                throw new ErreurDeSerialisation("Heille Roger, le Json devrait contenir les coups");

        }
        Log.d("Atelier05", "Rejouer " + temp);
        rejouerLesCoups(temp);


    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurDeSerialisation{
        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(__coups,listeCoupsEnObjetJson(coups));
        objetJson.put("parametresPartie", parametres.enObjetJson());
        return objetJson;
    }

    private void rejouerLesCoups(List<Integer> coupsARejouer){
        Log.d("Atelier05", " "+coupsARejouer);
    for(int i=0; i<coupsARejouer.size();i++){
        jouerCoup(coupsARejouer.get(i));

    }
    coups= coupsARejouer;

    }

    private List<Integer> listeCoupsAPartirJson(List<String> listeCoupsObjetJson){
        List<Integer> liste = new ArrayList<>();

        for(int i=0;i<listeCoupsObjetJson.size();i++){
            liste.add(Integer.parseInt(listeCoupsObjetJson.get(i)));
        }
        return liste;
    }
    private List<String> listeCoupsEnObjetJson(List<Integer> listeCoups){
        List<String> liste = new ArrayList<>();

        for(int i=0;i<listeCoups.size();i++){
            liste.add(listeCoups.get(i).toString());
        }
        return liste;
    }
}
