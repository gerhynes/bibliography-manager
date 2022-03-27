package main.java.bibliographyManager;

public class ArticleGUIInputStrategy extends GUIItemInputStrategy {
    public BibItem createBibItemFromInput() {
        ArticleBibItem article = new ArticleBibItem();
        return article;
    }
}
