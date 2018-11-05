package ca.cours5b5.frederiksylvain.controleurs;

import ca.cours5b5.frederiksylvain.proxy.ProxyListe;

public class ControleurPartieReseau {

    private static final ControleurPartieReseau instance = new ControleurPartieReseau();
    public static ControleurPartieReseau getInstance(){return instance;};

    private ProxyListe proxyEmettreCoups;
    private ProxyListe proxyRecevoirCoups;

    public void connecterAuServeur(){

    }

    private void connecterAuServeur(String idJoueurHote){

    }

    private void connecterEnTantQueJoueurHote(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){

    }
    private void connecterEnTantQueJoueurInvite(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){

    }
    public void deconnecterDuServeur(){

    }
    public void transmettreCoup(Integer idColonne){

    }
    private String getCheminCoupsJoueurInvite(String idJoueurInvite){

    }
    private String getCheminCoupsJoueurHot(String idJoueurHote){

    }
    private String getCheminPartie(String idJoueurHote){

    }
    public void detruireSauvegardeServeur(){

    }
}
