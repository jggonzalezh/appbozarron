package co.edu.uniquindio.android.electiva.proyectofinal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import co.edu.uniquindio.android.electiva.proyectofinal.R;
import co.edu.uniquindio.android.electiva.proyectofinal.fragments.ListaEntrenadoresFragment;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Entrenador;

public class EntrenadoresActivity extends AppCompatActivity implements ListaEntrenadoresFragment.OnEntrenadorSeleccionadoListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenadores);
    }

    /**
     * Metodo que permite inflar el menu
     *
     * @param menu es el menu que se va a inflar
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is presented
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onEntrenadorSeleccionado(Entrenador entrenador) {

        Intent intent = new Intent(this, ListaparticipanteEntrenadorActivity.class);
        //le enviamos  el personaje a la  actividad
        intent.putExtra("ent",entrenador);
        startActivity(intent);

    }
}
