package ca.cours5b5.frederiksylvain.Activites;

import android.os.Bundle;
import android.util.Log;

import ca.cours5b5.frederiksylvain.Global.GCommande;
import ca.cours5b5.frederiksylvain.R;
import ca.cours5b5.frederiksylvain.controleurs.ControleurAction;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.Fournisseur;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerFournisseur;

public class APartie extends Activite implements Fournisseur{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);
    }

    static{

    }

    @Override
    protected void onResume(){
        super.onResume();

    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    protected void onDestroy(){
        super.onDestroy();
    }


}
