package co.edu.uniquindio.android.electiva.proyectofinal.vo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Juan on 01/11/2016.
 */

public class Participante implements Parcelable {


    //Atributos de Clase del personaje

    private String id;

    private String nombre;

    private Date fecha;

    public String getRelacionUniversidad() {
        return relacionUniversidad;
    }

    private String historia;

    // Es una url de un video relacionado con el personaje
    private String url;

    private String relacionUniversidad;

    public Participante(String nombre, Date fecha,String historia ,String url ,String relacionUniversidad) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.historia=historia;
        this.url = url;
        this.relacionUniversidad=relacionUniversidad;
    }

    public Participante() {

    }

    protected Participante(Parcel in) {
        id = in.readString();
        nombre = in.readString();
        historia = in.readString();
        url = in.readString();
        relacionUniversidad = in.readString();
    }

    public static final Creator<Participante> CREATOR = new Creator<Participante>() {
        @Override
        public Participante createFromParcel(Parcel in) {
            return new Participante(in);
        }

        @Override
        public Participante[] newArray(int size) {
            return new Participante[size];
        }
    };

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public String getHistoria() {
        return historia;
    }

    public String getUrl() {
        return this.url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nombre);
        dest.writeString(historia);
        dest.writeString(url);
        dest.writeString(relacionUniversidad);
    }

}
