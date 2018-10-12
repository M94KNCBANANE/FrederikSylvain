package ca.cours5b5.frederiksylvain.Vue;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.frederiksylvain.Global.GCommande;
import ca.cours5b5.frederiksylvain.Global.GCouleur;
import ca.cours5b5.frederiksylvain.Modeles.MColonne;
import ca.cours5b5.frederiksylvain.Modeles.MGrille;
import ca.cours5b5.frederiksylvain.controleurs.Action;
import ca.cours5b5.frederiksylvain.controleurs.ControleurAction;

public class VGrille extends GridLayout{

    public VGrille(Context context) {
        super(context);
    }

    public VGrille(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private Action actionEntete;

    private class Colonne extends ArrayList<VCase>{



    }


    private List<VEntete> entetes;
    private VCase[][] lesCases;

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        Log.d("Atelier06", "VGrille::OnFinishInflate");
    }



    void creerGrille(int hauteur, int largeur){
        ajouterEnTetes(largeur);
        lesCases = new VCase[hauteur][largeur];
        ajouterCases(hauteur,largeur);

    }


    private void ajouterEnTetes(int largeur){

        for(int i=0;i<largeur;i++){
            VEntete entete = new VEntete(getContext(), i);
            installerListenerEntete(entete, i);
            addView(entete, getMiseEnPageEntete(i));
        }
        demanderActionEntete();
    }

    private void demanderActionEntete(){
       actionEntete = ControleurAction.demanderAction(GCommande.JOUER_COUP_ICI);


    }

    private LayoutParams getMiseEnPageEntete(int colonne){


        int rangee = 0;

    float poidsrangee = 3;
    float poidsColonne = 1;

    Spec speclargeur = GridLayout.spec(colonne, poidsColonne);
    Spec specrangee = GridLayout.spec(rangee, poidsrangee);

    LayoutParams mesParams = new LayoutParams( specrangee,speclargeur);

    mesParams.width = 0;
    mesParams.height = 0;
    mesParams.setGravity(Gravity.FILL);


        return mesParams;
    }

    private void ajouterCases(int hauteur, int largeur){
        for(int h=1;h<hauteur+1;h++){
            for(int l=0;l<largeur;l++){
                VCase cases = new VCase(getContext(), (hauteur -h), l);
                addView(cases, getMiseEnPageCase(h,l));
                lesCases[hauteur -h][l] = cases;
            }
        }

    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){

        float poidsrangee = 1;
        float poidsColonne = 1;

        Spec speclargeur = GridLayout.spec(colonne, poidsColonne);
        Spec specrangee = GridLayout.spec(rangee, poidsrangee);

        LayoutParams mesParams = new LayoutParams( specrangee,speclargeur);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);


        return mesParams;

    }


    private void installerListenerEntete(VEntete entete, final int colonne){
        entete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                 actionEntete.setArguments(colonne);
                 actionEntete.executerDesQuePossible();

            }
        });
    }

    void afficherJetons(MGrille grille){

        List<MColonne> listeColonne = grille.getColonnes();

        for(int colonne=0; colonne < listeColonne.size(); colonne++){
            MColonne colonneActuel = listeColonne.get(colonne);
            List<GCouleur> listeJeton = colonneActuel.getJetons();

            for(int rangee=0; rangee< listeJeton.size(); rangee++){

                afficherJeton(colonne,rangee,listeJeton.get(rangee));

            }
        }


    }

    private void afficherJeton(int colonne, int rangee, GCouleur jeton){

    lesCases[rangee][colonne].afficherJeton(jeton);

    }

}
