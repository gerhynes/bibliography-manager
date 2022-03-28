package main.java.bibliographyManager;

import javax.swing.*;

public class BookGUIInputStrategy extends GUIItemInputStrategy{
    public BibItem createBibItemFromInput() {
        BibItem book;
        BookForm bookForm = new BookForm();

        String title = bookForm.getBookTitleInput().getText();
        String author = bookForm.getBookAuthorInput().getText();
        int year = Integer.parseInt(bookForm.getBookYearInput().getText());
        String publisher = bookForm.getBookPublisherInput().getText();

        book = new BookBibItem(author, title, year, publisher);

        return book;
    }
}
