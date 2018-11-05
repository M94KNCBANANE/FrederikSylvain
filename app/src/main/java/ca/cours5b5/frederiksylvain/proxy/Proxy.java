package ca.cours5b5.frederiksylvain.proxy;

import com.google.firebase.database.DatabaseReference;

public abstract class Proxy {

    private String cheminServeur;
    protected DatabaseReference noeudServeur;

    public Proxy(String cheminServeur){
        this.cheminServeur = cheminServeur;
    }

    public void connecterAuServeur(){
        noeudServeur.getDatabase();
    }

    public void deconnecterAuServeur(){
        noeudServeur = null;
    }

    public abstract void detruireValeurs();
}
