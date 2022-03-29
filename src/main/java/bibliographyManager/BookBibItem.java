package main.java.bibliographyManager;

/**
 * Represents single book in bibliography
 */
public class BookBibItem extends BibItem implements Comparable<BibItem>{
    private String citeKey;
    private String author;
    private String title;
    private int year;
    private String publisher;

    /**
     * Generates BookBibItem
     * @param author
     * @param title
     * @param year
     * @param publisher
     */
    public BookBibItem(String author, String title, int year, String publisher){
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.citeKey = generateCiteKey(author, year);
    }

    /**
     * Generates valid citeKey for book
     * @return
     */
    public String generateCiteKey(String author, int year){
        String citeKey = "";
        String lastName = "";
        // If author is "lastname, firstname", use lastname
        if (author.indexOf(",") != -1) {
            lastName = author.substring(0, author.indexOf(","));
        } else {
            // If author is "firstname lastname", use lastname
            lastName = author.split(" ")[1];
        }
        citeKey = lastName.toLowerCase() + year;
        return citeKey;
    }

    // Getters and Setters
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

    /**
     * Provides string representation of book in Harvard style
     * @return
     */
    public String toHarvardStyle() {
        return author + ". (" + year + "). " + title + ". " + publisher + ".";
    }

    /**
     * Provides string representation of book in BibTeX format
     * @return
     */
    public String toBibTeX() {
        return "@book{" + citeKey + ",\n"
                + "author=\"" + author + "\",\n"
                + "title=\"" + title + "\",\n"
                + "year=\"" + year + "\",\n"
                + "publisher=\"" + publisher + "\",\n"
                + "}";
    }

    /**
     * Allows for comparison of BibItems based off their year of publication
     * @param nextItem
     * @return
     */
    @Override
    public int compareTo(BibItem nextItem){
        return Integer.compare(nextItem.getYear(), this.getYear());
    }
}
