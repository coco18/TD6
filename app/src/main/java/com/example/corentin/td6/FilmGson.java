package com.example.corentin.td6;

import java.util.Arrays;

/**
 * Created by Corentin on 05/06/2017.
 */

public class FilmGson {


    private String backdrop_path;
    private Genres[] genres;
    private int  id;
    private String name;
    private String original_language;
    private String original_title;
    private String overview;
    private float popularity;
    private String poster_path;
    private ProductionCompanies[] production_companies;
    private ProductionCountries[] production_countries;
    private String release_date;
    private SpokenLanguage[] spoken_languages;
    private String status;
    private String title;
    private boolean video;
    private float vote_average;
    private int vote_count;

    public FilmGson(String backdrop_path, Genres[] genres, int id, String name, String original_language, String original_title, String overview, float popularity, String poster_path, ProductionCompanies[] production_companies, ProductionCountries[] production_countries, String release_date, SpokenLanguage[] spoken_languages, String status, String title, boolean video, float vote_average, int vote_count) {
        this.backdrop_path = backdrop_path;
        this.genres = genres;
        this.id = id;
        this.name = name;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.release_date = release_date;
        this.spoken_languages = spoken_languages;
        this.status = status;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Genres[] getGenres() {
        return genres;
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

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
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

    public ProductionCountries[] getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(ProductionCountries[] production_countries) {
        this.production_countries = production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public SpokenLanguage[] getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(SpokenLanguage[] spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
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
        return "FilmGson{" +
                "backdrop_path='" + backdrop_path + '\'' +
                ", genres=" + Arrays.toString(genres) +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", production_companies=" + Arrays.toString(production_companies) +
                ", production_countries=" + Arrays.toString(production_countries) +
                ", release_date='" + release_date + '\'' +
                ", spoken_languages=" + Arrays.toString(spoken_languages) +
                ", status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }
}
