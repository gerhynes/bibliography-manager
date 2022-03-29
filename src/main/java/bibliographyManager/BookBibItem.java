package main.java.bibliographyManager;

import java.util.Locale;

public class BookBibItem extends BibItem implements Comparable<BibItem>{
    String citeKey;
    String author;
    String title;
    int year;
    String publisher;

    public BookBibItem(String author, String title, int year, String publisher){
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.citeKey = author.substring(0, author.indexOf(",")).toLowerCase() + year;
    }

    public String getCiteKey() {
        return citeKey;
    }

    public void setCiteKey(String citeKey) {
        this.citeKey = citeKey;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String toHarvardStyle() {
        return author + ". (" + year + "). " + title + ". " + publisher + ".";
    }

    public String toBibTeX() {
        return "@book{" + citeKey + ",\n"
                + "author=\"" + author + "\",\n"
                + "title=\"" + title + "\",\n"
                + "year=\"" + year + "\",\n"
                + "publisher=\"" + publisher + "\",\n"
                + "}";
    }
    @Override
    public int compareTo(BibItem nextItem){
        return Integer.compare(nextItem.getYear(), this.getYear());
    }
}
