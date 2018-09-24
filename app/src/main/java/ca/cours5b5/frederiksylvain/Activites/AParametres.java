package ca.cours5b5.frederiksylvain.Activites;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.frederiksylvain.Global.GCommande;
import ca.cours5b5.frederiksylvain.Modeles.MParametres;
import ca.cours5b5.frederiksylvain.R;
import ca.cours5b5.frederiksylvain.Serialisation.Jsonification;
import ca.cours5b5.frederiksylvain.controleurs.ControleurAction;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.Fournisseur;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerFournisseur;

public class AParametres extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        if(savedInstanceState !=null) {
            restaurerParametres(savedInstanceState);
        }
        Log.d("atelier04", AParametres.class.getSimpleName() + "::onCreate");
    }

    private void restaurerParametres(Bundle savedInstanceState){
       String json = savedInstanceState.getString("MParametres");
       Map<String, Object> objetJson = Jsonification.enObjetJson(json);
        MParametres.instance.aPartirObjetJson(objetJson);
        Log.d("Atelier05", "Restauration :: " + json);
    }

    static{
        Log.d("atelier04", AParametres.class.getSimpleName() + "::static");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("atelier04", AParametres.class.getSimpleName() + "::onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("atelier04", AParametres.class.getSimpleName() + "::onPause");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("atelier04", AParametres.class.getSimpleName() + "::onSaveInstanceState");
        sauvegarderParametres(outState);
    }

    private void sauvegarderParametres(Bundle outState){
       Map<String, Object> objetJson = MParametres.instance.enObjetJson();
       String json = Jsonification.enChaine(objetJson);
       outState.putString("MParametres", json);
       Log.d("Atelier05", "Sauvegarde :: " + json);

    }


    protected void onDestroy(){
        super.onDestroy();
        Log.d("atelier04", AParametres.class.getSimpleName() + "::onDestroy");
    }
}
