package main.java.bibliographyManager;

/**
 * Interface for creation of specific GUI-based strategies for producing BibItems
 */
public abstract class GUIItemInputStrategy implements ItemInputStrategy {
    public abstract BibItem createBibItemFromInput();
}
