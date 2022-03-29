package main.java.bibliographyManager;

import java.util.Comparator;

/**
 * Custom Comparator for sorting BibItems in bibliography
 */
public class SortedByYear implements Comparator<BibItem> {
    @Override
    public int compare(BibItem item1, BibItem item2) {
        return Integer.compare(item2.getYear(), item1.getYear());
    }
}