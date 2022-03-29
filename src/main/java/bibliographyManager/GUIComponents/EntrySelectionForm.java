package main.java.bibliographyManager.GUIComponents;

import main.java.bibliographyManager.BibItem;
import main.java.bibliographyManager.Bibliography;
import main.java.bibliographyManager.ConcreteBibItemFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles the selection of which type of BibItem is to be created
 */
public class EntrySelectionForm implements ActionListener {
    private Bibliography bibliography;
    private JPanel entrySelectionForm;
    private CardLayout cardLayout;
    private JPanel cardContainer;
    private JButton bookBtn;
    private JButton articleBtn;
    private JButton techReportBtn;

    /**
     * Generates EntrySelectionForm
     * @param bibliography
     * @param cardContainer
     */
    public EntrySelectionForm(Bibliography bibliography, JPanel cardContainer){
        this.bibliography = bibliography;
        this.cardContainer = cardContainer;
        this.cardLayout = (CardLayout) cardContainer.getLayout();
        entrySelectionForm = new JPanel(new GridLayout(2, 1));
        JPanel selectionTitle = new JPanel(new FlowLayout());
        JPanel selectionBody = new JPanel(new FlowLayout());
        JLabel entrySelectionMessage = new JLabel("Select an entry type...");
        selectionTitle.add(entrySelectionMessage);

        // Create buttons
        bookBtn = new JButton("Add Book");
        articleBtn = new JButton("Add Article");
        techReportBtn = new JButton("Add Technical Report");

        // Add action listeners
        bookBtn.addActionListener(this);
        articleBtn.addActionListener(this);
        techReportBtn.addActionListener(this);

        // Add buttons to panel
        selectionBody.add(bookBtn);
        selectionBody.add(articleBtn);
        selectionBody.add(techReportBtn);

        entrySelectionForm.add(selectionTitle);
        entrySelectionForm.add(selectionBody);

        cardContainer.add(entrySelectionForm, "entrySelection");
    }

    /**
     * Returns entrySelectionForm JPanel to container class
     * @return
     */
    public JPanel getEntrySelectionForm(){
        return this.entrySelectionForm;
    }

    /**
     * Uses ConcreteBibItemFactory to create BookBibItem
     * Saves BookBibItem to bibliography
     */
    private void createBook() {
        ConcreteBibItemFactory bibItemFactory = new ConcreteBibItemFactory();

        BibItem book = bibItemFactory.createBibItem("book");
        if (book != null) {
            System.out.println("Adding book to bibliography");
            bibliography.addEntry(book);
        } else {
            System.out.println("Item is null");
        }
    }

    /**
     * Uses ConcreteBibItemFactory to create ArticleBibItem
     * Saves ArticleBibItem to bibliography
     */
    private void createArticle() {
        ConcreteBibItemFactory bibItemFactory = new ConcreteBibItemFactory();
        BibItem article = bibItemFactory.createBibItem("article");
        if (article != null) {
            System.out.println("Adding article to bibliography");
            bibliography.addEntry(article);
        } else {
            System.out.println("Item is null");
        }
    }

    /**
     * Uses ConcreteBibItemFactory to create TechnicalReportBibItem
     * Saves TechnicalReportBibItem to bibliography
     */
    private void createTechnicalReport() {
        ConcreteBibItemFactory bibItemFactory = new ConcreteBibItemFactory();
        BibItem techReport = bibItemFactory.createBibItem("techReport");
        if (techReport != null) {
            System.out.println("Adding technical report to bibliography");
            bibliography.addEntry(techReport);
        } else {
            System.out.println("Item is null");
        }
    }

    /**
     * Triggers creation of specific BibItem based off button clicked
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookBtn) {
            createBook();
            cardLayout.show(cardContainer, "defaultCard");
        }
        if (e.getSource() == articleBtn) {
            createArticle();
            cardLayout.show(cardContainer, "defaultCard");
        }
        if (e.getSource() == techReportBtn) {
            createTechnicalReport();
            cardLayout.show(cardContainer, "defaultCard");
        }
    }
}
