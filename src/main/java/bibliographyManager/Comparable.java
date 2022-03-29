package main.java.bibliographyManager;

/**
 * Comparable interface for comparing BibItems
 * @param <T>
 */
public interface Comparable<T> {
    int compareTo(T o);
}
