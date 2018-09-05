package ca.cours5b5.frederiksylvain.Activites;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public abstract class Activite extends AppCompatActivity{

    static{
        Log.d("atelier04", Activite.class.getSimpleName() + "::static");
    }
}
