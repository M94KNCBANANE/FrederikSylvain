package ca.cours5b5.frederiksylvain.Activites;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;
import java.util.ResourceBundle;


import ca.cours5b5.frederiksylvain.Modeles.MParametres;
import ca.cours5b5.frederiksylvain.Modeles.MPartie;
import ca.cours5b5.frederiksylvain.R;
import ca.cours5b5.frederiksylvain.Serialisation.Jsonification;
import ca.cours5b5.frederiksylvain.controleurs.ControleurAction;
import ca.cours5b5.frederiksylvain.controleurs.ControleurObservation;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.Fournisseur;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerFournisseur;

public class APartie extends Activite implements Fournisseur{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);
        if(savedInstanceState !=null) {
            restaurerPartie(savedInstanceState);
        }
    }

    static{

    }

    @Override
    protected void onResume(){
        super.onResume();

    }
    private void restaurerPartie(Bundle savedInstanceState){
        String json = savedInstanceState.getString(MPartie.class.getSimpleName());
        Map<String, Object> objetJson = Jsonification.enObjetJson(json);
        ControleurObservation.partie.aPartirObjetJson(objetJson);
        Log.d("Atelier05", "Restauration :: " + json);
    }


    @Override
    protected void onPause(){
        super.onPause();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        sauvegarderParametres(outState);
    }

    private void sauvegarderParametres(Bundle outState){
        Map<String, Object> objetJson = ControleurObservation.partie.enObjetJson();
        String json = Jsonification.enChaine(objetJson);
        outState.putString(MPartie.class.getSimpleName(), json);
        Log.d("Atelier05", "Sauvegarde :: " + json);

    }

    protected void onDestroy(){
        super.onDestroy();
    }


}
