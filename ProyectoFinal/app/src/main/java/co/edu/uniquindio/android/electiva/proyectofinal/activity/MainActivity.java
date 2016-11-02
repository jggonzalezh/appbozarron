package co.edu.uniquindio.android.electiva.proyectofinal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import co.edu.uniquindio.android.electiva.proyectofinal.R;
import co.edu.uniquindio.android.electiva.proyectofinal.fragments.ListaParticipanteEntrenadorFragment;
import co.edu.uniquindio.android.electiva.proyectofinal.fragments.ListadoDeFuncionesFragment;
import co.edu.uniquindio.android.electiva.proyectofinal.util.AdaptadorDeFunciones;

public class MainActivity extends AppCompatActivity implements ListadoDeFuncionesFragment.OnFuncionSeleccionadoListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onFuncionSeleccionado(int pos) {


        if (pos == 0){
        Intent intent = new Intent(this, EquiposActivity.class);
        startActivity(intent);
        }

        if (pos == 1){
            Intent intent = new Intent(this, EntrenadoresActivity.class);
            startActivity(intent);
        }

        if (pos == 2){
            Intent intent = new Intent(this, ParticipantesActivity.class);
            startActivity(intent);
        }

    }
}