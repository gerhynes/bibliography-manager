package main.java.bibliographyManager.GUIComponents;

import main.java.bibliographyManager.Bibliography;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileNameForm implements ActionListener {
    private Bibliography bibliography;
    private JPanel fileNameForm;
    private CardLayout cardLayout;
    private JPanel cardContainer;
    private JTextField fileNameInput;
    private JButton fileNameSubmitBtn;

    public FileNameForm(Bibliography bibliography, JPanel cardContainer){
        this.bibliography = bibliography;
        this.cardContainer = cardContainer;
        this.cardLayout = (CardLayout) cardContainer.getLayout();
        this.fileNameForm = new JPanel(new GridLayout(2, 1));
        JPanel fileNameFormTitle = new JPanel(new FlowLayout());
        JPanel fileNameFormBody = new JPanel(new FlowLayout());

        // Set title message
        JLabel fileNameFormMessage = new JLabel("Enter a filename to save the bibliography to a .txt file");
        fileNameFormTitle.add(fileNameFormMessage);

        // Set form elements
        JLabel fileNameLabel = new JLabel("Enter file name (no extension)");
        fileNameInput = new JTextField(20);
        fileNameSubmitBtn = new JButton("Submit");
        fileNameSubmitBtn.addActionListener(this);

        fileNameFormBody.add(fileNameLabel);
        fileNameFormBody.add(fileNameInput);
        fileNameFormBody.add(fileNameSubmitBtn);

        fileNameForm.add(fileNameFormTitle);
        fileNameForm.add(fileNameFormBody);
    }

    public JPanel getFileNameForm(){
        return this.fileNameForm;
    }

    /**
     * Saves bibliography's entries to .txt file in Harvard format
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fileNameSubmitBtn) {
            String fileName = fileNameInput.getText();
            System.out.println("Saving bibliography to: " + fileName + ".txt");
            bibliography.saveToFile(fileName);
            cardLayout.show(cardContainer, "defaultCard");
        }
    }
}
