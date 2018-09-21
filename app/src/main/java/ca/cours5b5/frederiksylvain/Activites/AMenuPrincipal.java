package ca.cours5b5.frederiksylvain.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import ca.cours5b5.frederiksylvain.R;

public class AMenuPrincipal extends Activite {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        Log.d("atelier04", AMenuPrincipal.class.getSimpleName() + "::onCreate");
    }

    static{
        Log.d("atelier04", AMenuPrincipal.class.getSimpleName() + "::static");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("atelier04", AMenuPrincipal.class.getSimpleName() + "::onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("atelier04", AMenuPrincipal.class.getSimpleName() + "::onPause");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("atelier04", AMenuPrincipal.class.getSimpleName() + "::onSaveInstanceState");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d("atelier04", AMenuPrincipal.class.getSimpleName() + "::onDestroy");
    }

    public void test(View view){
         Intent intention = new Intent(this, AParametres.class);
        this.startActivity(intention);
    }
}
