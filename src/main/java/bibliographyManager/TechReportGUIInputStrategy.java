package main.java.bibliographyManager;

import main.java.bibliographyManager.GUIComponents.TechnicalReportForm;

/**
 * Handles creating UI for inputting technical report values
 */
public class TechReportGUIInputStrategy extends GUIItemInputStrategy {
    /**
     * Launches dialog, creates and returns new TechnicalReportBibItem
     * @return
     */
    public BibItem createBibItemFromInput() {
        TechnicalReportForm technicalReportForm = new TechnicalReportForm();

        String title = technicalReportForm.getTitle();
        String author = technicalReportForm.getAuthor();
        int year = technicalReportForm.getYear();
        String institution = technicalReportForm.getInstitution();

        // Check for empty inputs
        if(title.isEmpty() || author.isEmpty() || institution.isEmpty()){
            return null;
        } else {
            return new TechnicalReportBibItem(author, title, year, institution);
        }
    }
}