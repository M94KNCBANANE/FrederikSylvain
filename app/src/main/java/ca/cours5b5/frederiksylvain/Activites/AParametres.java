package ca.cours5b5.frederiksylvain.Activites;

import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ca.cours5b5.frederiksylvain.R;

public class AParametres extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
    }

    static{
        Log.d("atelier04", AParametres.class.getSimpleName() + "::static");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("atelier04", AParametres.class.getSimpleName() + "::onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("atelier04", AParametres.class.getSimpleName() + "::onPause");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("atelier04", AParametres.class.getSimpleName() + "::onSaveInstanceState");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d("atelier04", AParametres.class.getSimpleName() + "::onDestroy");
    }
}
