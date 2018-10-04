package ca.cours5b5.frederiksylvain.Vue;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

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

    private int nombreRangees;

    private class Colonne extends ArrayList<VCase>{

    }

    private List<Colonne> colonnesDeCases;

    private List<VEntete> entetes;

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        Log.d("Atelier06", "VGrille::OnFinishInflate");
    }

    private void initialiser(){

    }

    void creerGrille(int hauteur, int largeur){
        ajouterEnTetes(largeur);
        ajouterCases(hauteur,largeur);

    }

    private void initialiserColonnes(int largeur){

    }

    private void ajouterEnTetes(int largeur){
        for(int i=0;i<largeur;i++){
            VEntete entete = new VEntete(getContext(), i);

            addView(entete, getMiseEnPageEntete(i));
        }
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
                VCase test = new VCase(getContext(), (hauteur -h), l);
                addView(test, getMiseEnPageCase(h,l));
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

}
