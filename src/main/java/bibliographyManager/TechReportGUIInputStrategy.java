package main.java.bibliographyManager;

import main.java.bibliographyManager.GUIComponents.TechnicalReportForm;

public class TechReportGUIInputStrategy extends GUIItemInputStrategy {
    public BibItem createBibItemFromInput() {
        TechnicalReportForm technicalReportForm = new TechnicalReportForm();

        String title = technicalReportForm.getTitle();
        String author = technicalReportForm.getAuthor();
        int year = technicalReportForm.getYear();
        String institution = technicalReportForm.getInstitution();

        if(title.isEmpty() || author.isEmpty() || institution.isEmpty()){
            return null;
        } else {
            return new TechnicalReportBibItem(author, title, year, institution);
        }
    }
}