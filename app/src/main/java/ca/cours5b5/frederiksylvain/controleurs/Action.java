package ca.cours5b5.frederiksylvain.controleurs;

import android.util.Log;

import ca.cours5b5.frederiksylvain.controleurs.interfaces.Fournisseur;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerFournisseur;

public class Action {

    Fournisseur fournisseur;

    ListenerFournisseur listenerFournisseur;

    Object[] args;

    public void setArguments(Object... arguments){
        args = arguments;

    }
    public void executerDesQuePossible(){
        Log.d("test", "Executer des que possible action");
    ControleurAction.executerDesQuePossible(this);
    }
    public Action cloner(){
        Action clone = new Action();
        if(args != null) {
            clone.setArguments(args.clone());

        }
        clone.fournisseur=fournisseur;
        clone.listenerFournisseur=listenerFournisseur;
        return clone;
    }
}
