package ca.cours5b5.frederiksylvain.modeles;

import android.util.Log;

import java.util.Map;

import ca.cours5b5.frederiksylvain.controleurs.ControleurAction;
import ca.cours5b5.frederiksylvain.controleurs.ControleurPartieReseau;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.Fournisseur;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.frederiksylvain.exceptions.ErreurAction;
import ca.cours5b5.frederiksylvain.exceptions.ErreurSerialisation;
import ca.cours5b5.frederiksylvain.global.GCommande;
import ca.cours5b5.frederiksylvain.serialisation.AttributSerialisable;

public class MPartieReseau extends MPartie implements Fournisseur,Identifiable{

    @AttributSerialisable
    public String idJoueurInvite;
    private String __idJoueurInvite = "idJoueurInvite";

    @AttributSerialisable
    public String idJoueurHote;
    public String __idJoueurHote = "idJoueurHote";

    public MPartieReseau(MParametresPartie parametres){
        super(parametres);
        fournirActionRecevoirCoup();
    }

    @Override
    public String getId() {
        return idJoueurHote;
    }

    private void fournirActionRecevoirCoup(){
        ControleurAction.fournirAction(this,
                GCommande.RECEVOIR_COUP_RESEAU,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        try{
                                int colonne = Integer.parseInt( (String) args[0]);
                                recevoirCoupReseau(colonne);




                        }catch(ClassCastException e){

                            throw new ErreurAction(e);

                        }
                    }
                });
    }

    @Override
    protected void fournirActionPlacerJeton(){
        ControleurAction.fournirAction(this,
                GCommande.JOUER_COUP_ICI,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        try{

                            int colonne = (Integer) args[0];

                            jouerCoup(colonne);
                            ControleurPartieReseau.getInstance().transmettreCoup(colonne);

                        }catch(ClassCastException e){

                            throw new ErreurAction(e);

                        }
                    }
                });
    }

    private void recevoirCoupReseau(int colonne){
        jouerCoup(colonne);
    }

    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{
        super.aPartirObjetJson(objetJson);



    idJoueurHote = (String) objetJson.get(__idJoueurHote);
        idJoueurInvite = (String) objetJson.get(__idJoueurInvite);

    }

    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
        Map<String, Object> objetJson = super.enObjetJson();

        objetJson.put(__idJoueurHote,idJoueurHote);
        objetJson.put(__idJoueurInvite,idJoueurInvite);
        return objetJson;
    }


}
