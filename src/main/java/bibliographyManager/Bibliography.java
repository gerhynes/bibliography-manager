package main.java.bibliographyManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Bibliography - Singleton
 */
public class Bibliography {
    private static Bibliography self;

    private HashMap<String, BibItem> entries;

    protected Bibliography() {
        this.entries = new HashMap<>();
    }

    public static Bibliography getInstance() {
        if (self == null) self = new Bibliography();
        return self;
    }

    public void addEntry(String citeKey, BibItem entry) {
        this.entries.put(citeKey, entry);
    }

    public void deleteEntry(String citeKey){
        entries.remove(citeKey);
    }

    public Map<String, BibItem> getEntries() {
        return Collections.unmodifiableMap(this.entries);
    }

    /**
     * Iterates over entries and generates string representation in Harvard style
     *
     * @return
     */
    public String getEntriesHarvardStyle() {
        String res = "";
        for (Map.Entry<String, BibItem> entry : this.entries.entrySet()) {
            res += entry.getValue().toHarvardStyle() + "\n\n";
        }
        return res;
    }

    /**
     * Iterates over entries and generates string representation in BibTeX style separated by blank line
     * @return
     */
    public String getEntriesBibTeXStyle() {
        String res = "";
        for (Map.Entry<String, BibItem> entry : this.entries.entrySet()) {
            // Append entries in BibTeX format with line between them
            res += entry.getValue().toBibTeX() + "\n\n";
        }
        return res;
    }

    /**
     * Writes entries to .txt file in BibTeX format
     * @param fileName
     */
    public void saveToFile(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\resources\\" + fileName + ".txt"));
            writer.write(getEntriesBibTeXStyle());
            writer.write("Helloo");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
