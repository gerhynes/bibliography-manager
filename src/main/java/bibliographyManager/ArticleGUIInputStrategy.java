package main.java.bibliographyManager;

import main.java.bibliographyManager.GUIComponents.ArticleForm;

public class ArticleGUIInputStrategy extends GUIItemInputStrategy {
    public BibItem createBibItemFromInput() {
        ArticleForm articleForm = new ArticleForm();

        String title = articleForm.getTitle();
        String author = articleForm.getAuthor();
        int year = articleForm.getYear();
        String journal = articleForm.getJournal();
        String doi = articleForm.getDoi();

        return new ArticleBibItem(author, title, year, journal, doi);
    }
}
