package main.java.bibliographyManager;

public abstract class BibItem implements Comparable<BibItem>{
    public abstract int getYear();
    public abstract String toHarvardStyle();
    public abstract String toBibTeX();
    public abstract int compareTo(BibItem nextItem);
}
