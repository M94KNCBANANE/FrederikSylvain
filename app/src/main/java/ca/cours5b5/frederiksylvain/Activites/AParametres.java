package ca.cours5b5.frederiksylvain.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ca.cours5b5.frederiksylvain.R;

public class AParametres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        Log.d("MonEtiquette",this.getResources().getString(R.string.Bonjour) + this.getResources().getString(R.string.Ori));
    }
}
