package com.mukila;

public class Item {
    private String title;
    private String owner;
    private String type;
    private String creator;

    public Item(String title, String owner, String type, String creator)
    {
        this.setTitle(title);
        this.setOwner(owner);
        this.setType(type);
        this.setCreator(creator);
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getOwner()
    {
        return this.owner;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return this.type;
    }

    public void setCreator(String creator)
    {
        this.creator = creator;
    }

    public String getCreator()
    {
        return this.creator;
    }
}
