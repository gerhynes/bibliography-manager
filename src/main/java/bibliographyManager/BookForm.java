package main.java.bibliographyManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookForm implements ActionListener {
    private JDialog dialog;
    private JTextField bookAuthorInput;
    private JTextField bookTitleInput;
    private JTextField bookYearInput;
    private JTextField bookPublisherInput;
    private JButton bookSubmitBtn;

    private String author;
    private String title;
    private int year;
    private String publisher;

    public BookForm() {
        dialog = new JDialog();
        dialog.setSize(600, 600);

        JPanel bookForm = new JPanel(new GridLayout(3, 1));
        JPanel bookFormTitle = new JPanel(new FlowLayout());
        JPanel bookFormBody = new JPanel(new GridLayout(5, 1));

        // Set title message
        JLabel bookFormMessage = new JLabel("Enter the book's details");
        bookFormTitle.add(bookFormMessage);

        // Set inputs
        JLabel bookAuthorLabel = new JLabel("Enter Author (Format: lastname, firstname)");
        bookAuthorInput = new JTextField(20);
        JPanel authorInputs = new JPanel();
        authorInputs.add(bookAuthorLabel);
        authorInputs.add(bookAuthorInput);

        JLabel bookTitleLabel = new JLabel("Enter Title");
        bookTitleInput = new JTextField(20);
        JPanel titleInputs = new JPanel();
        titleInputs.add(bookTitleLabel);
        titleInputs.add(bookTitleInput);

        JLabel bookYearLabel = new JLabel("Enter Year");
        bookYearInput = new JTextField(20);
        JPanel yearInputs = new JPanel();
        yearInputs.add(bookYearLabel);
        yearInputs.add(bookYearInput);

        JLabel bookPublisherLabel = new JLabel("Enter Publisher");
        bookPublisherInput = new JTextField(20);
        JPanel publisherInputs = new JPanel();
        publisherInputs.add(bookPublisherLabel);
        publisherInputs.add(bookPublisherInput);

        bookSubmitBtn = new JButton("Submit");
        bookSubmitBtn.addActionListener(this);
        JPanel buttonWrapper = new JPanel();
        buttonWrapper.add(bookSubmitBtn);

        // Add inputs
        bookFormBody.add(authorInputs);
        bookFormBody.add(titleInputs);
        bookFormBody.add(yearInputs);
        bookFormBody.add(publisherInputs);
        bookFormBody.add(buttonWrapper);

        // Add title and body
        bookForm.add(bookFormTitle);
        bookForm.add(bookFormBody);

        // Add form to dialog
        dialog.add(bookForm);
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookSubmitBtn) {
            System.out.println("Book Submitted");
            title = bookTitleInput.getText();
            author = bookAuthorInput.getText();
            year = Integer.parseInt(bookYearInput.getText());
            publisher = bookPublisherInput.getText();

            System.out.println("title: " + title + " author: " + author + " year: " + year + " publisher: " + publisher);
            dialog.dispose();
        }
    }
}
