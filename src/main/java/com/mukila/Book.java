package com.mukila;

public class Book extends Item {
    private String author;

    public Book(String title, String author, String owner)
    {
        super(title, owner, "Book");
        this.setAuthor(author);
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor()
    {
        return this.author;
    }
}
