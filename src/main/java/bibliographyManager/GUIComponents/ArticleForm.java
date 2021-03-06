package main.java.bibliographyManager.GUIComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles inputting the values for creating a new ArticleBibItem
 */
public class ArticleForm implements ActionListener {
    private JDialog dialog;
    private JTextField articleAuthorInput;
    private JTextField articleTitleInput;
    private JTextField articleYearInput;
    private JTextField articleJournalInput;
    private JTextField articleDoiInput;
    private JButton articleSubmitBtn;
    private String author;
    private String title;
    private int year;
    private String journal;
    private String doi;

    /**
     * Generates ArticleForm
     */
    public ArticleForm() {
        dialog = new JDialog();
        dialog.setSize(600, 600);

        JPanel articleForm = new JPanel(new GridLayout(3, 1));
        JPanel articleFormTitle = new JPanel(new FlowLayout());
        JPanel articleFormBody = new JPanel(new GridLayout(6, 1));

        // Set title message
        JLabel bookFormMessage = new JLabel("Enter the article's details");
        articleFormTitle.add(bookFormMessage);

        // Set inputs
        JLabel articleAuthorLabel = new JLabel("Enter Author(s) (Format: lastname, firstname)");
        articleAuthorInput = new JTextField(20);
        JPanel authorInputs = new JPanel();
        authorInputs.add(articleAuthorLabel);
        authorInputs.add(articleAuthorInput);

        JLabel articleTitleLabel = new JLabel("Enter Title");
        articleTitleInput = new JTextField(20);
        JPanel titleInputs = new JPanel();
        titleInputs.add(articleTitleLabel);
        titleInputs.add(articleTitleInput);

        JLabel articleYearLabel = new JLabel("Enter Year");
        articleYearInput = new JTextField(20);
        JPanel yearInputs = new JPanel();
        yearInputs.add(articleYearLabel);
        yearInputs.add(articleYearInput);

        JLabel articleJournalLabel = new JLabel("Enter Journal");
        articleJournalInput = new JTextField(20);
        JPanel journalInputs = new JPanel();
        journalInputs.add(articleJournalLabel);
        journalInputs.add(articleJournalInput);

        JLabel articleDoiLabel = new JLabel("Enter DOI (Format 10.NNNN/NNNNN)");
        articleDoiInput = new JTextField(20);
        JPanel doiInputs = new JPanel();
        doiInputs.add(articleDoiLabel);
        doiInputs.add(articleDoiInput);

        articleSubmitBtn = new JButton("Submit");
        articleSubmitBtn.addActionListener(this);
        JPanel buttonWrapper = new JPanel();
        buttonWrapper.add(articleSubmitBtn);

        // Add inputs
        articleFormBody.add(authorInputs);
        articleFormBody.add(titleInputs);
        articleFormBody.add(yearInputs);
        articleFormBody.add(journalInputs);
        articleFormBody.add(doiInputs);
        articleFormBody.add(buttonWrapper);

        // Add title and body
        articleForm.add(articleFormTitle);
        articleForm.add(articleFormBody);

        dialog.add(articleForm);
        dialog.setModal(true);
        dialog.setVisible(true);
    }

    // Getters and Setters
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

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    /**
     * Saves input values to private variables for access by ArticleGUIInputStrategy
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == articleSubmitBtn) {
            title = articleTitleInput.getText();
            author = articleAuthorInput.getText();
            // Check if year can be converted to int
            String yearString = articleYearInput.getText();
            if ( yearString.equals("")){
                year = 0000;
            } else {
                year = Integer.parseInt(yearString);
            }
            journal = articleJournalInput.getText();
            doi = articleDoiInput.getText();
            dialog.dispose();
        }
    }
}
