package ca.cours5b5.frederiksylvain.Vue;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.frederiksylvain.Activites.AMenuPrincipal;

public abstract class Vue extends ConstraintLayout {


    static{
        Log.d("atelier04", Vue.class.getSimpleName() + "::static");
    }
    public Vue(Context context){
        super(context);
    }

    public Vue(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public Vue(Context context, AttributeSet attrs, int defStyleAttr){
        super(context,attrs,defStyleAttr);
    }


}
