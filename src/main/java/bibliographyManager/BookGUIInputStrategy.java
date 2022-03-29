package main.java.bibliographyManager;

import main.java.bibliographyManager.GUIComponents.BookForm;

public class BookGUIInputStrategy extends GUIItemInputStrategy{
    public BibItem createBibItemFromInput() {
        BookForm bookForm = new BookForm();

        String title = bookForm.getTitle();
        String author = bookForm.getAuthor();
        int year = bookForm.getYear();
        String publisher = bookForm.getPublisher();

        return new BookBibItem(author, title, year, publisher);
    }
}
