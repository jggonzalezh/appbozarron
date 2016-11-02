package co.edu.uniquindio.android.electiva.proyectofinal.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.proyectofinal.R;
import co.edu.uniquindio.android.electiva.proyectofinal.fragments.ListaEntrenadoresFragment;
import co.edu.uniquindio.android.electiva.proyectofinal.fragments.ListaParticipantesFragment;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Entrenador;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Participante;

/**
 * Created by Juan on 01/11/2016.
 */

public class AdaptadorDeEntrenador extends RecyclerView.Adapter<AdaptadorDeEntrenador.EntrenadorViewHolder> {


    //las lista de participantes o conjunto de datos del adptador
    private ArrayList<Entrenador> entrenadores;
    //Es una referencia de la interfaza que apuntara al fragmento que implementara la interfaz
    private static  OnClickAdaptadorDeEntrenador listener;

    /**
     * Es la definicion de una interfaz que permitira al adaptador  comunicarse  el fragmento  ListaParticipantesFragment que tiene el reciclerview
     * el fragmento debera implementar esta interfaz y sobreescribir el metodo
     */
    public interface OnClickAdaptadorDeEntrenador{
        public void onClickPosition(int pos);
    }

    /**
     * Constructor del adaptador
     * @param
     * @param
     */
    public AdaptadorDeEntrenador(ArrayList<Entrenador> entrenadores, ListaEntrenadoresFragment listaEntrenadoresFragment) {
        this.entrenadores = entrenadores;
        listener = (OnClickAdaptadorDeEntrenador) listaEntrenadoresFragment;
    }




    /**
     * El sistema llama a este callback cuando se cree el viewholder
     * @param parent
     * @param viewType
     * @return  PersonajeViewHolder el viewholder del adaptador
     */
    @Override
    public EntrenadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Aqui asocia una vista al viewholder
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_entrenador, parent, false);

        AdaptadorDeEntrenador.EntrenadorViewHolder entranadorVH = new EntrenadorViewHolder(itemView);

        return entranadorVH;


    }

    @Override
    public void onBindViewHolder(AdaptadorDeEntrenador.EntrenadorViewHolder holder, int position) {

        Entrenador entrenador = entrenadores.get(position);
        holder.binEntrenador(entrenador,position);

    }

    @Override
    public int getItemCount() {
        return entrenadores.size();
    }

    /**
     * Clase que modela un viewholder para el adaptador
     * esta es la que permite mantener implementar el patron  ViewHolder
     *
     */
    public static class EntrenadorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /**
         * Atributos que tiene que mantener el view holder  un item de la lista
         */
        private TextView txtNombreEntrenador;
        private ImageView imgEntrenador;





        /**
         * Constructor
         * @param itemView  es  la vista del viewholder
         */
        public EntrenadorViewHolder(View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);



            txtNombreEntrenador= (TextView) itemView.findViewById(R.id.nombre_entrenador);
            imgEntrenador=(ImageView) itemView.findViewById(R.id.imagen_entrenador);


        }

        /**
         * Metodo que permite pner el nombre  y la fecha de nacimiento en la vista
         * @param
         */
        public void binEntrenador(Entrenador entrenador,int pos) {
            txtNombreEntrenador.setText(entrenador.getNombre());


            switch (pos){

                case 0:
                    imgEntrenador.setImageResource(R.drawable.adele_cir);
                    break;
                case 1:
                    imgEntrenador.setImageResource(R.drawable.jhonny_cir);
                    break;

                case 2:
                    imgEntrenador.setImageResource(R.drawable.rhiana_cir);
                    break;


                default: imgEntrenador.setImageResource(R.mipmap.ic_entrena_p);
                    break;

            }





        }


        /**
         * Es el metodo que permite que se escucho el evento click de los items de la lista
         * @param v  la vista en la que hizo el click
         */
        @Override
        public void onClick(View v) {
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. "+ txtNombreEntrenador.getText());

            //Cuando le click al item  este llama al metodo del fragmento
            //recordemos que el fragmento implementa la interfaz
            //por aqui el adaptador le comunica al fragmento del evento
            listener.onClickPosition(getAdapterPosition());


        }
    }




}
