package main.java.bibliographyManager;

/**
 * Represents single bibliography entry
 */
public abstract class BibItem implements Comparable<BibItem>{
    public abstract String getCiteKey();
    public abstract int getYear();
    public abstract String toHarvardStyle();
    public abstract String toBibTeX();
    public abstract int compareTo(BibItem nextItem);
}
