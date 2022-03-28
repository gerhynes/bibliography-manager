package main.java.bibliographyManager;

public class TechReportGUIInputStrategy extends GUIItemInputStrategy {
    public BibItem createBibItemFromInput() {
        TechnicalReportForm technicalReportForm = new TechnicalReportForm();

        String title = technicalReportForm.getTitle();
        String author = technicalReportForm.getAuthor();
        int year = technicalReportForm.getYear();
        String institution = technicalReportForm.getInstitution();

        return new TechnicalReportBibItem(author, title, year, institution);
    }
}