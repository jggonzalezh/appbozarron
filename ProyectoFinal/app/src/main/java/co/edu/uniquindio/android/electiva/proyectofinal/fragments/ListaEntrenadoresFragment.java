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
import co.edu.uniquindio.android.electiva.proyectofinal.util.AdaptadorDeEntrenador;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Entrenador;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Participante;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaEntrenadoresFragment extends Fragment   implements  AdaptadorDeEntrenador.OnClickAdaptadorDeEntrenador{

    private ArrayList<Entrenador> entrenadores;
    private RecyclerView ListadoEntrenadores;
    private AdaptadorDeEntrenador adaptador;

    /**
     * Es una referencia de la  interfaz
     * este apuntara a la actividad que es la que implementa la interfaz
     * y asi el fragmento podra comunicarse con la interfaz
     */
    private OnEntrenadorSeleccionadoListener  listener;




    /**
     * Es la definicion de una interfaz que permitira al fragmento  comunicarse  con su su actividad
     *la actividad debera implementar esta interfaz y sobreescribir el metodo
     * El Fragmento captura la implementación de la interfaz durante su ciclo de vida onAttach método () y luego se puede llamar a los métodos de
     * interfaz con el fin de comunicarse con la actividad.
     */
    public interface OnEntrenadorSeleccionadoListener {

        //Metodo de la interfaz  este debe ser sobreescrito en la actividad que implementara la interfaz
        void onEntrenadorSeleccionado(Entrenador entrenador);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        // Se inicializa la lista
        entrenadores = new ArrayList();


        ArrayList<Participante> entrenaUno = new ArrayList<Participante>();

        entrenaUno.add(new Participante("Juan", new
                Date(System.currentTimeMillis()),
                "Estudiante"
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk","Estudiante" )  );

        entrenaUno.add(new Participante("Pedro", new
                Date(System.currentTimeMillis()),
                "Profesor"
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk","Estudiante" )  );


        //Se crea  la lista de personajes
        entrenadores.add(new Entrenador("Adele", "Pop",
                "conocida simplemente como Adele, es una cantante y compositora británica. Desde muy joven mostró" +
                        " su interés por la música y en 2006 egresó de la BRIT School de Artes Escénicas y Tecnología," +
                        " año en el firmó un contrato con XL Recordings."
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk",entrenaUno )  );



        ArrayList<Participante> entrenaDos = new ArrayList<Participante>();

        entrenaDos.add(new Participante("Pepe", new
                Date(System.currentTimeMillis()),
                "Estudiante"
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk","Estudiante" )  );

        entrenaDos.add(new Participante("Einer", new
                Date(System.currentTimeMillis()),
                "Profesor"
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk","Estudiante" )  );




        entrenadores.add(new Entrenador("Jhony Rivera", "Popular",
                "Su vena artística se notó desde pequeño cuando se le facilitaba componer trovas, coplas y poesías." +
                        " Una desilusión amorosa lo llevó a componer su primer éxito El Dolor de Una Partida que empezó" +
                        " a sonar en su natal Pereira, desde ahí fue pegando cada una de sus canciones hacia todo " +
                        "los rincones del país."
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk" ,entrenaDos)  );


        ArrayList<Participante> entrenaTres = new ArrayList<Participante>();

        entrenaTres.add(new Participante("Diana", new
                Date(System.currentTimeMillis()),
                "Estudiante"
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk","Estudiante" )  );

        entrenaTres.add(new Participante("Claudia", new
                Date(System.currentTimeMillis()),
                "Profesor"
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk","Estudiante" )  );


        entrenadores.add(new Entrenador("Rihanna", "R & B   ",
                "Robyn Rihanna Fenty (Bridgetown, 20 de febrero de 1988), conocida simplemente como Rihanna," +
                        " es una cantante, actriz y diseñadora de moda barbadense. Comenzó su carrera en el 2003 " +
                        "cuando audicionó para el productor musical Evan Rogers. A la edad de dieciséis," +
                        " Rogers, decidió llevarla a los Estados Unidos para grabar maquetas. "
                ,"https://www.youtube.com/watch?v=7IBERQ9abkk" ,entrenaTres)  );


    }

    public ListaEntrenadoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_entrenadores, container, false);
    }

    /**
     * El sistema llama a este callback  cuando el método <<onCreate>> de la actividad termina de ejecutarse
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        ListadoEntrenadores = (RecyclerView) getView().findViewById(R.id.listaEntranadores);

        // Es el adaptador  para el RecyclerView
        adaptador = new AdaptadorDeEntrenador(entrenadores,this);

        // Se adiciona el adaptador al Recyclerview
        ListadoEntrenadores.setAdapter(adaptador);

        //Este es el layout para el Recyclerview
        ListadoEntrenadores.setLayoutManager( new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        //es el id del item
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);




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
                listener = (OnEntrenadorSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                //En caso de que la actividad no haya implementado la interfaz arrojara unan excepción

                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnEntrenadorSeleccionadoListener");
            }
        }
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }


    @Override
    public void onClickPosition(int pos) {

        Entrenador ent=entrenadores.get(pos);

        //el listener es una referencia a la actividad
        // se le comunica el evento a la actividad
        listener.onEntrenadorSeleccionado(ent);
    }
}
