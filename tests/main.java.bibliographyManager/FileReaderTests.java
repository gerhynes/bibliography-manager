package main.java.bibliographyManager;

import org.junit.jupiter.api.Test;

public class FileReaderTests {

    @Test
    public void testReadingFromFile(){
        BibFileReader bibFileReader = new BibFileReader() {
            @Override
            public void readFromFile(String filename) {
                System.out.println("Bibliography in BibTeX format");
            }
        };
    }
}
