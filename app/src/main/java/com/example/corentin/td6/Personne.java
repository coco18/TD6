package com.example.corentin.td6;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Corentin on 03/06/2017.
 */

public class Personne extends Media implements Parcelable{

    private List<Media> connuePour;

    public Personne(int id, String nom, String poster) {
        super(id, nom, "Personne", poster);
        this.connuePour = new ArrayList<Media>();
    }

    public Personne(Parcel source) {
        super(source.readInt(), source.readString(), source.readString(), source.readString());
        this.connuePour = new ArrayList<Media>();
        int nbmedia = source.readInt();
        for (int i=0; i<nbmedia;i++){
            String type = source.readString();
            if (type.contentEquals("Film")){
                this.connuePour.add(new Film(source));
            } else if (type.contentEquals("Serie")){
                this.connuePour.add(new Serie(source));
            }
        }
    }

    public List<Media> getConnuePour() {
        return connuePour;
    }

    public void ajoutConnuePour(Media media){
        connuePour.add(media);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(super.getId());
        dest.writeString(super.getNom());
        dest.writeString(super.getType());
        dest.writeString(super.getPoster());
        dest.writeInt(connuePour.size());
        for (int i=0; i<connuePour.size(); i++){
            Media media = connuePour.get(i);
            if (media.getType().contentEquals("Film")){
                Film film = (Film) media;
                dest.writeString("Film");
                film.writeToParcel(dest, flags);
            } else if (media.getType().contentEquals("Serie")){
                Serie serie = (Serie) media;
                dest.writeString("Serie");
                serie.writeToParcel(dest, flags);
            }
        }
    }

    public static final Parcelable.Creator<Personne> CREATOR = new Parcelable.Creator<Personne>(){

        @Override
        public Personne createFromParcel(Parcel source) {
            return new Personne(source);
        }

        @Override
        public Personne[] newArray(int size) {
            return new Personne[0];
        }
    };

}
