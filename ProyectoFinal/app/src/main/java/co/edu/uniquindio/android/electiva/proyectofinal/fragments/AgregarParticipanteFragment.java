package co.edu.uniquindio.android.electiva.proyectofinal.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.edu.uniquindio.android.electiva.proyectofinal.R;
import co.edu.uniquindio.android.electiva.proyectofinal.activity.ParticipantesActivity;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Participante;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarParticipanteFragment extends DialogFragment implements View.OnClickListener {


    private Button boton;
    private Button  botonFecha;
    private EditText nombre;
    private EditText url;


    /**
     * Es una referencia de la  interfaz  OnPersonajeSeleccionadoListener
     * este apuntara a la actividad que es la que implementa la interfaz
     * y asi el fragmento podra comunicarse con la interfaz
     */
    private OnParticipanteAgregadoListener listener;


    /**
     * Es la definicion de una interfaz que permitira al fragmento  comunicarse  con su su actividad
     *la actividad debera implementar esta interfaz y sobreescribir el metodo
     * El Fragmento captura la implementación de la interfaz durante su ciclo de vida onAttach método () y luego se puede llamar a los métodos de
     * interfaz con el fin de comunicarse con la actividad.
     */
    public interface OnParticipanteAgregadoListener {

        //Metodo de la interfaz  este debe ser sobreescrito en la actividad que implementara la interfaz
        void onParticipanteAgregado(Participante participante);
    }


    public AgregarParticipanteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().setTitle("Agregar Participante");//cargue el texto desde los recursos
        View view  =inflater.inflate(R.layout.fragment_agregar_participante, container, false);
        boton = (Button) view.findViewById(R.id.boton_agregar);
        botonFecha = (Button) view.findViewById(R.id.btn_fecha_a);
        nombre =(EditText) view.findViewById(R.id.txt_nombre_a);
        url = (EditText) view.findViewById(R.id.txt_url_a);
        boton.setOnClickListener(this);
        botonFecha.setOnClickListener(this);

        return  view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;

        if (context instanceof Activity){

            activity = (Activity) context;

            try {
                listener = (OnParticipanteAgregadoListener) activity;
            }catch (ClassCastException e){
                throw  new ClassCastException(activity.toString()+ " debe implementar la interfaz OnParticipanteAgregadoListener");
            }


        }
    }


    @Override
    public void onClick(View v) {


       if (boton.getId() == v.getId()) {

            Participante par=new Participante();

            par.setNombre(nombre.getText().toString());

            //-------------------------------------
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date fecha;
            String dateInString = "2014-09-15";
            try {
                fecha = sdf.parse(dateInString);
                par.setFecha(fecha);
            }catch (ParseException e){
                e.printStackTrace();
            }
            //------------------------------------------------
            par.setHistoria( "historia");
            par.setUrl(url.getText().toString());


            listener.onParticipanteAgregado(par);

            dismiss();
        }

        if (botonFecha.getId() == v.getId()) {
            ((ParticipantesActivity) getActivity()).mostrarDialogoDatePicker();

        }


    }

    public void setBotonFecha(int year, int month, int dayOfMonth) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String dateInString = "2014-09-15";
        Date fecha =new Date();

        String dateInString = year+"-"+month+"-"+dayOfMonth;
        try {
            fecha = sdf.parse(dateInString);
        }catch (ParseException e){
            e.printStackTrace();
        }

        botonFecha.setText(fecha.toString());
    }


}
