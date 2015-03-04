package com.luizgadao.interactivestory.model;

/**
 * Created by luizcarlos on 03/03/15.
 */
public class Choice {

    private String text;
    private int nextPage;

    public Choice( String text, int nextPage ) {
        this.text = text;
        this.nextPage = nextPage;
    }

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage( int nextPage ) {
        this.nextPage = nextPage;
    }
}
