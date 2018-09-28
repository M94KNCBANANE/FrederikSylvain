package ca.cours5b5.frederiksylvain.Vue;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.frederiksylvain.Activites.AMenuPrincipal;
import ca.cours5b5.frederiksylvain.Activites.AParametres;
import ca.cours5b5.frederiksylvain.Global.GCommande;
import ca.cours5b5.frederiksylvain.R;
import ca.cours5b5.frederiksylvain.controleurs.Action;
import ca.cours5b5.frederiksylvain.controleurs.ControleurAction;

public class VMenuPrincipal extends Vue {

    public VMenuPrincipal(Context context){
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr){
        super(context,attrs,defStyleAttr);
    }

    static{
        Log.d("atelier04", VMenuPrincipal.class.getSimpleName() + "::static");
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("atelier04", VMenuPrincipal.class.getSimpleName() + "::onFinishInflate");
        Button bouttonParametres =  this.findViewById(R.id.parametres);
        bouttonParametres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Action actionParametres = ControleurAction.demanderAction(GCommande.OUVRIR_MENU_PARAMETRES);
                actionParametres.executerDesQuePossible();
            }
        });

        Button bouttonJouer=  this.findViewById(R.id.jouer);
        bouttonJouer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Action actionJouer = ControleurAction.demanderAction(GCommande.OUVRIR_JOUER);
                actionJouer.executerDesQuePossible();
            }
        });
    }
}
