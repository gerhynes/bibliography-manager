package main.java.bibliographyManager;

/**
 * Provides interface for creation of any BibItem
 */
public interface BibItemFactory {
    public BibItem createBibItem(String input);
}
