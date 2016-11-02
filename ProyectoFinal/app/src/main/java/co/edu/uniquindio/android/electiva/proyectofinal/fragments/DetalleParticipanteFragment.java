package co.edu.uniquindio.android.electiva.proyectofinal.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.proyectofinal.R;
import co.edu.uniquindio.android.electiva.proyectofinal.vo.Participante;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleParticipanteFragment extends Fragment  implements View.OnClickListener {

    //Atributos de clase del fragmento
    private TextView txtNombre;  //txt_nombre
    private TextView txtedad;//txt_edad
    private TextView txtentrena;//  txt_entrena
    private TextView txtrelacion;//txt_relacion
    private TextView txtvotos;//txt_votos
    private TextView txtvideo;//txt_video
    private TextView txtestado;//txt_estado

    private Participante participante;



    public DetalleParticipanteFragment() {
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

       return inflater.inflate(R.layout.fragment_detalle_participante, container, false);

    }



    public void mostrarParticipante (Participante participante) {

        this.participante=participante;

        txtNombre = (TextView) getView().findViewById(R.id.txt_nombre); //txt_nombre
        txtNombre.setText(participante.getNombre());

        txtedad = (TextView) getView().findViewById(R.id.txt_edad); //txt_edad
        txtedad.setText("20");

        txtentrena = (TextView) getView().findViewById(R.id.txt_entrena); //txt_entrena
        txtentrena.setText("arreglar");

        txtrelacion= (TextView) getView().findViewById(R.id.txt_entrena);//txt_relacion
        txtrelacion.setText(participante.getRelacionUniversidad());
        txtvotos =(TextView) getView().findViewById(R.id.txt_votos);//txt_votos
        txtvotos.setText("100");
        txtvideo=(TextView) getView().findViewById(R.id.txt_video);//txt_video
        txtvideo.setText(participante.getUrl());

        txtvideo.setOnClickListener(this);

        txtestado=(TextView) getView().findViewById(R.id.txt_estado);//txt_estado
        txtestado.setText("Activo");

        /*this.personaje = personaje;
        txtNombre = (TextView) getView().findViewById(R.id.titulo_de_detalle_personaje);
        txtNombre.setText(personaje.getNombre());

        txtHistoria= (TextView) getView().findViewById(R.id.descripcion_de_detalle_personaje);
        txtHistoria.setText(personaje.getHistoria());

        btnIrVideo = (Button) getView().findViewById(R.id.btn_ir_a_trailes);
        btnIrVideo.setOnClickListener(this);*/
    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(participante.getUrl()));
        startActivity(intent);

    }
}
