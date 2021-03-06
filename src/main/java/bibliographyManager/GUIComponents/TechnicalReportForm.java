package main.java.bibliographyManager.GUIComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles inputting the values for creating a new TechnicalReportBibItem
 */
public class TechnicalReportForm implements ActionListener {
    private JDialog dialog;
    private JTextField technicalReportAuthorInput;
    private JTextField technicalReportTitleInput;
    private JTextField technicalReportYearInput;
    private JTextField technicalReportInstitutionInput;
    private JButton technicalReportSubmitBtn;
    private String title;
    private String author;
    private int year;
    private String institution;

    /**
     * Generates TechnicalReportForm
     */
    public TechnicalReportForm() {
        dialog = new JDialog();
        dialog.setSize(600, 600);

        JPanel technicalReportForm = new JPanel(new GridLayout(3, 1));
        JPanel technicalReportFormTitle = new JPanel(new FlowLayout());
        JPanel technicalReportFormBody = new JPanel(new GridLayout(5, 1));

        // Set title message
        JLabel bookFormMessage = new JLabel("Enter the Technical Report's details");
        technicalReportFormTitle.add(bookFormMessage);

        // Set inputs
        JLabel technicalReportAuthorLabel = new JLabel("Enter Author");
        technicalReportAuthorInput = new JTextField(20);
        JPanel authorInputs = new JPanel();
        authorInputs.add(technicalReportAuthorLabel);
        authorInputs.add(technicalReportAuthorInput);

        JLabel technicalReportTitleLabel = new JLabel("Enter Title");
        technicalReportTitleInput = new JTextField(20);
        JPanel titleInputs = new JPanel();
        titleInputs.add(technicalReportTitleLabel);
        titleInputs.add(technicalReportTitleInput);

        JLabel technicalReportYearLabel = new JLabel("Enter Year");
        technicalReportYearInput = new JTextField(20);
        JPanel yearInputs = new JPanel();
        yearInputs.add(technicalReportYearLabel);
        yearInputs.add(technicalReportYearInput);

        JLabel technicalReportInstitutionLabel = new JLabel("Enter Institution");
        technicalReportInstitutionInput = new JTextField(20);
        JPanel institutionInputs = new JPanel();
        institutionInputs.add(technicalReportInstitutionLabel);
        institutionInputs.add(technicalReportInstitutionInput);

        technicalReportSubmitBtn = new JButton("Submit");
        technicalReportSubmitBtn.addActionListener(this);
        JPanel buttonWrapper = new JPanel();
        buttonWrapper.add(technicalReportSubmitBtn);

        // Add inputs
        technicalReportFormBody.add(authorInputs);
        technicalReportFormBody.add(titleInputs);
        technicalReportFormBody.add(yearInputs);
        technicalReportFormBody.add(institutionInputs);
        technicalReportFormBody.add(buttonWrapper);

        // Add title and body
        technicalReportForm.add(technicalReportFormTitle);
        technicalReportForm.add(technicalReportFormBody);

        // Add form to dialog
        dialog.add(technicalReportForm);
        dialog.setModal(true);
        dialog.setVisible(true);
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
     * Saves input values to private variables for access by TechReportGUIStrategy
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == technicalReportSubmitBtn) {
            title = technicalReportTitleInput.getText();
            author = technicalReportAuthorInput.getText();
            // Check if year can be converted to int
            String yearString = technicalReportYearInput.getText();
            if ( yearString.equals("")){
                year = 0000;
            } else {
                year = Integer.parseInt(yearString);
            }
            institution = technicalReportInstitutionInput.getText();
            dialog.dispose();
        }
    }
}
