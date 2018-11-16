package ca.cours5b5.frederiksylvain.proxy;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public abstract class Proxy {

    private String cheminServeur;
    protected DatabaseReference noeudServeur;

    public Proxy(String cheminServeur){

        this.cheminServeur = cheminServeur;

    }

    public void connecterAuServeur(){

           noeudServeur = FirebaseDatabase.getInstance().getReference(cheminServeur);

    }

    public void deconnecterAuServeur(){

        noeudServeur = null;
        detruireValeurs();
    }

    public abstract void detruireValeurs();
}
