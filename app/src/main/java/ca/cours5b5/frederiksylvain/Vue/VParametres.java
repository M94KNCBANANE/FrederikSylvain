package ca.cours5b5.frederiksylvain.Vue;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ca.cours5b5.frederiksylvain.Modeles.MParametres;
import ca.cours5b5.frederiksylvain.R;
import ca.cours5b5.frederiksylvain.Global.GConstantes;

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

    @Override
        protected void onFinishInflate(){

            super.onFinishInflate();


        Spinner monSpinnerHauteur = this.findViewById(R.id.spinnerHauteur);
        final ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        monSpinnerHauteur.setAdapter(adapterHauteur);

        adapterHauteur.addAll(MParametres.instance.getChoixHauteur());

        monSpinnerHauteur.setSelection(adapterHauteur.getPosition(MParametres.instance.getHauteur()));
        monSpinnerHauteur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int choix = (Integer) adapterView.getAdapter().getItem(i);
                MParametres.instance.setHauteur(choix);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Spinner monSpinnerLargeur = this.findViewById(R.id.spinnerLargeur);
        ArrayAdapter<Integer> adapterLargeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        monSpinnerLargeur.setAdapter(adapterLargeur);

        adapterLargeur.addAll(MParametres.instance.getChoixLargeur());

        monSpinnerLargeur.setSelection(adapterLargeur.getPosition(MParametres.instance.getLargeur()));
        monSpinnerLargeur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int choix = (Integer) adapterView.getAdapter().getItem(i);
                MParametres.instance.setLargeur(choix);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Spinner monSpinnerGagner = this.findViewById(R.id.spinnerGagner);
        ArrayAdapter<Integer> adapterGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        monSpinnerGagner.setAdapter(adapterGagner);
        adapterGagner.addAll(MParametres.instance.getChoixPourGagner());
        monSpinnerGagner.setSelection(adapterGagner.getPosition(MParametres.instance.getPourGagner()));
        monSpinnerGagner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int choix = (Integer) adapterView.getAdapter().getItem(i);
                Log.d("test", "test" + choix);
                MParametres.instance.setPourGagner(choix);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Log.d("atelier04", VParametres.class.getSimpleName() + "::onFinishInflate");
    }
}
