package ca.cours5b5.frederiksylvain.controleurs;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.frederiksylvain.Modeles.MParametres;
import ca.cours5b5.frederiksylvain.Modeles.Modele;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerObservateur;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;

    static{
    observations = new HashMap<>();
    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){
        observations.put(MParametres.instance,listenerObservateur);
        lancerObservation(MParametres.instance);

    }

    public static void lancerObservation(Modele modele){
    ListenerObservateur listener = observations.get(modele);
    if(listener !=null) {
        listener.reagirChangementAuModele(modele);
    }
    }
}
