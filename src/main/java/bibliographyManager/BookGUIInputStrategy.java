package main.java.bibliographyManager;

import main.java.bibliographyManager.GUIComponents.BookForm;

public class BookGUIInputStrategy extends GUIItemInputStrategy {
    /**
     * Generates BooKForm and creates BookBibItem based off inputs
     * @return
     */
    public BibItem createBibItemFromInput() {
        BookForm bookForm = new BookForm();

        String title = bookForm.getTitle();
        String author = bookForm.getAuthor();
        int year = bookForm.getYear();
        String publisher = bookForm.getPublisher();

        if (title.isEmpty() || author.isEmpty() || publisher.isEmpty()) {
            return null;
        } else {
            return new BookBibItem(author, title, year, publisher);
        }
    }
}
