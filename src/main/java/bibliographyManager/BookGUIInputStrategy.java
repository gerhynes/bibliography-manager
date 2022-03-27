package main.java.bibliographyManager;

import javax.swing.*;

public class BookGUIInputStrategy extends GUIItemInputStrategy{
    public BibItem createBibItemFromInput() {
        BookBibItem book = new BookBibItem();
        return book;
    }
}
