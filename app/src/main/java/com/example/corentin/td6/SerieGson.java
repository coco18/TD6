package com.example.corentin.td6;

import java.util.Arrays;

/**
 * Created by Corentin on 06/06/2017.
 */

public class SerieGson {


    private String backdrop_path;
    private CreateBy create_by;
    private Genres[] genres;
    private int  id;
    private String name;
    private String original_language;
    private String original_name;
    private String overview;
    private float popularity;
    private String poster_path;
    private ProductionCompanies[] production_companies;
    private String status;
    private String type;
    private float vote_average;
    private int vote_count;

    public SerieGson(String backdrop_path, CreateBy create_by, Genres[] genres, int id, String name, String original_language, String original_name, String overview, float popularity, String poster_path, ProductionCompanies[] production_companies, String status, String type, float vote_average, int vote_count) {
        this.backdrop_path = backdrop_path;
        this.create_by = create_by;
        this.genres = genres;
        this.id = id;
        this.name = name;
        this.original_language = original_language;
        this.original_name = original_name;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.production_companies = production_companies;
        this.status = status;
        this.type = type;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }


    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public CreateBy getCreate_by() {
        return create_by;
    }

    public void setCreate_by(CreateBy create_by) {
        this.create_by = create_by;
    }

    public Genres[] getGenres() {
        return genres;
    }

    public String getGenre(){
        String genre ="";
        for (int i=0; i<this.genres.length;i++){
            if (i==this.genres.length-1){
                genre+= this.genres[i].getName();
            } else {
                genre += this.genres[i].getName() + ", ";
            }
        }
        return genre;
    }


    public void setGenres(Genres[] genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public ProductionCompanies[] getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(ProductionCompanies[] production_companies) {
        this.production_companies = production_companies;
    }

    public String getProduction(){
        String produciton ="";
        for (int i=0; i<this.production_companies.length;i++){
            if (i==this.production_companies.length-1){
                produciton+= this.production_companies[i].getName();
            } else {
                produciton += this.production_companies[i].getName() + ", ";
            }
        }
        return produciton;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    @Override
    public String toString() {
        return "SerieGson{" +
                "backdrop_path='" + backdrop_path + '\'' +
                ", create_by=" + create_by +
                ", genres=" + Arrays.toString(genres) +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_name='" + original_name + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", production_companies=" + Arrays.toString(production_companies) +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }
}
