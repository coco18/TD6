package com.example.corentin.td6;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Corentin on 03/06/2017.
 */

public class Serie extends Media implements Parcelable{

    private String description;
    private String toileDeFond;

    public Serie(String nom, String description, String poster, String toileDeFond) {
        super(nom, "Serie", poster);
        this.description = description;
        this.toileDeFond = toileDeFond;
    }

    public Serie(Parcel source) {
        super(source.readString(), source.readString(), source.readString());
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
        dest.writeString(super.getNom());
        dest.writeString(super.getType());
        dest.writeString(super.getPoster());
        dest.writeString(this.description);
        dest.writeString(this.toileDeFond);
    }

    public static final Parcelable.Creator<Serie> CREATOR = new Parcelable.Creator<Serie>(){

        @Override
        public Serie createFromParcel(Parcel source) {
            return new Serie(source);
        }

        @Override
        public Serie[] newArray(int size) { return new Serie[0]; }
    };


}
