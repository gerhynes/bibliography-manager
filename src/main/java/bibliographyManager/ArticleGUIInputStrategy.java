package main.java.bibliographyManager;

public class ArticleGUIInputStrategy extends GUIItemInputStrategy {
    public BibItem createBibItemFromInput() {
        ArticleForm articleForm = new ArticleForm();

        String title = articleForm.getTitle();
        String author = articleForm.getAuthor();
        int year = articleForm.getYear();
        String journal = articleForm.getJournal();
        String doi = articleForm.getDoi();

        BibItem article = new ArticleBibItem(author, title, year, journal, doi);
        return article;
    }
}
