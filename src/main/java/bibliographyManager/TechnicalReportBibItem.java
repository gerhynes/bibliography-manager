package main.java.bibliographyManager;

/**
 * Represents single technical report in bibliography
 */
public class TechnicalReportBibItem extends BibItem implements Comparable<BibItem>{
    String citeKey;
    String author;
    String title;
    int year;
    String institution;

    /**
     * Generates TechnicalReportBibItem
     * @param author
     * @param title
     * @param year
     * @param institution
     */
    public TechnicalReportBibItem(String author, String title, int year, String institution) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.institution = institution;
        this.citeKey = generateCiteKey(author, year);
    }

    /**
     * Generates valid citeKey
     * @param author
     * @param year
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
        citeKey = lastName.toLowerCase() + ":" + year;
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

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * Provides string representation of article in Harvard style
     * @return
     */
    public String toHarvardStyle() {
        return author + ". (" + year + "). " + title + ". " + institution + ".";
    }

    /**
     * Provides string representation of article in BibTeX format
     * @return
     */
    public String toBibTeX() {
        return "@techreport{" + citeKey + ",\n"
                + "author=\"" + author + "\",\n"
                + "title=\"" + title + "\",\n"
                + "year=\"" + year + "\",\n"
                + "institution=\"" + institution + "\",\n"
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
