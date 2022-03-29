package main.java.bibliographyManager;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArticleBibItemTests {
    ArticleBibItem article = new ArticleBibItem("Noam Chomsky", "Logical Syntax and Semantics: Their Linguistic Relevance", 1955, "Language, 31 (1): 36–45", "10.1007/54956");
    String doi = article.getDoi();

    @Test
    public void testDoiURLPrefix() {
        // DOI starts with "https://doi.org/"
        assertTrue(doi.startsWith("https://doi.org/"));
    }

    @Test
    public void testDoiPrefixStructure() {
        // After "https://doi.org/", pattern is: two digits, period, four digits
        Pattern pattern = Pattern.compile("\\d\\d.\\d\\d\\d\\d");
        Matcher matcher = pattern.matcher(doi.substring(16).split("/")[0]);
        assertTrue(matcher.matches());
    }

    @Test
    public void testDoiSuffixStructure() {
        // DOI after url prefix consists of two parts separated by /
        assertTrue(doi.substring(16).split("/").length == 2);
    }

    @Test
    public void testDoiUniqueSuffixExists() {
        // DOI after url prefix and NN.NNNN/ is not empty
        assertTrue(doi.substring(16).split("/")[1].length() > 0);
    }
}