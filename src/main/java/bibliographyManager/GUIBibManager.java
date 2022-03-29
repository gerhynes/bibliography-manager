package main.java.bibliographyManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIBibManager implements ActionListener {
    private Bibliography bibliography;
    private JFrame frame;
    private JPanel adminPanel;
    private JButton loadFileBtn;
    private JButton saveToFileBtn;
    private JButton addEntryBtn;
    private JButton deleteEntryBtn;
    private JButton viewBibliographyBtn;
    private JButton quitBtn;
    private JPanel cardContainer;
    private JTextArea textArea;

    /**
     * Instantiates GUIBibManager
     * @param args
     */
    public static void main(String[] args) {
        GUIBibManager guiBibManager = new GUIBibManager();
    }

    /**
     * Constructor to generate GUIBibManager
     */
    public GUIBibManager() {
        // Instantiate bibliography singleton
        bibliography = new Bibliography();

        // Add sample entries to bibliography
        addDemoEntries();

        // Create frame
        frame = new JFrame("Bibliography Management System");
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 800);

        // Add panels
        addAdminPanel(frame);
        addCardContainer(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Adds sample book, article and technical report to the bibliography
     */
    public void addDemoEntries(){
        BookBibItem book = new BookBibItem("Rothfuss, Patrick", "The Wise Man's Fear", 2011, "Tor");
        ArticleBibItem article  = new ArticleBibItem("Bogue, Lorna", "Ringfort Conservation", 2019, "Eriu 57 (1)", "10.1007/54321");
        TechnicalReportBibItem technicalReport = new TechnicalReportBibItem("Lenihan, Eddie", "Curlew Conservation on the Mid Shannon", 2005, "NPWS");

        bibliography.addEntry(book);
        bibliography.addEntry(article);
        bibliography.addEntry(technicalReport);
    }

    /**
     * Generates admin panel and adds to frame
     * @param frame
     */
    public void addAdminPanel(JFrame frame) {
        adminPanel = new JPanel();
        adminPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        adminPanel.setPreferredSize(new Dimension(800, 200));
        adminPanel.setBackground(Color.DARK_GRAY);

        // Create buttons
        loadFileBtn = new JButton("Load BibTeX File");
        saveToFileBtn = new JButton("Save Bibliography to File");
        addEntryBtn = new JButton("Add Entry to Bibliography");
        deleteEntryBtn = new JButton("Delete Entry from Bibliography");
        viewBibliographyBtn = new JButton("View Bibliography");
        quitBtn = new JButton("Quit");

        // Add action listeners
        loadFileBtn.addActionListener(this);
        saveToFileBtn.addActionListener(this);
        addEntryBtn.addActionListener(this);
        deleteEntryBtn.addActionListener(this);
        viewBibliographyBtn.addActionListener(this);
        quitBtn.addActionListener(this);

        // Add buttons to panel
        adminPanel.add(loadFileBtn);
        adminPanel.add(saveToFileBtn);
        adminPanel.add(addEntryBtn);
        adminPanel.add(deleteEntryBtn);
        adminPanel.add(viewBibliographyBtn);
        adminPanel.add(quitBtn);

        // Add panel to frame
        frame.add(adminPanel, BorderLayout.PAGE_START);
    }

    /**
     * Generates card container for forms and outputs and adds to frame
     * @param frame
     */
    public void addCardContainer(JFrame frame) {
        cardContainer = new JPanel(new CardLayout());
        cardContainer.setPreferredSize(new Dimension(800, 400));
        cardContainer.setBackground(Color.BLACK);

        // Default card
        JPanel defaultCard = new JPanel();
        JLabel defaultMessage = new JLabel("Welcome to the Bibliography Management System");
        defaultCard.add(defaultMessage);

        // Load File Card
        JPanel loadFile = new JPanel();
        JLabel loadFileMessage = new JLabel("Loading file...");
        loadFile.add(loadFileMessage);

        // Add cards to cardContainer
        cardContainer.add(defaultCard, "defaultCard");
        cardContainer.add(loadFile, "loadFile");
        addEntrySelectionForm(cardContainer);
        addDeleteForm(cardContainer);
        addFileNameForm(cardContainer);
        addEntriesDisplayPanel(cardContainer);

        // Add cardContainer to frame
        frame.add(cardContainer, BorderLayout.CENTER);
    }

    /**
     * Generates delete form and adds to frame
     * @param cardContainer
     */
    public void addDeleteForm(JPanel cardContainer) {
        DeleteForm deleteForm = new DeleteForm(bibliography, cardContainer);
        cardContainer.add(deleteForm.getDeleteForm(), "deleteForm");
    }

    /**
     * Generates form for specifying fileName for saving bibliography to file
     * @param cardContainer
     */
    public void addFileNameForm(JPanel cardContainer) {
        FileNameForm fileNameForm = new FileNameForm(bibliography, cardContainer);
        cardContainer.add(fileNameForm.getFileNameForm(), "fileNameForm");
    }

    public void addEntrySelectionForm(JPanel cardContainer) {
        EntrySelectionForm entrySelectionForm = new EntrySelectionForm(bibliography, cardContainer);
        cardContainer.add(entrySelectionForm.getEntrySelectionForm(), "entrySelection");
    }

    public void addEntriesDisplayPanel(JPanel cardContainer){
        JPanel viewEntries = new JPanel();
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        viewEntries.add(scrollPane);

        cardContainer.add(viewEntries, "viewEntries");
    }

    /**
     * Loads appropriate card based on button clicked
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) cardContainer.getLayout();

        if (e.getSource() == loadFileBtn) {
            cardLayout.show(cardContainer, "loadFile");
        }
        if (e.getSource() == saveToFileBtn) {
            cardLayout.show(cardContainer, "fileNameForm");
        }
        if (e.getSource() == deleteEntryBtn) {
            cardLayout.show(cardContainer, "deleteForm");
        }
        if (e.getSource() == viewBibliographyBtn) {
            viewEntries();
            cardLayout.show(cardContainer, "viewEntries");
        }
        if (e.getSource() == addEntryBtn) {
            cardLayout.show(cardContainer, "entrySelection");
        }
        if (e.getSource() == quitBtn) {
            quit();
        }
    }

    /**
     * Displays the bibliography's entries in Harvard style
     */
    public void viewEntries() {
        System.out.println("Getting all bibliography entries");
        textArea.setText(bibliography.getEntriesHarvardStyle());
    }

    /**
     * Read from file functionality is not required in the assignment
     * @param filename
     */
    public void readFromFile(String filename) {
        System.out.println("Reading from file");
        quit();
    }

    /**
     * Terminates the program
     */
    public void quit() {
        // Terminate system with exit code 0
        System.exit(0);
        // Prevent any further code from running while system terminates
        return;
    }
}
