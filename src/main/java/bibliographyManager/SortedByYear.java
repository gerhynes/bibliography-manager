package main.java.bibliographyManager;

import java.util.Comparator;

public class SortedByYear implements Comparator<BibItem> {
    public int compare(BibItem item1, BibItem item2) {
        return Integer.compare(item1.getYear(), item2.getYear());
    }
}