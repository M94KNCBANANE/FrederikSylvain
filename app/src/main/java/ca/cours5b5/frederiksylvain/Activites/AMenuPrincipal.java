package ca.cours5b5.frederiksylvain.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import ca.cours5b5.frederiksylvain.Global.GCommande;
import ca.cours5b5.frederiksylvain.R;
import ca.cours5b5.frederiksylvain.controleurs.ControleurAction;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.Fournisseur;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerFournisseur;

public class AMenuPrincipal extends Activite implements Fournisseur {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        Log.d("atelier04", AMenuPrincipal.class.getSimpleName() + "::onCreate");

        ControleurAction.fournirAction(this, GCommande.OUVRIR_MENU_PARAMETRES, new ListenerFournisseur() {
            @Override
            public void executer(Object[] args) {
                test();
            }
        });
    }

    static{
        Log.d("atelier04", AMenuPrincipal.class.getSimpleName() + "::static");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("atelier04", AMenuPrincipal.class.getSimpleName() + "::onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("atelier04", AMenuPrincipal.class.getSimpleName() + "::onPause");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("atelier04", AMenuPrincipal.class.getSimpleName() + "::onSaveInstanceState");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d("atelier04", AMenuPrincipal.class.getSimpleName() + "::onDestroy");
    }

    public void test(){
         Intent intention = new Intent(this, AParametres.class);
        this.startActivity(intention);
    }
}
