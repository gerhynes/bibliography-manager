package main.java.bibliographyManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Singleton for storing and accessing bibliography entries
 */
public class Bibliography {
    private static Bibliography self;

    private BibFileReader bibFileReader;

    private HashMap<String, BibItem> entries;

    /**
     * Generates bibliography
     */
    protected Bibliography() {
        this.entries = new HashMap<String, BibItem>();
    }

    public static Bibliography getInstance() {
        if (self == null) self = new Bibliography();
        return self;
    }

    public void setBibFileReader(BibFileReader bibFileReader){
        this.bibFileReader = bibFileReader;
    }

    /**
     * Adds BibItem to bibliography
     * @param entry
     */
    public void addEntry(BibItem entry) {
        this.entries.put(entry.getCiteKey(), entry);
    }

    /**
     * Deletes BibItem from bibliography based off the item's citeKey
     * @param citeKey
     */
    public void deleteEntry(String citeKey){
        entries.remove(citeKey);
    }

    /**
     * Sorts entries by year and generates string representation in Harvard style separated by blank line
     * @return
     */
    public String getEntriesHarvardStyle() {
        String res = "";
        ArrayList<BibItem> entryList = new ArrayList<>(entries.values());
        entryList.sort(new SortedByYear());
        for(BibItem item : entryList) {
            res +=item.toHarvardStyle() + "\n\n";
        }
        return res;
    }

    /**
     * Sorts entries by year and generates string representation in BibTeX style separated by blank line
     * @return
     */
    public String getEntriesBibTeXStyle() {
        String res = "";
        ArrayList<BibItem> entryList = new ArrayList<>(entries.values());
        entryList.sort(new SortedByYear());
        for(BibItem item : entryList) {
            res +=item.toBibTeX() + "\n\n";
        }
        return res;
    }

    /**
     * Writes entries to .txt file in BibTeX format in the resources directory
     * @param fileName
     */
    public void saveToFile(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\resources\\" + fileName + ".txt"));
            writer.write(getEntriesBibTeXStyle());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
