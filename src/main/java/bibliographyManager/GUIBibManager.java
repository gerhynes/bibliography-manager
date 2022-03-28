package main.java.bibliographyManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class GUIBibManager implements ActionListener {
    private Bibliography bibliography;
    private ConcreteBibItemFactory bibItemFactory;
    HashMap<String, ItemInputStrategy> inputStrategies;
    private JFrame frame;
    private JPanel adminPanel;
    private JButton loadFileBtn;
    private JButton saveToFileBtn;
    private JButton addEntryBtn;
    private JButton deleteEntryBtn;
    private JButton viewBibliographyBtn;
    private JButton quitBtn;
    private JPanel cardContainer;
    private JButton bookBtn;
    private JButton articleBtn;
    private JButton techReportBtn;

    public static void main(String[] args) {
        GUIBibManager guiBibManager = new GUIBibManager();
    }

    /**
     * Constructor to generate GUIBibManager
     */
    public GUIBibManager() {
        // Instantiate bibliography singleton
        bibliography = new Bibliography();

        frame = new JFrame("Bibliography Management System");
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 800);

        // Add panels
        addAdminPanel(frame);
        addCardContainer(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

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

        // View Entries Card
        JPanel viewEntries = new JPanel();
        JLabel entriesLabel = new JLabel("Bibliography Entries");
        viewEntries.add(entriesLabel);

        // Add cards to cardContainer
        cardContainer.add(defaultCard, "defaultCard");
        cardContainer.add(loadFile, "loadFile");
        cardContainer.add(viewEntries, "viewEntries");
        addEntrySelectionForm(cardContainer);
        addDeleteForm(cardContainer);
        addFileNameForm(cardContainer);

        // Add cardContainer to frame
        frame.add(cardContainer, BorderLayout.CENTER);
    }

    public void addDeleteForm(JPanel cardContainer) {
        DeleteForm deleteForm = new DeleteForm(bibliography, cardContainer);
        cardContainer.add(deleteForm.getDeleteForm(), "deleteForm");
    }

    public void addFileNameForm(JPanel cardContainer) {
        FileNameForm fileNameForm = new FileNameForm(bibliography, cardContainer);
        cardContainer.add(fileNameForm.getFileNameForm(), "fileNameForm");
    }

    public void addEntrySelectionForm(JPanel cardContainer) {
        // Entry Selection Card
        JPanel entrySelection = new JPanel(new GridLayout(2, 1));
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

        entrySelection.add(selectionTitle);
        entrySelection.add(selectionBody);

        cardContainer.add(entrySelection, "entrySelection");
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
            cardLayout.show(cardContainer, "viewEntries");
        }
        if (e.getSource() == addEntryBtn) {
            cardLayout.show(cardContainer, "entrySelection");
        }
        if (e.getSource() == bookBtn) {
            createBook();
        }
        if (e.getSource() == articleBtn) {
            createArticle();
        }
        if (e.getSource() == techReportBtn) {
            createTechnicalReport();
        }
        if (e.getSource() == quitBtn) {
            quit();
        }
    }

    /**
     * Prints the bibliography's entries in Harvard style
     */
    public void viewEntries() {
        System.out.println("Getting all bibliography entries");
        System.out.println(bibliography.getEntriesHarvardStyle());
    }

    /**
     * Read from file functionality is not required in the assignment
     *
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
}
