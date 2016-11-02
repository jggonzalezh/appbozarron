package co.edu.uniquindio.android.electiva.proyectofinal.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.proyectofinal.R;
import co.edu.uniquindio.android.electiva.proyectofinal.util.AdaptadorDeFunciones;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoDeFuncionesFragment extends Fragment  implements  AdaptadorDeFunciones.OnClickAdaptadorDeFuncion {

    ArrayList<String> funciones;
    RecyclerView listadoDeFunciones;

    AdaptadorDeFunciones adaptador;


    /**
     * Es una referencia de la  interfaz  nFuncionSeleccionadoListener
     * este apuntara a la actividad que es la que implementa la interfaz
     * y asi el fragmento podra comunicarse con la interfaz
     */
    private OnFuncionSeleccionadoListener listener;



    /**
     * Es la definicion de una interfaz que permitira al fragmento  comunicarse  con su su actividad
     *la actividad debera implementar esta interfaz y sobreescribir el metodo
     * El Fragmento captura la implementación de la interfaz durante su ciclo de vida onAttach método () y luego se puede llamar a los métodos de
     * interfaz con el fin de comunicarse con la actividad.
     */
    public interface OnFuncionSeleccionadoListener {

        //Metodo de la interfaz  este debe ser sobreescrito en la actividad que implementara la interfaz
        void onFuncionSeleccionado(int pos);
    }


    public ListadoDeFuncionesFragment() {
        // Required empty public constructor
    }



    /**
     * El sistema llama a este callback cuando se crea el fragmento
     * se deberían inicializar todos los elementos esenciales que el fragmento
     * requiere mantener mientras está en pausa o detenido, y después reanudado
     * @param savedInstanceState un bundle para mantener el estado del fragmento
     */
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        funciones = new ArrayList();
        funciones.add("Equipos");
        funciones.add("Entrenadores");
        funciones.add("Participantes");
        funciones.add("Votar");
    }


    /**
     * El sistema llama a este callback cuando es el momento de que se dibuje la interfaz para el fragmento.
     * Debe devolver un View  es la raíz del layout del fragmento, o null en caso de no necesitar layout.
     * @param inflater  objeto para inflar los view objects
     * @param container
     * @param savedInstanceState
     * @return View es la raíz del layout del fragmento,
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listado_de_funciones, container, false);
    }

    /**
     * El sistema llama a este callback  cuando el método <<onCreate>> de la actividad termina de ejecutarse
     * @param savedInstanceState
     */

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listadoDeFunciones= (RecyclerView) getView().findViewById(R.id.listaFunciones);

        adaptador = new AdaptadorDeFunciones(funciones,this);

        listadoDeFunciones.setAdapter(adaptador);

        listadoDeFunciones.setLayoutManager(         new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }


    /**
     * El sistema llama a este callbackes  cuando el fragmento es asociado con la actividad
     * @param context es el contexto de la actividad
     */
    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        Activity activity;

        if (context instanceof Activity) {
            activity = (Activity) context;
            try {


                //se asocia a la referencia de la interfaz  la actividad que debe haber implementado la interfaz
                listener = (OnFuncionSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                //En caso de que la actividad no haya implementado la interfaz arrojara unan excepción

                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnPersonajeSeleccionadoListener");
            }
        }
    }


    @Override
    public void onClickPosition(int pos) {
        listener.onFuncionSeleccionado(pos);
    }
}
