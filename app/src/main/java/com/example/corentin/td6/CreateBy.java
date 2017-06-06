package com.example.corentin.td6;

/**
 * Created by Corentin on 06/06/2017.
 */
public class CreateBy {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "CreateBy{" +
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

    public CreateBy(int id, String name) {

        this.id = id;
        this.name = name;
    }
}
