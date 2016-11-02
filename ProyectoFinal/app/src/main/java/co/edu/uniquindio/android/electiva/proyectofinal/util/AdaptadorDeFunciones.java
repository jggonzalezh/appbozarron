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
import co.edu.uniquindio.android.electiva.proyectofinal.fragments.ListadoDeFuncionesFragment;


/**
 * Created by Juan on 25/10/2016.
 */

public class AdaptadorDeFunciones   extends  RecyclerView.Adapter<AdaptadorDeFunciones.FuncionViewHolder> {


    //las lista de funciones de la interfaz principal del adptador
    private ArrayList<String> funciones;
    //Es una referencia de la interfaz que apuntara al fragmento que implementara la interfaz
    private static OnClickAdaptadorDeFuncion listener;

    /**
     * Es la definicion de una interfaz que permitira al adaptador  comunicarse  el fragmento  que tiene el reciclerview
     * el fragmento debera implementar esta interfaz y sobreescribir el metodo
     */
    public interface OnClickAdaptadorDeFuncion{
        public void onClickPosition(int pos);
    }

    public AdaptadorDeFunciones(ArrayList<String> funciones, ListadoDeFuncionesFragment listadoDeFuncionesFragment) {
        this.funciones = funciones;

        listener=(OnClickAdaptadorDeFuncion)listadoDeFuncionesFragment;
    }



    /**
     * El sistema llama a este callback cuando se cree el viewholder
     * @param parent
     * @param viewType
     * @return  FuncionViewHolder el viewholder del adaptador
     */
    @Override
    public FuncionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Aqui asocia una vista al viewholder
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_funciones, parent, false);

        //Se crea el viewholder
        FuncionViewHolder   func = new FuncionViewHolder(itemView);

        return func;


    }

    @Override
    public void onBindViewHolder(FuncionViewHolder holder, int position) {

        String funcion = funciones.get(position);
        holder.binFuncion(funcion,position);


    }



    @Override
    public int getItemCount() {
        return  funciones.size();
    }

    /**
     * Clase que modela un viewholder para el adaptador
     * esta es la que permite mantener implementar el patron  ViewHolder
     *
     */
    public static class FuncionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /**
         * Atributos que tiene que mantener el view holder  un item de la lista
         */
        private TextView titulo;
        private ImageView img;


        /**
         * Constructor
         * @param itemView  es  la vista del viewholder
         */
        public FuncionViewHolder(View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
            img = (ImageView) itemView.findViewById(R.id.imagen);
        }

        /**
         * Metodo que permite pner el nombre  y la fecha de nacimiento en la vista
         * @param
         */
        public void binFuncion(String funcion,int pos) {
            titulo.setText(funcion);

            switch (pos){

                case 0:
                    img.setImageResource(R.mipmap.ic_equipo);
                    break;
                case 1:
                    img.setImageResource(R.mipmap.ic_equipo);
                    break;

                case 2:
                    img.setImageResource(R.mipmap.ic_parti);
                    break;
                case 3:
                    img.setImageResource(R.mipmap.ic_vote);
                    break;

                default: img.setImageResource(R.mipmap.ic_equipo);
                    break;

            }




        }


        /**
         * Es el metodo que permite que se escucho el evento click de los items de la lista
         * @param v  la vista en la que hizo el click
         */
        @Override
        public void onClick(View v) {
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. "+ titulo.getText());

            //Cuando le click al item  este llama al metodo del fragmento
            //recordemos que el fragmento implementa la interfaz
            //por aqui el adaptador le comunica al fragmento del evento
            listener.onClickPosition(getAdapterPosition());


        }
    }

}
