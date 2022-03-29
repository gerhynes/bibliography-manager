package main.java.bibliographyManager;

import main.java.bibliographyManager.GUIComponents.ArticleForm;

/**
 * Handles creating UI for inputting article values
 */
public class ArticleGUIInputStrategy extends GUIItemInputStrategy {

    /**
     * Launches dialog, creates and returns new ArticleBibItem
     * @return
     */
    public BibItem createBibItemFromInput() {
        ArticleForm articleForm = new ArticleForm();

        String title = articleForm.getTitle();
        String author = articleForm.getAuthor();
        int year = articleForm.getYear();
        String journal = articleForm.getJournal();
        String doi = articleForm.getDoi();

        // Check for empty inputs
        if(title.isEmpty() || author.isEmpty() || journal.isEmpty() || doi.isEmpty()){
            return null;
        } else {
            return new ArticleBibItem(author, title, year, journal, doi);
        }
    }
}
