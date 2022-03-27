package main.java.bibliographyManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArticleForm implements ActionListener {
    private JPanel articleForm;
    private CardLayout cardLayout;
    private JPanel cardContainer;
    private JTextField articleAuthorInput;
    private JTextField articleTitleInput;
    private JTextField articleYearInput;
    private JTextField articleJournalInput;
    private JTextField articleDoiInput;
    private JButton articleSubmitBtn;

    public ArticleForm(JPanel cardContainer){
        this.cardContainer = cardContainer;
        this.cardLayout = (CardLayout) cardContainer.getLayout();
        this.articleForm = new JPanel(new GridLayout(3, 1));
        JPanel articleFormTitle = new JPanel(new FlowLayout());
        JPanel articleFormBody = new JPanel(new GridLayout(6,1));

        // Set title message
        JLabel bookFormMessage = new JLabel("Enter the article's details");
        articleFormTitle.add(bookFormMessage);

        // Set inputs
        JLabel articleAuthorLabel = new JLabel("Enter Author");
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
    }

    public JPanel getArticleForm() {
        return this.articleForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == articleSubmitBtn) {
            System.out.println("Article Submitted");
            String title = articleTitleInput.getText();
            String author = articleAuthorInput.getText();
            int year = Integer.parseInt(articleYearInput.getText());
            String journal = articleJournalInput.getText();
            String doi = articleDoiInput.getText();

            System.out.println("title: " + title + " author: " + author + " year: " + year + " journal: " + journal + " doi: " + doi);

            cardLayout.show(cardContainer, "defaultCard");
        }
    }
}
