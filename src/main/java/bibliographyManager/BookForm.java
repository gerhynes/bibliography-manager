package main.java.bibliographyManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookForm implements ActionListener {
    private JFrame frame;
    private JPanel bookForm;
    private JTextField bookAuthorInput;
    private JTextField bookTitleInput;
    private JTextField bookYearInput;
    private JTextField bookPublisherInput;
    private JButton bookSubmitBtn;


    public JTextField getBookAuthorInput() {
        return bookAuthorInput;
    }

    public void setBookAuthorInput(JTextField bookAuthorInput) {
        this.bookAuthorInput = bookAuthorInput;
    }

    public JTextField getBookTitleInput() {
        return bookTitleInput;
    }

    public void setBookTitleInput(JTextField bookTitleInput) {
        this.bookTitleInput = bookTitleInput;
    }

    public JTextField getBookYearInput() {
        return bookYearInput;
    }

    public void setBookYearInput(JTextField bookYearInput) {
        this.bookYearInput = bookYearInput;
    }

    public JTextField getBookPublisherInput() {
        return bookPublisherInput;
    }

    public void setBookPublisherInput(JTextField bookPublisherInput) {
        this.bookPublisherInput = bookPublisherInput;
    }

    public BookForm() {
        frame = new JFrame("Book Form");
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 800);

        this.bookForm = new JPanel(new GridLayout(3, 1));
        JPanel bookFormTitle = new JPanel(new FlowLayout());
        JPanel bookFormBody = new JPanel(new GridLayout(5,1));

        // Set title message
        JLabel bookFormMessage = new JLabel("Enter the book's details");
        bookFormTitle.add(bookFormMessage);

        // Set inputs
        JLabel bookAuthorLabel = new JLabel("Enter Author");
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

        // Add form to frame
        frame.add(bookForm);

        frame.setVisible(true);
    }

    public JPanel getBookForm() {
        return this.bookForm;
    }

    public BookBibItem createBookBibItem(String title, String author, int year, String publisher){
        return new BookBibItem(title, author, year, publisher);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookSubmitBtn) {
            System.out.println("Book Submitted");
            String title = bookTitleInput.getText();
            String author = bookAuthorInput.getText();
            int year = Integer.parseInt(bookYearInput.getText());
            String publisher = bookPublisherInput.getText();

            System.out.println("title: " + title + " author: " + author + " year: " + year + " publisher: " + publisher);
        }
    }
}
