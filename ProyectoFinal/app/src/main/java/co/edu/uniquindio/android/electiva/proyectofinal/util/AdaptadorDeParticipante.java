package co.edu.uniquindio.android.electiva.proyectofinal.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.proyectofinal.R;
import co.edu.uniquindio.android.electiva.proyectofinal.fragments.ListaParticipanteEntrenadorFragment;
import co.edu.uniquindio.android.electiva.proyectofinal.fragments.ListaParticipantesFragment;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Participante;

/**
 * Created by Juan on 01/11/2016.
 */

public class AdaptadorDeParticipante  extends  RecyclerView.Adapter<AdaptadorDeParticipante.ParticipanteViewHolder> {


    //las lista de participantes o conjunto de datos del adptador
    private ArrayList<Participante> participantes;
    //Es una referencia de la interfaza que apuntara al fragmento que implementara la interfaz
    private static OnClickAdaptadorDeParticipante listener;

    /**
     * Es la definicion de una interfaz que permitira al adaptador  comunicarse  el fragmento  ListaParticipantesFragment que tiene el reciclerview
     * el fragmento debera implementar esta interfaz y sobreescribir el metodo
     */
    public interface OnClickAdaptadorDeParticipante{
        public void onClickPosition(int pos);
    }

    /**
     * Constructor del adaptador
     * @param
     * @param
     */
    public AdaptadorDeParticipante(ArrayList<Participante> personajes, ListaParticipantesFragment listaParticipantesFragment) {
        this.participantes = personajes;
        listener = (OnClickAdaptadorDeParticipante) listaParticipantesFragment;
    }







    /**
     * El sistema llama a este callback cuando se cree el viewholder
     * @param parent
     * @param viewType
     * @return  PersonajeViewHolder el viewholder del adaptador
     */
    @Override
    public ParticipanteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Aqui asocia una vista al viewholder
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_participante, parent, false);

        ParticipanteViewHolder participanteVH = new ParticipanteViewHolder(itemView);

        return participanteVH;


    }

    @Override
    public void onBindViewHolder(ParticipanteViewHolder holder, int position) {

        Participante participante = participantes.get(position);
        holder.binParticipante(participante);

    }

    @Override
    public int getItemCount() {
        return participantes.size();
    }

    /**
     * Clase que modela un viewholder para el adaptador
     * esta es la que permite mantener implementar el patron  ViewHolder
     *
     */
    public static class ParticipanteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /**
         * Atributos que tiene que mantener el view holder  un item de la lista
         */
        private TextView txtNombreParticipante;
        private TextView txtRelacion;




        /**
         * Constructor
         * @param itemView  es  la vista del viewholder
         */
        public ParticipanteViewHolder(View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);


            txtRelacion = (TextView) itemView.findViewById(R.id.relacion);
            txtNombreParticipante= (TextView) itemView.findViewById(R.id.nombre);


        }

        /**
         * Metodo que permite pner el nombre  y la fecha de nacimiento en la vista
         * @param
         */
        public void binParticipante(Participante participante) {
            txtNombreParticipante.setText(participante.getNombre());
            txtRelacion.setText(participante.getRelacionUniversidad());
        }


        /**
         * Es el metodo que permite que se escucho el evento click de los items de la lista
         * @param v  la vista en la que hizo el click
         */
        @Override
        public void onClick(View v) {
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. "+ txtNombreParticipante.getText());

            //Cuando le click al item  este llama al metodo del fragmento
            //recordemos que el fragmento implementa la interfaz
            //por aqui el adaptador le comunica al fragmento del evento
            listener.onClickPosition(getAdapterPosition());


        }
    }





}
