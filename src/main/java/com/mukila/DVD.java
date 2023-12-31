package com.mukila;

public class DVD extends Item {
    private String director;

    public DVD(String title, String director, String owner)
    {
        super(title, owner, "DVD");
        this.setDirector(director);
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public String getDirector()
    {
        return this.director;
    }
}
