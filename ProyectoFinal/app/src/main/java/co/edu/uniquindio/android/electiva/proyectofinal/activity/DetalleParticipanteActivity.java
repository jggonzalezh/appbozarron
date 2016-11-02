package co.edu.uniquindio.android.electiva.proyectofinal.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.edu.uniquindio.android.electiva.proyectofinal.R;
import co.edu.uniquindio.android.electiva.proyectofinal.fragments.DetalleParticipanteFragment;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Participante;

public class DetalleParticipanteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_participante);


        DetalleParticipanteFragment detalleParticipante = (DetalleParticipanteFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_participante);
        Participante participante = (Participante) getIntent().getExtras().get("par");
        detalleParticipante.mostrarParticipante(participante);
    }
}
