package ru.stqa.pft.addressbook.tech;

import java.util.Objects;

public class GData {
    private final String name;
    private int id;
    public GData (String name){
        this.id = Integer.MAX_VALUE;
        this.name = name;
    }
    public GData (String name, int id){
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GData gData = (GData) o;

        return name != null ? name.equals(gData.name) : gData.name == null;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GData{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

}
