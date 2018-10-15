package ca.cours5b5.frederiksylvain.controleurs;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.frederiksylvain.Modeles.MParametres;
import ca.cours5b5.frederiksylvain.Modeles.MPartie;
import ca.cours5b5.frederiksylvain.Modeles.Modele;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerObservateur;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;
    public static MPartie partie;

    static{
    observations = new HashMap<>();
    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){
        Log.d("Atelier06", "ControleurObservation::observerModele");
        if(nomModele.equals("MParametres")) {
            observations.put(MParametres.instance, listenerObservateur);
            lancerObservationPremiereFois(MParametres.instance);
        }else if(nomModele.equals("MPartie")){

            partie = new MPartie(MParametres.instance.getParametresPartie().cloner());

            observations.put(ControleurObservation.partie, listenerObservateur);
            lancerObservationPremiereFois(partie);
        }


    }

    public static void lancerObservation(Modele modele){
    ListenerObservateur listener = observations.get(modele);
    if(listener !=null) {
        listener.reagirChangementAuModele(modele);
    }
    }

    public static void lancerObservationPremiereFois(Modele modele){
        ListenerObservateur listener = observations.get(modele);
        if(listener !=null) {
            listener.reagirNouveauModele(modele);
        }
    }
}
