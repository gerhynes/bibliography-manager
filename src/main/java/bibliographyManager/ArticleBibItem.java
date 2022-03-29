package main.java.bibliographyManager;

public class ArticleBibItem extends BibItem implements Comparable<BibItem> {
    String citeKey;
    String doi;
    String author;
    String title;
    int year;
    String journal;

    public ArticleBibItem(String author, String title, int year, String journal, String doi) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.journal = journal;
        this.citeKey = author.substring(0, author.indexOf(",")) + String.valueOf(year).substring(2) + journal.substring(0, journal.indexOf(' ')).toLowerCase();
        this.doi = "https://doi.org/" + doi;
    }

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

    @Override
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

    public String toHarvardStyle() {
        return author + ". (" + year + "). " + title + ". " + journal + ". " + doi;
    }

    public String toBibTeX() {
        return "@article{" + citeKey + ",\n"
                + "author=\"" + author + "\",\n"
                + "title=\"" + title + "\",\n"
                + "year=\"" + year + "\",\n"
                + "journal=\"" + journal + "\",\n"
                + "doi=\"" + doi + "\n"
                + "}";
    }

    @Override
    public int compareTo(BibItem nextItem) {
        return Integer.compare(this.getYear(), nextItem.getYear());
    }
}
