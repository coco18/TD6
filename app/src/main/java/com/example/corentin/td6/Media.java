package com.example.corentin.td6;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Corentin on 03/06/2017.
 */

public abstract class Media {

    private int id;
    private String nom;
    private String poster;
    private String type;


    public Media(int id, String nom, String type, String poster) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.poster = poster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", poster='" + poster + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
