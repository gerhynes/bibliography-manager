package main.java.bibliographyManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteForm implements ActionListener {
    private JPanel deleteForm;
    private CardLayout cardLayout;
    private JPanel cardContainer;
    private JTextField citeKeyInput;
    private JButton deleteSubmitBtn;

    public DeleteForm(JPanel cardContainer){
        this.cardContainer = cardContainer;
        this.cardLayout = (CardLayout) cardContainer.getLayout();
        this.deleteForm = new JPanel(new GridLayout(2, 1));
        JPanel deleteFormTitle = new JPanel(new FlowLayout());
        JPanel deleteFormBody = new JPanel(new FlowLayout());

        // Set title message
        JLabel deleteFormMessage = new JLabel("Select an entry's citeKey to delete it");
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

    public JPanel getDeleteForm(){
        return this.deleteForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteSubmitBtn) {
            System.out.println("Deleting entry with citeKey: " + citeKeyInput.getText());
            cardLayout.show(cardContainer, "defaultCard");
        }
    }
}
