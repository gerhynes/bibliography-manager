package main.java.bibliographyManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArticleForm implements ActionListener {
    private JDialog dialog;
    private JPanel articleForm;
    private JTextField articleAuthorInput;
    private JTextField articleTitleInput;
    private JTextField articleYearInput;
    private JTextField articleJournalInput;
    private JTextField articleDoiInput;
    private JButton articleSubmitBtn;

    String author;
    String title;
    int year;
    String journal;
    String doi;

    public ArticleForm() {
        dialog = new JDialog();
        dialog.setSize(600, 600);

        this.articleForm = new JPanel(new GridLayout(3, 1));
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

    public JTextField getArticleAuthorInput() {
        return articleAuthorInput;
    }

    public void setArticleAuthorInput(JTextField articleAuthorInput) {
        this.articleAuthorInput = articleAuthorInput;
    }

    public JTextField getArticleTitleInput() {
        return articleTitleInput;
    }

    public void setArticleTitleInput(JTextField articleTitleInput) {
        this.articleTitleInput = articleTitleInput;
    }

    public JTextField getArticleYearInput() {
        return articleYearInput;
    }

    public void setArticleYearInput(JTextField articleYearInput) {
        this.articleYearInput = articleYearInput;
    }

    public JTextField getArticleJournalInput() {
        return articleJournalInput;
    }

    public void setArticleJournalInput(JTextField articleJournalInput) {
        this.articleJournalInput = articleJournalInput;
    }

    public JTextField getArticleDoiInput() {
        return articleDoiInput;
    }

    public void setArticleDoiInput(JTextField articleDoiInput) {
        this.articleDoiInput = articleDoiInput;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == articleSubmitBtn) {
            System.out.println("Article Submitted");
            title = articleTitleInput.getText();
            author = articleAuthorInput.getText();
            year = Integer.parseInt(articleYearInput.getText());
            journal = articleJournalInput.getText();
            doi = articleDoiInput.getText();

            System.out.println("title: " + title + " author: " + author + " year: " + year + " journal: " + journal + " doi: " + doi);
            dialog.dispose();
        }
    }
}
