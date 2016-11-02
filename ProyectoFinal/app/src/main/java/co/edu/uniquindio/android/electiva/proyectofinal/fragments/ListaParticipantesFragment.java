package co.edu.uniquindio.android.electiva.proyectofinal.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;

import co.edu.uniquindio.android.electiva.proyectofinal.R;
import co.edu.uniquindio.android.electiva.proyectofinal.activity.ParticipantesActivity;
import co.edu.uniquindio.android.electiva.proyectofinal.util.AdaptadorDeParticipante;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Participante;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaParticipantesFragment extends Fragment implements  AdaptadorDeParticipante.OnClickAdaptadorDeParticipante {


    private ArrayList <Participante> participantes;
    private RecyclerView ListadoParticipantes;
    private AdaptadorDeParticipante adaptador;


    /**
     * Es una referencia de la  interfaz OnParticipanteSeleccionadoListener
     * este apuntara a la actividad que es la que implementa la interfaz
     * y asi el fragmento podra comunicarse con la interfaz
     */
    private OnParticipanteSeleccionadoListener  listener;


    /**
     * Es la definicion de una interfaz que permitira al fragmento  comunicarse  con su su actividad
     *la actividad debera implementar esta interfaz y sobreescribir el metodo
     * El Fragmento captura la implementación de la interfaz durante su ciclo de vida onAttach método () y luego se puede llamar a los métodos de
     * interfaz con el fin de comunicarse con la actividad.
     */
    public interface OnParticipanteSeleccionadoListener {

        //Metodo de la interfaz  este debe ser sobreescrito en la actividad que implementara la interfaz
        void onParticiapanteSeleccionado(Participante participante);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        // Se inicializa la lista
        participantes = new ArrayList();

        //Se crea  la lista de personajes

        participantes.add(new Participante("Juan", new
                Date(System.currentTimeMillis()),
                "Estudiante"
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk","Estudiante" )  );

        participantes.add(new Participante("Pedro", new
                Date(System.currentTimeMillis()),
                "Profesor"
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk","Profesor" )  );

        participantes.add(new Participante("Pepe", new
                Date(System.currentTimeMillis()),
                "Estudiante"
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk","Estudiante" )  );

        participantes.add(new Participante("Einer", new
                Date(System.currentTimeMillis()),
                "Profesor"
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk","Profesor" )  );

        participantes.add(new Participante("Diana", new
                Date(System.currentTimeMillis()),
                "Estudiante"
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk","Estudiante" )  );

        participantes.add(new Participante("Claudia", new
                Date(System.currentTimeMillis()),
                "Profesor"
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk","Profesor" )  );


    }




    public ListaParticipantesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_participantes, container, false);
    }


    /**
     * El sistema llama a este callback  cuando el método <<onCreate>> de la actividad termina de ejecutarse
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        ListadoParticipantes = (RecyclerView) getView().findViewById(R.id.listaParticipantes);

        // Es el adaptador  para el RecyclerView
        adaptador = new AdaptadorDeParticipante(participantes,this);

        // Se adiciona el adaptador al Recyclerview
        ListadoParticipantes.setAdapter(adaptador);

        //Este es el layout para el Recyclerview
        ListadoParticipantes.setLayoutManager( new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }


    /**
     * Es el metodo que permite escuchar los eventos del menu
     * @param item  el item del menu  en el que  se hizo click
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //es el id del item
        int id = item.getItemId();


        //Si se dio click en agregar
        if (id == R.id.menu_agregar) {


            ((ParticipantesActivity) getActivity()).mostrarDialigoAgregarParticipante(ListaParticipantesFragment.class.getName());

        }
        //Si se dio click en eliminar
        if (id == R.id.menu_eliminar) {
            participantes.remove(1);
            adaptador.notifyItemRemoved(1);
        }
        if (id == R.id.menu_modificar) {
            Participante aux = participantes.get(1);
            participantes.set(1,participantes.get(2));
            participantes.set(2, aux);
            adaptador.notifyItemMoved(1, 2);
        }

        return super.onOptionsItemSelected(item);




    }


    public  void agregarParticipante(Participante participante){

        participantes.add(participante);
        adaptador.notifyItemInserted(0);


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
                listener = (OnParticipanteSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                //En caso de que la actividad no haya implementado la interfaz arrojara unan excepción

                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnParticipanteSeleccionadoListener");
            }
        }
    }


    /**
     * Metodo que permite  inicializar la lista de participantes
     * @param participantes una lista de personajes
     */
    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    /**
     * Metodo que permite obtener la lista de participantes
     * @return   ArrayList<Personaje>  la lista de personajes obtenida
     */
    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    /**
     * Este el el metodo que se debe sobreescribir de la interface OnClickAdaptadorDePersonaje
     * este recibe el evento mandado desde el adaptador
     * ya que el adaptador tiene una referencia al fragmento
     * pues el fragmento implementa la interface que se declaro en el adaptador
     */
    @Override
    public void onClickPosition(int pos) {

        Participante par=participantes.get(pos);

        //el listener es una referencia a la actividad
        // se le comunica el evento a la actividad
        listener.onParticiapanteSeleccionado(par);
    }



}
