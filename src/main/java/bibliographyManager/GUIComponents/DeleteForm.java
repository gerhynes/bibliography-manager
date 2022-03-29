package main.java.bibliographyManager.GUIComponents;

import main.java.bibliographyManager.Bibliography;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles deleting a BibItem based off its citeKey
 */
public class DeleteForm implements ActionListener {
    private Bibliography bibliography;
    private JPanel deleteForm;
    private CardLayout cardLayout;
    private JPanel cardContainer;
    private JTextField citeKeyInput;
    private JButton deleteSubmitBtn;

    /**
     * Generates DeleteForm
     * @param bibliography
     * @param cardContainer
     */
    public DeleteForm(Bibliography bibliography, JPanel cardContainer){
        this.bibliography = bibliography;
        this.cardContainer = cardContainer;
        this.cardLayout = (CardLayout) cardContainer.getLayout();

        // Set up form
        this.deleteForm = new JPanel(new GridLayout(2, 1));
        JPanel deleteFormTitle = new JPanel(new FlowLayout());
        JPanel deleteFormBody = new JPanel(new FlowLayout());

        // Set title message
        JLabel deleteFormMessage = new JLabel("Enter an entry's citeKey to delete it");
        deleteFormTitle.add(deleteFormMessage);

        // Set form elements
        JLabel citeKeyLabel = new JLabel("Enter citeKey");
        citeKeyInput = new JTextField(20);
        deleteSubmitBtn = new JButton("Submit");
        deleteSubmitBtn.addActionListener(this);

        deleteFormBody.add(citeKeyLabel);
        deleteFormBody.add(citeKeyInput);
        deleteFormBody.add(deleteSubmitBtn);

        deleteForm.add(deleteFormTitle);
        deleteForm.add(deleteFormBody);
    }

    /**
     * Returns form for use in main GUI
     * @return
     */
    public JPanel getDeleteForm(){
        return this.deleteForm;
    }

    /**
     * Triggers deletion of entry
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteSubmitBtn) {
            String citeKey = citeKeyInput.getText();
            System.out.println("Deleting entry with citeKey: " + citeKey);
            bibliography.deleteEntry(citeKey);
            cardLayout.show(cardContainer, "defaultCard");
        }
    }
}
