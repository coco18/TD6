package com.example.corentin.td6;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Corentin on 31/05/2017.
 */

public class Film extends Media implements Parcelable {

    private String description;
    private String toileDeFond;

    public Film(int id, String nom, String description, String poster, String toileDeFond) {
        super(id, nom, "Film", poster);
        this.description = description;
        this.toileDeFond = toileDeFond;
    }

    public Film(Parcel source) {
        super(source.readInt(), source.readString(), source.readString(), source.readString());
        this.description = source.readString();
        this.toileDeFond = source.readString();
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getToileDeFond() {
        return toileDeFond;
    }

    public void setToileDeFond(String toileDeFond) {
        this.toileDeFond = toileDeFond;
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
        dest.writeString(this.description);
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
