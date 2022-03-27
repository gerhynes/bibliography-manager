package main.java.bibliographyManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ArticleBibItemTests {
    ArticleBibItem article = new ArticleBibItem("Noam Chomsky", "Logical Syntax and Semantics: Their Linguistic Relevance", 1955, "Language. 31 (1): 36–45", "10.1007/54956");
    String doi = article.getDoi();

    @Test
    public void testDoiURLPrefix() {
        // DOI starts with "https://doi.org/"
        assertTrue(doi.startsWith("https://doi.org/"));
    }

    @Test
    public void testDoiPrefixStructure() {
        // DOI starts with "https://doi.org/"
//        assertTrue(doi.substring(16)));
    }


    @Test
    public void testDoiSuffixStructure() {
        // DOI after url prefix consists of two parts separated by /
        assertTrue(doi.substring(16).split("/").length == 2);
    }
}