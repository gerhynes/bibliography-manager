package main.java.bibliographyManager;

public class TechnicalReportBibItem extends BibItem implements Comparable<BibItem>{
    String citeKey;
    String author;
    String title;
    int year;
    String institution;

    public TechnicalReportBibItem(String author, String title, int year, String institution) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.institution = institution;
        this.citeKey = author.substring(0, author.indexOf(",")) + ":" + year;
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

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String toHarvardStyle() {
        return author + ". (" + year + "). " + title + ". " + institution + ".";
    }

    public String toBibTeX() {
        return "@techreport{" + citeKey + ",\n"
                + "author=\"" + author + "\",\n"
                + "title=\"" + title + "\",\n"
                + "year=\"" + year + "\",\n"
                + "institution=\"" + institution + "\",\n"
                + "}";
    }

    @Override
    public int compareTo(BibItem nextItem){
        return Integer.compare(this.getYear(), nextItem.getYear());
    }
}
