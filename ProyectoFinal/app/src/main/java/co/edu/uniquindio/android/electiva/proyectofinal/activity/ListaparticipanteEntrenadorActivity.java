package co.edu.uniquindio.android.electiva.proyectofinal.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.edu.uniquindio.android.electiva.proyectofinal.R;
import co.edu.uniquindio.android.electiva.proyectofinal.fragments.ListaParticipanteEntrenadorFragment;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Entrenador;

public class ListaparticipanteEntrenadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaparticipante_entrenador);

        ListaParticipanteEntrenadorFragment listaParticipanteEntre = (ListaParticipanteEntrenadorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_participante_entre);
        Entrenador entrenador = (Entrenador) getIntent().getExtras().get("ent");
        listaParticipanteEntre.mostrarEntrenador(entrenador);
    }
}
