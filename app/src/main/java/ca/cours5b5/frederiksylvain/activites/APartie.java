package ca.cours5b5.frederiksylvain.activites;


import android.os.Bundle;

import ca.cours5b5.frederiksylvain.R;
import ca.cours5b5.frederiksylvain.controleurs.ControleurAction;
import ca.cours5b5.frederiksylvain.controleurs.ControleurModeles;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.Fournisseur;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.frederiksylvain.donnees.SauvegardeTemporaire;
import ca.cours5b5.frederiksylvain.global.GCommande;
import ca.cours5b5.frederiksylvain.modeles.MParametres;
import ca.cours5b5.frederiksylvain.modeles.MPartie;

public class APartie extends Activite implements Fournisseur{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_partie);

        ControleurAction.fournirAction(this, GCommande.QUITTER, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {

                APartie.this.finish();

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

        ControleurModeles.sauvegarderModele(MPartie.class.getSimpleName());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        ControleurModeles.sauvegarderModeleDansCetteSource(MPartie.class.getSimpleName(),
                new SauvegardeTemporaire(outState));

    }
}