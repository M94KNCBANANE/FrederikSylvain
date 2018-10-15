package ca.cours5b5.frederiksylvain.Vue;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.frederiksylvain.Global.GCouleur;
import ca.cours5b5.frederiksylvain.Modeles.MGrille;
import ca.cours5b5.frederiksylvain.Modeles.MParametres;
import ca.cours5b5.frederiksylvain.Modeles.MPartie;
import ca.cours5b5.frederiksylvain.Modeles.Modele;
import ca.cours5b5.frederiksylvain.R;
import ca.cours5b5.frederiksylvain.controleurs.ControleurObservation;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerObservateur;

public class VPartie extends Vue{

    private VGrille grille;

    public VPartie (Context context){ super(context);}

    public VPartie(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr){
        super(context,attrs,defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("Atelier06", "VPartie::OnFinishInflate");
        initialiser();
        observerPartie();
    }

    private void initialiser(){
       grille = this.findViewById(R.id.grille);

    }

    private void observerPartie(){

        String nom = MPartie.class.getSimpleName();
        Log.d("Atelier06", "VPartie::ObserverPartie");
        ControleurObservation.observerModele(nom, new ListenerObservateur() {

            @Override
            public void reagirNouveauModele(Modele modele) {
                super.reagirNouveauModele(modele);
                MPartie partie = (MPartie) modele;
                Log.d("Atelier06", "VPartie::reagirNouveauModele");
                initialiserGrille(partie);
                miseAJourGrille(partie);
            }

            @Override
            public void reagirChangementAuModele(Modele modele) {
                miseAJourGrille((MPartie) modele);
            }
        });


    }

   private void initialiserGrille(MPartie partie){

        int hauteur = partie.getParametres().getHauteur();
        int largeur = partie.getParametres().getLargeur();
        grille.creerGrille(hauteur,largeur);

    }


    private void miseAJourGrille(MPartie partie){
        Log.d("Atelier07", "miseAJourGrille");
        grille.afficherJetons(partie.getGrille());
    }

}
