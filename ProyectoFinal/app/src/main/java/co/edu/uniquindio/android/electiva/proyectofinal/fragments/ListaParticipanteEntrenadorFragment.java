package co.edu.uniquindio.android.electiva.proyectofinal.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.proyectofinal.R;
import co.edu.uniquindio.android.electiva.proyectofinal.util.AdaptadorDeParticipante;
import co.edu.uniquindio.android.electiva.proyectofinal.util.AdaptadorDeParticipanteEntrena;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Entrenador;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Participante;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaParticipanteEntrenadorFragment extends Fragment  implements View.OnClickListener{

    private TextView txtNombre;  //txt_nombre
    private ImageView imgEntre;//img_entrena_l


    private ArrayList<Participante> listaParticipantesEntrenador;
    private RecyclerView ListadoParticipantes;
    private AdaptadorDeParticipanteEntrena adaptador;

    private Entrenador entrenador;


    public ListaParticipanteEntrenadorFragment() {
        // Required empty public constructor
    }

    /**
     * El sistema llama a este callback cuando se crea el fragmento
     * se deberían inicializar todos los elementos esenciales que el fragmento
     * requiere mantener mientras está en pausa o detenido, y después reanudado
     * @param savedInstanceState un bundle para mantener el estado del fragmento
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_participante_entrenador, container, false);
    }




    public void mostrarEntrenador (Entrenador entrenador) {
        txtNombre =(TextView) getView().findViewById(R.id.txt_nombre_entrena_l); //txt_nombre
        String name =entrenador.getNombre();

        String adele="a";

        txtNombre.setText(name);

        imgEntre=(ImageView) getView().findViewById(R.id.img_entrena_l);//img_entrena_l




              if (name.equals("Adele")) {
                  imgEntre.setImageResource(R.drawable.adele_cir);
              }
              if (name.equals("Jhony Rivera"))
                  imgEntre.setImageResource(R.drawable.jhonny_cir);

             if (name.equals("Rihanna"))
                 imgEntre.setImageResource(R.drawable.rhiana_cir);







       ListadoParticipantes = (RecyclerView) getView().findViewById(R.id.listaParticipantesEntrenador);
        // Es el adaptador  para el RecyclerView

        listaParticipantesEntrenador= new ArrayList<Participante>();

        listaParticipantesEntrenador = (ArrayList<Participante>) entrenador.getParticipanteEntrena();

        int num=listaParticipantesEntrenador.size();



        txtNombre.setText(String.valueOf(num));

        adaptador = new AdaptadorDeParticipanteEntrena(listaParticipantesEntrenador,this);

        // Se adiciona el adaptador al Recyclerview
        ListadoParticipantes.setAdapter(adaptador);

        //Este es el layout para el Recyclerview
        ListadoParticipantes.setLayoutManager( new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));


        txtNombre.setOnClickListener(this);
    }












    @Override
    public void onClick(View v) {

    }
}
