package ca.cours5b5.frederiksylvain.proxy;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.List;

import ca.cours5b5.frederiksylvain.controleurs.Action;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.Fournisseur;
import ca.cours5b5.frederiksylvain.global.GCommande;
import ca.cours5b5.frederiksylvain.global.GConstantes;

public class ProxyListe extends Proxy implements Fournisseur {

    private ChildEventListener childEventListener;

    private Query requete;

    private Action actionNouvelItem;

    private List<DatabaseReference> noeudsAjoutes;

    public ProxyListe(String cheminServeur){
        super(cheminServeur);

    }

    public void setActionNouvelItem(GCommande commande){

    }

    public void ajouterValeur(Object valeur){

    }

    @Override
    public void connecterAuServeur(){
        super.connecterAuServeur();
        creerListener();
        requete= getRequete();
    }

    private void creerListener(){

    }

    protected Query getRequete(){


    }

    @Override
    public void deconnecterDuServeur(){


        super.deconnecterAuServeur();
    }


    @Override
    public void detruireValeurs() {

    }
}
