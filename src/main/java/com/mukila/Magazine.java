package com.mukila;

public class Magazine extends Item {
    private String editor;

    public Magazine(String title, String editor, String owner)
    {
        super(title, owner, "Magazine");
        this.setEditor(editor);
    }

    public void setEditor(String editor)
    {
        this.editor = editor;
    }

    public String getEditor()
    {
        return this.editor;
    }
}
