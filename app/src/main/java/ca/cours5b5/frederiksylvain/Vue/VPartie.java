package ca.cours5b5.frederiksylvain.Vue;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.frederiksylvain.Modeles.MPartie;
import ca.cours5b5.frederiksylvain.Modeles.Modele;

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
    }

    private void initialiser(){

    }

    private void observerPartie(){

    }

    private MPartie getPartie(Modele modele){
        return null;
    }

    private void initialiserGrille(MPartie partie){

    }
}
