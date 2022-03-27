package main.java.bibliographyManager;

public class TechReportGUIInputStrategy extends GUIItemInputStrategy {
    // Pass inputs as parameters
    public BibItem createBibItemFromInput() {
        // Create and return TechnicalReportBibItem
        TechnicalReportBibItem technicalReport = new TechnicalReportBibItem();
        return technicalReport;
    }
}