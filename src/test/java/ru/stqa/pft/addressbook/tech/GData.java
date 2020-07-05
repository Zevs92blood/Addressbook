package ru.stqa.pft.addressbook.tech;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class GData {
    @Expose
    private  String name;
    @Expose
    private String header;
    @Expose
    private String footer;
    private int id;
    public GData (String name){
        this.id = Integer.MAX_VALUE;
        this.header = "header";
        this.footer = "footer";
        this.name = name;
    }
    public GData (String name, int id){
        this.header = "header";
        this.footer = "footer";
        this.id = id;
        this.name = name;
    }

    public GData (String name, String header, String footer){
        this.name = name;
        this.header = header;
        this.footer = footer;
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
    public String getHeader() {
        return header;
    }
    public String getFooter() {
        return footer;
    }

}
