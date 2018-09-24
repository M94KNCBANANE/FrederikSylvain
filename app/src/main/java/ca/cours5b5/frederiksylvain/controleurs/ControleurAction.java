package ca.cours5b5.frederiksylvain.controleurs;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.frederiksylvain.Global.GCommande;
import ca.cours5b5.frederiksylvain.Modeles.Modele;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.Fournisseur;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerFournisseur;

public class ControleurAction {

    private static Map<GCommande, Action> actions;
    private static List<Action> fileAttenteExecution;

    static {
        actions = new HashMap<>();
        fileAttenteExecution = new ArrayList<>();

        for (GCommande commande : GCommande.values()) {
            actions.put(commande, new Action());
        }

    }

    public static Action demanderAction(GCommande commande) {

        return actions.get(commande);
    }

    public static void fournirAction(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur) {

        enregistrerFournisseur(fournisseur, commande, listenerFournisseur);
        executerActionExecutables();
    }

    static void executerDesQuePossible(Action action) {

        ajouterActionEnFileDattente(action);
        executerActionExecutables();
    }

    private static void executerActionExecutables() {

        for (Action action : fileAttenteExecution) {
            if (siActionExecutable(action)) {

                fileAttenteExecution.remove(action);
                executerMaintenant(action);
                lancerObservationSiApplicable(action);
            }
        }

    }

    static boolean siActionExecutable(Action action) {



        return (action.listenerFournisseur != null);
    }

    private static void lancerObservationSiApplicable(Action action) {
        if (action.fournisseur instanceof Modele) {
            ControleurObservation.lancerObservation((Modele) action.fournisseur);
        }
    }

    private static synchronized void executerMaintenant(Action action) {

        action.listenerFournisseur.executer(action.args);


    }

    private static void enregistrerFournisseur(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur) {
        Action action = actions.get(commande);
        action.fournisseur = fournisseur;
        action.listenerFournisseur = listenerFournisseur;
    }

    private static void ajouterActionEnFileDattente(Action action) {
        Action clone = action.cloner();

        fileAttenteExecution.add(clone);
    }

}
