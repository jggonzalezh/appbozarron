package co.edu.uniquindio.android.electiva.proyectofinal.vo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Juan on 01/11/2016.
 */

public class Entrenador implements Parcelable {


    //Atributos de Clase del personaje

    private String id;
    private String nombre;
    private String  genero;
    private String historia;
    private String url;
    private List <Participante> participanteEntrena;



    public Entrenador(String nombre, String genero, String historia , String url, ArrayList<Participante> participanteEntrena) {
        this.nombre = nombre;
        this.genero = genero;
        this.historia=historia;
        this.url = url;
        this.participanteEntrena=participanteEntrena;

    }

    public Entrenador() {

    }

    protected Entrenador(Parcel in) {
        id = in.readString();
        nombre = in.readString();
        genero = in.readString();
        historia = in.readString();
        url = in.readString();
        participanteEntrena= in.readArrayList(Participante.class.getClassLoader());

    }

    public static final Creator<Entrenador> CREATOR = new Creator<Entrenador>() {
        @Override
        public Entrenador createFromParcel(Parcel in) {
            return new Entrenador(in);
        }

        @Override
        public Entrenador[] newArray(int size) {
            return new Entrenador[size];
        }
    };

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {

        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getHistoria() {
        return historia;
    }

    public String getUrl() {
        return this.url;
    }

    public List<Participante> getParticipanteEntrena() {
        return participanteEntrena;
    }

    public void setParticipanteEntrena(List<Participante> participanteEntrena) {
        this.participanteEntrena = participanteEntrena;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nombre);
        dest.writeString(genero);
        dest.writeString(historia);
        dest.writeString(url);
        dest.writeList(participanteEntrena);
    }

}

