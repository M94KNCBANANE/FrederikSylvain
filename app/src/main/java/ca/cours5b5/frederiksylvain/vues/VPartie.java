package ca.cours5b5.frederiksylvain.vues;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import android.util.AttributeSet;
import android.util.Log;


import ca.cours5b5.frederiksylvain.R;
import ca.cours5b5.frederiksylvain.controleurs.ControleurObservation;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.frederiksylvain.exceptions.ErreurObservation;

import ca.cours5b5.frederiksylvain.global.GConstantes;
import ca.cours5b5.frederiksylvain.global.GCouleur;

import ca.cours5b5.frederiksylvain.modeles.MParametresPartie;
import ca.cours5b5.frederiksylvain.modeles.MPartie;
import ca.cours5b5.frederiksylvain.modeles.Modele;


public class VPartie extends Vue {

    private VGrille grille;

    private TextView textJoueur1;
    private TextView textJoueur2;


    public VPartie(Context context) {
        super(context);
    }

    public VPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        initialiser();

        observerPartie();

    }

    private void initialiser() {

        grille = findViewById(R.id.grille);
        textJoueur1= findViewById(R.id.texte_joueur_un);
        textJoueur2 =findViewById(R.id.texte_joueur_deux);



    }

    private void observerPartie() {

        String nom = getNomModele();
        ControleurObservation.observerModele(nom,
                new ListenerObservateur() {
                    @Override
                    public void reagirNouveauModele(Modele modele) {

                        MPartie partie = getPartie(modele);

                        preparerAffichage(partie);

                        miseAJourGrille(partie);

                    }

                    @Override
                    public void reagirChangementAuModele(Modele modele) {

                        MPartie partie = getPartie(modele);

                        miseAJourGrille(partie);

                    }
                });
    }

    private void preparerAffichage(MPartie partie) {

        MParametresPartie parametresPartie = partie.getParametres();

        grille.creerGrille(parametresPartie.getHauteur(), parametresPartie.getLargeur());

    }

    private MPartie getPartie(Modele modele){

        try{

            return (MPartie) modele;

        }catch(ClassCastException e){

            throw new ErreurObservation(e);

        }

    }

    private void miseAJourGrille(MPartie partie){

        grille.afficherJetons(partie.getGrille());
        setCouleurJoueur(partie.getCouleurCourante());

    }

    public void setCouleurJoueur(GCouleur couleurCourante) {

        if(couleurCourante == GCouleur.ROUGE) {
            textJoueur1.setBackgroundColor(Color.RED);
            textJoueur2.setBackgroundColor(Color.WHITE);
        } else if(couleurCourante == GCouleur.JAUNE) {
            textJoueur2.setBackgroundColor(Color.YELLOW);
            textJoueur1.setBackgroundColor(Color.WHITE);
        }
    }






    protected String getNomModele(){
        return MPartie.class.getSimpleName();
    }

}
