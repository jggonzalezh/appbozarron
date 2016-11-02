package co.edu.uniquindio.android.electiva.proyectofinal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import co.edu.uniquindio.android.electiva.proyectofinal.R;
import co.edu.uniquindio.android.electiva.proyectofinal.fragments.AgregarParticipanteFragment;
import co.edu.uniquindio.android.electiva.proyectofinal.fragments.DatePickerFragment;
import co.edu.uniquindio.android.electiva.proyectofinal.fragments.ListaParticipantesFragment;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Participante;

public class ParticipantesActivity extends AppCompatActivity  implements ListaParticipantesFragment.OnParticipanteSeleccionadoListener , AgregarParticipanteFragment.OnParticipanteAgregadoListener ,DatePickerFragment.OnFechaSeleccionadaListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participantes);
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


    /**
     * Este es el metodo que se sobreescribe de la interfaz implementada onParticiapanteSeleccionado
     * Este metodo permite mostrar el detalle de un personaje cuando sea seleccionado de la lista de personajes
     * @param
     */

    @Override
    public void onParticiapanteSeleccionado(Participante participante) {

        Intent intent = new Intent(this, DetalleParticipanteActivity.class);
        //le enviamos  el personaje a la  actividad
        intent.putExtra("par",participante);
        startActivity(intent);

    }


    public void mostrarDialigoAgregarParticipante(String nombreClase) {

        AgregarParticipanteFragment dialogAgreParticipante = new AgregarParticipanteFragment();
        dialogAgreParticipante.setStyle(dialogAgreParticipante.STYLE_NORMAL, R.style.DialogoTitulo);
        dialogAgreParticipante.show(getSupportFragmentManager(), nombreClase);
    }

    public void mostrarDialogoDatePicker() {

        DatePickerFragment dialogsDatePicker = new DatePickerFragment();
        dialogsDatePicker.show(getSupportFragmentManager(), "datePicker");


    }


    @Override
    public void onParticipanteAgregado(Participante participante) {
        ((ListaParticipantesFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_participantes)).agregarParticipante(participante);
    }


    @Override
    public void onFechaSelecionada(int year, int month, int dayOfMonth) {

        String name= ListaParticipantesFragment.class.getName();
        ((AgregarParticipanteFragment) getSupportFragmentManager().findFragmentByTag(name)).setBotonFecha(year,month,dayOfMonth);
        Log.v("el tag",name);
    }

}