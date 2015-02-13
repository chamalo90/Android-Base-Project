package com.android.base.baseapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity { // Point d'entrée de l'application

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Code exécuté au lancement de l'activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Lien vers le .xml (détail du contenu graphique), pour le trouver, onglet ressources ('res'), puis 'layout'
        Button buttonOne = (Button) findViewById(R.id.button); // Création d'un objet bouton - le lier au bouton "graphique" placé dans le xml au préalable
        buttonOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) { // Ajout d'un listener sur ce bouton, code éxécuté lorsqu'il est pressé.
                Intent myIntent = new Intent(MainActivity.this, MenuActivity.class); // Création d'une nouvelle activité
                myIntent.putExtra("key", "coucou"); // Passage de contenu entre activité, ici une chaine de caractère inutile :p
                MainActivity.this.startActivity(myIntent); // Démarrage de la nouvelle activité
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // code exécuté lorsque le bouton menu est pressé
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
