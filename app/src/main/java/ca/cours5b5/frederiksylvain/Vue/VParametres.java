package ca.cours5b5.frederiksylvain.Vue;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.frederiksylvain.Global.GCommande;
import ca.cours5b5.frederiksylvain.Modeles.MParametres;
import ca.cours5b5.frederiksylvain.Modeles.Modele;
import ca.cours5b5.frederiksylvain.R;
import ca.cours5b5.frederiksylvain.Global.GConstantes;
import ca.cours5b5.frederiksylvain.controleurs.Action;
import ca.cours5b5.frederiksylvain.controleurs.ControleurAction;
import ca.cours5b5.frederiksylvain.controleurs.ControleurObservation;
import ca.cours5b5.frederiksylvain.controleurs.interfaces.ListenerObservateur;

public class VParametres extends Vue{

    static{
        Log.d("atelier04", VParametres.class.getSimpleName() + "::static");
    }
    public VParametres(Context context){
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr){
        super(context,attrs,defStyleAttr);
    }

    private Spinner monSpinnerHauteur;
    private Spinner monSpinnerLargeur;
    private Spinner monSpinnerGagner;
    private ArrayAdapter<Integer> adapterHauteur;
    private ArrayAdapter<Integer> adapterLargeur;
    private ArrayAdapter<Integer> adapterGagner;


    @Override
        protected void onFinishInflate(){

            super.onFinishInflate();




       monSpinnerHauteur = this.findViewById(R.id.spinnerHauteur);
       adapterHauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        monSpinnerHauteur.setAdapter(adapterHauteur);

        adapterHauteur.addAll(MParametres.instance.getChoixHauteur());

        monSpinnerHauteur.setSelection(adapterHauteur.getPosition(MParametres.instance.getParametresPartie().getHauteur()));
        monSpinnerHauteur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Action actionHauteur = ControleurAction.demanderAction(GCommande.CHOISIR_HAUTEUR);
                actionHauteur.setArguments((Integer) adapterView.getAdapter().getItem(i));
                actionHauteur.executerDesQuePossible();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        monSpinnerLargeur = this.findViewById(R.id.spinnerLargeur);
        adapterLargeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        monSpinnerLargeur.setAdapter(adapterLargeur);

        adapterLargeur.addAll(MParametres.instance.getChoixLargeur());

        monSpinnerLargeur.setSelection(adapterLargeur.getPosition(MParametres.instance.getParametresPartie().getLargeur()));
        monSpinnerLargeur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Action actionLargeur = ControleurAction.demanderAction(GCommande.CHOISIR_LARGEUR);
                actionLargeur.setArguments((Integer) adapterView.getAdapter().getItem(i));
                actionLargeur.executerDesQuePossible();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        monSpinnerGagner = this.findViewById(R.id.spinnerGagner);
        adapterGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        monSpinnerGagner.setAdapter(adapterGagner);
        adapterGagner.addAll(MParametres.instance.getChoixPourGagner());
        monSpinnerGagner.setSelection(adapterGagner.getPosition(MParametres.instance.getParametresPartie().getPourGagner()));
        monSpinnerGagner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Action actionGagner = ControleurAction.demanderAction(GCommande.CHOISIR_POUR_GAGNER);
                actionGagner.setArguments((Integer) adapterView.getAdapter().getItem(i));
                actionGagner.executerDesQuePossible();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ControleurObservation.observerModele(MParametres.class.getSimpleName(), new ListenerObservateur() {
                    @Override
                    public void reagirChangementAuModele(Modele modele) {
                    afficherParametres(MParametres.instance);
                    }
                });
                Log.d("atelier04", VParametres.class.getSimpleName() + "::onFinishInflate");
    }

    private void afficherParametres(Modele modele) {
        adapterHauteur.clear();
        adapterGagner.clear();
        adapterLargeur.clear();

        adapterHauteur.addAll(MParametres.instance.getChoixHauteur());
        adapterLargeur.addAll(MParametres.instance.getChoixLargeur());
        adapterGagner.addAll(MParametres.instance.getChoixPourGagner());

    }
}
