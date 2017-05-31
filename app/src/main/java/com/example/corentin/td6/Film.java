package com.example.corentin.td6;

/**
 * Created by Corentin on 31/05/2017.
 */

public class Film {

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
}
