package com.example.corentin.td6;

/**
 * Created by Corentin on 05/06/2017.
 */
public class ProductionCompanies {

    private String name;
    private int id;
    public ProductionCompanies(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genres{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
}
