package ca.cours5b5.frederiksylvain.donnees;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import ca.cours5b5.frederiksylvain.serialisation.Jsonification;

public class Serveur extends SourceDeDonnees {

    private Serveur(){}

    private static final Serveur instance = new Serveur();

    public static Serveur getInstance() {return instance;}

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {
        return null;
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        Log.d("Atelier11","sauvegarde Modele");
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);

        noeud.setValue(objetJson);

    }

    public void detruireSauvegarde(String cheminSauvegarde){

        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);

        noeud.removeValue();
    }
}