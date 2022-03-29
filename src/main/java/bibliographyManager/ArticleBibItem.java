package main.java.bibliographyManager;

/**
 * BibItem for recording academic articles
 */
public class ArticleBibItem extends BibItem implements Comparable<BibItem> {
    String citeKey;
    String doi;
    String author;
    String title;
    int year;
    String journal;

    /**
     * Generates ArticleBibItem
     * @param author
     * @param title
     * @param year
     * @param journal
     * @param doi
     */
    public ArticleBibItem(String author, String title, int year, String journal, String doi) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.journal = journal;
        this.citeKey = generateCiteKey(author, year, journal);
        this.doi = "https://doi.org/" + doi;
    }

    /**
     * Checks formatting of author and journal to generate valid citeKey
     * @param author
     * @param year
     * @param journal
     * @return
     */
    public String generateCiteKey(String author, int year, String journal){
        String citeKey = "";
        String lastName = "";
        // If author is "lastname, firstname", use lastname
        if (author.indexOf(",") != -1) {
            lastName = author.substring(0, author.indexOf(","));
        } else {
            // If author is "firstname lastname", use lastname
            lastName = author.split(" ")[1];
        }

        // Get final two digits from year
        String yearShortFormat = String.valueOf(year).substring(2);

        String journalTitle = "";
        // If journal is "title, details", use title
        if(journal.indexOf(",") != -1){
            journalTitle = journal.substring(0, journal.indexOf(",")).toLowerCase();
        } else {
            // Use entire title provided
            journalTitle = journal.toLowerCase();
        }

        citeKey = lastName + yearShortFormat + journalTitle;
        return citeKey;
    }

    // Getters and Setters
    public String getCiteKey() {
        return citeKey;
    }

    public void setCiteKey(String citeKey) {
        this.citeKey = citeKey;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
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

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    /**
     * Provides string representation of article in Harvard style
     * @return
     */
    public String toHarvardStyle() {
        return author + ". (" + year + "). " + title + ". " + journal + ". " + doi;
    }

    /**
     * Provides string representation of article in BibTeX format
     * @return
     */
    public String toBibTeX() {
        return "@article{" + citeKey + ",\n"
                + "author=\"" + author + "\",\n"
                + "title=\"" + title + "\",\n"
                + "year=\"" + year + "\",\n"
                + "journal=\"" + journal + "\",\n"
                + "doi=\"" + doi + "\n"
                + "}";
    }

    /**
     * Allows for comparison of BibItems based off their year of publication
     * @param nextItem
     * @return
     */
    @Override
    public int compareTo(BibItem nextItem) {
        return Integer.compare(nextItem.getYear(), this.getYear());
    }
}
