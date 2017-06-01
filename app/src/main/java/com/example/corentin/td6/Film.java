package com.example.corentin.td6;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Corentin on 31/05/2017.
 */

public class Film implements Parcelable {

    private String titre;
    private String description;
    private String poster;
    private String toileDeFond;

    public Film(String titre, String description, String poster, String toileDeFond) {
        this.titre = titre;
        this.description = description;
        this.poster = poster;
        this.toileDeFond = toileDeFond;
    }

    public Film(Parcel in){
        this.titre = in.readString();
        this.description = in.readString();
        this.poster = in.readString();
        this.toileDeFond = in.readString();
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getToileDeFond() {
        return toileDeFond;
    }

    public void setToileDeFond(String toileDeFond) {
        this.toileDeFond = toileDeFond;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", poster='" + poster + '\'' +
                ", toileDeFond='" + toileDeFond + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titre);
        dest.writeString(this.description);
        dest.writeString(this.poster);
        dest.writeString(this.toileDeFond);
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>(){

        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[0];
        }
    };

}
