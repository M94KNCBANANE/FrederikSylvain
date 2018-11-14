package ca.cours5b5.frederiksylvain.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ca.cours5b5.frederiksylvain.controleurs.ControleurModeles;
import ca.cours5b5.frederiksylvain.donnees.Disque;
import ca.cours5b5.frederiksylvain.donnees.SauvegardeTemporaire;
import ca.cours5b5.frederiksylvain.donnees.Serveur;
import ca.cours5b5.frederiksylvain.donnees.Transition;
import ca.cours5b5.frederiksylvain.modeles.MParametres;
import ca.cours5b5.frederiksylvain.modeles.MPartieReseau;


public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialiserControleurModeles(savedInstanceState);
        initialiserApplication();

    }

    protected void initialiserControleurModeles(Bundle savedInstanceState) {

        ControleurModeles.setSequenceDeChargement(
                new Transition(savedInstanceState),
                new SauvegardeTemporaire(savedInstanceState),
                Serveur.getInstance(),
                Disque.getInstance());

    }

    protected void initialiserApplication(){

        Disque.getInstance().setRepertoireRacine(getFilesDir());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        ControleurModeles.sauvegarderModeleDansCetteSource(MParametres.class.getSimpleName(),
                new SauvegardeTemporaire(outState));
    }

}