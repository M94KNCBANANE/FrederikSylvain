package ca.cours5b5.frederiksylvain.modeles;

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
    public String get__idJoueurHote = "idJoueurHote";

    public MPartieReseau(MParametresPartie parametres){
        super(parametres);
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

                            ControleurPartieReseau.getInstance().connecterAuServeur();



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

    }

    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{
    super.aPartirObjetJson(objetJson);
    }

    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
    super.enObjetJson();

    return null;
    }


}
