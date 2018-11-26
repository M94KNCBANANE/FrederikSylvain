package ca.cours5b5.frederiksylvain.donnees;

import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement);

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    public abstract void detruireSauvegarde(String cheminSauvegarde);

    protected String getNomModele(String cheminDeSauvegarde){
        return cheminDeSauvegarde.split("/")[0];
    }




}
