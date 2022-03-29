package main.java.bibliographyManager;

import main.java.bibliographyManager.GUIComponents.BookForm;

/**
 * Handles creating UI for inputting book values
 */
public class BookGUIInputStrategy extends GUIItemInputStrategy {
    /**
     * Launches dialog, creates and returns new BookBibItem
     * @return
     */
    public BibItem createBibItemFromInput() {
        BookForm bookForm = new BookForm();

        String title = bookForm.getTitle();
        String author = bookForm.getAuthor();
        int year = bookForm.getYear();
        String publisher = bookForm.getPublisher();

        // Check for empty inputs
        if (title.isEmpty() || author.isEmpty() || publisher.isEmpty()) {
            return null;
        } else {
            return new BookBibItem(author, title, year, publisher);
        }
    }
}
