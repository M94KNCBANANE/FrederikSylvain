package ca.cours5b5.frederiksylvain.activites;

import android.os.Bundle;
import android.util.Log;

import ca.cours5b5.frederiksylvain.R;
import ca.cours5b5.frederiksylvain.controleurs.ControleurModeles;
import ca.cours5b5.frederiksylvain.controleurs.ControleurPartieReseau;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.Fournisseur;
import ca.cours5b5.frederiksylvain.modeles.MPartieReseau;

public class APartieReseau extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie_reseau);
    }

    @Override
    protected void onPause(){
        super.onPause();
        ControleurPartieReseau.getInstance().detruireSauvegardeServeur();
        ControleurPartieReseau.getInstance().deconnecterDuServeur();
    }

    @Override
    protected void onResume(){
        super.onResume();
        ControleurPartieReseau.getInstance().connecterAuServeur();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ControleurModeles.detruireModele(MPartieReseau.class.getSimpleName());
    }
}
