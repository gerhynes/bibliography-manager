package main.java.bibliographyManager;

/**
 * Interface for creation of specific strategies for producing BibItems
 */
public interface ItemInputStrategy {
    public BibItem createBibItemFromInput();
}
